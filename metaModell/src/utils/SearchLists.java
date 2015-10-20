package utils;

import java.util.Iterator;

import persistence.AbstractPersistentRoot;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.Predcate;
import persistence.SearchListRoot;

public class SearchLists {

	private SearchLists() {
	}

	public static MTypeSearchList toMTypeSearchList(final SearchListRoot<? extends PersistentMType> searchListRoot)
			throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		final Iterator<? extends PersistentMType> iterator = searchListRoot.iterator();
		while (iterator.hasNext()) {
			result.add((iterator.next()));
		}
		return result;
	}

	public static MTypeSearchList createMTypeSearchList(final PersistentMType... types) throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		for (final PersistentMType cType : types) {
			result.add(cType);
		}
		return result;
	}

	public static MModelItemSearchList addSecondToFirst(final MModelItemSearchList a,
			final SearchListRoot<? extends PersistentMModelItem> b) throws PersistenceException {
		final Iterator<? extends PersistentMModelItem> iterator = b.iterator();
		while (iterator.hasNext()) {
			a.add(iterator.next());
		}
		return a;
	}

	public static MTypeSearchList addSecondToFirst(final MTypeSearchList a,
			final SearchListRoot<? extends PersistentMType> b) throws PersistenceException {
		final Iterator<? extends PersistentMType> iterator = b.iterator();
		while (iterator.hasNext()) {
			a.add(iterator.next());
		}
		return a;
	}

	public static boolean contains(final MTypeSearchList list, final AbstractPersistentRoot item)
			throws PersistenceException {
		return list.findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return argument.equals(item);
			}
		}) != null;
	}

}
