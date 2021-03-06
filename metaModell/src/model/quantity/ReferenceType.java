package model.quantity;

import model.ConsistencyException;
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
import persistence.CompUnitTypeSearchList;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReferenceType;
import persistence.PersistentUnitType;
import persistence.ReferenceTypeProxi;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class ReferenceType extends PersistentObject implements PersistentReferenceType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentReferenceType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.getClass(objectId);
        return (PersistentReferenceType)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentReferenceType createReferenceType(long exponent,PersistentUnitType ref) throws PersistenceException{
        return createReferenceType(exponent,ref,false);
    }
    
    public static PersistentReferenceType createReferenceType(long exponent,PersistentUnitType ref,boolean delayed$Persistence) throws PersistenceException {
        PersistentReferenceType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
                .newDelayedReferenceType(exponent);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
                .newReferenceType(exponent,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("exponent", exponent);
        final$$Fields.put("ref", ref);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentReferenceType createReferenceType(long exponent,PersistentUnitType ref,boolean delayed$Persistence,PersistentReferenceType This) throws PersistenceException {
        PersistentReferenceType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
                .newDelayedReferenceType(exponent);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
                .newReferenceType(exponent,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("exponent", exponent);
        final$$Fields.put("ref", ref);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("exponent", new Long(this.getExponent()).toString());
            AbstractPersistentRoot ref = (AbstractPersistentRoot)this.getRef();
            if (ref != null) {
                result.put("ref", ref.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    ref.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && ref.hasEssentialFields())ref.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
    
    public ReferenceType provideCopy() throws PersistenceException{
        ReferenceType result = this;
        result = new ReferenceType(this.exponent, 
                                   this.ref, 
                                   this.This, 
                                   this.myCONCMModelItem, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected long exponent;
    protected PersistentUnitType ref;
    protected PersistentReferenceType This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public ReferenceType(long exponent,PersistentUnitType ref,PersistentReferenceType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.exponent = exponent;
        this.ref = ref;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 182;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 182) ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade
            .newReferenceType(exponent,this.getId());
        super.store();
        if(this.getRef() != null){
            this.getRef().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.refSet(this.getId(), getRef());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public long getExponent() throws PersistenceException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.exponentSet(this.getId(), newValue);
        this.exponent = newValue;
    }
    public PersistentUnitType getRef() throws PersistenceException {
        return this.ref;
    }
    public void setRef(PersistentUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ref)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ref = (PersistentUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.refSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentReferenceType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentReferenceType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theReferenceTypeFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentReferenceType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentReferenceType result = new ReferenceTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentReferenceType)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleReferenceType(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReferenceType(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReferenceType(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReferenceType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReferenceType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReferenceType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReferenceType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReferenceType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentReferenceType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentReferenceType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setExponent((Long)final$$Fields.get("exponent"));
			this.setRef((PersistentUnitType)final$$Fields.get("ref"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public CompUnitTypeSearchList inverseGetRefs() 
				throws PersistenceException{
        CompUnitTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
							.inverseGetRefs(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_REFERENCE_TYPE);
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
