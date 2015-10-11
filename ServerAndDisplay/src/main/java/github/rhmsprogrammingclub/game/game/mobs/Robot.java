package github.rhmsprogrammingclub.game.game.mobs;

import com.n9mtq4.patternimage.Pattern;
import com.n9mtq4.patternimage.PatternImage;
import com.n9mtq4.patternimage.colorgetter.RasterTexture;
import com.n9mtq4.patternimage.colorgetter.StaticColor;
import com.n9mtq4.patternimage.shapes.Square;
import github.rhmsprogrammingclub.game.game.TextureUtils;
import github.rhmsprogrammingclub.game.game.entities.Mob;

import java.awt.image.BufferedImage;

/**
 * Created by will on 10/11/15 at 1:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Robot extends Mob {
	
	private static final BufferedImage robotImage = TextureUtils.readImage("/assets/drawable/robot.png");
	private static final Pattern PLACEHOLDER_PATTERN = new Pattern(new StaticColor(0, 0, 0), new Square(0, 0, 1));
	
	private final RobotColorGetter robotColor;
	
	private boolean shield;
	private int disableTime;
	
	public Robot(int x, int y, int color) {
		super(x, y, PLACEHOLDER_PATTERN);
		
		this.robotColor = new RobotColorGetter(color);
		this.sprite = new Pattern(robotColor, new Square(0, 0, 64), false, x, y);
		
		this.shield = false;
		this.disableTime = 0;
		
	}
	
	@Override
	public void tick() {
		super.tick();
		if (time % 16 * 5 == 0) setShield(!isShielded());
	}
	
	public final void tryToShoot() {
		
	}
	
	private void shoot() {
		
	}
	
	@Override
	public final void move(int xd, int yd) {
		if (!isDisabled()) super.move(xd, yd);
	}
	
	public final boolean isShielded() {
		return shield;
	}
	
	public final void setShield(boolean shield) {
		this.shield = shield;
	}
	
	public final int getDisableTime() {
		return disableTime;
	}
	
	public final void setDisableTime(int disableTime) {
		this.disableTime = disableTime;
	}
	
	public final boolean isDisabled() {
		return getDisableTime() > 0;
	}
	
	private final class RobotColorGetter extends RasterTexture {
		
		private final int robotColor;
		
		public RobotColorGetter(int robotColor) {
			super(robotImage);
			this.robotColor = robotColor;
		}
		
		@Override
		public int getColorAt(int x, int y, Pattern pattern, PatternImage image) {
			int color = super.getColorAt(x, y, pattern, image);
			if (color == 0xffff00ff) return -1; // transparent color
			if (color == 0xffffffff) return robotColor; // replaces pure white with the robot color
			if (color == 0xff0000ff) if (!isShielded()) return -1; // replaces the blue shield with nothing
			return color;
		}
	}
	
}
