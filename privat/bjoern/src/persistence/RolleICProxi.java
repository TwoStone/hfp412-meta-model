package persistence;



public abstract class RolleICProxi extends PersistentInCacheProxiOptimistic implements PersistentRolle{
    
    public RolleICProxi(long objectId) {
        super(objectId);
    }
    public RolleICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentAkteur getRolleFuer() throws PersistenceException {
        return ((PersistentRolle)this.getTheObject()).getRolleFuer();
    }
    public void setRolleFuer(PersistentAkteur newValue) throws PersistenceException {
        ((PersistentRolle)this.getTheObject()).setRolleFuer(newValue);
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentRolle)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentRolle)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentRolle)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentRolle)this.getTheObject()).initializeOnCreation();
    }

    
}
