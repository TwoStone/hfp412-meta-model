package persistence;



public abstract class AbstractMetaTypeProxi extends PersistentProxi implements PersistentAbstractMetaType{
    
    public AbstractMetaTypeProxi(long objectId) {
        super(objectId);
    }
    public AbstractMetaTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbstractMetaType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbstractMetaType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbstractMetaType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException{
        return ((PersistentAbstractMetaType)this.getTheObject()).specializes(metaType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbstractMetaType)this.getTheObject()).initializeOnCreation();
    }

    
}
