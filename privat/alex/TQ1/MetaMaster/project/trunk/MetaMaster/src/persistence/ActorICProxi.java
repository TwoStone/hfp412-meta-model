package persistence;



public abstract class ActorICProxi extends PersistentInCacheProxiOptimistic implements PersistentActor{
    
    public ActorICProxi(long objectId) {
        super(objectId);
    }
    public ActorICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentActor)this.getTheObject()).setName(newValue);
    }
    
    
    
    public RoleSearchList getRoles(TDObserver observer) 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).getRoles(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initializeOnInstantiation();
    }
    public RoleSearchList inverseGetRoleOwner() 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).inverseGetRoleOwner();
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public RoleSearchList getRoles() 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).getRoles();
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addRole(String roleName) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).addRole(roleName);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initializeOnCreation();
    }

    
}
