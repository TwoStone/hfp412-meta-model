
package model;

import persistence.*;


/* Additional import section end */

public class Quantity extends model.AbsQuantity implements PersistentQuantity{
    
    
    public static PersistentQuantity createQuantity(PersistentFraction amount,PersistentUnit unit) throws PersistenceException {
        PersistentQuantity result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .newQuantity();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("unit", unit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentQuantity createQuantity(PersistentFraction amount,PersistentUnit unit,PersistentQuantity This) throws PersistenceException {
        PersistentQuantity result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .newQuantity();
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
            AbstractPersistentRoot amount = (AbstractPersistentRoot)this.getAmount();
            if (amount != null) {
                result.put("amount", amount.createProxiInformation());
                if(depth > 1) {
                    amount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && amount.hasEssentialFields())amount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot unit = (AbstractPersistentRoot)this.getUnit();
            if (unit != null) {
                result.put("unit", unit.createProxiInformation());
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
                              this.amount, 
                              this.unit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentFraction amount;
    protected PersistentUnit unit;
    
    public Quantity(PersistentAbsQuantity This,PersistentFraction amount,PersistentUnit unit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)This,id);
        this.amount = amount;
        this.unit = unit;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentFraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(PersistentFraction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.amount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.amount = (PersistentFraction)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theQuantityFacade.amountSet(this.getId(), newValue);
    }
    public PersistentUnit getUnit() throws PersistenceException {
        return this.unit;
    }
    public void setUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), newValue);
    }
    public PersistentQuantity getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQuantity result = new QuantityProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentQuantity)this.This;
    }
    
    public void accept(model.visitor.AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(model.visitor.AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getAmount() == null ? 0 : 1)
            + (this.getUnit() == null ? 0 : 1));
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
        this.setThis((PersistentQuantity)This);
		if(this.equals(This)){
			this.setAmount((PersistentFraction)final$$Fields.get("amount"));
			this.setUnit((PersistentUnit)final$$Fields.get("unit"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
