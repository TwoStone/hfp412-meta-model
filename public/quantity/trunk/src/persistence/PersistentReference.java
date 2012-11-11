package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentReference extends Anything, AbstractPersistentProxi {
    
    public PersistentReferenceType getType() throws PersistenceException ;
    public void setType(PersistentReferenceType newValue) throws PersistenceException ;
    public long getExponent() throws PersistenceException ;
    public void setExponent(long newValue) throws PersistenceException ;
    public PersistentUnit getRef() throws PersistenceException ;
    public void setRef(PersistentUnit newValue) throws PersistenceException ;
    public PersistentReference getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

