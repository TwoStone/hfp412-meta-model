package model.quantity;

import model.UserException;
import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsQuantityVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.QuantityProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Quantity extends model.quantity.AbsQuantity implements PersistentQuantity{
    
    
    public static PersistentQuantity createQuantity(common.Fraction amount,PersistentAbsUnit unit) throws PersistenceException{
        return createQuantity(amount,unit,false);
    }
    
    public static PersistentQuantity createQuantity(common.Fraction amount,PersistentAbsUnit unit,boolean delayed$Persistence) throws PersistenceException {
        PersistentQuantity result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
                .newDelayedQuantity(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
                .newQuantity(amount,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("unit", unit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentQuantity createQuantity(common.Fraction amount,PersistentAbsUnit unit,boolean delayed$Persistence,PersistentQuantity This) throws PersistenceException {
        PersistentQuantity result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
                .newDelayedQuantity(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
                .newQuantity(amount,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("unit", unit);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("amount", this.getAmount().toString());
            AbstractPersistentRoot unit = (AbstractPersistentRoot)this.getUnit();
            if (unit != null) {
                result.put("unit", unit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    unit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && unit.hasEssentialFields())unit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Quantity provideCopy() throws PersistenceException{
        Quantity result = this;
        result = new Quantity(this.This, 
                              this.myCONCMModelItem, 
                              this.amount, 
                              this.unit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected common.Fraction amount;
    protected PersistentAbsUnit unit;
    
    public Quantity(PersistentAbsQuantity This,PersistentMModelItem myCONCMModelItem,common.Fraction amount,PersistentAbsUnit unit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.amount = amount;
        this.unit = unit;        
    }
    
    static public long getTypeId() {
        return 194;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 194) ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .newQuantity(amount,this.getId());
        super.store();
        if(this.getUnit() != null){
            this.getUnit().store();
            ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), getUnit());
        }
        
    }
    
    public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theQuantityFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public PersistentAbsUnit getUnit() throws PersistenceException {
        return this.unit;
    }
    public void setUnit(PersistentAbsUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unit = (PersistentAbsUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), newValue);
        }
    }
    public PersistentQuantity getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQuantity result = new QuantityProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentQuantity)this.This;
    }
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUnit() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantity)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentQuantity)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setAmount((common.Fraction)final$$Fields.get("amount"));
			this.setUnit((PersistentAbsUnit)final$$Fields.get("unit"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: delete

	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		// TODO: implement method: fetchDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"fetchDependentItems\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: prepareForDeletion

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
