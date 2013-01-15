package persistence;



public abstract class MComplexTypeICProxi extends MTypeICProxi implements PersistentMComplexType{
    
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
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isStructuralEquivalant(other);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchTypeLinkOperator();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isSingleton();
    }
    public PersistentMBoolean isLessOrEqual() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isLessOrEqual();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isAbstract();
    }

    
}
