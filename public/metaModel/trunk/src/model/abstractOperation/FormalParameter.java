package model.abstractOperation;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.AbsOperationSearchList;
import persistence.AbstractPersistentRoot;
import persistence.ActualParameterSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FormalParameterProxi;
import persistence.FormalParameterSearchList;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentFormalParameter;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class FormalParameter extends PersistentObject implements PersistentFormalParameter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFormalParameter getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.getClass(objectId);
        return (PersistentFormalParameter)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFormalParameter createFormalParameter(PersistentMType ofType,String name) throws PersistenceException{
        return createFormalParameter(ofType,name,false);
    }
    
    public static PersistentFormalParameter createFormalParameter(PersistentMType ofType,String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentFormalParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
                .newDelayedFormalParameter(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
                .newFormalParameter(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("ofType", ofType);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFormalParameter createFormalParameter(PersistentMType ofType,String name,boolean delayed$Persistence,PersistentFormalParameter This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentFormalParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
                .newDelayedFormalParameter(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
                .newFormalParameter(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("ofType", ofType);
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot ofType = (AbstractPersistentRoot)this.getOfType();
            if (ofType != null) {
                result.put("ofType", ofType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    ofType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && ofType.hasEssentialFields())ofType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("name", this.getName());
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
    
    public static FormalParameterSearchList getFormalParameterByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
            .getFormalParameterByName(name);
    }
    
    public FormalParameter provideCopy() throws PersistenceException{
        FormalParameter result = this;
        result = new FormalParameter(this.ofType, 
                                     this.name, 
                                     this.This, 
                                     this.myCONCMModelItem, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMType ofType;
    protected String name;
    protected PersistentFormalParameter This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public FormalParameter(PersistentMType ofType,String name,PersistentFormalParameter This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.ofType = ofType;
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 119) ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade
            .newFormalParameter(name,this.getId());
        super.store();
        if(this.getOfType() != null){
            this.getOfType().store();
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.ofTypeSet(this.getId(), getOfType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public PersistentMType getOfType() throws PersistenceException {
        return this.ofType;
    }
    public void setOfType(PersistentMType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ofType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ofType = (PersistentMType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.ofTypeSet(this.getId(), newValue);
        }
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentFormalParameter newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFormalParameter)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theFormalParameterFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentFormalParameter getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFormalParameter result = new FormalParameterProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFormalParameter)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleFormalParameter(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFormalParameter(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFormalParameter(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFormalParameter(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFormalParameter(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getOfType() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFormalParameter)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentFormalParameter)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setOfType((PersistentMType)final$$Fields.get("ofType"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public AbsOperationSearchList inverseGetParameters() 
				throws PersistenceException{
        AbsOperationSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade
							.inverseGetParameters(this.getId(), this.getClassId());
		return result;
    }
    public ActualParameterSearchList inverseGetType() 
				throws PersistenceException{
        ActualParameterSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
							.inverseGetType(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().inverseGetParameters());
		SearchLists.addSecondToFirst(result, getThis().inverseGetType());
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
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
