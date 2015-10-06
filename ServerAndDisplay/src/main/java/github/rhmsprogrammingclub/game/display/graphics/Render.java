package github.rhmsprogrammingclub.game.display.graphics;

/**
 * Created by will on 10/6/15 at 5:39 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Render {
	
	public static final int TRANSPARENT_COLOR = 0xffff00ff;
	
	public int width;
	public int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void draw(Render render, int xOff, int yOff) {
		
		for (int y = 0; y < render.height; y++) {
			int yPx = y + yOff;
			if ((yPx < 0) || (yPx >= height)) continue;
			
			for (int x = 0; x < render.width; x++) {
				int xPx = x + xOff;
				if ((xPx < 0) || (xPx >= width)) continue;
				
				int pixelColor = render.pixels[x + y * render.width];
				if (pixelColor > 0 || pixelColor == TRANSPARENT_COLOR) pixels[xPx + yPx * width] = pixelColor;
				
			}
			
		}
		
	}
	
}
