package persistence;

public interface PersistentConversionRate extends Anything, AbstractPersistentProxi {
    
    public PersistentUnit getFromUnit() throws PersistenceException ;
    public void setFromUnit(PersistentUnit newValue) throws PersistenceException ;
    public PersistentUnit getToUnit() throws PersistenceException ;
    public void setToUnit(PersistentUnit newValue) throws PersistenceException ;
    public PersistentFraction getConversionRate() throws PersistenceException ;
    public void setConversionRate(PersistentFraction newValue) throws PersistenceException ;
    public PersistentConversionRate getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

