package persistence;

import model.UserException;

import model.visitor.*;

public class ServerICProxi extends PersistentInCacheProxiOptimistic implements PersistentServer{
    
    public ServerICProxi(long objectId) {
        super(objectId);
    }
    public ServerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theServerFacade
            .getServer(this.getId());
    }
    
    public long getClassId() {
        return -105;
    }
    
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getErrors();
    }
    public String getPassword() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getPassword();
    }
    public void setPassword(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setPassword(newValue);
    }
    public String getUser() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setUser(newValue);
    }
    public long getHackCount() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackCount();
    }
    public void setHackCount(long newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackCount(newValue);
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackDelay();
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackDelay(newValue);
    }
    public PersistentServer getThis() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    
    
    public PersistentAccountTypeManager getAccountTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAccountTypeManager();
    }
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public void removeMessage(final PersistentMessage m) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeMessage(m);
    }
    public void addConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addConversion(unit, factor, constant);
    }
    public void createAssociation(final PersistentAssociationManager manager, final PersistentMType source, final PersistentMType target, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociation(manager, source, target, name);
    }
    public void createHierarchy(final PersistentAssociationManager manager, final PersistentAssociation a, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createHierarchy(manager, a, name);
    }
    public void removeFromHierarchy(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeFromHierarchy(h, a);
    }
    public void createVoidOperation(final PersistentOperationManager operationManager, final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createVoidOperation(operationManager, source, name, fp);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createOperation(source, target, name, fp);
    }
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createVoidOperation(source, name, fp);
    }
    public PersistentLinkManager getLinkManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getLinkManager();
    }
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAssociationManager();
    }
    public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAccountTypeManager(observer);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createUnitType(final PersistentUnitTypeManager manager, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createUnitType(manager, name);
    }
    public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAccountType(accountTypeManager, name, type, unitType);
    }
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAtomicRootType(aspect, typeName, singletonType, abstractType);
    }
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createHierarchy(a, name);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
    }
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getUnitTypeManager();
    }
    public PersistentMessageManager getMessageManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getMessageManager();
    }
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager(observer);
    }
    public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getUnitTypeManager(observer);
    }
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createQuantity(unit, f);
    }
    public PersistentMessageManager getMessageManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getMessageManager(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnCreation();
    }
    public void createStaticMessage(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createStaticMessage(manager, type, name, target, ap);
    }
    public void createMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentInstanceObject source, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createMessage(manager, type, source, target, ap);
    }
    public void removeAssociation(final PersistentAssociation a) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeAssociation(a);
    }
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAssociationManager(observer);
    }
    public void removeFp(final PersistentFormalParameter fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeFp(fp);
    }
    public PersistentFractionManager getFractionManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getFractionManager(observer);
    }
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager();
    }
    public PersistentConversionManager getConversionManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getConversionManager();
    }
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addFp(op, fp);
    }
    public void createUnit(final PersistentUnitType type, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createUnit(type, name);
    }
    public void createVoidMessage(final PersistentInstanceObject source, final PersistentOperation type, final ActualParameterSearchList ap) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createVoidMessage(source, type, ap);
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAtomicSubType(superType, typeName, singletonType, abstractType);
    }
    public PersistentConversionManager getConversionManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getConversionManager(observer);
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getMeasurementTypeManager(observer);
    }
    public void addToHierarchy(final PersistentAssociation association, final PersistentHierarchy theHierarchy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addToHierarchy(association, theHierarchy);
    }
    public void addDefaultUnit(final PersistentUnitType type, final PersistentUnit defaultUnit) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addDefaultUnit(type, defaultUnit);
    }
    public void createFp(final PersistentOperationManager operationManager, final String name, final PersistentMType ofType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createFp(operationManager, name, ofType);
    }
    public void addReference(final PersistentCompUnit compUnit, final PersistentUnit unit, final long exponent) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addReference(compUnit, unit, exponent);
    }
    public void createCompUnit(final PersistentCompUnitType compUnitType, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createCompUnit(compUnitType, name);
    }
    public void createMessage(final PersistentInstanceObject source, final PersistentOperation type, final PersistentInstanceObject target, final ActualParameterSearchList ap) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createMessage(source, type, target, ap);
    }
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getFractionManager();
    }
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addReferenceType(compUnitType, unitType, exponent);
    }
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAspect(aspectManager, name);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public PersistentAccountManager getAccountManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAccountManager(observer);
    }
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager(observer);
    }
    public void createLink(final PersistentInstanceObject source, final PersistentAssociation type, final PersistentInstanceObject target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createLink(source, type, target);
    }
    public PersistentMeasurementTypeManager getMeasurementTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getMeasurementTypeManager();
    }
    public void createCompUnitType(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createCompUnitType(name);
    }
    public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createMeasurementType(measurementTypeManager, name, type, unitType);
    }
    public void createVoidMessage(final PersistentMessageManager manager, final PersistentOperation type, final PersistentInstanceObject source, final ActualParameterSearchList ap) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createVoidMessage(manager, type, source, ap);
    }
    public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type, final PersistentInstanceObject object) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAccount(accountManager, name, type, object);
    }
    public PersistentAccountManager getAccountManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAccountManager();
    }
    public PersistentLinkManager getLinkManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getLinkManager(observer);
    }
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getQuantityManager();
    }
    public void removeOperation(final PersistentOperation op) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeOperation(op);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnInstantiation();
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addAssociation(h, a);
    }
    public PersistentOperationManager getOperationManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getOperationManager();
    }
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getQuantityManager(observer);
    }
    public void createConstant(final PersistentOperationManager operationManager, final String name, final PersistentMType target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createConstant(operationManager, name, target);
    }
    public void removeLink(final PersistentLink link) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeLink(link);
    }
    public void createStaticOp(final PersistentOperationManager operationManager, final String name, final PersistentMType target, final FormalParameterSearchList fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createStaticOp(operationManager, name, target, fp);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).disconnected();
    }
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).finishModeling(compUnitType);
    }
    public void createOperation(final PersistentOperationManager operationManager, final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createOperation(operationManager, source, target, name, fp);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createConst(final PersistentMessageManager manager, final PersistentOperation type, final String name, final PersistentInstanceObject target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createConst(manager, type, name, target);
    }
    public void removeFpFromOp(final PersistentOperation operation, final PersistentFormalParameter fp) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeFpFromOp(operation, fp);
    }
    public void createLink(final PersistentLinkManager link, final PersistentAssociation type, final PersistentInstanceObject source, final PersistentInstanceObject target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createLink(link, type, source, target);
    }
    public PersistentOperationManager getOperationManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getOperationManager(observer);
    }

    
}
