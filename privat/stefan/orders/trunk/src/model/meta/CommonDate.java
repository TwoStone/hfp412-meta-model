
package model.meta;

import persistence.*;
import model.*;


/* Additional import section end */

public class CommonDate extends PersistentObject implements PersistentCommonDate{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCommonDate getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getClass(objectId);
        return (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCommonDate createCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        PersistentCommonDate result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
            .newCommonDate(createDate,commitDate);
        return result;
    }
    
    public static PersistentCommonDate createCommonDate(java.sql.Date createDate,java.sql.Date commitDate,PersistentCommonDate This) throws PersistenceException {
        PersistentCommonDate result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
            .newCommonDate(createDate,commitDate);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected java.sql.Date createDate;
    protected java.sql.Date commitDate;
    
    public CommonDate(java.sql.Date createDate,java.sql.Date commitDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.createDate = createDate;
        this.commitDate = commitDate;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.createDate;
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.createDateSet(this.getId(), newValue);
        this.createDate = newValue;
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.commitDate;
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.commitDateSet(this.getId(), newValue);
        this.commitDate = newValue;
    }
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCommonDate(this);
    }
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommonDate(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommonDate(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommonDate(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommonDate(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommonDate(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommonDate(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommonDate(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
