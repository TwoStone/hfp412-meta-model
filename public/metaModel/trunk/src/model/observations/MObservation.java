package model.observations;

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
import persistence.MModelItemSearchList;
import persistence.MObservationProxi;
import persistence.MObservationSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnumValue;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class MObservation extends PersistentObject implements PersistentMObservation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMObservation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.getClass(objectId);
        return (PersistentMObservation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMObservation createMObservation(String name,PersistentMObservationType theType,PersistentMEnumValue enumValue,PersistentMObject theObsObject) throws PersistenceException{
        return createMObservation(name,theType,enumValue,theObsObject,false);
    }
    
    public static PersistentMObservation createMObservation(String name,PersistentMObservationType theType,PersistentMEnumValue enumValue,PersistentMObject theObsObject,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMObservation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
                .newDelayedMObservation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
                .newMObservation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("theType", theType);
        final$$Fields.put("enumValue", enumValue);
        final$$Fields.put("theObsObject", theObsObject);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMObservation createMObservation(String name,PersistentMObservationType theType,PersistentMEnumValue enumValue,PersistentMObject theObsObject,boolean delayed$Persistence,PersistentMObservation This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMObservation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
                .newDelayedMObservation(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
                .newMObservation(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("theType", theType);
        final$$Fields.put("enumValue", enumValue);
        final$$Fields.put("theObsObject", theObsObject);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            AbstractPersistentRoot theType = (AbstractPersistentRoot)this.getTheType();
            if (theType != null) {
                result.put("theType", theType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    theType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && theType.hasEssentialFields())theType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot enumValue = (AbstractPersistentRoot)this.getEnumValue();
            if (enumValue != null) {
                result.put("enumValue", enumValue.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    enumValue.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && enumValue.hasEssentialFields())enumValue.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot theObsObject = (AbstractPersistentRoot)this.getTheObsObject();
            if (theObsObject != null) {
                result.put("theObsObject", theObsObject.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    theObsObject.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && theObsObject.hasEssentialFields())theObsObject.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
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
    
    public static MObservationSearchList getMObservationByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMObservationFacade
            .getMObservationByName(name);
    }
    
    public MObservation provideCopy() throws PersistenceException{
        MObservation result = this;
        result = new MObservation(this.name, 
                                  this.theType, 
                                  this.enumValue, 
                                  this.theObsObject, 
                                  this.This, 
                                  this.myCONCMModelItem, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected PersistentMObservationType theType;
    protected PersistentMEnumValue enumValue;
    protected PersistentMObject theObsObject;
    protected PersistentMObservation This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public MObservation(String name,PersistentMObservationType theType,PersistentMEnumValue enumValue,PersistentMObject theObsObject,PersistentMObservation This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.theType = theType;
        this.enumValue = enumValue;
        this.theObsObject = theObsObject;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 345;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 345) ConnectionHandler.getTheConnectionHandler().theMObservationFacade
            .newMObservation(name,this.getId());
        super.store();
        if(this.getTheType() != null){
            this.getTheType().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theTypeSet(this.getId(), getTheType());
        }
        if(this.getEnumValue() != null){
            this.getEnumValue().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.enumValueSet(this.getId(), getEnumValue());
        }
        if(this.getTheObsObject() != null){
            this.getTheObsObject().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theObsObjectSet(this.getId(), getTheObsObject());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMObservationFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMObservationType getTheType() throws PersistenceException {
        return this.theType;
    }
    public void setTheType(PersistentMObservationType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.theType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.theType = (PersistentMObservationType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMEnumValue getEnumValue() throws PersistenceException {
        return this.enumValue;
    }
    public void setEnumValue(PersistentMEnumValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.enumValue)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.enumValue = (PersistentMEnumValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.enumValueSet(this.getId(), newValue);
        }
    }
    public PersistentMObject getTheObsObject() throws PersistenceException {
        return this.theObsObject;
    }
    public void setTheObsObject(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.theObsObject)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.theObsObject = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theObsObjectSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentMObservation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMObservation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theMObservationFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentMObservation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMObservation result = new MObservationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMObservation)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMObservation(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObservation(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObservation(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObservation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMObservation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObservation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObservation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObservation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTheType() != null) return 1;
        if (this.getEnumValue() != null) return 1;
        if (this.getTheObsObject() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMObservation)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMObservation)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String)final$$Fields.get("name"));
			this.setTheType((PersistentMObservationType)final$$Fields.get("theType"));
			this.setEnumValue((PersistentMEnumValue)final$$Fields.get("enumValue"));
			this.setTheObsObject((PersistentMObject)final$$Fields.get("theObsObject"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
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
