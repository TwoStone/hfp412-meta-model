package persistence;


public interface Procdure<T> {

	void doItTo(T argument) throws PersistenceException;

}
