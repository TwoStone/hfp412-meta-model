package persistence;


public interface Predcate<T> {
	
	boolean test(T argument) throws PersistenceException;

}
