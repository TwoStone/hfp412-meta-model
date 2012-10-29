
package model;

import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsQuantityVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.QuantityProxi;
import persistence.TDObserver;


/* Additional import section end */

public class Quantity extends model.AbsQuantity implements PersistentQuantity{
    
    
    public static PersistentQuantity createQuantity() throws PersistenceException {
        PersistentQuantity result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .newQuantity(common.Fraction.Null);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentQuantity createQuantity(PersistentQuantity This) throws PersistenceException {
        PersistentQuantity result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade
            .newQuantity(common.Fraction.Null);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @Override
	public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("amount", this.getAmount().toString());
            AbstractPersistentRoot unit = this.getUnit();
            if (unit != null) {
                result.put("unit", unit.createProxiInformation(false));
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
    
    @Override
	public Quantity provideCopy() throws PersistenceException{
        Quantity result = this;
        result = new Quantity(this.This, 
                              this.amount, 
                              this.unit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    @Override
	public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction amount;
    protected PersistentUnit unit;
    
    public Quantity(PersistentAbsQuantity This,common.Fraction amount,PersistentUnit unit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(This,id);
        this.amount = amount;
        this.unit = unit;        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    @Override
	public long getClassId() {
        return getTypeId();
    }
    
    @Override
	public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    @Override
	public void setAmount(common.Fraction newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theQuantityFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    @Override
	public PersistentUnit getUnit() throws PersistenceException {
        return this.unit;
    }
    @Override
	public void setUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), newValue);
    }
    @Override
	public PersistentQuantity getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQuantity result = new QuantityProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentQuantity)this.This;
    }
    
    @Override
	public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    @Override
	public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    @Override
	public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    @Override
	public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    @Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantity(this);
    }
    @Override
	public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantity(this);
    }
    @Override
	public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantity(this);
    }
    @Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantity(this);
    }
    @Override
	public int getLeafInfo() throws PersistenceException{
        return 0 
            + (this.getUnit() == null ? 0 : 1);
    }
    
    
    @Override
	public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    @Override
	public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    @Override
	public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantity)This);
		if(this.equals(This)){
		}
    }
    @Override
	public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

	@Override
	public PersistentAbsQuantity divide(PersistentAbsQuantity divisor)
			throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity subtract(PersistentAbsQuantity minuend)
			throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity mult(PersistentAbsQuantity factor)
			throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity add(PersistentAbsQuantity summand)
			throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
