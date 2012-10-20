package persistence;

public interface PersistentRolle extends Anything, AbstractPersistentProxi {
    
    public PersistentAkteur getRolleFuer() throws PersistenceException ;
    public void setRolleFuer(PersistentAkteur newValue) throws PersistenceException ;
    public abstract PersistentRolle getThis() throws PersistenceException ;
    
    public void accept(model.visitor.RolleVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.RolleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.RolleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

