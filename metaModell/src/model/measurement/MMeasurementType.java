package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MQuantiObjectTypeExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnExceptionVisitor;
import model.visitor.MQuantiObjectTypeReturnVisitor;
import model.visitor.MQuantiObjectTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MMeasurementTypeProxi;
import persistence.MMeasurementTypeSearchList;
import persistence.MModelItemSearchList;
import persistence.MeasurementSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMModelItem;
import persistence.PersistentMQuantiObjectType;
import persistence.PersistentMType;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MMeasurementType extends model.measurement.MQuantiObjectType implements PersistentMMeasurementType{
    
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,String name) throws PersistenceException{
        return createMMeasurementType(type,unitType,name,false);
    }
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMMeasurementType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newDelayedMMeasurementType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newMMeasurementType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("unitType", unitType);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMMeasurementType createMMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,String name,boolean delayed$Persistence,PersistentMMeasurementType This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMMeasurementType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newDelayedMMeasurementType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
                .newMMeasurementType(name,-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static MMeasurementTypeSearchList getMMeasurementTypeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
            .getMMeasurementTypeByName(name);
    }
    
    public MMeasurementType provideCopy() throws PersistenceException{
        MMeasurementType result = this;
        result = new MMeasurementType(this.type, 
                                      this.unitType, 
                                      this.This, 
                                      this.myCONCMModelItem, 
                                      this.name, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    
    public MMeasurementType(PersistentMType type,PersistentAbsUnitType unitType,PersistentMQuantiObjectType This,PersistentMModelItem myCONCMModelItem,String name,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)type,(PersistentAbsUnitType)unitType,(PersistentMQuantiObjectType)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.name = name;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 126) ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade
            .newMMeasurementType(name,this.getId());
        super.store();
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMMeasurementTypeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMMeasurementType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMMeasurementType result = new MMeasurementTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMMeasurementType)this.This;
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMMeasurementType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMMeasurementType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMMeasurementType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMMeasurementType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getType() != null) return 1;
        if (this.getUnitType() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMMeasurementType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMMeasurementType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setType((PersistentMType)final$$Fields.get("type"));
			this.setUnitType((PersistentAbsUnitType)final$$Fields.get("unitType"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public MeasurementSearchList inverseGetType() 
				throws PersistenceException{
        MeasurementSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();

		// Exemplare
		SearchLists.addSecondToFirst(result, getThis().inverseGetType());
		return result;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		// TODO: implement method: prepareForDeletion

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
