package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTypeManager extends Anything, AbstractPersistentProxi {
    
    public TypeManager_TypesProxi getTypes() throws PersistenceException ;
    public PersistentTypeManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType subType) 
				throws model.ConsistencyException, model.CycleException, PersistenceException;
    public PersistentMAbstractSumType createSumType(final MTypeSearchList addends) 
				throws model.ConsistencyException, PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void createSumType(final MTypeSearchList addends, final Invoker invoker) 
				throws PersistenceException;
    public void createProductType(final MTypeSearchList factors, final Invoker invoker) 
				throws PersistenceException;
    public PersistentMAbstractProductType createProductType(final MTypeSearchList factors) 
				throws model.ConsistencyException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType subType, final Invoker invoker) 
				throws PersistenceException;
    public void createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException;
    public PersistentMAtomicType createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException;
    public PersistentMAtomicType createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException;

}

