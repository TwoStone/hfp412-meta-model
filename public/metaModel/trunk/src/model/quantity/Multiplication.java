
package model.quantity;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class Multiplication extends model.quantity.UnitMutabCalc implements PersistentMultiplication{
    
    
    public static PersistentMultiplication createMultiplication() throws PersistenceException{
        return createMultiplication(false);
    }
    
    public static PersistentMultiplication createMultiplication(boolean delayed$Persistence) throws PersistenceException {
        PersistentMultiplication result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade
                .newDelayedMultiplication();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade
                .newMultiplication(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMultiplication createMultiplication(boolean delayed$Persistence,PersistentMultiplication This) throws PersistenceException {
        PersistentMultiplication result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade
                .newDelayedMultiplication();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade
                .newMultiplication(-1);
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
    
    public Multiplication provideCopy() throws PersistenceException{
        Multiplication result = this;
        result = new Multiplication(this.arg1, 
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
    
    public Multiplication(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,PersistentAbsUnit targetUnit,PersistentAbsUnitType targetUnitType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,(PersistentAbsUnit)targetUnit,(PersistentAbsUnitType)targetUnitType,id);        
    }
    
    static public long getTypeId() {
        return 328;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 328) ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade
            .newMultiplication(this.getId());
        super.store();
        
    }
    
    public PersistentMultiplication getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMultiplication result = new MultiplicationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMultiplication)this.This;
    }
    
    public void accept(UnitMutabCalcVisitor visitor) throws PersistenceException {
        visitor.handleMultiplication(this);
    }
    public <R> R accept(UnitMutabCalcReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMultiplication(this);
    }
    public <E extends UserException>  void accept(UnitMutabCalcExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMultiplication(this);
    }
    public <R, E extends UserException> R accept(UnitMutabCalcReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMultiplication(this);
    }
    public void accept(BasicCalculationVisitor visitor) throws PersistenceException {
        visitor.handleMultiplication(this);
    }
    public <R> R accept(BasicCalculationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMultiplication(this);
    }
    public <E extends UserException>  void accept(BasicCalculationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMultiplication(this);
    }
    public <R, E extends UserException> R accept(BasicCalculationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMultiplication(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMultiplication(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMultiplication(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMultiplication(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMultiplication(this);
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
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void calcTargetRefs() 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calcTargetRefs
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMultiplication)This);
		if(this.equals(This)){
		}
    }
    public void calcFraction(final common.Fraction arg1, final common.Fraction arg2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calcFraction
        
    }
    public void calcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calcAtomar
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void calc1Compound1Atomar(final PersistentQuantity atom, final PersistentCompoundQuantity comp) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calc1Compound1Atomar
        
    }
    public void calcComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calcComp
        
    }
    public void calcTargetRefTypes() 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: calcTargetRefTypes
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
