package persistence;



public abstract class AbsUnitTypeProxi extends PersistentProxi implements PersistentAbsUnitType{
    
    public AbsUnitTypeProxi(long objectId) {
        super(objectId);
    }
    public AbsUnitTypeProxi(PersistentInCacheProxi object) {
        super(object);
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
