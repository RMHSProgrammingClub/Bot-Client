package github.rhmsprogrammingclub.game.display;

import github.rhmsprogrammingclub.game.display.graphics.Screen;
import github.rhmsprogrammingclub.game.game.Level;
import github.rhmsprogrammingclub.game.server.Server;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by will on 10/6/15 at 3:24 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class GameDisplay extends Canvas implements Runnable {
	
	public static final int WIDTH = 360;
	public static final int HEIGHT = (WIDTH / 4) * 3; //smartboards are 4:3, right?
	public static final int SCALE = 2;
	public static final double GAME_SPEED = 60d; // ticks per second
	public static final boolean DEBUG = true;
	private static final Font DEBUG_FONT = new Font("Verdana", Font.BOLD, 24);
	private static final Font NORMAL_FONT = new Font("Verdana", Font.BOLD, 12);
	
	private final Server server;
	
	private Screen screen;
	private Level level;
	
	private Thread thread;
	private boolean running;
	private int fps;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public GameDisplay(Server server) {
		this.server = server;
		this.running = false;
		final Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		
		requestFocus();
		
	}
	
	public synchronized void start() {
		
		if (running) stop();
		running = true;
		this.thread = new Thread(this, "Game Thread");
		thread.start();
		
	}
	
	public synchronized void stop() {
		
		try {
			if (!running) return;
			running = false;
			if (thread != null) thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void renderGame() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		
		screen.clear();
		level.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		if (DEBUG) {
			g.setColor(new Color(255, 255, 0));
			g.setFont(DEBUG_FONT);
			g.drawString(fps + " fps", 0, HEIGHT * SCALE - 18);
			g.setFont(NORMAL_FONT);
		}
		
		g.dispose();
		bs.show();
		
	}
	
	private void render() {
		renderGame();
	}
	
	private void tick() {
		
		level.tick();
		
	}
	
	/**
	 * Main game loop
	 * */
	@Override
	public void run() {
		
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double clockSpeed = 1 / GAME_SPEED;
		int tickCount = 0;
		boolean ticked = false;
		
		requestFocus();
		requestFocusInWindow();
		tick();
		while (running) {
			
//			game loop
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > clockSpeed) {
				
				tick();
				unprocessedSeconds -= clockSpeed;
				ticked = true;
				tickCount++;
				if (tickCount % GAME_SPEED == 0) {
					
					System.out.println(tickCount + " ups, " + frames + " fps");
					previousTime += 1000;
					fps = frames;
					frames = 0;
					tickCount = 0;
					
				}
				
			}
			
			if (ticked) {
				
				render();
				frames++;
				ticked = false;
				
			}
			
			render();
			frames++;
			
		}
		
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}
	
	public static int getHEIGHT() {
		return HEIGHT;
	}
	
	public static int getSCALE() {
		return SCALE;
	}
	
	public static double getGameSpeed() {
		return GAME_SPEED;
	}
	
	public static boolean isDEBUG() {
		return DEBUG;
	}
	
	public static Font getDebugFont() {
		return DEBUG_FONT;
	}
	
	public static Font getNormalFont() {
		return NORMAL_FONT;
	}
	
	public Server getServer() {
		return server;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public int getFps() {
		return fps;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
}
