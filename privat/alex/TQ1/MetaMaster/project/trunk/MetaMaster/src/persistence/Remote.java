package persistence;


/* Additional import section end */

public interface Remote extends AbstractPersistentProxi {
    
    public void connected(final String user) 
				throws PersistenceException;
    public void disconnected() 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;

    public void accept(model.visitor.RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

