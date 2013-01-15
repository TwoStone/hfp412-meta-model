package persistence;



public abstract class MQuantiObjectTypeProxi extends PersistentProxi implements PersistentMQuantiObjectType{
    
    public MQuantiObjectTypeProxi(long objectId) {
        super(objectId);
    }
    public MQuantiObjectTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public PersistentMType getType() throws PersistenceException {
        return ((PersistentMQuantiObjectType)this.getTheObject()).getType();
    }
    public void setType(PersistentMType newValue) throws PersistenceException {
        ((PersistentMQuantiObjectType)this.getTheObject()).setType(newValue);
    }
    public PersistentAbsUnitType getUnitType() throws PersistenceException {
        return ((PersistentMQuantiObjectType)this.getTheObject()).getUnitType();
    }
    public void setUnitType(PersistentAbsUnitType newValue) throws PersistenceException {
        ((PersistentMQuantiObjectType)this.getTheObject()).setUnitType(newValue);
    }
    public abstract PersistentMQuantiObjectType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMQuantiObjectType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMQuantiObjectType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMQuantiObjectType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMQuantiObjectType)this.getTheObject()).initializeOnCreation();
    }

    
}
