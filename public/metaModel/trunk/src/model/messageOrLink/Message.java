
package model.messageOrLink;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MessageOrLinkExceptionVisitor;
import model.visitor.MessageOrLinkReturnExceptionVisitor;
import model.visitor.MessageOrLinkReturnVisitor;
import model.visitor.MessageOrLinkVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MessageProxi;
import persistence.Message_ActualParametersProxi;
import persistence.PersistenceException;
import persistence.PersistentInstanceObject;
import persistence.PersistentMessage;
import persistence.PersistentMessageOrLink;
import persistence.PersistentOperation;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class Message extends model.messageOrLink.MessageOrLink implements PersistentMessage{
    
    
    public static PersistentMessage createMessage(PersistentInstanceObject source,PersistentInstanceObject target,PersistentOperation type) throws PersistenceException{
        return createMessage(source,target,type,false);
    }
    
    public static PersistentMessage createMessage(PersistentInstanceObject source,PersistentInstanceObject target,PersistentOperation type,boolean delayed$Persistence) throws PersistenceException {
        PersistentMessage result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                .newDelayedMessage();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                .newMessage(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMessage createMessage(PersistentInstanceObject source,PersistentInstanceObject target,PersistentOperation type,boolean delayed$Persistence,PersistentMessage This) throws PersistenceException {
        PersistentMessage result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                .newDelayedMessage();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMessageFacade
                .newMessage(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        final$$Fields.put("type", type);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("actualParameters", this.getActualParameters().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Message provideCopy() throws PersistenceException{
        Message result = this;
        result = new Message(this.source, 
                             this.target, 
                             this.This, 
                             this.type, 
                             this.getId());
        result.actualParameters = this.actualParameters.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentOperation type;
    protected Message_ActualParametersProxi actualParameters;
    
    public Message(PersistentInstanceObject source,PersistentInstanceObject target,PersistentMessageOrLink This,PersistentOperation type,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentInstanceObject)source,(PersistentInstanceObject)target,(PersistentMessageOrLink)This,id);
        this.type = type;
        this.actualParameters = new Message_ActualParametersProxi(this);        
    }
    
    static public long getTypeId() {
        return 133;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 133) ConnectionHandler.getTheConnectionHandler().theMessageFacade
            .newMessage(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theMessageFacade.typeSet(this.getId(), getType());
        }
        this.getActualParameters().store();
        
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentOperation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMessageFacade.typeSet(this.getId(), newValue);
        }
    }
    public Message_ActualParametersProxi getActualParameters() throws PersistenceException {
        return this.actualParameters;
    }
    public PersistentMessage getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMessage result = new MessageProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMessage)this.This;
    }
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException {
        visitor.handleMessage(this);
    }
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMessage(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMessage(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMessage(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1)
            + this.getActualParameters().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMessage)This);
		if(this.equals(This)){
			this.setSource((PersistentInstanceObject)final$$Fields.get("source"));
			this.setTarget((PersistentInstanceObject)final$$Fields.get("target"));
			this.setType((PersistentOperation)final$$Fields.get("type"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
