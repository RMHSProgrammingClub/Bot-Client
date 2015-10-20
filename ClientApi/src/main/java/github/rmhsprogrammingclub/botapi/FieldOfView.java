package github.rmhsprogrammingclub.botapi;

import github.rmhsprogrammingclub.botapi.visible.VisibleBot;
import github.rmhsprogrammingclub.botapi.visible.VisibleObstacle;

import java.io.Serializable;

/**
 * Created by will on 10/6/15 at 6:20 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class FieldOfView implements Serializable {
	
	private static final long serialVersionUID = 4543215661643990297L;
	
	private final VisibleBot[] visibleBots;
	private final VisibleObstacle[] visibleObstacles;
	
	public FieldOfView(VisibleBot[] visibleBots, VisibleObstacle[] visibleObstacles) {
		this.visibleBots = visibleBots;
		this.visibleObstacles = visibleObstacles;
	}
	
	public VisibleObstacle[] getVisibleObstacles() {
		return visibleObstacles;
	}
	
	public VisibleBot[] getVisibleBots() {
		return visibleBots;
	}
	
}
