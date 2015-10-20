package utils;

import java.util.Iterator;

import persistence.AbstractPersistentRoot;
import persistence.PersistenceException;
import persistence.SearchListRoot;

public final class Iterables {

	/**
	 * Prevent instantiation of utility classes.
	 */
	private Iterables() {

	}

	public static <T extends AbstractPersistentRoot> Iterable<T> wrap(final SearchListRoot<T> searchList) {
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				try {
					return searchList.iterator();
				} catch (PersistenceException e) {
					throw new RuntimeException(e);
				}
			}
		};
	}

}
