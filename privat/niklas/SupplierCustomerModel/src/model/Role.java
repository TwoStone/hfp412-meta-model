
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Role provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentRole This;
    
    public Role(PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
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
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentRole)This);
		if(this.equals(This)){
		}
    }
    public ActorSearchList inverseGetRoles() 
				throws PersistenceException{
        ActorSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theActorFacade
							.inverseGetRoles(this.getId(), this.getClassId());
		return result;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
