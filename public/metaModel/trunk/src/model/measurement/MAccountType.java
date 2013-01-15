
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class MAccountType extends model.measurement.MQuantiObjectType implements PersistentMAccountType{
    
    
    public static PersistentMAccountType createMAccountType(MType type,PersistentAbsUnitType unitType) throws PersistenceException{
        return createMAccountType(type,unitType,false);
    }
    
    public static PersistentMAccountType createMAccountType(MType type,PersistentAbsUnitType unitType,boolean delayed$Persistence) throws PersistenceException {
        PersistentMAccountType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newDelayedMAccountType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newMAccountType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMAccountType createMAccountType(MType type,PersistentAbsUnitType unitType,boolean delayed$Persistence,PersistentMAccountType This) throws PersistenceException {
        PersistentMAccountType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newDelayedMAccountType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newMAccountType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("subAccountTypes", this.getSubAccountTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MAccountType provideCopy() throws PersistenceException{
        MAccountType result = this;
        result = new MAccountType(this.type, 
                                  this.unitType, 
                                  this.This, 
                                  this.getId());
        result.subAccountTypes = this.subAccountTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MAccountType_SubAccountTypesProxi subAccountTypes;
    
    public MAccountType(MType type,PersistentAbsUnitType unitType,PersistentMQuantiObjectType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((MType)type,(PersistentAbsUnitType)unitType,(PersistentMQuantiObjectType)This,id);
        this.subAccountTypes = new MAccountType_SubAccountTypesProxi(this);        
    }
    
    static public long getTypeId() {
        return 187;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 187) ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
            .newMAccountType(this.getId());
        super.store();
        this.getSubAccountTypes().store();
        
    }
    
    public MAccountType_SubAccountTypesProxi getSubAccountTypes() throws PersistenceException {
        return this.subAccountTypes;
    }
    public PersistentMAccountType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMAccountType result = new MAccountTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMAccountType)this.This;
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    public void accept(MAccountTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MAccountTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MAccountTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
            + (this.getUnitType() == null ? 0 : 1)
            + this.getSubAccountTypes().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public boolean containsMAccountTypeHierarchy(final MAccountTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getSubAccountTypes().iterator();
		while(iterator0.hasNext())
			if(((MAccountTypeHierarchyHIERARCHY)iterator0.next()).containsMAccountTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMAccountType)This);
		if(this.equals(This)){
			this.setType((MType)final$$Fields.get("type"));
			this.setUnitType((PersistentAbsUnitType)final$$Fields.get("unitType"));
		}
    }
    public <T> T strategyMAccountTypeHierarchy(final T parameter, final MAccountTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$subAccountTypes$$MAccountType = strategy.initialize$$MAccountType$$subAccountTypes(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getSubAccountTypes().iterator();
		while (iterator$$.hasNext()){
			PersistentMAccountType current$$Field = (PersistentMAccountType)iterator$$.next();
			T current$$ = current$$Field.strategyMAccountTypeHierarchy(result$$subAccountTypes$$MAccountType, strategy);
			result$$subAccountTypes$$MAccountType = strategy.consolidate$$MAccountType$$subAccountTypes(getThis(), result$$subAccountTypes$$MAccountType, current$$);
		}
		return strategy.finalize$$MAccountType(getThis(), parameter,result$$subAccountTypes$$MAccountType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
