package persistence;

import model.UserException;

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
    public abstract PersistentMComplexType getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMComplexType)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMProductType transientAddFactor(final MType factor) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).transientAddFactor(factor);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isStructuralEqual(otherType);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchName();
    }
    public PersistentMSumType transientAddAddend(final MType addend) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).transientAddAddend(addend);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isLessOrEqual(otherType);
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
    public PersistentMSumType fetchDisjunctiveNormalform() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).fetchDisjunctiveNormalform();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).isAbstract();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMComplexType)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }

    
}
