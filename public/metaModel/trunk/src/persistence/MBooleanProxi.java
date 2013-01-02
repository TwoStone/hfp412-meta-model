package persistence;



public abstract class MBooleanProxi extends PersistentProxi implements PersistentMBoolean{
    
    public MBooleanProxi(long objectId) {
        super(objectId);
    }
    public MBooleanProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentMBoolean getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentMBoolean)this.getTheObject()).toBoolean();
    }
    public PersistentMBoolean createFromBoolean(final boolean bool) 
				throws PersistenceException{
        return ((PersistentMBoolean)this.getTheObject()).createFromBoolean(bool);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean invert() 
				throws PersistenceException{
        return ((PersistentMBoolean)this.getTheObject()).invert();
    }

    
}
