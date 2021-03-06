package model.naming;

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
import persistence.NameInstanceProxi;
import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentName;
import persistence.PersistentNameInstance;
import persistence.PersistentNameSchemeInstance;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class NameInstance extends PersistentObject implements PersistentNameInstance{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentNameInstance getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.getClass(objectId);
        return (PersistentNameInstance)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentNameInstance createNameInstance(PersistentName type,PersistentAbstractObject fromObject,PersistentNameSchemeInstance nameScheme) throws PersistenceException{
        return createNameInstance(type,fromObject,nameScheme,false);
    }
    
    public static PersistentNameInstance createNameInstance(PersistentName type,PersistentAbstractObject fromObject,PersistentNameSchemeInstance nameScheme,boolean delayed$Persistence) throws PersistenceException {
        PersistentNameInstance result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
                .newDelayedNameInstance();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
                .newNameInstance(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("fromObject", fromObject);
        final$$Fields.put("nameScheme", nameScheme);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentNameInstance createNameInstance(PersistentName type,PersistentAbstractObject fromObject,PersistentNameSchemeInstance nameScheme,boolean delayed$Persistence,PersistentNameInstance This) throws PersistenceException {
        PersistentNameInstance result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
                .newDelayedNameInstance();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
                .newNameInstance(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("fromObject", fromObject);
        final$$Fields.put("nameScheme", nameScheme);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot fromObject = (AbstractPersistentRoot)this.getFromObject();
            if (fromObject != null) {
                result.put("fromObject", fromObject.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    fromObject.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fromObject.hasEssentialFields())fromObject.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot nameScheme = (AbstractPersistentRoot)this.getNameScheme();
            if (nameScheme != null) {
                result.put("nameScheme", nameScheme.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    nameScheme.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && nameScheme.hasEssentialFields())nameScheme.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
    
    public NameInstance provideCopy() throws PersistenceException{
        NameInstance result = this;
        result = new NameInstance(this.type, 
                                  this.fromObject, 
                                  this.nameScheme, 
                                  this.This, 
                                  this.myCONCMModelItem, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentName type;
    protected PersistentAbstractObject fromObject;
    protected PersistentNameSchemeInstance nameScheme;
    protected PersistentNameInstance This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public NameInstance(PersistentName type,PersistentAbstractObject fromObject,PersistentNameSchemeInstance nameScheme,PersistentNameInstance This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        this.fromObject = fromObject;
        this.nameScheme = nameScheme;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 248;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 248) ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade
            .newNameInstance(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.typeSet(this.getId(), getType());
        }
        if(this.getFromObject() != null){
            this.getFromObject().store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.fromObjectSet(this.getId(), getFromObject());
        }
        if(this.getNameScheme() != null){
            this.getNameScheme().store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.nameSchemeSet(this.getId(), getNameScheme());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public PersistentName getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentName newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentName)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentAbstractObject getFromObject() throws PersistenceException {
        return this.fromObject;
    }
    public void setFromObject(PersistentAbstractObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fromObject)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromObject = (PersistentAbstractObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.fromObjectSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeInstance getNameScheme() throws PersistenceException {
        return this.nameScheme;
    }
    public void setNameScheme(PersistentNameSchemeInstance newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.nameScheme)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.nameScheme = (PersistentNameSchemeInstance)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.nameSchemeSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentNameInstance newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentNameInstance)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.ThisSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentNameInstance getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNameInstance result = new NameInstanceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNameInstance)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleNameInstance(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameInstance(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameInstance(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameInstance(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNameInstance(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameInstance(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameInstance(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameInstance(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getType() != null) return 1;
        if (this.getFromObject() != null) return 1;
        if (this.getNameScheme() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNameInstance)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentNameInstance)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setType((PersistentName)final$$Fields.get("type"));
			this.setFromObject((PersistentAbstractObject)final$$Fields.get("fromObject"));
			this.setNameScheme((PersistentNameSchemeInstance)final$$Fields.get("nameScheme"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		return new MModelItemSearchList();
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
