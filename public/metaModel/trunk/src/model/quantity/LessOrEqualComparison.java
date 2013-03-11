
package model.quantity;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class LessOrEqualComparison extends PersistentObject implements PersistentLessOrEqualComparison{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentLessOrEqualComparison getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade.getClass(objectId);
        return (PersistentLessOrEqualComparison)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentLessOrEqualComparison createLessOrEqualComparison() throws PersistenceException{
        return createLessOrEqualComparison(false);
    }
    
    public static PersistentLessOrEqualComparison createLessOrEqualComparison(boolean delayed$Persistence) throws PersistenceException {
        PersistentLessOrEqualComparison result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
                .newDelayedLessOrEqualComparison();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
                .newLessOrEqualComparison(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentLessOrEqualComparison createLessOrEqualComparison(boolean delayed$Persistence,PersistentLessOrEqualComparison This) throws PersistenceException {
        PersistentLessOrEqualComparison result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
                .newDelayedLessOrEqualComparison();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
                .newLessOrEqualComparison(-1);
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
            AbstractPersistentRoot arg1 = (AbstractPersistentRoot)this.getArg1();
            if (arg1 != null) {
                result.put("arg1", arg1.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    arg1.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && arg1.hasEssentialFields())arg1.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot arg2 = (AbstractPersistentRoot)this.getArg2();
            if (arg2 != null) {
                result.put("arg2", arg2.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    arg2.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && arg2.hasEssentialFields())arg2.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public LessOrEqualComparison provideCopy() throws PersistenceException{
        LessOrEqualComparison result = this;
        result = new LessOrEqualComparison(this.getId());
        result.arg1 = this.arg1;
        result.arg2 = this.arg2;
        result.This = this.This;
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbsQuantity arg1;
    protected PersistentAbsQuantity arg2;
    protected PersistentLessOrEqualComparison This;
    
    public LessOrEqualComparison(long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);        
    }
    
    static public long getTypeId() {
        return -380;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -380) ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
            .newLessOrEqualComparison(this.getId());
        super.store();
        
    }
    
    public PersistentAbsQuantity getArg1() throws PersistenceException {
        return this.arg1;
    }
    public void setArg1(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.arg1)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.arg1 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
    }
    public PersistentAbsQuantity getArg2() throws PersistenceException {
        return this.arg2;
    }
    public void setArg2(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.arg2)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.arg2 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
    }
    protected void setThis(PersistentLessOrEqualComparison newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLessOrEqualComparison)PersistentProxi.createProxi(objectId, classId);
    }
    public PersistentLessOrEqualComparison getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLessOrEqualComparison result = new LessOrEqualComparisonProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentLessOrEqualComparison)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLessOrEqualComparison(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLessOrEqualComparison(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLessOrEqualComparison(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLessOrEqualComparison(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getArg1() != null) return 1;
        if (this.getArg2() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLessOrEqualComparison)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public PersistentMBoolean compareAtomar(final PersistentQuantity arg1, final PersistentQuantity arg2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: compareAtomar
        try{
            throw new java.lang.UnsupportedOperationException("Method \"compareAtomar\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public PersistentMBoolean compareComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: compareComp
        try{
            throw new java.lang.UnsupportedOperationException("Method \"compareComp\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public PersistentMBoolean compareMixed(final PersistentCompoundQuantity comp, final PersistentQuantity atom) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: compareMixed
        try{
            throw new java.lang.UnsupportedOperationException("Method \"compareMixed\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public PersistentMBoolean compare() 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: compare
        try{
            throw new java.lang.UnsupportedOperationException("Method \"compare\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
