package persistence;

public interface PersistentOrder extends Anything, AbstractPersistentProxi {
    
    public PersistentCustomer getCustomer() throws PersistenceException ;
    public void setCustomer(PersistentCustomer newValue) throws PersistenceException ;
    public PersistentSupplier getContractor() throws PersistenceException ;
    public void setContractor(PersistentSupplier newValue) throws PersistenceException ;
    public Order_PositionsProxi getPositions() throws PersistenceException ;
    public PersistentOrder getThis() throws PersistenceException ;
    
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

