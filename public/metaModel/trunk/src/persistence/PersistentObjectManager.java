package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentObjectManager extends Anything, AbstractPersistentProxi {
    
    public ObjectManager_ObjectsProxi getObjects() throws PersistenceException ;
    public PersistentObjectManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentMObject createMObject(final MAtomicTypeSearchList types) 
				throws model.ConsistencyException, PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void createMObject(final MAtomicTypeSearchList types, final Invoker invoker) 
				throws PersistenceException;

}

