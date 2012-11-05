package persistence;



public abstract class MComplexTypeProxi extends PersistentProxi implements PersistentMComplexType{
    
    public MComplexTypeProxi(long objectId) {
        super(objectId);
    }
    public MComplexTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public MComplexType_ContainedTypesProxi getContainedTypes() throws PersistenceException {
        return ((PersistentMComplexType)this.getTheObject()).getContainedTypes();
    }
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnCreation();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).getTypeLinkOperator();
    }

    
}
