package github.rmhsprogrammingclub.botapi;

import github.rmhsprogrammingclub.game.networking.botcontroller.IBot;

import java.util.ArrayList;

/**
 * Created by will on 10/19/15 at 6:39 PM.
 * This is a temporary class that wont be used in the
 * final version.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class BotGame {
	
	private static int turns = 200;
	private static boolean gotTurnInfo = false;
	private static ArrayList<Bot> bots;
	private static int turnNumber = 0;
	
	public static boolean gamePlaying() {
		return turns > 0;
	}
	
	public static TurnInfo waitForTurn() {
		return waitForTurnSpinLock();
	}
	
	private static TurnInfo waitForTurnSpinLock() {
		while (!isMyTurn()) {
			try {
				Thread.sleep(1);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return getTurnInfo();
		
	}
	
	public static boolean isMyTurn() {
		gotTurnInfo = false;
		return true;
	}
	
	public static TurnInfo getTurnInfo() {
		if (!isMyTurn()) return null;
		gotTurnInfo = true;
		
		Bot[] botsa = new Bot[bots.size()];
		bots.toArray(botsa);
		
		return new TurnInfo(botsa, turnNumber++);
	}
	
	public static void addBot(IBot controller) {
		bots.add(makeBot(controller));
	}
	
	private static Bot makeBot(IBot controller) {
		return Bot.makeBot(controller);
	}
	
}
