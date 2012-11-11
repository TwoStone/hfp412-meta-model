package persistence;



public abstract class AbsUnitICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbsUnit{
    
    public AbsUnitICProxi(long objectId) {
        super(objectId);
    }
    public AbsUnitICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentAbsUnitType getType() throws PersistenceException {
        return ((PersistentAbsUnit)this.getTheObject()).getType();
    }
    public void setType(PersistentAbsUnitType newValue) throws PersistenceException {
        ((PersistentAbsUnit)this.getTheObject()).setType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentAbsUnit)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAbsUnit)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentAbsUnit getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbsUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbsUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbsUnit)this.getTheObject()).initializeOnCreation();
    }

    
}
