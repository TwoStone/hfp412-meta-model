package persistence;


public interface ProcdureException<T, E extends model.UserException> {

	void doItTo(T argument) throws PersistenceException, E;

}
