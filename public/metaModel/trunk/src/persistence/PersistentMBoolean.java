package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMBoolean extends Anything, AbstractPersistentProxi {
    
    public abstract PersistentMBoolean getThis() throws PersistenceException ;
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException;
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public boolean toBoolean() 
				throws PersistenceException;
    public PersistentMBoolean invert() 
				throws PersistenceException;

}

