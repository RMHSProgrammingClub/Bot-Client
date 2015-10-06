package github.rmhsprogrammingclub.botapi;

import java.io.Serializable;

/**
 * Created by will on 10/6/15 at 6:01 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Bot implements Serializable {
	
	private static final long serialVersionUID = 3167193990326541568L;
	
	private int x;
	private int y;
	private int disabledTime;
	
	/**
	 * private default constructor
	 * added security
	 * */
	private Bot() {
	}
	
	public final void forward(int distance) {
		
	}
	
	public final void backward(int distance) {
		forward(-distance);
	}
	
	public final void turn(int degree) {
		
	}
	
	public final void shoot() {
		
	}
	
	public final void strafeLeft(int amount) {
		
	}
	
	public final void strafeRight(int amount) {
		strafeLeft(-amount);
	}
	
	public final void placeObsticle() {
		
	}
	
	public final void spawnBot() {
		
	}
	
	public final int getX() {
		return x;
	}
	
	public final int getY() {
		return y;
	}
	
	/**
	 * should this be accessable?
	 * */
	public final int getDisabledTime() {
		return disabledTime;
	}
	
	public final boolean isDisabled() {
		return disabledTime > 0;
	}
	
}
