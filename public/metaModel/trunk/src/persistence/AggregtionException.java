package persistence;

public interface AggregtionException<Argument, Result, E extends model.UserException> {

	public Result neutral() throws PersistenceException, E;
	public Result compose(Result result,Argument argument) throws PersistenceException, E;

}
