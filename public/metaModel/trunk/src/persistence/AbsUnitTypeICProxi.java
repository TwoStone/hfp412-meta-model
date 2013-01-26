package persistence;



public abstract class AbsUnitTypeICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbsUnitType{
    
    public AbsUnitTypeICProxi(long objectId) {
        super(objectId);
    }
    public AbsUnitTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentAbsUnitType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAbsUnitType)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentAbsUnitType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbsUnitType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbsUnitType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbsUnitType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbsUnitType)this.getTheObject()).initializeOnCreation();
    }

    
}
