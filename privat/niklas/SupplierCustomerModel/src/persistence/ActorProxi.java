package persistence;



public class ActorProxi extends PersistentProxi implements PersistentActor{
    
    public ActorProxi(long objectId) {
        super(objectId);
    }
    public ActorProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theActorFacade
            .getActor(this.getId());
    }
    
    public long getClassId() {
        return 112;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentActor)this.getTheObject()).setName(newValue);
    }
    public Actor_RolesProxi getRoles() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getRoles();
    }
    public PersistentActor getThis() throws PersistenceException {
        return ((PersistentActor)this.getTheObject()).getThis();
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).copyingPrivateUserAttributes(copy);
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
    public void changeName(final String newName) 
				throws PersistenceException{
        ((PersistentActor)this.getTheObject()).changeName(newName);
    }

    
}
