package github.rhmsprogrammingclub.game.game.entities;

import com.n9mtq4.patternimage.Pattern;
import github.rhmsprogrammingclub.game.display.GameDisplay;
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
	protected Pattern sprite;
	
	public Entity(int x, int y, Pattern sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void init(Level level, GameDisplay display) {
		this.level = level;
		this.display = display;
	}
	
	public void tick() {
		
		sprite.setxOff(x);
		sprite.setyOff(y);
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public Pattern getSprite() {
		return sprite;
	}
	
}
