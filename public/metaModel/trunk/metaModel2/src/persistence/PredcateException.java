package persistence;


public interface PredcateException<T, E extends model.UserException> {
	
	boolean test(T argument) throws PersistenceException, E;

}
