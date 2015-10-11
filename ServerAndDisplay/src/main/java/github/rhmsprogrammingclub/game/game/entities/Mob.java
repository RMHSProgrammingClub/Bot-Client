package github.rhmsprogrammingclub.game.game.entities;

import com.n9mtq4.patternimage.Pattern;

/**
 * Created by will on 10/11/15 at 10:55 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Mob extends Entity {
	
	public Direction dir = Direction.FORWARD;
	public boolean moving = false;
	
	public int spawnX;
	public int spawnY;
	
	protected int time;
	
	public Mob(int x, int y, Pattern pattern) {
		super(x, y, pattern);
		this.spawnX = x;
		this.spawnY = y;
	}
	
	public void tick() {
		
		super.tick();
		time++;
		move(1, 1);
		
	}
	
	protected boolean isOutSideLevel() {
		return (x < 0 || y < 0 || x > (level.getWidth()) || y > (level.getHeight()));
	}
	
	public void move(int xd, int yd) {
		
		if (xd != 0 && yd != 0) {
			move(0, yd);
			move(xd, 0);
			return;
		}
		
		if (xd > 0) dir = Direction.RIGHT;
		if (xd < 0) dir = Direction.LEFT;
		if (yd > 0) dir = Direction.BACKWARDS;
		if (yd < 0) dir = Direction.FORWARD;
		
		if (!collision(xd, yd)) {
			x += xd;
			y += yd;
		}
		
	}
	
	public boolean collision(int xd, int yd) {
		
		// the future x and y values
		int xv = x + xd;
		int yv = y + yd;
		
		// do collision code here
		
		return false;
		
	}
	
	protected int getDistance(Entity entity) {
		return getDistance(this, entity);
	}
	
	private static int getDistance(Entity e1, Entity e2) {
		return getDistance(e1.x, e1.y, e2.x, e2.y);
	}
	
	private static int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
}
