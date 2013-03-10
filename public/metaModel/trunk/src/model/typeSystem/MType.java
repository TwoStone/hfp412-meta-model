package model.typeSystem;

import persistence.AbsOperationSearchList;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FormalParameterSearchList;
import persistence.MMixedConjunctionSearchList;
import persistence.MMixedTypeDisjunctionSearchList;
import persistence.MModelItemSearchList;
import persistence.MObservationTypeSearchList;
import persistence.MQuantiObjectTypeSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public abstract class MType extends PersistentObject implements PersistentMType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getClass(objectId);
        return (PersistentMType)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("inverseOPTarget", this.getInverseOPTarget().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("mTDJContainingMe", this.getMTDJContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("inverseFormalParameterType", this.getInverseFormalParameterType().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("mTCContainingMe", this.getMTCContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("quantifiedObjektTypes", this.getQuantifiedObjektTypes().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
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
    
    public abstract MType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMType This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public MType(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 172;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMTypeFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theMTypeFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    protected void setThis(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMTypeFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theMTypeFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public abstract PersistentMType getThis() throws PersistenceException ;
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    
    
    public FormalParameterSearchList getInverseFormalParameterType() 
				throws PersistenceException{
        FormalParameterSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
							.inverseGetOfType(this.getId(), this.getClassId());
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public AbsOperationSearchList getInverseOPTarget() 
				throws PersistenceException{
        AbsOperationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade
							.inverseGetTarget(this.getId(), this.getClassId());
		return result;
    }
    public MMixedConjunctionSearchList getMTCContainingMe() 
				throws PersistenceException{
        MMixedConjunctionSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade
							.inverseGetFactors(this.getId(), this.getClassId());
		return result;
    }
    public MMixedTypeDisjunctionSearchList getMTDJContainingMe() 
				throws PersistenceException{
        MMixedTypeDisjunctionSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade
							.inverseGetAddends(this.getId(), this.getClassId());
		return result;
    }
    public MQuantiObjectTypeSearchList getQuantifiedObjektTypes() 
				throws PersistenceException{
        MQuantiObjectTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMQuantiObjectTypeFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMType)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMType)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public AbsOperationSearchList inverseGetSource() 
				throws PersistenceException{
        AbsOperationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade
							.inverseGetSource(this.getId(), this.getClassId());
		return result;
    }
    public MObservationTypeSearchList inverseGetTheType() 
				throws PersistenceException{
        MObservationTypeSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theMObservationTypeFacade
							.inverseGetTheType(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().fetchAdditionalDependentItems());
		// TYPES
		SearchLists.addSecondToFirst(result, getThis().filteredFetchTypesContainingThisDirectly());
		// OBSERVATIONS
		SearchLists.addSecondToFirst(result, getThis().inverseGetTheType());
		// PARAMS
		SearchLists.addSecondToFirst(result, getThis().getInverseFormalParameterType());
		// OPERATIONS
		SearchLists.addSecondToFirst(result, getThis().getInverseOPTarget());
		SearchLists.addSecondToFirst(result, getThis().inverseGetSource());

		// TODO add other dependencies (assocs, MMTypes, etc)
		return result;
	}
    public MTypeSearchList filteredFetchTypesContainingThisDirectly() 
				throws PersistenceException{

		// Kruecke weil transiente inverse im FW persistiert werden !?
		final MTypeSearchList result = getThis().fetchTypesContainingThisDirectly();
		result.filter(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return TypeManager.getTheTypeManager().containsType(argument).toBoolean();
			}
		});

		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
