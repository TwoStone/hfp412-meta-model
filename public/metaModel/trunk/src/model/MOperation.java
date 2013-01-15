
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MOperation extends model.MAbsOperation implements PersistentMOperation{
    
    
    public static PersistentMOperation createMOperation(String name,MType source,MType target) throws PersistenceException{
        return createMOperation(name,source,target,false);
    }
    
    public static PersistentMOperation createMOperation(String name,MType source,MType target,boolean delayed$Persistence) throws PersistenceException {
        PersistentMOperation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMOperationFacade
                .newDelayedMOperation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMOperationFacade
                .newMOperation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMOperation createMOperation(String name,MType source,MType target,boolean delayed$Persistence,PersistentMOperation This) throws PersistenceException {
        PersistentMOperation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMOperationFacade
                .newDelayedMOperation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMOperationFacade
                .newMOperation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("source", source);
        final$$Fields.put("target", target);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MOperation provideCopy() throws PersistenceException{
        MOperation result = this;
        result = new MOperation(this.name, 
                                this.source, 
                                this.target, 
                                this.This, 
                                this.getId());
        result.parameters = this.parameters.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MOperation(String name,MType source,MType target,PersistentMAbsOperation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(MType)source,(MType)target,(PersistentMAbsOperation)This,id);        
    }
    
    static public long getTypeId() {
        return 190;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 190) ConnectionHandler.getTheConnectionHandler().theMOperationFacade
            .newMOperation(name,this.getId());
        super.store();
        
    }
    
    public PersistentMOperation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMOperation result = new MOperationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMOperation)this.This;
    }
    
    public void accept(MAbsOperationVisitor visitor) throws PersistenceException {
        visitor.handleMOperation(this);
    }
    public <R> R accept(MAbsOperationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMOperation(this);
    }
    public <E extends UserException>  void accept(MAbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMOperation(this);
    }
    public <R, E extends UserException> R accept(MAbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMOperation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMOperation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMOperation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMOperation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMOperation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + this.getParameters().getLength());
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
        this.setThis((PersistentMOperation)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setSource((MType)final$$Fields.get("source"));
			this.setTarget((MType)final$$Fields.get("target"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
