package model.quantity;

import model.UserException;
import model.basic.MFalse;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.BasicCalculationExceptionVisitor;
import model.visitor.BasicCalculationReturnExceptionVisitor;
import model.visitor.BasicCalculationReturnVisitor;
import model.visitor.BasicCalculationVisitor;
import model.visitor.UnitImutabCalcExceptionVisitor;
import model.visitor.UnitImutabCalcReturnExceptionVisitor;
import model.visitor.UnitImutabCalcReturnVisitor;
import model.visitor.UnitImutabCalcVisitor;
import persistence.AdditionProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAddition;
import persistence.PersistentBasicCalculation;
import persistence.PersistentMBoolean;
import persistence.TDObserver;

/* Additional import section end */

public class Addition extends model.quantity.UnitImutabCalc implements PersistentAddition{
    
    
    public static PersistentAddition createAddition() throws PersistenceException{
        return createAddition(false);
    }
    
    public static PersistentAddition createAddition(boolean delayed$Persistence) throws PersistenceException {
        PersistentAddition result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade
                .newDelayedAddition();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade
                .newAddition(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAddition createAddition(boolean delayed$Persistence,PersistentAddition This) throws PersistenceException {
        PersistentAddition result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade
                .newDelayedAddition();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade
                .newAddition(-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Addition provideCopy() throws PersistenceException{
        Addition result = this;
        result = new Addition(this.arg1, 
                              this.arg2, 
                              this.resultt, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Addition(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,id);        
    }
    
    static public long getTypeId() {
        return 332;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 332) ConnectionHandler.getTheConnectionHandler().theAdditionFacade
            .newAddition(this.getId());
        super.store();
        
    }
    
    public PersistentAddition getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAddition result = new AdditionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAddition)this.This;
    }
    
    public void accept(UnitImutabCalcVisitor visitor) throws PersistenceException {
        visitor.handleAddition(this);
    }
    public <R> R accept(UnitImutabCalcReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddition(this);
    }
    public <E extends UserException>  void accept(UnitImutabCalcExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddition(this);
    }
    public <R, E extends UserException> R accept(UnitImutabCalcReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddition(this);
    }
    public void accept(BasicCalculationVisitor visitor) throws PersistenceException {
        visitor.handleAddition(this);
    }
    public <R> R accept(BasicCalculationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddition(this);
    }
    public <E extends UserException>  void accept(BasicCalculationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddition(this);
    }
    public <R, E extends UserException> R accept(BasicCalculationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddition(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddition(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddition(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddition(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddition(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArg1() != null) return 1;
        if (this.getArg2() != null) return 1;
        if (this.getResultt() != null) return 1;
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public PersistentMBoolean mustSignInverted() 
				throws PersistenceException{
		return MFalse.getTheMFalse();
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAddition)This);
		if(this.equals(This)){
		}
    }
    public common.Fraction calcFraction(final common.Fraction arg1, final common.Fraction arg2) 
				throws model.NotComputableException, PersistenceException{
		try {
			return arg1.add(arg2);
		} catch (final Throwable e) {
			throw new model.NotComputableException(e.getMessage());
		}
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
