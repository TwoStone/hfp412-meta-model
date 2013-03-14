package model.quantity;

import model.UserException;
import model.basic.MTrue;
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
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentBasicCalculation;
import persistence.PersistentMBoolean;
import persistence.PersistentSubtraction;
import persistence.SubtractionProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Subtraction extends model.quantity.UnitImutabCalc implements PersistentSubtraction{
    
    
    public static PersistentSubtraction createSubtraction() throws PersistenceException{
        return createSubtraction(false);
    }
    
    public static PersistentSubtraction createSubtraction(boolean delayed$Persistence) throws PersistenceException {
        PersistentSubtraction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSubtractionFacade
                .newDelayedSubtraction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSubtractionFacade
                .newSubtraction(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentSubtraction createSubtraction(boolean delayed$Persistence,PersistentSubtraction This) throws PersistenceException {
        PersistentSubtraction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSubtractionFacade
                .newDelayedSubtraction();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSubtractionFacade
                .newSubtraction(-1);
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
    
    public Subtraction provideCopy() throws PersistenceException{
        Subtraction result = this;
        result = new Subtraction(this.arg1, 
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
    
    public Subtraction(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,id);        
    }
    
    static public long getTypeId() {
        return 330;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 330) ConnectionHandler.getTheConnectionHandler().theSubtractionFacade
            .newSubtraction(this.getId());
        super.store();
        
    }
    
    public PersistentSubtraction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentSubtraction result = new SubtractionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentSubtraction)this.This;
    }
    
    public void accept(UnitImutabCalcVisitor visitor) throws PersistenceException {
        visitor.handleSubtraction(this);
    }
    public <R> R accept(UnitImutabCalcReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubtraction(this);
    }
    public <E extends UserException>  void accept(UnitImutabCalcExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubtraction(this);
    }
    public <R, E extends UserException> R accept(UnitImutabCalcReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubtraction(this);
    }
    public void accept(BasicCalculationVisitor visitor) throws PersistenceException {
        visitor.handleSubtraction(this);
    }
    public <R> R accept(BasicCalculationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubtraction(this);
    }
    public <E extends UserException>  void accept(BasicCalculationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubtraction(this);
    }
    public <R, E extends UserException> R accept(BasicCalculationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubtraction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSubtraction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubtraction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubtraction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubtraction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArg1() != null) return 1;
        if (this.getArg2() != null) return 1;
        if (this.getResultt() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentSubtraction)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public common.Fraction calcFraction(final common.Fraction arg1, final common.Fraction arg2) 
				throws model.NotComputableException, PersistenceException{
		try {
			return arg1.sub(arg2);
		} catch (final Throwable e) {
			throw new model.NotComputableException(e.getMessage());
		}
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public PersistentMBoolean mustSignInverted() 
				throws PersistenceException{
		return MTrue.getTheMTrue();
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
