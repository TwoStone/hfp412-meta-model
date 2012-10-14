package persistence;



public abstract class RoleICProxi extends PersistentInCacheProxiOptimistic implements PersistentRole{
    
    public RoleICProxi(long objectId) {
        super(objectId);
    }
    public RoleICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentActor getRoleOwner() throws PersistenceException {
        return ((PersistentRole)this.getTheObject()).getRoleOwner();
    }
    public void setRoleOwner(PersistentActor newValue) throws PersistenceException {
        ((PersistentRole)this.getTheObject()).setRoleOwner(newValue);
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initializeOnCreation();
    }

    
}
