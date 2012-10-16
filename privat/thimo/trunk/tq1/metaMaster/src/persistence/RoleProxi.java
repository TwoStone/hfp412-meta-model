package persistence;



public abstract class RoleProxi extends PersistentProxi implements PersistentRole{
    
    public RoleProxi(long objectId) {
        super(objectId);
    }
    public RoleProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public PersistentActor getRoleFor() throws PersistenceException {
        return ((PersistentRole)this.getTheObject()).getRoleFor();
    }
    public void setRoleFor(PersistentActor newValue) throws PersistenceException {
        ((PersistentRole)this.getTheObject()).setRoleFor(newValue);
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentRole)this.getTheObject()).initializeOnCreation();
    }

    
}
