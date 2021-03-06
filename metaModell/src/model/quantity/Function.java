package model.quantity;

import model.UserException;
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
import persistence.FunctionProxi;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentFunction;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class Function extends PersistentObject implements PersistentFunction{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFunction getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFunctionFacade.getClass(objectId);
        return (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant) throws PersistenceException{
        return createFunction(factor,constant,false);
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant,boolean delayed$Persistence) throws PersistenceException {
        PersistentFunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newDelayedFunction(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newFunction(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("factor", factor);
        final$$Fields.put("constant", constant);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFunction createFunction(common.Fraction factor,common.Fraction constant,boolean delayed$Persistence,PersistentFunction This) throws PersistenceException {
        PersistentFunction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newDelayedFunction(factor,constant);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFunctionFacade
                .newFunction(factor,constant,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("factor", factor);
        final$$Fields.put("constant", constant);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("factor", this.getFactor().toString());
            result.put("constant", this.getConstant().toString());
            AbstractPersistentRoot myCONCMModelItem = (AbstractPersistentRoot)this.getMyCONCMModelItem();
            if (myCONCMModelItem != null) {
                result.put("myCONCMModelItem", myCONCMModelItem.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    myCONCMModelItem.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    myCONCMModelItem.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Function provideCopy() throws PersistenceException{
        Function result = this;
        result = new Function(this.factor, 
                              this.constant, 
                              this.This, 
                              this.myCONCMModelItem, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected common.Fraction factor;
    protected common.Fraction constant;
    protected PersistentFunction This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public Function(common.Fraction factor,common.Fraction constant,PersistentFunction This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.factor = factor;
        this.constant = constant;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 137;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 137) ConnectionHandler.getTheConnectionHandler().theFunctionFacade
            .newFunction(factor,constant,this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public common.Fraction getFactor() throws PersistenceException {
        return this.factor;
    }
    public void setFactor(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFunctionFacade.factorSet(this.getId(), newValue);
        this.factor = newValue;
    }
    public common.Fraction getConstant() throws PersistenceException {
        return this.constant;
    }
    public void setConstant(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFunctionFacade.constantSet(this.getId(), newValue);
        this.constant = newValue;
    }
    protected void setThis(PersistentFunction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMModelItem getMyCONCMModelItem() throws PersistenceException {
        return this.myCONCMModelItem;
    }
    public void setMyCONCMModelItem(PersistentMModelItem newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCONCMModelItem)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCONCMModelItem = (PersistentMModelItem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFunctionFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentFunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFunction result = new FunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFunction)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleFunction(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFunction(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFunction(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFunction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFunction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentFunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setFactor((common.Fraction)final$$Fields.get("factor"));
			this.setConstant((common.Fraction)final$$Fields.get("constant"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}
    public common.Fraction executeInverse(final common.Fraction amount) 
				throws PersistenceException{
		Fraction result = null;
		try {
			result = amount.add(this.constant.mul(Fraction.parse("-1"))).mul(factor.invert());
		} catch (final Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
    public common.Fraction execute(final common.Fraction amount) 
				throws PersistenceException{
		Fraction result = null;
		try {
			result = amount.mul(this.factor).add(this.constant);
		} catch (final Throwable e) {
			e.printStackTrace();
		}
		return result;
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
		// implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		//

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
