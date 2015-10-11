package github.rhmsprogrammingclub.game.display;

import com.n9mtq4.patternimage.PatternImage;
import com.n9mtq4.patternimage.example.Example;
import com.n9mtq4.patternimage.ui.PatternImageContainer;
import github.rhmsprogrammingclub.game.game.Level;
import github.rhmsprogrammingclub.game.server.Server;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Created by will on 10/6/15 at 3:24 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class GameDisplay implements Runnable {
	
	public static final int WIDTH = 360;
	public static final int HEIGHT = (WIDTH / 4) * 3; //smartboards are 4:3, right?
	public static final int SCALE = 2;
	public static final double GAME_SPEED = 16d; // ticks per second
	public static final boolean DEBUG = true;
	
	private final Server server;
	
	private JFrame frame;
	
	private PatternImage screen;
	private PatternImageContainer screenRender;
	private Level level;
	
	private Thread thread;
	private boolean running;
	
	public GameDisplay(Server server) {
		
		this.server = server;
		this.running = false;
		
		this.level = new Level(WIDTH, HEIGHT);
		this.screen = new PatternImage(WIDTH, HEIGHT);
		this.screenRender = new PatternImageContainer(screen, DEBUG, GAME_SPEED, SCALE);
		
		this.frame = new JFrame("Game Window");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.add(screenRender);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		initScreen();
		start();
		
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
	
	private void initScreen() {
		screen.setBackground(new Example.AnimatedRadialGradient());
		screenRender.start();
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
		
		frame.requestFocus();
		screenRender.requestFocusInWindow();
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
					frames = 0;
					tickCount = 0;
					
				}
				
			}
			
			if (ticked) ticked = false;
			
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
	
	public Server getServer() {
		return server;
	}
	
	public PatternImage getScreen() {
		return screen;
	}
	
}
