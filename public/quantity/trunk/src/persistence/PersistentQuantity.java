package persistence;

public interface PersistentQuantity extends PersistentAbsQuantity {
    
    public PersistentFraction getAmount() throws PersistenceException ;
    public void setAmount(PersistentFraction newValue) throws PersistenceException ;
    public PersistentUnit getUnit() throws PersistenceException ;
    public void setUnit(PersistentUnit newValue) throws PersistenceException ;
    public PersistentQuantity getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AbsQuantityVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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

