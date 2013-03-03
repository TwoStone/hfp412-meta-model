package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.BasicCalculationExceptionVisitor;
import model.visitor.BasicCalculationReturnExceptionVisitor;
import model.visitor.BasicCalculationReturnVisitor;
import model.visitor.BasicCalculationVisitor;
import model.visitor.UnitMutabCalcExceptionVisitor;
import model.visitor.UnitMutabCalcReturnExceptionVisitor;
import model.visitor.UnitMutabCalcReturnVisitor;
import model.visitor.UnitMutabCalcVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.DivisionProxi;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentBasicCalculation;
import persistence.PersistentDivision;
import persistence.TDObserver;

/* Additional import section end */

public class Division extends model.quantity.UnitMutabCalc implements PersistentDivision{
    
    
    public static PersistentDivision createDivision() throws PersistenceException{
        return createDivision(false);
    }
    
    public static PersistentDivision createDivision(boolean delayed$Persistence) throws PersistenceException {
        PersistentDivision result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDivisionFacade
                .newDelayedDivision();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDivisionFacade
                .newDivision(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDivision createDivision(boolean delayed$Persistence,PersistentDivision This) throws PersistenceException {
        PersistentDivision result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDivisionFacade
                .newDelayedDivision();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDivisionFacade
                .newDivision(-1);
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
    
    public Division provideCopy() throws PersistenceException{
        Division result = this;
        result = new Division(this.arg1, 
                              this.arg2, 
                              this.resultt, 
                              this.This, 
                              this.targetUnit, 
                              this.targetUnitType, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Division(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,PersistentAbsUnit targetUnit,PersistentAbsUnitType targetUnitType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,(PersistentAbsUnit)targetUnit,(PersistentAbsUnitType)targetUnitType,id);        
    }
    
    static public long getTypeId() {
        return 333;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 333) ConnectionHandler.getTheConnectionHandler().theDivisionFacade
            .newDivision(this.getId());
        super.store();
        
    }
    
    public PersistentDivision getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDivision result = new DivisionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDivision)this.This;
    }
    
    public void accept(UnitMutabCalcVisitor visitor) throws PersistenceException {
        visitor.handleDivision(this);
    }
    public <R> R accept(UnitMutabCalcReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDivision(this);
    }
    public <E extends UserException>  void accept(UnitMutabCalcExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDivision(this);
    }
    public <R, E extends UserException> R accept(UnitMutabCalcReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDivision(this);
    }
    public void accept(BasicCalculationVisitor visitor) throws PersistenceException {
        visitor.handleDivision(this);
    }
    public <R> R accept(BasicCalculationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDivision(this);
    }
    public <E extends UserException>  void accept(BasicCalculationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDivision(this);
    }
    public <R, E extends UserException> R accept(BasicCalculationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDivision(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDivision(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDivision(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDivision(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDivision(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArg1() != null) return 1;
        if (this.getArg2() != null) return 1;
        if (this.getResultt() != null) return 1;
        if (this.getTargetUnit() != null) return 1;
        if (this.getTargetUnitType() != null) return 1;
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void calcTargetRefs() 
				throws model.NotComputableException, PersistenceException{
		// TODO: implement method: calcTargetRefs

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDivision)This);
		if(this.equals(This)){
		}
    }
    public common.Fraction calcFraction(final common.Fraction arg1, final common.Fraction arg2) 
				throws model.NotComputableException, PersistenceException{
		// TODO: implement method: calcFraction
		try {
			throw new java.lang.UnsupportedOperationException("Method \"calcFraction\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void calcTargetRefTypes() 
				throws model.NotComputableException, PersistenceException{
		// TODO: implement method: calcTargetRefTypes

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
