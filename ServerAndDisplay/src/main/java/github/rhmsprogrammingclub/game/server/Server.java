package github.rhmsprogrammingclub.game.server;

import github.rhmsprogrammingclub.game.display.GameDisplay;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by will on 10/6/15 at 3:23 PM.
 * 
 * @since v0.1
 * @version v0.1
 * @author Will "n9Mtq4" Bresnahan
 */
public final class Server implements Runnable {
	
	public static final int REGISTER_PORT = 4334;
	public static final int GAME_PORT = 4335;
	
	private static Server instance;
	
	public static void main(String[] args) {
		
		if (instance == null) instance = new Server(args);
	}
	
	private final String[] args;
	private final GameDisplay gameDisplay;
	private final ArrayList<ClientConnection> clients;
	
	private ServerState state;
	private boolean running;
	@Deprecated
	private boolean stop;
	private Thread thread;
	
	private ServerSocket registerServer;
	private Socket registerIn;
	private Socket registerOut;
	
	private Server(String[] args) {
		
		this.args = args;
		this.gameDisplay = new GameDisplay(this);
		this.clients = new ArrayList<ClientConnection>();
		this.running = false;
		this.stop = false;
		this.state = ServerState.NOTHING;
		
	}
	
	private final synchronized void start() {
		if (running) return; // server is running already
		this.thread = new Thread(this);
		thread.start();
	}
	
	private final synchronized void stop() {
		if (!running) return; // the server is stopped already
		this.running = false;
		try {
			thread.join();
			thread = null;
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public final void run() {
		
//		start registering server until the start code is received from a game master
		setState(ServerState.REGISTER);
		try {
			
			System.out.println("Starting register on: " + InetAddress.getLocalHost() + ":" + REGISTER_PORT);
			this.registerServer = new ServerSocket(REGISTER_PORT);
			System.out.println("Waiting for a connected on: " + InetAddress.getLocalHost() + ":" + REGISTER_PORT);
			this.registerIn = registerServer.accept();
			
//			http://www.java2s.com/Code/Java/Network-Protocol/ServerSocketandSocketforSerializableobject.htm
			ObjectOutputStream oos = new ObjectOutputStream(registerIn.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(registerIn.getInputStream());
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private final void setState(ServerState state) {
		this.state = state;
	}
	
}
