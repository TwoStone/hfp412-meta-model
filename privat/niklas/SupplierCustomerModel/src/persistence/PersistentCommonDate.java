package persistence;

public interface PersistentCommonDate extends Anything, AbstractPersistentProxi {
    
    public java.sql.Date getCreateDate() throws PersistenceException ;
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException ;
    public java.sql.Date getCommitDate() throws PersistenceException ;
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException ;
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    

}

