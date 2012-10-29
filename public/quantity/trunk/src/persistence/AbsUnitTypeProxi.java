package persistence;



public abstract class AbsUnitTypeProxi extends PersistentProxi implements PersistentAbsUnitType{
    
    public AbsUnitTypeProxi(long objectId) {
        super(objectId);
    }
    public AbsUnitTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public PersistentAbsUnit getDefaultUnit() throws PersistenceException {
        return ((PersistentAbsUnitType)this.getTheObject()).getDefaultUnit();
    }
    public void setDefaultUnit(PersistentAbsUnit newValue) throws PersistenceException {
        ((PersistentAbsUnitType)this.getTheObject()).setDefaultUnit(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentAbsUnitType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAbsUnitType)this.getTheObject()).setName(newValue);
    }
    
    
    
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
