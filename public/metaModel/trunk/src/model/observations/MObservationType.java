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
import persistence.MObservationSearchList;
import persistence.MObservationTypeProxi;
import persistence.MObservationTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnum;
import persistence.PersistentMModelItem;
import persistence.PersistentMObservationType;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MObservationType extends PersistentObject implements PersistentMObservationType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMObservationType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.getClass(objectId);
        return (PersistentMObservationType)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMObservationType createMObservationType(String name,PersistentMEnum enumType,PersistentMType theType) throws PersistenceException{
        return createMObservationType(name,enumType,theType,false);
    }
    
    public static PersistentMObservationType createMObservationType(String name,PersistentMEnum enumType,PersistentMType theType,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMObservationType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
                .newDelayedMObservationType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
                .newMObservationType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("enumType", enumType);
        final$$Fields.put("theType", theType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMObservationType createMObservationType(String name,PersistentMEnum enumType,PersistentMType theType,boolean delayed$Persistence,PersistentMObservationType This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMObservationType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
                .newDelayedMObservationType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
                .newMObservationType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("enumType", enumType);
        final$$Fields.put("theType", theType);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            AbstractPersistentRoot enumType = (AbstractPersistentRoot)this.getEnumType();
            if (enumType != null) {
                result.put("enumType", enumType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    enumType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && enumType.hasEssentialFields())enumType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot theType = (AbstractPersistentRoot)this.getTheType();
            if (theType != null) {
                result.put("theType", theType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    theType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && theType.hasEssentialFields())theType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
    
    public static MObservationTypeSearchList getMObservationTypeByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
            .getMObservationTypeByName(name);
    }
    
    public MObservationType provideCopy() throws PersistenceException{
        MObservationType result = this;
        result = new MObservationType(this.name, 
                                      this.enumType, 
                                      this.theType, 
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
    protected PersistentMEnum enumType;
    protected PersistentMType theType;
    protected PersistentMObservationType This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public MObservationType(String name,PersistentMEnum enumType,PersistentMType theType,PersistentMObservationType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.enumType = enumType;
        this.theType = theType;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 344;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 344) ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
            .newMObservationType(name,this.getId());
        super.store();
        if(this.getEnumType() != null){
            this.getEnumType().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.enumTypeSet(this.getId(), getEnumType());
        }
        if(this.getTheType() != null){
            this.getTheType().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.theTypeSet(this.getId(), getTheType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentMEnum getEnumType() throws PersistenceException {
        return this.enumType;
    }
    public void setEnumType(PersistentMEnum newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.enumType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.enumType = (PersistentMEnum)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.enumTypeSet(this.getId(), newValue);
        }
    }
    public PersistentMType getTheType() throws PersistenceException {
        return this.theType;
    }
    public void setTheType(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.theType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.theType = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.theTypeSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentMObservationType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMObservationType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentMObservationType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMObservationType result = new MObservationTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMObservationType)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMObservationType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObservationType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObservationType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObservationType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMObservationType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMObservationType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMObservationType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMObservationType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEnumType() != null) return 1;
        if (this.getTheType() != null) return 1;
        if (this.getDependentItems().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMObservationType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMObservationType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String)final$$Fields.get("name"));
			this.setEnumType((PersistentMEnum)final$$Fields.get("enumType"));
			this.setTheType((PersistentMType)final$$Fields.get("theType"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public MObservationSearchList inverseGetTheType() 
				throws PersistenceException{
        MObservationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade
							.inverseGetTheType(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList getDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().inverseGetTheType());
		return result;
	}
    public MModelItemSearchList getDependentItems(final TDObserver observer) 
				throws PersistenceException{
        return this.getMyCONCMModelItem().getDependentItems(observer);
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
