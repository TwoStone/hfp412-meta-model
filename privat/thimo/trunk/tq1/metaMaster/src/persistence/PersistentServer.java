package persistence;

public interface PersistentServer extends Invoker, Remote, Anything, AbstractPersistentProxi {
    
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public String getUser() throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    public void accept(model.visitor.InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void handleResult(final Command command) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentActorManager getActorManager(final TDObserver observer) 
				throws PersistenceException;
    public void deleteErrors() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void changeName(final PersistentActor actor, final String nme) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public PersistentActorManager getActorManager() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createActor(final String name) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addRole(final PersistentActor actor, final String roleName) 
				throws PersistenceException;

}

