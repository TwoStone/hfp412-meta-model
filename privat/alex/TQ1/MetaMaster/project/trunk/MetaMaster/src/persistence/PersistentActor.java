package persistence;

public interface PersistentActor extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentActor getThis() throws PersistenceException ;
    
    public void accept(model.visitor.ActorVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.ActorReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.ActorExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.ActorReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public RoleSearchList getRoles(TDObserver observer) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public RoleSearchList inverseGetRoleOwner() 
				throws PersistenceException;
    public RoleSearchList getRoles() 
				throws PersistenceException;
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addRole(String roleName) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

