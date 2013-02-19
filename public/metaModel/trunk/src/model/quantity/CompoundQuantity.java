package model.quantity;

import model.NotComputableException;
import model.UserException;
import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsQuantityVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.CompoundQuantityProxi;
import persistence.CompoundQuantity_PartsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentCompoundQuantity;
import persistence.TDObserver;

/* Additional import section end */

public class CompoundQuantity extends model.quantity.AbsQuantity implements PersistentCompoundQuantity{
    
    
    public static PersistentCompoundQuantity createCompoundQuantity() throws PersistenceException{
        return createCompoundQuantity(false);
    }
    
    public static PersistentCompoundQuantity createCompoundQuantity(boolean delayed$Persistence) throws PersistenceException {
        PersistentCompoundQuantity result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                .newDelayedCompoundQuantity();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                .newCompoundQuantity(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompoundQuantity createCompoundQuantity(boolean delayed$Persistence,PersistentCompoundQuantity This) throws PersistenceException {
        PersistentCompoundQuantity result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                .newDelayedCompoundQuantity();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
                .newCompoundQuantity(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("parts", this.getParts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompoundQuantity provideCopy() throws PersistenceException{
        CompoundQuantity result = this;
        result = new CompoundQuantity(this.This, 
                                      this.getId());
        result.parts = this.parts.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompoundQuantity_PartsProxi parts;
    
    public CompoundQuantity(PersistentAbsQuantity This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)This,id);
        this.parts = new CompoundQuantity_PartsProxi(this);        
    }
    
    static public long getTypeId() {
        return 109;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 109) ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade
            .newCompoundQuantity(this.getId());
        super.store();
        this.getParts().store();
        
    }
    
    public CompoundQuantity_PartsProxi getParts() throws PersistenceException {
        return this.parts;
    }
    public PersistentCompoundQuantity getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompoundQuantity result = new CompoundQuantityProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompoundQuantity)this.This;
    }
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundQuantity(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getParts().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompoundQuantity)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
