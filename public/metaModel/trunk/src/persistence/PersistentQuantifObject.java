package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentQuantifObject extends Anything, AbstractPersistentProxi {
    
    public PersistentInstanceObject getObject() throws PersistenceException ;
    public void setObject(PersistentInstanceObject newValue) throws PersistenceException ;
    public abstract PersistentQuantifObject getThis() throws PersistenceException ;
    
    public void accept(QuantifObjectVisitor visitor) throws PersistenceException;
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

