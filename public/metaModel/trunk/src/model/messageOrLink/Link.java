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
import persistence.LinkProxi;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentLink;
import persistence.PersistentMObject;
import persistence.PersistentMessageOrLink;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Link extends model.messageOrLink.MessageOrLink implements PersistentLink{
    
    
    public static PersistentLink createLink(PersistentMObject source,PersistentMObject target,PersistentAssociation type) throws PersistenceException{
        return createLink(source,target,type,false);
    }
    
    public static PersistentLink createLink(PersistentMObject source,PersistentMObject target,PersistentAssociation type,boolean delayed$Persistence) throws PersistenceException {
        PersistentLink result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLinkFacade
                .newDelayedLink();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLinkFacade
                .newLink(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentLink createLink(PersistentMObject source,PersistentMObject target,PersistentAssociation type,boolean delayed$Persistence,PersistentLink This) throws PersistenceException {
        PersistentLink result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLinkFacade
                .newDelayedLink();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLinkFacade
                .newLink(-1);
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
                result.put("type", type.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Link provideCopy() throws PersistenceException{
        Link result = this;
        result = new Link(this.source, 
                          this.target, 
                          this.This, 
                          this.type, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAssociation type;
    
    public Link(PersistentMObject source,PersistentMObject target,PersistentMessageOrLink This,PersistentAssociation type,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMObject)source,(PersistentMObject)target,(PersistentMessageOrLink)This,id);
        this.type = type;        
    }
    
    static public long getTypeId() {
        return 141;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 141) ConnectionHandler.getTheConnectionHandler().theLinkFacade
            .newLink(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theLinkFacade.typeSet(this.getId(), getType());
        }
        
    }
    
    public PersistentAssociation getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentAssociation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentAssociation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLinkFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentLink getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLink result = new LinkProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentLink)this.This;
    }
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException {
        visitor.handleLink(this);
    }
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLink(this);
    }
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLink(this);
    }
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLink(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLink(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLink(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLink(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLink(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSource() != null) return 1;
        if (this.getTarget() != null) return 1;
        if (this.getType() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLink)This);
		if(this.equals(This)){
			this.setSource((PersistentMObject)final$$Fields.get("source"));
			this.setTarget((PersistentMObject)final$$Fields.get("target"));
			this.setType((PersistentAssociation)final$$Fields.get("type"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
