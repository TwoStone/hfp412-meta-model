package persistence;



public abstract class MComplexTypeICProxi extends PersistentInCacheProxiOptimistic implements PersistentMComplexType{
    
    public MComplexTypeICProxi(long objectId) {
        super(objectId);
    }
    public MComplexTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public MComplexType_ContainedTypesProxi getContainedTypes() throws PersistenceException {
        return ((PersistentMComplexType)this.getTheObject()).getContainedTypes();
    }
    public abstract PersistentMComplexType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isStructuralEqual(otherType);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isLessOrEqual(otherType);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnCreation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isSingleton();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isAbstract();
    }

    
}
