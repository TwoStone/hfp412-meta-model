package persistence;


/* Additional import section end */

public interface Invoker extends AbstractPersistentProxi {
    
    public void handleResult(final Command command) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;

    public void accept(model.visitor.InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

