package persistence;



public abstract class AbsUnitProxi extends PersistentProxi implements PersistentAbsUnit{
    
    public AbsUnitProxi(long objectId) {
        super(objectId);
    }
    public AbsUnitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentAbsUnit)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAbsUnit)this.getTheObject()).setName(newValue);
    }
    
    
    
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
