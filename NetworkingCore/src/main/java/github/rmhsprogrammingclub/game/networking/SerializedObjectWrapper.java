package github.rmhsprogrammingclub.game.networking;

import java.io.Serializable;

/**
 * Created by will on 10/7/15 at 8:09 PM.
 * 
 * @since v0.1
 * @version v0.1
 * @author Will "n9Mtq4" Bresnahan
 */
public final class SerializedObjectWrapper<E extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 2942400751779609270L;
	
	private final E object;
	private final String type;
	
	public SerializedObjectWrapper(E object) {
		this.object = object;
		this.type = object.getClass().getName();
	}
	
	public final E getObject() {
		return object;
	}
	
	public final String getType() {
		return type;
	}
	
	
}
