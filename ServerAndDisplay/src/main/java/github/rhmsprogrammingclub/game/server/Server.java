package github.rhmsprogrammingclub.game.server;

import github.rhmsprogrammingclub.game.display.GameDisplay;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by will on 10/6/15 at 3:23 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Server implements Runnable {
	
	public static final int IN_PORT = 4334;
	public static final int OUT_PORT = 4335;
	
	private static Server instance;
	
	public static void main(String[] args) {
		if (instance == null) instance = new Server();
	}
	
	private ServerSocket socketServer;
	private ArrayList<Socket> botSockets;
	private final GameDisplay gameDisplay;
	
	private Server() {
		
		this.gameDisplay = new GameDisplay(this);
		
	}
	
	@Override
	public void run() {
		
		while (gameDisplay.isRunning()) {
			
//			handle socket connections
			
		}
		
	}
	
}
