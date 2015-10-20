package github.rmhsprogrammingclub.botapi;

import github.rmhsprogrammingclub.game.networking.botcontroller.IBot;

import java.io.Serializable;

/**
 * Created by will on 10/6/15 at 6:01 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Bot implements Serializable {
	
	private static final long serialVersionUID = 3167193990326541568L;
	
	public static Bot makeBot(IBot controller) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if (!stackTraceElements[1].getMethodName().equals("makeBot") && !stackTraceElements[1].getClassName().equals(BotGame.class.getName())) {
			System.out.println("You don't have the access to make a new bot.");
			return null;
		}
		return new Bot(controller);
	}
	
	private final IBot controller;
	
	/**
	 * private default constructor
	 * added security
	 * */
	private Bot(IBot controller) {
		this.controller = controller;
	}
	
	public final void forward(int distance) {
		controller.move(distance);
	}
	
	public final void backward(int distance) {
		forward(-distance);
	}
	
	public final void turn(int degree) {
		controller.turn(degree);
	}
	
	public final void shoot() {
		controller.shoot();
	}
	
	public final void strafeLeft(int amount) {
		controller.strafe(amount);
	}
	
	public final void strafeRight(int amount) {
		strafeLeft(-amount);
	}
	
	public final void placeObsticle() {
		controller.placeObstacle();
	}
	
	public final void spawnBot(int x, int y) {
		controller.spawnBot(x, y);
	}
	
	public final int getX() {
		return controller.getPosition().x;
	}
	
	public final int getY() {
		return controller.getPosition().y;
	}
	
	public final FieldOfView getFieldOfView() {
		return null;
	}
	
	/**
	 * should this be accessible?
	 * */
	public final int getDisabledTime() {
		return controller.getDisabledTime();
	}
	
	public final boolean isDisabled() {
		return getDisabledTime() > 0;
	}
	
}
