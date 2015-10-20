package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import persistence.PersistenceException;

/**
 * Utilityklasse für Listen.
 * 
 * @author Nik
 * 
 */
public final class Lists {

	/**
	 * Hide default constructor to prevent instantiation.
	 */
	private Lists() {
	}

	/**
	 * Erstellt eine neuen {@link ArrayList}.
	 */
	public static <T> ArrayList<T> newArrayList() {
		return new ArrayList<T>();
	}

	/**
	 * Erstellt eine neue {@link ArrayList} die das übergeben Element und alle Elemente des zweiten Arguments enthält.
	 */
	public static <T> ArrayList<T> newArrayList(T first, Collection<T> others) {
		ArrayList<T> result = newArrayList(others.size() + 1);
		result.add(first);
		result.addAll(others);
		return result;
	}

	/**
	 * Erstellt eine neue {@link ArrayList} mit der angegeben initialen Kapazität.
	 */
	public static <T> ArrayList<T> newArrayList(int initialCapacity) {
		return new ArrayList<T>(initialCapacity);
	}

	/**
	 * Erstellt eine neue {@link ArrayList} aus der übergebenen {@link Collection}.
	 */
	public static <T> ArrayList<T> newArrayList(Collection<? extends T> collection) {
		return new ArrayList<T>(collection);
	}

	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> newArrayList(T... elements) {
		ArrayList<T> list = newArrayList(elements.length);
		for (T element : elements) {
			list.add(element);
		}
		return list;
	}

	/**
	 * Transformiert die Liste elementweise in dem die übergebene {@link FunctionWithResult Funktion} auf jedem Element
	 * angewendet wird.
	 */
	public static <T, R> List<R> transform(List<T> list, FunctionWithResult<T, R> func) throws PersistenceException {
		return transform(list.iterator(), func);
	}

	/**
	 * Transformiert den Iterator elementweise in dem die übergebene {@link FunctionWithResult Funktion} auf jedem
	 * Element angewendet wird.
	 */
	public static <T, R> List<R> transform(Iterator<T> it, FunctionWithResult<T, R> func) throws PersistenceException {
		List<R> result = newArrayList();
		while (it.hasNext()) {
			result.add(func.apply(it.next()));
		}
		return result;
	}

	/**
	 * Liefert eine gefilterte Liste zurück, für welche die Auswertung des {@link Predicate Prädikats} <code>true</code>
	 * liefert.
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) throws PersistenceException {
		return filter(list.iterator(), predicate);
	}

	/**
	 * Liefert eine gefilterte Liste zurück, für welche die Auswertung des {@link Predicate Prädikats} <code>true</code>
	 * liefert.
	 */
	public static <T> List<T> filter(Iterator<T> it, Predicate<T> predicate) throws PersistenceException {
		List<T> result = newArrayList();
		while (it.hasNext()) {
			T element = it.next();
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

	/**
	 * Führt die übergebene {@link Function Funktion} auf jedem Element der Liste aus.
	 */
	public static <T> void each(List<T> list, Function<T> func) throws Exception {
		for (T element : list) {
			func.apply(element);
		}
	}

	public static boolean isEmpty(Iterable<?> iterable) {
		return !iterable.iterator().hasNext();
	}

	public static interface FunctionWithResult<T, R> {
		public R apply(T element) throws PersistenceException;
	}

	public static interface Function<T> {
		public void apply(T element) throws PersistenceException;
	}

	public static interface Predicate<T> {
		public boolean apply(T element) throws PersistenceException;
	}

}
