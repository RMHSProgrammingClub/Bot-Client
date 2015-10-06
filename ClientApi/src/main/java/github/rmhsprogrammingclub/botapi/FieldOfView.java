package github.rmhsprogrammingclub.botapi;

import java.io.Serializable;

/**
 * Created by will on 10/6/15 at 6:20 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public final class FieldOfView implements Serializable {
	
	private static final long serialVersionUID = 4543215661643990297L;
	
	private final Bot[] visibleBots;
	
	public FieldOfView(Bot[] visibleBots) {
		this.visibleBots = visibleBots;
	}
	
}
