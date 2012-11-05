package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAtomicType extends MType, MAtomicTypeHierarchyHIERARCHY, Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public PersistentMAspect getAspect() throws PersistenceException ;
    public void setAspect(PersistentMAspect newValue) throws PersistenceException ;
    public PersistentMAtomicType getSuperType() throws PersistenceException ;
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException , model.CycleException;
    public PersistentMAtomicType getThis() throws PersistenceException ;
    
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(MAtomicTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public MTypeSearchList getSuperTypes(final TDObserver observer) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public MTypeSearchList getSuperTypes() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public MAtomicTypeSearchList getSubTypes() 
				throws PersistenceException;

}

