
package model;

import persistence.*;


/* Additional import section end */

public abstract class Actor extends PersistentObject implements PersistentActor{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentActor getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theActorFacade.getClass(objectId);
        return (PersistentActor)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            result.put("roles", this.getRoles(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ActorSearchList getActorByName(String index) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theActorFacade
            .getActorByName(index);
    }
    
    public abstract Actor provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentActor This;
    
    public Actor(String name,PersistentActor This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theActorFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentActor newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentActor)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theActorFacade.ThisSet(this.getId(), newValue);
    }
    public abstract PersistentActor getThis() throws PersistenceException ;
    
    
    
    public RoleSearchList getRoles(final TDObserver observer) 
				throws PersistenceException{
        RoleSearchList result = getThis().getRoles();
		observer.updateTransientDerived(getThis(), "roles", result);
		return result;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public RoleSearchList inverseGetRoleOwner() 
				throws PersistenceException{
        RoleSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theRoleFacade
							.inverseGetRoleOwner(this.getId(), this.getClassId());
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentActor)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public RoleSearchList getRoles() 
				throws PersistenceException{
		// TODO Auto-generated method stub
		return null;
	}

    /* Start of protected part that is not overridden by persistence generator */

	public void addRole(String roleName) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
    
    /* End of protected part that is not overridden by persistence generator */
    
}
