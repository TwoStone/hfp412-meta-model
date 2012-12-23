package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAbsUnit extends Anything, AbstractPersistentProxi {
    
    public PersistentAbsUnitType getType() throws PersistenceException ;
    public void setType(PersistentAbsUnitType newValue) throws PersistenceException ;
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentAbsUnit getThis() throws PersistenceException ;
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

