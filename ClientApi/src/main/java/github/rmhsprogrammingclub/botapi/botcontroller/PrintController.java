package github.rmhsprogrammingclub.botapi.botcontroller;

import github.rmhsprogrammingclub.botapi.BotGame;
import github.rmhsprogrammingclub.botapi.FieldOfView;
import github.rmhsprogrammingclub.botapi.visible.VisibleBot;
import github.rmhsprogrammingclub.botapi.visible.VisibleObstacle;
import github.rmhsprogrammingclub.game.networking.botcontroller.IBot;

import java.awt.Point;

/**
 * Created by will on 10/19/15 at 6:02 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class PrintController implements IBot {
	
	private Point pos;
	private int turn;
	
	public PrintController(int x, int y) {
		this.pos = new Point(x, y);
		this.turn = 0;
	}
	
	@Override
	public void move(int i) {
		move(i, turn);
	}
	
	private void move(int distance, int degree) {
		if (distance == 0) return;
		double nx = distance * Math.cos(degree);
		double ny = distance * Math.sin(degree);
		pos.x += nx;
		pos.y += ny;
		print("Your robot has moved forward " + distance + " units");
	}
	
	@Override
	public final void turn(int i) {
		turn += i;
		turn %= 360;
		print("Your robot has turned " + i + " degrees to " + turn + " degrees");
	}
	
	@Override
	public final void shoot() {
		print("Your robot has shoot forward at " + turn + " degrees");
	}
	
	@Override
	public final void strafe(int distance) {
//		move perpendicular to turn vector
		move(Math.abs(distance), turn + (distance > 0 ? 90 : -90));
		print("Strafing doesn't work yet");
	}
	
	@Override
	public final void placeObstacle() {
		print("Your robot has placed an obstacle");
	}
	
	@Override
	public final void spawnBot(int x, int y) {
		BotGame.addBot(new PrintController(x, y));
		print("You robot has spawned a new robot");
	}
	
	@Override
	public final Point getPosition() {
		return pos;
	}
	
	@Override
	public final int getDegrees() {
		return turn;
	}
	
	@Override
	public final int getDisabledTime() {
		print("Disabling is not yet implemented");
		return 0;
	}
	
	@Override
	public FieldOfView getFieldOfView() {
		return new FieldOfView(new VisibleBot[]{}, new VisibleObstacle[] {});
	}
	
	private static void print(Object msg) {
		System.out.println(String.valueOf(msg));
	}
	
}
