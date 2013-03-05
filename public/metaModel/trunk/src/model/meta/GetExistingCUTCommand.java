
package model.meta;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;
import model.visitor.CommonDateExceptionVisitor;
import model.visitor.CommonDateReturnExceptionVisitor;
import model.visitor.CommonDateReturnVisitor;
import model.visitor.CommonDateVisitor;
import model.visitor.UnitTypeManagerCommandExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnVisitor;
import model.visitor.UnitTypeManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.GetExistingCUTCommand_RefTypesProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCompUnitType;
import persistence.PersistentGetExistingCUTCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnitTypeManager;


/* Additional import section end */

public class GetExistingCUTCommand extends PersistentObject implements PersistentGetExistingCUTCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentGetExistingCUTCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.getClass(objectId);
        return (PersistentGetExistingCUTCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentGetExistingCUTCommand createGetExistingCUTCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createGetExistingCUTCommand(createDate,commitDate,false);
    }
    
    public static PersistentGetExistingCUTCommand createGetExistingCUTCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentGetExistingCUTCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade
                .newDelayedGetExistingCUTCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade
                .newGetExistingCUTCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected GetExistingCUTCommand_RefTypesProxi refTypes;
    protected Invoker invoker;
    protected PersistentUnitTypeManager commandReceiver;
    protected PersistentCompUnitType commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public GetExistingCUTCommand(Invoker invoker,PersistentUnitTypeManager commandReceiver,PersistentCompUnitType commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.refTypes = new GetExistingCUTCommand_RefTypesProxi(this);
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 339;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 339) ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade
            .newGetExistingCUTCommand(this.getId());
        super.store();
        this.getRefTypes().store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public GetExistingCUTCommand_RefTypesProxi getRefTypes() throws PersistenceException {
        return this.refTypes;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentUnitTypeManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentUnitTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCompUnitType getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentCompUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentCompUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.commandResultSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGetExistingCUTCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.getMyCommonDate().getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.getMyCommonDate().getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleGetExistingCUTCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGetExistingCUTCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleGetExistingCUTCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGetExistingCUTCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleGetExistingCUTCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGetExistingCUTCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleGetExistingCUTCommand(this);
    }
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGetExistingCUTCommand(this);
    }
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGetExistingCUTCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCommandReceiver() != null) return 1;
        if (this.getCommandResult() != null) return 1;
        if (this.getRefTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        this.setCommandResult(this.getCommandReceiver().getExistingCUT(this.getRefTypes().getList()));
		
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
