package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCommonDate extends Anything, AbstractPersistentProxi {
    
    public java.sql.Date getCreateDate() throws PersistenceException ;
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException ;
    public java.sql.Date getCommitDate() throws PersistenceException ;
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    

}

