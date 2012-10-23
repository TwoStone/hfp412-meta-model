package persistence;

public interface Aggregtion<Argument, Result> {

	public Result neutral() throws PersistenceException;
	public Result compose(Result result,Argument argument) throws PersistenceException;

}
