
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
import model.visitor.QuantityManagerCommandExceptionVisitor;
import model.visitor.QuantityManagerCommandReturnExceptionVisitor;
import model.visitor.QuantityManagerCommandReturnVisitor;
import model.visitor.QuantityManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAddCommand;
import persistence.PersistentCommonDate;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantityManager;


/* Additional import section end */

public class AddCommand extends PersistentObject implements PersistentAddCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAddCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.getClass(objectId);
        return (PersistentAddCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAddCommand createAddCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createAddCommand(createDate,commitDate,false);
    }
    
    public static PersistentAddCommand createAddCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentAddCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAddCommandFacade
                .newDelayedAddCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAddCommandFacade
                .newAddCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentAbsQuantity summand1;
    protected PersistentAbsQuantity summand2;
    protected Invoker invoker;
    protected PersistentQuantityManager commandReceiver;
    protected PersistentAbsQuantity commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public AddCommand(PersistentAbsQuantity summand1,PersistentAbsQuantity summand2,Invoker invoker,PersistentQuantityManager commandReceiver,PersistentAbsQuantity commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.summand1 = summand1;
        this.summand2 = summand2;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 338;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 338) ConnectionHandler.getTheConnectionHandler().theAddCommandFacade
            .newAddCommand(this.getId());
        super.store();
        if(this.getSummand1() != null){
            this.getSummand1().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.summand1Set(this.getId(), getSummand1());
        }
        if(this.getSummand2() != null){
            this.getSummand2().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.summand2Set(this.getId(), getSummand2());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentAbsQuantity getSummand1() throws PersistenceException {
        return this.summand1;
    }
    public void setSummand1(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.summand1)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.summand1 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.summand1Set(this.getId(), newValue);
        }
    }
    public PersistentAbsQuantity getSummand2() throws PersistenceException {
        return this.summand2;
    }
    public void setSummand2(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.summand2)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.summand2 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.summand2Set(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentQuantityManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentQuantityManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentQuantityManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentAbsQuantity getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.commandResultSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAddCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleAddCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddCommand(this);
    }
    public void accept(QuantityManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddCommand(this);
    }
    public <R> R accept(QuantityManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddCommand(this);
    }
    public <E extends UserException>  void accept(QuantityManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddCommand(this);
    }
    public <R, E extends UserException> R accept(QuantityManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSummand1() != null) return 1;
        if (this.getSummand2() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        if (this.getCommandResult() != null) return 1;
        return 0;
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.setCommandResult(this.getCommandReceiver().add(this.getSummand1(), this.getSummand2()));
		}
		catch(model.NotComputableException e){
			this.commandException = e;
		}
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
