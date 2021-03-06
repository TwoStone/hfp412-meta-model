package model.quantity;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AbsUnitTypeExceptionVisitor;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AbsUnitTypeVisitor;
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
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentProxi;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.TDObserver;
import persistence.UnitTypeProxi;
import constants.ExceptionConstants;

/* Additional import section end */

public class UnitType extends model.quantity.AbsUnitType implements PersistentUnitType{
    
    
    public static PersistentUnitType createUnitType(String name) throws PersistenceException{
        return createUnitType(name,false);
    }
    
    public static PersistentUnitType createUnitType(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
                .newDelayedUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
                .newUnitType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentUnitType createUnitType(String name,boolean delayed$Persistence,PersistentUnitType This) throws PersistenceException {
        PersistentUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
                .newDelayedUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
                .newUnitType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot defaultUnit = (AbstractPersistentRoot)this.getDefaultUnit();
            if (defaultUnit != null) {
                result.put("defaultUnit", defaultUnit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    defaultUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && defaultUnit.hasEssentialFields())defaultUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public UnitType provideCopy() throws PersistenceException{
        UnitType result = this;
        result = new UnitType(this.name, 
                              this.This, 
                              this.myCONCMModelItem, 
                              this.defaultUnit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentUnit defaultUnit;
    
    public UnitType(String name,PersistentAbsUnitType This,PersistentMModelItem myCONCMModelItem,PersistentUnit defaultUnit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentAbsUnitType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.defaultUnit = defaultUnit;        
    }
    
    static public long getTypeId() {
        return 184;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 184) ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
            .newUnitType(name,this.getId());
        super.store();
        if(this.getDefaultUnit() != null){
            this.getDefaultUnit().store();
            ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade.defaultUnitSet(this.getId(), getDefaultUnit());
        }
        
    }
    
    public PersistentUnit getDefaultUnit() throws PersistenceException {
        return this.defaultUnit;
    }
    public void setDefaultUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.defaultUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.defaultUnit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade.defaultUnitSet(this.getId(), newValue);
        }
    }
    public PersistentUnitType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitType result = new UnitTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnitType)this.This;
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDefaultUnit() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentUnitType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_UNITTYPE);
	}
    public PersistentAbsUnit fetchDefaultUnit() 
				throws model.ConsistencyException, PersistenceException{
		final PersistentUnit result = this.getDefaultUnit();
		if (result == null) {
			throw new ConsistencyException(ExceptionConstants.NO_DEFAULT_UNIT);
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
