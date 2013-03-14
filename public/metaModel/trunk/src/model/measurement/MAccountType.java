package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAccountTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MAccountTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MAccountTypeHierarchyHIERARCHYVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MQuantiObjectTypeExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnVisitor;
import model.visitor.MQuantiObjectTypeVisitor;
import persistence.AccountSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MAccountTypeHierarchyHIERARCHY;
import persistence.MAccountTypeHierarchyHIERARCHYStrategy;
import persistence.MAccountTypeProxi;
import persistence.MAccountTypeSearchList;
import persistence.MAccountType_SubAccountTypesProxi;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddSubAccountTypeCommand;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAccountType;
import persistence.PersistentMModelItem;
import persistence.PersistentMQuantiObjectType;
import persistence.PersistentMType;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MAccountType extends model.measurement.MQuantiObjectType implements PersistentMAccountType{
    
    
    public static PersistentMAccountType createMAccountType(PersistentMType type,PersistentAbsUnitType unitType,String name) throws PersistenceException{
        return createMAccountType(type,unitType,name,false);
    }
    
    public static PersistentMAccountType createMAccountType(PersistentMType type,PersistentAbsUnitType unitType,String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAccountType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newDelayedMAccountType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newMAccountType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMAccountType createMAccountType(PersistentMType type,PersistentAbsUnitType unitType,String name,boolean delayed$Persistence,PersistentMAccountType This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMAccountType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newDelayedMAccountType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
                .newMAccountType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            result.put("subAccountTypes", this.getSubAccountTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static MAccountTypeSearchList getMAccountTypeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
            .getMAccountTypeByName(name);
    }
    
    public MAccountType provideCopy() throws PersistenceException{
        MAccountType result = this;
        result = new MAccountType(this.type, 
                                  this.unitType, 
                                  this.This, 
                                  this.myCONCMModelItem, 
                                  this.name, 
                                  this.getId());
        result.subAccountTypes = this.subAccountTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected MAccountType_SubAccountTypesProxi subAccountTypes;
    
    public MAccountType(PersistentMType type,PersistentAbsUnitType unitType,PersistentMQuantiObjectType This,PersistentMModelItem myCONCMModelItem,String name,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)type,(PersistentAbsUnitType)unitType,(PersistentMQuantiObjectType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.name = name;
        this.subAccountTypes = new MAccountType_SubAccountTypesProxi(this);        
    }
    
    static public long getTypeId() {
        return 166;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 166) ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
            .newMAccountType(name,this.getId());
        super.store();
        this.getSubAccountTypes().store();
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
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
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
        if (this.getType() != null) return 1;
        if (this.getUnitType() != null) return 1;
        if (this.getSubAccountTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addSubAccountType(final PersistentMAccountType accountType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddSubAccountTypeCommand command = model.meta.AddSubAccountTypeCommand.createAddSubAccountTypeCommand(now, now);
		command.setAccountType(accountType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
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
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMAccountType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setType((PersistentMType)final$$Fields.get("type"));
			this.setUnitType((PersistentAbsUnitType)final$$Fields.get("unitType"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public MAccountTypeSearchList inverseGetSubAccountTypes() 
				throws PersistenceException{
        MAccountTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
							.inverseGetSubAccountTypes(this.getId(), this.getClassId());
		return result;
    }
    public AccountSearchList inverseGetType() 
				throws PersistenceException{
        AccountSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
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
    public void addSubAccountType(final PersistentMAccountType accountType) 
				throws model.CycleException, PersistenceException{
		this.getThis().getSubAccountTypes().add(accountType);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();

		// Subaccount Types
		SearchLists.addSecondToFirst(result, getThis().getSubAccountTypes());

		// Accounts
		SearchLists.addSecondToFirst(result, getThis().inverseGetType());

		// TODO add other dependencies (assocs, MMTypes, etc)
		return result;
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
    
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: delete
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
