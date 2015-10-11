package github.rhmsprogrammingclub.game.game.entities;

import com.n9mtq4.patternimage.Pattern;
import com.n9mtq4.patternimage.PatternImage;
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
	public PatternImage screen;
	protected Pattern sprite;
	
	public Entity(int x, int y, Pattern sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void init(Level level, PatternImage screen) {
		this.level = level;
		this.screen = screen;
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
