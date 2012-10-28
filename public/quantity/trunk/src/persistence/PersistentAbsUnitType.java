package persistence;

public interface PersistentAbsUnitType extends Anything, AbstractPersistentProxi {
    
    public abstract PersistentAbsUnitType getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

