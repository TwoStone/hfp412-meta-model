package persistence;

import model.*;
public interface PersistentActorManager extends Anything, AbstractPersistentProxi {
    
    public ActorManager_ActorsProxi getActors() throws PersistenceException ;
    public PersistentActorManager getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void createActor(String name, Invoker invoker) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void createActor(String name) 
				throws model.DoubleDefinition, PersistenceException;
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void addRole(PersistentActor actor, String roleName, Invoker invoker) 
				throws PersistenceException;
    public void addRole(PersistentActor actor, String roleName) 
				throws PersistenceException;

}

