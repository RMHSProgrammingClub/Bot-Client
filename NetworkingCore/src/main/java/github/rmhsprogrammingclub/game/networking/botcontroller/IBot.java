package github.rmhsprogrammingclub.game.networking.botcontroller;

import github.rmhsprogrammingclub.botapi.FieldOfView;

import java.awt.Point;

/**
 * Created by will on 10/19/15 at 5:34 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
@SuppressWarnings("unused")
public interface IBot {
	
	void move(int distance);
	
	void turn(int degree);
	
	void shoot();
	
	void strafe(int distance);
	
	void placeObstacle();
	
	void spawnBot(int x, int y);
	
	Point getPosition();
	
	int getDegrees();
	
	int getDisabledTime();
	
	FieldOfView getFieldOfView();
	
}
