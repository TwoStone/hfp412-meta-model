package common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SummableHashMap<K> {

	private final Map<K, Long> map;

	public SummableHashMap() {
		this.map = new HashMap<K, Long>();
	}

	public Map<K, Long> getMap() {
		return map;
	}

	public void aggregate(SummableHashMap<K> arg) {
		Iterator<K> i = arg.getMap().keySet().iterator();
		while (i.hasNext()) {
			K key = i.next();
			if (this.getMap().containsKey(key)) {
				Long value = this.getMap().get(key) + arg.getMap().get(key);
				this.getMap().put(key, value);
			} else {
				this.getMap().put(key, arg.getMap().get(key));
			}
		}
	}

}