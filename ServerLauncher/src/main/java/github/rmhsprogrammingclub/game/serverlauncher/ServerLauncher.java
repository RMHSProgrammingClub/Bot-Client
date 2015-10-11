package github.rmhsprogrammingclub.game.serverlauncher;

import github.rhmsprogrammingclub.game.server.Server;
import github.rmhsprogrammingclub.game.serverlauncher.classpath.LibLoader;

/**
 * Created by will on 10/11/15 at 9:01 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class ServerLauncher {
	
	public static void main(final String[] args) {
		
		LibLoader.loadLibs();
		
		Server.getInstance(args);
		
	}
	
	private ServerLauncher() {}
	
}
