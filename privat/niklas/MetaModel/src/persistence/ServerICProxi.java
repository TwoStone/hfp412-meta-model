package persistence;



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
        return -125;
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
    
    public void accept(model.visitor.InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(model.visitor.RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    
    
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
    }
    public PersistentTypeManager getTypeManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public void createAspect(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAspect(name);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentAspectManager getAspectManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager(observer);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnCreation();
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).disconnected();
    }
    public PersistentAspectManager getAspectManager() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getAspectManager();
    }
    public PersistentTypeManager getTypeManager(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).getTypeManager(observer);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createSumType(final AbstractMetaTypeSearchList types) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createSumType(types);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createType(final String name, final PersistentMetaAspect aspect) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createType(name, aspect);
    }
    public void addSupertype(final PersistentMetaType type, final PersistentMetaType superType) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addSupertype(type, superType);
    }

    
}