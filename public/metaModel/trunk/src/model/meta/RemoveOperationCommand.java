
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
import model.visitor.OperationManagerCommandExceptionVisitor;
import model.visitor.OperationManagerCommandReturnExceptionVisitor;
import model.visitor.OperationManagerCommandReturnVisitor;
import model.visitor.OperationManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;
import persistence.PersistentRemoveOperationCommand;


/* Additional import section end */

public class RemoveOperationCommand extends PersistentObject implements PersistentRemoveOperationCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentRemoveOperationCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.getClass(objectId);
        return (PersistentRemoveOperationCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentRemoveOperationCommand createRemoveOperationCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createRemoveOperationCommand(createDate,commitDate,false);
    }
    
    public static PersistentRemoveOperationCommand createRemoveOperationCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentRemoveOperationCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade
                .newDelayedRemoveOperationCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade
                .newRemoveOperationCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentOperation op;
    protected Invoker invoker;
    protected PersistentOperationManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public RemoveOperationCommand(PersistentOperation op,Invoker invoker,PersistentOperationManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.op = op;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 139;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 139) ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade
            .newRemoveOperationCommand(this.getId());
        super.store();
        if(this.getOp() != null){
            this.getOp().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.opSet(this.getId(), getOp());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentOperation getOp() throws PersistenceException {
        return this.op;
    }
    public void setOp(PersistentOperation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.op)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.op = (PersistentOperation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.opSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentOperationManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentOperationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentOperationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleRemoveOperationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveOperationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemoveOperationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveOperationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveOperationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveOperationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveOperationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveOperationCommand(this);
    }
    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveOperationCommand(this);
    }
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveOperationCommand(this);
    }
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveOperationCommand(this);
    }
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveOperationCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getOp() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().removeOperation(this.getOp());
		}
		catch(model.ConsistencyException e){
			this.commandException = e;
		}
    }
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
