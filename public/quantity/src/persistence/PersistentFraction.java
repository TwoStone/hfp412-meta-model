package persistence;

public interface PersistentFraction extends Anything, AbstractPersistentProxi {
    
    public long getEnumerator() throws PersistenceException ;
    public void setEnumerator(long newValue) throws PersistenceException ;
    public long getDenominator() throws PersistenceException ;
    public void setDenominator(long newValue) throws PersistenceException ;
    public PersistentFraction getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentFraction add(final PersistentFraction fraction) 
				throws PersistenceException;
    public PersistentFraction toRational() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentFraction mul(final PersistentFraction fraction) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

