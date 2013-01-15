
package model.measurement;

import persistence.*;


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
            AbstractPersistentRoot defaultType = (AbstractPersistentRoot)this.getDefaultType();
            if (defaultType != null) {
                result.put("defaultType", defaultType.createProxiInformation(false));
                if(depth > 1) {
                    defaultType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && defaultType.hasEssentialFields())defaultType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
    protected PersistentInstanceObject defaultType;
    protected PersistentQuantifObject This;
    
    public QuantifObject(PersistentInstanceObject defaultType,PersistentQuantifObject This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.defaultType = defaultType;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 198;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getDefaultType() != null){
            this.getDefaultType().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.defaultTypeSet(this.getId(), getDefaultType());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentInstanceObject getDefaultType() throws PersistenceException {
        return this.defaultType;
    }
    public void setDefaultType(PersistentInstanceObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.defaultType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.defaultType = (PersistentInstanceObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantifObjectFacade.defaultTypeSet(this.getId(), newValue);
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
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantifObject)This);
		if(this.equals(This)){
			this.setDefaultType((PersistentInstanceObject)final$$Fields.get("defaultType"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
