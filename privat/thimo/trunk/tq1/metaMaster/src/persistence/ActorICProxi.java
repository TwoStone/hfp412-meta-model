package persistence;



public class ActorICProxi extends PersistentInCacheProxiOptimistic implements PersistentActor{
    
    public ActorICProxi(long objectId) {
        super(objectId);
    }
    public ActorICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theActorFacade
            .getActor(this.getId());
    }
    
    public long getClassId() {
        return 131;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentActor)this.getTheObject()).setName(newValue);
    }
    public PersistentActor getThis() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.ActorVisitor visitor) throws PersistenceException {
        visitor.handleActor(this);
    }
    public <R> R accept(model.visitor.ActorReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActor(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActor(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActor(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActor(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActor(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActor(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActor(this);
    }
    
    
    public RoleSearchList inverseGetRoleFor() 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).inverseGetRoleFor();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public RoleSearchList getMyRoles(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).getMyRoles(observer);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addRole(final String roleName) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).addRole(roleName);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initializeOnCreation();
    }
    public RoleSearchList getMyRoles() 
				throws PersistenceException{
        return ((PersistentActor)this.getTheObject()).getMyRoles();
    }

    
}
