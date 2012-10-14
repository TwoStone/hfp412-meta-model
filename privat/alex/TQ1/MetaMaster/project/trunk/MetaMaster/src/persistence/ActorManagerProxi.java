package persistence;

import model.*;

public class ActorManagerProxi extends PersistentProxi implements PersistentActorManager{
    
    public ActorManagerProxi(long objectId) {
        super(objectId);
    }
    public ActorManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theActorManagerFacade
            .getActorManager(this.getId());
    }
    
    public long getClassId() {
        return 112;
    }
    
    public ActorManager_ActorsProxi getActors() throws PersistenceException {
        return ((PersistentActorManager)this.getTheObject()).getActors();
    }
    public PersistentActorManager getThis() throws PersistenceException {
        return ((PersistentActorManager)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActorManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActorManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActorManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActorManager(this);
    }
    
    
    public void createActor(String name, Invoker invoker) 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).createActor(name, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createActor(String name) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentActorManager)this.getTheObject()).createActor(name);
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).initializeOnCreation();
    }
    public void addRole(PersistentActor actor, String roleName, Invoker invoker) 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).addRole(actor, roleName, invoker);
    }
    public void addRole(PersistentActor actor, String roleName) 
				throws PersistenceException{
        ((PersistentActorManager)this.getTheObject()).addRole(actor, roleName);
    }

    
}
