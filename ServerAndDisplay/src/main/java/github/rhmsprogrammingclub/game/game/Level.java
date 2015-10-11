package github.rhmsprogrammingclub.game.game;

import com.n9mtq4.patternimage.PatternImage;
import com.n9mtq4.patternimage.utils.RgbConverter;
import github.rhmsprogrammingclub.game.game.entities.Entity;
import github.rhmsprogrammingclub.game.game.mobs.Robot;

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
	private final PatternImage screen;
	
	public Level(int width, int height, PatternImage screen) {
		this.entities = new ArrayList<Entity>();
		this.width = width;
		this.height = height;
		this.screen = screen;
	}
	
	public final void tick() {
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	
	public final void addEntity(Entity entity) {
		
		screen.addPattern(entity.getSprite());
		entity.init(this, screen);
		entities.add(entity);
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
