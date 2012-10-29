package persistence;



public abstract class AbsQuantityICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbsQuantity{
    
    public AbsQuantityICProxi(long objectId) {
        super(objectId);
    }
    public AbsQuantityICProxi(PersistentObject object) {
        super(object);
    }
    
    
    
    
    
    public PersistentAbsQuantity divide(final PersistentAbsQuantity divisor) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).divide(divisor);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentAbsQuantity subtract(final PersistentAbsQuantity minuend) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).subtract(minuend);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentAbsQuantity mult(final PersistentAbsQuantity factor) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).mult(factor);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initializeOnCreation();
    }
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).add(summand);
    }

    
}
