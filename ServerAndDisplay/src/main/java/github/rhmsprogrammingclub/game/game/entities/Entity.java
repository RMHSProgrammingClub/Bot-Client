package github.rhmsprogrammingclub.game.game.entities;

import github.rhmsprogrammingclub.game.display.GameDisplay;
import github.rhmsprogrammingclub.game.display.graphics.Screen;
import github.rhmsprogrammingclub.game.display.graphics.Sprite;
import github.rhmsprogrammingclub.game.game.Level;

/**
 * Created by will on 10/6/15 at 5:55 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public abstract class Entity {
	
	public int x;
	public int y;
	public boolean removed = false;
	public Level level;
	public GameDisplay display;
	protected Sprite sprite;
	
	public void init(Level level, GameDisplay display) {
		this.level = level;
		this.display = display;
	}
	
	public void render(Screen screen) {
		
	}
	
	public void renderSpriteRel(Screen screen, Sprite sprite) {
		screen.renderSpriteRel(x, y, x / Screen.ABS_TILE_SIZE, y / Screen.ABS_TILE_SIZE, sprite, level);
	}
	
	public void renderSpriteAbs(Screen screen, Sprite sprite) {
		screen.renderSpriteAbs(x, y, x / Screen.ABS_TILE_SIZE, y / Screen.ABS_TILE_SIZE, sprite, level);
	}
	
	public void tick() {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
}
