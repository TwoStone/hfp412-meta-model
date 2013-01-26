package persistence;



public abstract class MAbstractSumTypeICProxi extends MComplexTypeICProxi implements PersistentMAbstractSumType{
    
    public MAbstractSumTypeICProxi(long objectId) {
        super(objectId);
    }
    public MAbstractSumTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentMAbstractSumType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAbstractSumType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAbstractSumType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).isStructuralEquivalant(other);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAbstractSumType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).isLessOrEqual(other);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).isSingleton();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAbstractSumType)this.getTheObject()).initializeOnCreation();
    }
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).fetchTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMAbstractSumType)this.getTheObject()).isAbstract();
    }

    
}
