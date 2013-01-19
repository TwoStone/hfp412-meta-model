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
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException;
    public void createAssociation(final PersistentAssociationManager manager, final PersistentMType source, final PersistentMType target, final String name) 
				throws PersistenceException;
    public void createHierarchy(final PersistentAssociationManager manager, final PersistentAssociation a, final String name) 
				throws PersistenceException;
    public void removeFromHierarchy(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException;
    public void addConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws PersistenceException;
    public void createVoidOperation(final PersistentOperationManager operationManager, final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException;
    public void publishCompUnit(final PersistentCompUnit compUnit) 
				throws PersistenceException;
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException;
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException;
    public PersistentLinkManager getLinkManager() 
				throws PersistenceException;
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException;
    public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createUnitType(final PersistentUnitTypeManager manager, final String name) 
				throws PersistenceException;
    public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException;
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException;
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException;
    public PersistentMessageManager getMessageManager() 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException;
    public PersistentMessageManager getMessageManager(final TDObserver observer) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void createStaticMessage(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException;
    public void createMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException;
    public void removeAssociation(final PersistentAssociation a) 
				throws PersistenceException;
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor1, final PersistentAbsQuantity factor2) 
				throws PersistenceException;
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException;
    public void removeFp(final PersistentFormalParameter fp) 
				throws PersistenceException;
    public PersistentFractionManager getFractionManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException;
    public PersistentConversionManager getConversionManager() 
				throws PersistenceException;
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws PersistenceException;
    public void createUnit(final PersistentUnitType type, final String name) 
				throws PersistenceException;
    public void createVoidMessage(final PersistentInstanceObject source, final PersistentOperation type, final ActualParameterSearchList ap) 
				throws PersistenceException;
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException;
    public PersistentConversionManager getConversionManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void addToHierarchy(final PersistentAssociation association, final PersistentHierarchy theHierarchy) 
				throws PersistenceException;
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand1, final PersistentAbsQuantity summand2) 
				throws PersistenceException;
    public void addDefaultUnit(final PersistentUnitType type, final PersistentUnit defaultUnit) 
				throws PersistenceException;
    public void createFp(final PersistentOperationManager operationManager, final String name, final PersistentMType ofType) 
				throws PersistenceException;
    public void addReference(final PersistentCompUnit compUnit, final PersistentUnit unit, final long exponent) 
				throws PersistenceException;
    public void createCompUnit(final PersistentCompUnitType compUnitType, final String name) 
				throws PersistenceException;
    public void createMessage(final PersistentInstanceObject source, final PersistentOperation type, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException;
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException;
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException;
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public PersistentAccountManager getAccountManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException;
    public void createLink(final PersistentInstanceObject source, final PersistentAssociation type, final PersistentInstanceObject target) 
				throws PersistenceException;
    public PersistentMeasurementTypeManager getMeasurementTypeManager() 
				throws PersistenceException;
    public PersistentAbsQuantity div(final PersistentAbsQuantity dividend, final PersistentAbsQuantity divisor) 
				throws PersistenceException;
    public void createCompUnitType(final String name) 
				throws PersistenceException;
    public void createVoidMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap) 
				throws PersistenceException;
    public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException;
    public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type, final PersistentInstanceObject object) 
				throws PersistenceException;
    public PersistentLinkManager getLinkManager(final TDObserver observer) 
				throws PersistenceException;
    public PersistentAccountManager getAccountManager() 
				throws PersistenceException;
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException;
    public void removeOperation(final PersistentOperation op) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentOperationManager getOperationManager() 
				throws PersistenceException;
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException;
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException;
    public void createConstant(final PersistentOperationManager operationManager, final String name, final PersistentMType target) 
				throws PersistenceException;
    public void removeLink(final PersistentLink link) 
				throws PersistenceException;
    public void createStaticOp(final PersistentOperationManager operationManager, final String name, final PersistentMType target, final FormalParameterSearchList fp) 
				throws PersistenceException;
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws PersistenceException;
    public void createOperation(final PersistentOperationManager operationManager, final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createConst(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentInstanceObject target) 
				throws PersistenceException;
    public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend, final PersistentAbsQuantity subtrahend) 
				throws PersistenceException;
    public void removeFpFromOp(final PersistentOperation operation, final PersistentFormalParameter fp) 
				throws PersistenceException;
    public PersistentOperationManager getOperationManager(final TDObserver observer) 
				throws PersistenceException;
    public void createLink(final PersistentLinkManager link, final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target) 
				throws PersistenceException;

}

