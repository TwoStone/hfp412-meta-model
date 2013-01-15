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
    
    
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public void createAssociationFrom(final PersistentMType source, final String name, final PersistentMType target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociationFrom(source, name, target);
    }
    public void createAssociationTo(final PersistentMType target, final String name, final PersistentMType source) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociationTo(target, name, source);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public PersistentFractionManager getFractionManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getFractionManager();
    }
    public void createAspect(final PersistentAspectManager aspectManager, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAspect(aspectManager, name);
    }
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addReferenceType(compUnitType, unitType, exponent);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public void createHierarchy(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createHierarchy(name);
    }
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager(observer);
    }
    public PersistentAssociationManager getAssociationManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAssociationManager();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createUnitType(unitTypeManager, name);
    }
    public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAtomicRootType(aspect, typeName, singletonType, abstractType);
    }
    public void createAssociation(final PersistentAssociationManager manager, final String name, final PersistentMType source, final PersistentMType target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociation(manager, name, source, target);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
    }
    public PersistentUnitTypeManager getUnitTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getUnitTypeManager();
    }
    public PersistentQuantityManager getQuantityManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getQuantityManager();
    }
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addToHierarchy(association, theHierarchy);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager(observer);
    }
    public PersistentQuantityManager getQuantityManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getQuantityManager(observer);
    }
    public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getUnitTypeManager(observer);
    }
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction f) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createQuantity(unit, f);
    }
    public void createCompUnitType(final PersistentUnitTypeManager unitTypeManager, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createCompUnitType(unitTypeManager, name);
    }
    public void addAssociations(final PersistentMAHierarchy theHierarchy, final PersistentMAssociation association) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addAssociations(theHierarchy, association);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnCreation();
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).disconnected();
    }
    public PersistentAssociationManager getAssociationManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAssociationManager(observer);
    }
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).finishModeling(compUnitType);
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
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createUnit(final PersistentAbsUnitType type, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createUnit(type, name);
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAtomicSubType(superType, typeName, singletonType, abstractType);
    }
    public PersistentConversionManager getConversionManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getConversionManager(observer);
    }

    
}
