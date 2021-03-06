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
import persistence.CompUnitSearchList;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentUnit;
import persistence.ReferenceProxi;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class Reference extends PersistentObject implements PersistentReference{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentReference getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.getClass(objectId);
        return (PersistentReference)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentReference createReference(long exponent,PersistentUnit ref) throws PersistenceException{
        return createReference(exponent,ref,false);
    }
    
    public static PersistentReference createReference(long exponent,PersistentUnit ref,boolean delayed$Persistence) throws PersistenceException {
        PersistentReference result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newDelayedReference(exponent);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newReference(exponent,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("exponent", exponent);
        final$$Fields.put("ref", ref);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentReference createReference(long exponent,PersistentUnit ref,boolean delayed$Persistence,PersistentReference This) throws PersistenceException {
        PersistentReference result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newDelayedReference(exponent);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newReference(exponent,-1);
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
    
    public Reference provideCopy() throws PersistenceException{
        Reference result = this;
        result = new Reference(this.exponent, 
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
    protected PersistentUnit ref;
    protected PersistentReference This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public Reference(long exponent,PersistentUnit ref,PersistentReference This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.exponent = exponent;
        this.ref = ref;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 180;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 180) ConnectionHandler.getTheConnectionHandler().theReferenceFacade
            .newReference(exponent,this.getId());
        super.store();
        if(this.getRef() != null){
            this.getRef().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), getRef());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public long getExponent() throws PersistenceException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theReferenceFacade.exponentSet(this.getId(), newValue);
        this.exponent = newValue;
    }
    public PersistentUnit getRef() throws PersistenceException {
        return this.ref;
    }
    public void setRef(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ref)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ref = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentReference newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentReference)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentReference getThis() throws PersistenceException {
        if(this.This == null){
            PersistentReference result = new ReferenceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentReference)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleReference(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReference(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReference(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReference(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentReference)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentReference)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setExponent((Long)final$$Fields.get("exponent"));
			this.setRef((PersistentUnit)final$$Fields.get("ref"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public CompUnitSearchList inverseGetRefs() 
				throws PersistenceException{
        CompUnitSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
							.inverseGetRefs(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_REFERENCE);
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
