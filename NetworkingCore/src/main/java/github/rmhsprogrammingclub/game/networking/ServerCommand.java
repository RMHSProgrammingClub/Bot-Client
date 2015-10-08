package github.rmhsprogrammingclub.game.networking;

import java.io.Serializable;

/**
 * Created by will on 10/7/15 at 8:15 PM.
 * 
 * @since v0.1
 * @version v0.1
 * @author Will "n9Mtq4" Bresnahan
 */
public final class ServerCommand implements Serializable {
	
	public static SerializedObjectWrapper<ServerCommand> createWithCommand(String command) {
		return new SerializedObjectWrapper<ServerCommand>(new ServerCommand(command));
	}
	
	private final String command;
	
	private ServerCommand(String command) {
		this.command = command;
	}
	
	public final String getCommand() {
		return command;
	}
	
}
