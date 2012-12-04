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
    
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType subType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addSubType(superType, subType);
    }
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public void createAssociationFrom(final MType source, final String name, final MType target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociationFrom(source, name, target);
    }
    public void createAssociationTo(final MType target, final String name, final MType source) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociationTo(target, name, source);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public void createAspect(final PersistentAspectManager aspectManager, final String aspectName) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentServer)this.getTheObject()).createAspect(aspectManager, aspectName);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public void createAtomicType(final PersistentMAspect parent, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAtomicType(parent, typeName, singletonType, abstractType);
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
    public void createAssociation(final PersistentAssociationManager manager, final String name, final MType source, final MType target) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAssociation(manager, name, source, target);
    }
    public void createSubType(final PersistentMAtomicType superType, final String typeName, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createSubType(superType, typeName, singletonType, abstractType);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
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
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }

    
}
