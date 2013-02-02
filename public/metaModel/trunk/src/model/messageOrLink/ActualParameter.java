
package model.messageOrLink;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.ActualParameterProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentActualParameter;
import persistence.PersistentFormalParameter;
import persistence.PersistentInstanceObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class ActualParameter extends PersistentObject implements PersistentActualParameter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentActualParameter getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.getClass(objectId);
        return (PersistentActualParameter)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentActualParameter createActualParameter(PersistentFormalParameter type,PersistentInstanceObject value) throws PersistenceException{
        return createActualParameter(type,value,false);
    }
    
    public static PersistentActualParameter createActualParameter(PersistentFormalParameter type,PersistentInstanceObject value,boolean delayed$Persistence) throws PersistenceException {
        PersistentActualParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
                .newDelayedActualParameter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
                .newActualParameter(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("value", value);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentActualParameter createActualParameter(PersistentFormalParameter type,PersistentInstanceObject value,boolean delayed$Persistence,PersistentActualParameter This) throws PersistenceException {
        PersistentActualParameter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
                .newDelayedActualParameter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
                .newActualParameter(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("value", value);
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
            AbstractPersistentRoot value = (AbstractPersistentRoot)this.getValue();
            if (value != null) {
                result.put("value", value.createProxiInformation(false));
                if(depth > 1) {
                    value.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && value.hasEssentialFields())value.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ActualParameter provideCopy() throws PersistenceException{
        ActualParameter result = this;
        result = new ActualParameter(this.type, 
                                     this.value, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentFormalParameter type;
    protected PersistentInstanceObject value;
    protected PersistentActualParameter This;
    
    public ActualParameter(PersistentFormalParameter type,PersistentInstanceObject value,PersistentActualParameter This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        this.value = value;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 194;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 194) ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
            .newActualParameter(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.typeSet(this.getId(), getType());
        }
        if(this.getValue() != null){
            this.getValue().store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.valueSet(this.getId(), getValue());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentFormalParameter getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentFormalParameter newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentFormalParameter)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentInstanceObject getValue() throws PersistenceException {
        return this.value;
    }
    public void setValue(PersistentInstanceObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.value)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.value = (PersistentInstanceObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.valueSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentActualParameter newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentActualParameter)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentActualParameter getThis() throws PersistenceException {
        if(this.This == null){
            PersistentActualParameter result = new ActualParameterProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentActualParameter)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActualParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActualParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActualParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActualParameter(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
            + (this.getValue() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentActualParameter)This);
		if(this.equals(This)){
			this.setType((PersistentFormalParameter)final$$Fields.get("type"));
			this.setValue((PersistentInstanceObject)final$$Fields.get("value"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
