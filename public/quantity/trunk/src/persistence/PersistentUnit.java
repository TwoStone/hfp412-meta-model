package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentUnit extends PersistentAbsUnit {
    
    public PersistentUnit getThis() throws PersistenceException ;
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public ConversionSearchList getMyConversions() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

