package persistence;



public abstract class MTypeProxi extends PersistentProxi implements PersistentMType{
    
    public MTypeProxi(long objectId) {
        super(objectId);
    }
    public MTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentMType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).isStructuralEquivalant(other);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isLessOrEqual() 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).isLessOrEqual();
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).isSingleton();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMType)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMType)this.getTheObject()).isAbstract();
    }

    
}
