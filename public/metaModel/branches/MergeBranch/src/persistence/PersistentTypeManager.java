package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTypeManager extends Anything, AbstractPersistentProxi {
    
    public TypeManager_AtomicTypesProxi getAtomicTypes() throws PersistenceException ;
    public TypeManager_ProductTypesProxi getProductTypes() throws PersistenceException ;
    public TypeManager_SumTypesProxi getSumTypes() throws PersistenceException ;
    public PersistentTypeManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder) 
				throws model.WrongSubTypeAspectException, model.CycleException, PersistenceException;
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void createAtomicType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException;
    public void createSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.WrongSubTypeAspectException, model.DoubleDefinitionException, model.ConsistencyException, model.CycleException, PersistenceException;
    public void createAtomicType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException;

}

