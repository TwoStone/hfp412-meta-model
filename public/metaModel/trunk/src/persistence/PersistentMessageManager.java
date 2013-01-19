package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMessageManager extends Anything, AbstractPersistentProxi {
    
    public MessageManager_MessagesProxi getMessages() throws PersistenceException ;
    public PersistentMessageManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException;
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void removeMessage(final PersistentMessage m, final Invoker invoker) 
				throws PersistenceException;
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException;
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException;
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException;
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target, final Invoker invoker) 
				throws PersistenceException;

}

