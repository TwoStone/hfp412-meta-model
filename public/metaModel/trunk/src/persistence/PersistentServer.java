package persistence;

import model.UserException;

import model.visitor.*;

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
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException;
    public void addAspect(final String name) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException;
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addAtomicType(final PersistentMAspect aspect, final String name) 
				throws PersistenceException;

}

