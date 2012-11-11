package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentQuantity extends PersistentAbsQuantity {
    
    public common.Fraction getAmount() throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public PersistentUnit getUnit() throws PersistenceException ;
    public void setUnit(PersistentUnit newValue) throws PersistenceException ;
    public PersistentQuantity getThis() throws PersistenceException ;
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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

