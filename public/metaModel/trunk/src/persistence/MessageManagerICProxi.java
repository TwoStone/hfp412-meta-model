package persistence;

import model.UserException;

import model.visitor.*;

public class MessageManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentMessageManager{
    
    public MessageManagerICProxi(long objectId) {
        super(objectId);
    }
    public MessageManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade
            .getMessageManager(this.getId());
    }
    
    public long getClassId() {
        return 239;
    }
    
    public MessageManager_MessagesProxi getMessages() throws PersistenceException {
        return ((PersistentMessageManager)this.getTheObject()).getMessages();
    }
    public PersistentMessageManager getThis() throws PersistenceException {
        return ((PersistentMessageManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMessageManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMessageManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMessageManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMessageManager(this);
    }
    
    
    public void removeMessage(final PersistentMessage m, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).removeMessage(m, invoker);
    }
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createMessage(type, source, target, ap, invoker);
    }
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).removeMessage(m);
    }
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createStaticMessage(type, name, target, ap, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createVoidMessage(type, source, ap, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createStaticMessage(type, name, target, ap);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createMessage(type, source, target, ap);
    }
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createConst(type, name, target);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).initializeOnCreation();
    }
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createVoidMessage(type, source, ap);
    }
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMessageManager)this.getTheObject()).createConst(type, name, target, invoker);
    }

    
}
