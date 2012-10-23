package persistence;


/* Additional import section end */

public interface Invoker extends AbstractPersistentProxi {
    
    public void handleResult(final Command command) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;

    
}

