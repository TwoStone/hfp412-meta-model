package common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class hides an attribute of type Map and provides an aggregate functionality to sum values with the same key
 * Restriction: Values must be "castable" to Long
 * 
 * @author Stefan
 * 
 * @param <K>
 *            Type for key value for hided HashMap.
 */
public class SummableHashMap<K> {

	private final Map<K, Long> map;

	public SummableHashMap() {
		this.map = new HashMap<K, Long>();
	}

	public Map<K, Long> getMap() {
		return map;
	}

	/**
	 * merges the argument to the map. values with the same key will be added.
	 * 
	 * @param arg
	 *            SummableHashMap to merge
	 */
	public void aggregate(final SummableHashMap<K> arg) {
		final Iterator<K> i = arg.getMap().keySet().iterator();
		while (i.hasNext()) {
			final K key = i.next();
			if (this.getMap().containsKey(key)) {
				final Long value = this.getMap().get(key) + arg.getMap().get(key);
				this.getMap().put(key, value);
			} else {
				this.getMap().put(key, arg.getMap().get(key));
			}
		}
	}

	/**
	 * Adds a key-value pair to the map. If the key exists, the value will be added to the existing value.
	 * 
	 * @param key
	 * @param value
	 */
	public void add(final K key, final Long value) {
		Long concreteValue = value;
		if (this.getMap().containsKey(key))
			concreteValue = value + this.getMap().get(key);
		this.getMap().put(key, concreteValue);

	}

}