package github.rhmsprogrammingclub.game.game;

import com.n9mtq4.patternimage.PatternImage;
import github.rhmsprogrammingclub.game.game.entities.Entity;

import java.util.ArrayList;

/**
 * Created by will on 10/6/15 at 5:44 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Level {
	
	private final ArrayList<Entity> entities;
	
	private final int width;
	private final int height;
	
	public Level(int width, int height) {
		this.entities = new ArrayList<Entity>();
		this.width = width;
		this.height = height;
	}
	
	public final void tick() {
		
	}
	
	public final void render(PatternImage screen) {
		
		
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
