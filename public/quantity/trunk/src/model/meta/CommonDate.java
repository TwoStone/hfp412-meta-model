
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CommonDate extends PersistentObject implements PersistentCommonDate{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCommonDate getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.getClass(objectId);
        return (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCommonDate createCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCommonDate(createDate,commitDate,false);
    }
    
    public static PersistentCommonDate createCommonDate(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentCommonDate result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
                .newDelayedCommonDate(createDate,commitDate);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
                .newCommonDate(createDate,commitDate,-1);
        }
        return result;
    }
    
    public static PersistentCommonDate createCommonDate(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence,PersistentCommonDate This) throws PersistenceException {
        PersistentCommonDate result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
                .newDelayedCommonDate(createDate,commitDate);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
                .newCommonDate(createDate,commitDate,-1);
        }
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
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 113) ConnectionHandler.getTheConnectionHandler().theCommonDateFacade
            .newCommonDate(createDate,commitDate,this.getId());
        super.store();
        
    }
    
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.createDate;
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.createDateSet(this.getId(), newValue);
        this.createDate = newValue;
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.commitDate;
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCommonDateFacade.commitDateSet(this.getId(), newValue);
        this.commitDate = newValue;
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCommonDate(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommonDate(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommonDate(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommonDate(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommonDate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommonDate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommonDate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommonDate(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
