package persistence;

public interface PersistentRole extends Anything, AbstractPersistentProxi {
    
    public PersistentActor getRoleFor() throws PersistenceException ;
    public void setRoleFor(PersistentActor newValue) throws PersistenceException ;
    public abstract PersistentRole getThis() throws PersistenceException ;
    
    public void accept(model.visitor.RoleVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.RoleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.RoleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

