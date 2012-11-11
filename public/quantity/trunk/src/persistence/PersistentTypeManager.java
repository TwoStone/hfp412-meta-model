package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTypeManager extends Anything, AbstractPersistentProxi {
    
    public TypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException ;
    public PersistentTypeManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createUnitType(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit) 
				throws PersistenceException;
    public void createUnitType(final String name) 
				throws PersistenceException;

}

