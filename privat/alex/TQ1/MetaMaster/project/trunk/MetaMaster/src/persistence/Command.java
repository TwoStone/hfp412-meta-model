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
    public void sendException(PersistenceException exception) 
				throws PersistenceException;

    public void accept(model.visitor.CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

