package persistence;



public abstract class AbsQuantityICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbsQuantity{
    
    public AbsQuantityICProxi(long objectId) {
        super(objectId);
    }
    public AbsQuantityICProxi(PersistentObject object) {
        super(object);
    }
    
    
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initializeOnCreation();
    }

    
}
