package utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import persistence.PersistenceException;
import utils.Lists.FunctionWithResult;

/**
 * Utilityklasse für Sets.
 */
public final class Sets {

	/**
	 * Hide default constructor to prevent instantiation.
	 */
	private Sets() {

	}

	/**
	 * Erstellt ein neues {@link HashSet}.
	 */
	public static <T> HashSet<T> newHashSet() {
		return new HashSet<T>();
	}

	/**
	 * Erstellt ein neues {@link HashSet} mit den übergeben Werten.
	 */
	public static <T> HashSet<T> newHashSet(Collection<? extends T> values) {
		return new HashSet<T>(values);
	}

	/**
	 * Transformiert das übergeben {@link Iterable} in ein Set.
	 */
	public static <T, R> Set<R> transform(Iterable<? extends T> collection, FunctionWithResult<T, R> func)
			throws PersistenceException {
		HashSet<R> result = newHashSet();
		for (T element : collection) {
			result.add(func.apply(element));
		}
		return result;
	}
}
