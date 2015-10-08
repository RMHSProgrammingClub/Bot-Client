package github.rhmsprogrammingclub.game.server.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * A {@link HashMap} that can get by key or
 * get the key by value.
 * 
 * <p>
 * Created by will on 9/23/15 at 10:04 AM.
 * 
 * @since v0.1
 * @version v0.1
 * @author Will "n9Mtq4" Bresnahan
 */
@SuppressWarnings("unused")
public class TwoWayHashMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
	
	/**
	 * @see HashMap#HashMap(int, float)
	 * */
	public TwoWayHashMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}
	
	/**
	 * @see HashMap#HashMap(int)
	 * */
	public TwoWayHashMap(int initialCapacity) {
		super(initialCapacity);
	}
	
	/**
	 * @see HashMap#HashMap()
	 * */
	public TwoWayHashMap() {
	}
	
	/**
	 * @see HashMap#HashMap(Map)
	 * */
	public TwoWayHashMap(Map<? extends K, ? extends V> m) {
		super(m);
	}
	
	/**
	 * Gets the key based on the value.
	 * Isn't very efficient
	 * 
	 * @return The key for the given value
	 * @param value The value to get the key from
	 * */
	public K getReverse(V value) {
		for (K key : keySet()) {
			if (get(key).hashCode() == value.hashCode()) return key;
		}
		return null;
	}
	
}
