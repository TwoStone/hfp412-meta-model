package persistence;

import model.*;


/* Additional import section end */

public interface Command extends AbstractPersistentProxi {
    
    public void execute() 
				throws PersistenceException;
    public void checkException() 
				throws UserException, PersistenceException;
    public void sendResult() 
				throws PersistenceException;
    public Invoker fetchInvoker() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;

    
}

