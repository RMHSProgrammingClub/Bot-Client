package github.rhmsprogrammingclub.game.server;

/**
 * Created by will on 10/7/15 at 7:15 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ClientConnection {
	
	private final String ip;
	private final int port;
	
	public ClientConnection(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public final String getIp() {
		return ip;
	}
	
	public final int getPort() {
		return port;
	}
	
}
