package utils;

import java.util.Iterator;

import persistence.PersistenceException;

/**
 * Utilityklasse für den Umgange mit Strings.
 */
public final class Strings {

	/**
	 * Privater Konstruktor zum verhindern der Instanzierung.
	 */
	private Strings() {
	}

	/**
	 * Liefert die Stringrepräsentation des Iterators, wobei die einzelenen Elemente mit dem übergeben "glue verklebt"
	 * werden. Die String Repräsentation der einzelnen Elemente wird anhand der übergebenen {@link ToStringStrategy}
	 * ermittelt.
	 * 
	 */
	public static <T> String join(String glue, Iterator<T> iterator, ToStringStrategy<T> strategy)
			throws PersistenceException {
		StringBuilder builder = new StringBuilder();

		if (iterator.hasNext()) {
			builder.append(strategy.getString(iterator.next()));
		}

		while (iterator.hasNext()) {
			builder.append(glue);
			builder.append(strategy.getString(iterator.next()));
		}

		return builder.toString();
	}

	/**
	 * Funktioniert wie die Methode {@link #join(String, Iterator, ToStringStrategy)}, wobei für die
	 * Stringrepräsentation der Elemente {@link Object#toString()} aufgerufen wird.
	 */
	public static <T> String join(String glue, Iterator<T> iterator) throws PersistenceException {
		return join(glue, iterator, new ToStringStrategy<T>() {

			@Override
			public String getString(T element) {
				return element.toString();
			}
		});
	}

	/**
	 * Stratgie um einem Element eine Stringrepräsentation zu zuordnen.
	 */
	public static interface ToStringStrategy<T> {
		public abstract String getString(T element) throws PersistenceException;
	}
}
