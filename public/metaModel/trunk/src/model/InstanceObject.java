
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.InstanceObjectProxi;
import persistence.PersistenceException;
import persistence.PersistentInstanceObject;
import persistence.PersistentMAtomicType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.QuantifObjectSearchList;
import persistence.TDObserver;


/* Additional import section end */

public class InstanceObject extends PersistentObject implements PersistentInstanceObject{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentInstanceObject getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.getClass(objectId);
        return (PersistentInstanceObject)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentInstanceObject createInstanceObject(PersistentMAtomicType type) throws PersistenceException{
        return createInstanceObject(type,false);
    }
    
    public static PersistentInstanceObject createInstanceObject(PersistentMAtomicType type,boolean delayed$Persistence) throws PersistenceException {
        PersistentInstanceObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
                .newDelayedInstanceObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
                .newInstanceObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentInstanceObject createInstanceObject(PersistentMAtomicType type,boolean delayed$Persistence,PersistentInstanceObject This) throws PersistenceException {
        PersistentInstanceObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
                .newDelayedInstanceObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
                .newInstanceObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
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
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public InstanceObject provideCopy() throws PersistenceException{
        InstanceObject result = this;
        result = new InstanceObject(this.type, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMAtomicType type;
    protected PersistentInstanceObject This;
    
    public InstanceObject(PersistentMAtomicType type,PersistentInstanceObject This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 130) ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
            .newInstanceObject(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.typeSet(this.getId(), getType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentMAtomicType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.typeSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentInstanceObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentInstanceObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentInstanceObject getThis() throws PersistenceException {
        if(this.This == null){
            PersistentInstanceObject result = new InstanceObjectProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentInstanceObject)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleInstanceObject(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInstanceObject(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInstanceObject(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInstanceObject(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public QuantifObjectSearchList inverseGetObject() 
				throws PersistenceException{
        QuantifObjectSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade
							.inverseGetObject(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentInstanceObject)This);
		if(this.equals(This)){
			this.setType((PersistentMAtomicType)final$$Fields.get("type"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
