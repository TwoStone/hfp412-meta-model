package model.measurement;

import persistence.AbstractPersistentRoot;
import persistence.AggregationStrategy;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAggregateCommand;
import persistence.PersistentMObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantifObject;
import persistence.TDObserver;

/* Additional import section end */

public abstract class QuantifObject extends PersistentObject implements PersistentQuantifObject{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentQuantifObject getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.getClass(objectId);
        return (PersistentQuantifObject)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot object = (AbstractPersistentRoot)this.getObject();
            if (object != null) {
                result.put("object", object.createProxiInformation(false));
                if(depth > 1) {
                    object.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && object.hasEssentialFields())object.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract QuantifObject provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMObject object;
    protected PersistentQuantifObject This;
    
    public QuantifObject(PersistentMObject object,PersistentQuantifObject This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.object = object;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getObject() != null){
            this.getObject().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.objectSet(this.getId(), getObject());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentMObject getObject() throws PersistenceException {
        return this.object;
    }
    public void setObject(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.object)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.object = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.objectSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentQuantifObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentQuantifObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentQuantifObject getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantifObject)This);
		if(this.equals(This)){
			this.setObject((PersistentMObject)final$$Fields.get("object"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void aggregate(final AggregationStrategy strategy, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAggregateCommand command = model.meta.AggregateCommand.createAggregateCommand(now, now);
		command.setStrategy(strategy);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
