package github.rmhsprogrammingclub.botapi;

/**
 * Created by will on 10/19/15 at 6:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class TurnInfo {
	
	private Bot[] bots;
	private int turnNumber;
	
	public TurnInfo(Bot[] bots, int turnNumber) {
		this.bots = bots;
		this.turnNumber = turnNumber;
	}
	
	public Bot[] getBots() {
		return bots;
	}
	
	public final int getTurnNumber() {
		return turnNumber;
	}
	
}
