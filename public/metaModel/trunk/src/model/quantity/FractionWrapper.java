package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FractionWrapperProxi;
import persistence.PersistenceException;
import persistence.PersistentFractionWrapper;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class FractionWrapper extends PersistentObject implements PersistentFractionWrapper{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFractionWrapper getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade.getClass(objectId);
        return (PersistentFractionWrapper)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFractionWrapper createFractionWrapper() throws PersistenceException{
        return createFractionWrapper(false);
    }
    
    public static PersistentFractionWrapper createFractionWrapper(boolean delayed$Persistence) throws PersistenceException {
        PersistentFractionWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade
                .newDelayedFractionWrapper(common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade
                .newFractionWrapper(common.Fraction.Null,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFractionWrapper createFractionWrapper(boolean delayed$Persistence,PersistentFractionWrapper This) throws PersistenceException {
        PersistentFractionWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade
                .newDelayedFractionWrapper(common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade
                .newFractionWrapper(common.Fraction.Null,-1);
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
            result.put("fraction", this.getFraction().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FractionWrapper provideCopy() throws PersistenceException{
        FractionWrapper result = this;
        result = new FractionWrapper(this.fraction, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction fraction;
    protected PersistentFractionWrapper This;
    
    public FractionWrapper(common.Fraction fraction,PersistentFractionWrapper This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fraction = fraction;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 281;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 281) ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade
            .newFractionWrapper(common.Fraction.Null,this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public common.Fraction getFraction() throws PersistenceException {
        return this.fraction;
    }
    public void setFraction(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade.fractionSet(this.getId(), newValue);
        this.fraction = newValue;
    }
    protected void setThis(PersistentFractionWrapper newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFractionWrapper)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFractionWrapperFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentFractionWrapper getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFractionWrapper result = new FractionWrapperProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFractionWrapper)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFractionWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFractionWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFractionWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFractionWrapper(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFractionWrapper)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
