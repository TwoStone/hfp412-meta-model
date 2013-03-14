package utils;

import persistence.PersistenceException;
import persistence.Predcate;

public class TruePredcate<T> implements Predcate<T> {

	@Override
	public boolean test(T argument) throws PersistenceException {
		return true;
	}
}
