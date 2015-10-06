package github.rmhsprogrammingclub.botapi;

/**
 * Created by will on 10/6/15 at 6:20 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Sounds {
	
	private final double leftStrength;
	private final double rightStrength;
	
	public Sounds(double leftStrength, double rightStrength) {
		this.leftStrength = leftStrength;
		this.rightStrength = rightStrength;
	}
	
	public final double getLeftStrength() {
		return leftStrength;
	}
	
	public final double getRightStrength() {
		return rightStrength;
	}
	
}
