package utils;

import java.util.Iterator;

import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMType;
import persistence.SearchListRoot;

public class SearchLists {

	private SearchLists() {
	}

	public static MTypeSearchList toMTypeSearchList(SearchListRoot<? extends PersistentMType> searchListRoot)
			throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		Iterator<? extends PersistentMType> iterator = searchListRoot.iterator();
		while (iterator.hasNext()) {
			result.add((iterator.next()));
		}
		return result;
	}
}
