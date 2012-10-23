package persistence;



public abstract class NamedEntityICProxi extends PersistentInCacheProxiOptimistic implements PersistentNamedEntity{
    
    public NamedEntityICProxi(long objectId) {
        super(objectId);
    }
    public NamedEntityICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentNamedEntity)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentNamedEntity)this.getTheObject()).setName(newValue);
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNamedEntity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNamedEntity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNamedEntity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNamedEntity)this.getTheObject()).initializeOnCreation();
    }

    
}
