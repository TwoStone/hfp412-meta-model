
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class CONCMModelItem extends model.MModelItem implements PersistentCONCMModelItem{
    
    
    public static PersistentCONCMModelItem createCONCMModelItem(boolean delayed$Persistence,PersistentCONCMModelItem This) throws PersistenceException {
        PersistentCONCMModelItem result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCONCMModelItemFacade
                .newDelayedCONCMModelItem();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCONCMModelItemFacade
                .newCONCMModelItem(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
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
    
    public CONCMModelItem provideCopy() throws PersistenceException{
        CONCMModelItem result = this;
        result = new CONCMModelItem(this.This, 
                                    this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public CONCMModelItem(PersistentMModelItem This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMModelItem)This,id);        
    }
    
    static public long getTypeId() {
        return 324;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 324) ConnectionHandler.getTheConnectionHandler().theCONCMModelItemFacade
            .newCONCMModelItem(this.getId());
        super.store();
        
    }
    
    public PersistentCONCMModelItem getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCONCMModelItem result = new CONCMModelItemProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCONCMModelItem)this.This;
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleCONCMModelItem(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCONCMModelItem(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCONCMModelItem(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCONCMModelItem(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCONCMModelItem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCONCMModelItem(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCONCMModelItem(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCONCMModelItem(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getDependentItems().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public MModelItemSearchList getDependentItems() 
				throws PersistenceException{
        return getThis().getDependentItems();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCONCMModelItem)This);
		if(this.equals(This)){
		}
    }
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
        getThis().prepareForDeletion();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
