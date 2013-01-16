package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentServer extends Invoker, Remote, Anything, AbstractPersistentProxi {
    
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public String getUser() throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentAccountTypeManager getAccountTypeManager() 
				throws PersistenceException;
    public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void createAssociationFrom(final PersistentMType source, final String name, final PersistentMType target) 
				throws PersistenceException;
    public void createAssociationTo(final PersistentMType target, final String name, final PersistentMType source) 
				throws PersistenceException;
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException;
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws PersistenceException;
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public PersistentAccountManager getAccountManager(final TDObserver observer) 
				throws PersistenceException;
    public void createHierarchy(final String name) 
				throws PersistenceException;
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException;
    public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentMeasurementTypeManager getMeasurementTypeManager() 
				throws PersistenceException;
    public void createUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException;
    public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException;
    public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException;
    public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type, final PersistentInstanceObject object) 
				throws PersistenceException;
    public PersistentAccountManager getAccountManager() 
				throws PersistenceException;
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException;
    public void createAssociation(final PersistentAssociationManager manager, final String name, final PersistentMType source, final PersistentMType target) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException;
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException;
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException;
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException;
    public void createCompUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException;
    public void addAssociations(final PersistentMAHierarchy theHierarchy, final PersistentMAssociation association) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentFractionManager getFractionManager(final TDObserver observer) 
				throws PersistenceException;
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException;
    public PersistentConversionManager getConversionManager() 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createUnit(final PersistentAbsUnitType type, final String name) 
				throws PersistenceException;
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException;
    public PersistentConversionManager getConversionManager(final TDObserver observer) 
				throws PersistenceException;

}

