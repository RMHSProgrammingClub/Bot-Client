package github.rhmsprogrammingclub.game.display.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Created by will on 10/6/15 at 5:41 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Sprite {
	
	private final int SIZE;
	private final int SIZE_MASK;
	private int x;
	private int y;
	private final int width;
	private final int height;
	private final int[] pixels;
	private SpriteSheet sheet;
	
	public Sprite(int size, Color color) {
		this.SIZE = size;
		this.SIZE_MASK = SIZE - 1;
		this.width = SIZE;
		this.height = SIZE;
		pixels = new int[width * height];
		setColor(color.getRGB());
	}
	
	public Sprite(int width, int height) {
		this.SIZE = width;
		this.SIZE_MASK = SIZE - 1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.SIZE_MASK = SIZE - 1;
		this.width = SIZE;
		this.height = SIZE;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[width * height];
		load();
	}
	
	private void load() {
		
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.width];
			}
		}
		
	}
	
	private void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public final BufferedImage toBufferedImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		image.setRGB(0, 0, width, height, pixels, 0, width);
		return image;
	}
	
	public final void tick() {
		
	}
	
	public final Sprite getSprite() {
		return this;
	}
	
	public int getSIZE() {
		return SIZE;
	}
	
	public int getSIZE_MASK() {
		return SIZE_MASK;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public SpriteSheet getSheet() {
		return sheet;
	}
	
}
