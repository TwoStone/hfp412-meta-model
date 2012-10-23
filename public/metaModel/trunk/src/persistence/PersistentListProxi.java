package persistence;

abstract public class PersistentListProxi<T extends AbstractPersistentRoot> extends SearchListRoot<T> {

	protected abstract void remove(PersistentListEntryProxi entry) throws PersistenceException;

}
