package persistence;

import model.visitor.*;
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

    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

