package persistence;



public abstract class BooleanValueICProxi extends PersistentInCacheProxiOptimistic implements PersistentBooleanValue{
    
    public BooleanValueICProxi(long objectId) {
        super(objectId);
    }
    public BooleanValueICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentBooleanValue getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initializeOnCreation();
    }

    
}
