
package model.messageOrLink;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class MessageManager extends PersistentObject implements PersistentMessageManager{
    
    private static PersistentMessageManager theMessageManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMessageManager getTheMessageManager() throws PersistenceException{
        if (theMessageManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MessageManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade.getTheMessageManager();
                            theMessageManager = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.Hashtable<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentMessageManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMessageManager;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theMessageManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("messages", this.getMessages().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MessageManager provideCopy() throws PersistenceException{
        MessageManager result = this;
        result = new MessageManager(this.This, 
                                    this.getId());
        result.messages = this.messages.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MessageManager_MessagesProxi messages;
    protected PersistentMessageManager This;
    
    public MessageManager(PersistentMessageManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.messages = new MessageManager_MessagesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 168;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public MessageManager_MessagesProxi getMessages() throws PersistenceException {
        return this.messages;
    }
    protected void setThis(PersistentMessageManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMessageManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMessageManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMessageManager result = new MessageManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMessageManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getMessages().getLength());
    }
    
    
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException{
        //TODO: implement method: removeMessage
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        //TODO: implement method: createMessage
        
    }
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        //TODO: implement method: createVoidMessage
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void removeMessage(final PersistentMessage m, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveMessageCommand command = model.meta.RemoveMessageCommand.createRemoveMessageCommand(now, now);
		command.setM(m);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createMessage(final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateMessageCommand command = model.meta.CreateMessageCommand.createCreateMessageCommand(now, now);
		command.setType(type);
		command.setSource(source);
		command.setTarget(target);
		java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while(apIterator.hasNext()){
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateStaticMessageCommand command = model.meta.CreateStaticMessageCommand.createCreateStaticMessageCommand(name, now, now);
		command.setType(type);
		command.setTarget(target);
		java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while(apIterator.hasNext()){
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createVoidMessage(final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateVoidMessageCommand command = model.meta.CreateVoidMessageCommand.createCreateVoidMessageCommand(now, now);
		command.setType(type);
		command.setSource(source);
		java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while(apIterator.hasNext()){
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void createStaticMessage(final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        //TODO: implement method: createStaticMessage
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMessageManager)This);
		if(this.equals(This)){
		}
    }
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        //TODO: implement method: createConst
        
    }
    public void createConst(final PersistentOperation type, final String name, final PersistentInstanceObject target, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateConstCommand command = model.meta.CreateConstCommand.createCreateConstCommand(name, now, now);
		command.setType(type);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
