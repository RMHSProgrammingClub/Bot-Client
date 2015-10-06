package github.rhmsprogrammingclub.game.display.graphics;

import github.rhmsprogrammingclub.game.game.Level;

/**
 * Created by will on 10/6/15 at 5:40 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Screen {
	
	
	public static final int TILE_SIZE = 5; // 2^TILE_SIZE = pixels
	public static final int ABS_TILE_SIZE = 1 << TILE_SIZE;
	private static final int LEVEL_WIDTH = 64; //TODO: change later
	private static final int LEVEL_HEIGHT = 64; //TODO: change later
	
	public int width;
	public int height;
	public int[] pixels;
	public int[] tiles;
	
	public int xOff;
	public int yOff;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		this.tiles = new int[LEVEL_WIDTH * LEVEL_HEIGHT];
	}
	
	public final void renderSpriteAbs(int xp, int yp, int x1, int y1, Sprite spriteSource, Level level) {
		Sprite sprite = spriteSource.getSprite();
		for (int y = 0; y < sprite.getSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getSIZE() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.getPixels()[x + y * sprite.getSIZE()];
				if (col != Render.TRANSPARENT_COLOR) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public final void renderSpriteRel(int xp, int yp, int x1, int y1, Sprite spriteSource, Level level) {
		Sprite sprite = spriteSource.getSprite();
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < sprite.getSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getSIZE() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.getPixels()[x + y * sprite.getSIZE()];
				if (col != Render.TRANSPARENT_COLOR) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
/*	public final void renderTile(int xp, int yp, int x1, int y1, Tile tile, Level level) {
		Sprite sprite = tile.sprite.getSprite();
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < sprite.getSIZE(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getSIZE(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getSIZE() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int spriteColor = sprite.pixels[x + y * sprite.getSIZE()];
				if (spriteColor != Render.TRANSPARENT_COLOR) {
					pixels[xa + ya * width] = spriteColor;
//					pixels[xa + ya * width] = spriteColor;
				}
			}
		}
	}*/
	
	public final void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000; //black
		}
	}
	
	public final void setOffSet(int xOff, int yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
	}
	
}
