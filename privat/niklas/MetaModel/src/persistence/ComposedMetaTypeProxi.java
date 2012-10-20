package persistence;



public abstract class ComposedMetaTypeProxi extends AbstractMetaTypeProxi implements PersistentComposedMetaType{
    
    public ComposedMetaTypeProxi(long objectId) {
        super(objectId);
    }
    public ComposedMetaTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public ComposedMetaType_ComponentsProxi getComponents() throws PersistenceException {
        return ((PersistentComposedMetaType)this.getTheObject()).getComponents();
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComposedMetaType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComposedMetaType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentComposedMetaType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComposedMetaType)this.getTheObject()).initializeOnCreation();
    }
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException{
        return ((PersistentComposedMetaType)this.getTheObject()).specializes(metaType);
    }

    
}
