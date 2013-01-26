package persistence;



public abstract class MAbstractProductTypeProxi extends MComplexTypeProxi implements PersistentMAbstractProductType{
    
    public MAbstractProductTypeProxi(long objectId) {
        super(objectId);
    }
    public MAbstractProductTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentMAbstractProductType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAbstractProductType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAbstractProductType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).isStructuralEquivalant(other);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAbstractProductType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).isLessOrEqual(other);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).isSingleton();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAbstractProductType)this.getTheObject()).initializeOnCreation();
    }
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).fetchTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMAbstractProductType)this.getTheObject()).isAbstract();
    }

    
}
