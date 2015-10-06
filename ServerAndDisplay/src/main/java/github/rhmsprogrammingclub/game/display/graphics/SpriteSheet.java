package github.rhmsprogrammingclub.game.display.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by will on 10/6/15 at 5:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class SpriteSheet {
	
	private String path;
	public int size;
	public int width;
	@Deprecated
	public int height;
	public int[] pixels;
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.size = width;
		pixels = new int[width * height];
		load();
	}
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.size = size;
		this.width = size;
		pixels = new int[size * size];
		load();
	}
	
	private void load() {
		
		try {
			
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		}catch (IOException e) {
			System.err.println("Error reading sprite sheet from " + path);
			e.printStackTrace();
		}
		
	}
	
}
