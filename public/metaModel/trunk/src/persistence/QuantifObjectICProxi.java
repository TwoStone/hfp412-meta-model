package persistence;



public abstract class QuantifObjectICProxi extends PersistentInCacheProxiOptimistic implements PersistentQuantifObject{
    
    public QuantifObjectICProxi(long objectId) {
        super(objectId);
    }
    public QuantifObjectICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentInstanceObject getDefaultType() throws PersistenceException {
        return ((PersistentQuantifObject)this.getTheObject()).getDefaultType();
    }
    public void setDefaultType(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentQuantifObject)this.getTheObject()).setDefaultType(newValue);
    }
    public abstract PersistentQuantifObject getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantifObject)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantifObject)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQuantifObject)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQuantifObject)this.getTheObject()).initializeOnCreation();
    }

    
}
