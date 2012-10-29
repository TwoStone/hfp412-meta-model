package persistence;



public abstract class AbsQuantityProxi extends PersistentProxi implements PersistentAbsQuantity{
    
    public AbsQuantityProxi(long objectId) {
        super(objectId);
    }
    public AbsQuantityProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    
    
    
    public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).sub(minuend);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsQuantity)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).mul(factor);
    }
    public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).div(divisor);
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
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand) 
				throws PersistenceException{
        return ((PersistentAbsQuantity)this.getTheObject()).add(summand);
    }

    
}
