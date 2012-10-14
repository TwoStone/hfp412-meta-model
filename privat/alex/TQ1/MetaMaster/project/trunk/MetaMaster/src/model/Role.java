
package model;

import persistence.*;


/* Additional import section end */

public abstract class Role extends PersistentObject implements PersistentRole{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentRole getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theRoleFacade.getClass(objectId);
        return (PersistentRole)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot roleOwner = (AbstractPersistentRoot)this.getRoleOwner();
            if (roleOwner != null) {
                result.put("roleOwner", roleOwner.createProxiInformation());
                if(depth > 1) {
                    roleOwner.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && roleOwner.hasEssentialFields())roleOwner.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Role provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentActor roleOwner;
    protected PersistentRole This;
    
    public Role(PersistentActor roleOwner,PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.roleOwner = roleOwner;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentActor getRoleOwner() throws PersistenceException {
        return this.roleOwner;
    }
    public void setRoleOwner(PersistentActor newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.roleOwner)) return;
        if(getThis().getRoleOwner() != null)throw new PersistenceException("Final field roleOwner in type Role has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.roleOwner = (PersistentActor)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theRoleFacade.roleOwnerSet(this.getId(), newValue);
    }
    protected void setThis(PersistentRole newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentRole)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theRoleFacade.ThisSet(this.getId(), newValue);
    }
    public abstract PersistentRole getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentRole)This);
		if(this.equals(This)){
			this.setRoleOwner((PersistentActor)final$$Fields.get("roleOwner"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
