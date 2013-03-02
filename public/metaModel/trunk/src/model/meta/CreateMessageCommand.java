
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
import model.visitor.MessageManagerCommandExceptionVisitor;
import model.visitor.MessageManagerCommandReturnExceptionVisitor;
import model.visitor.MessageManagerCommandReturnVisitor;
import model.visitor.MessageManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.CreateMessageCommand_ApProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentMObject;
import persistence.PersistentMessageManager;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentProxi;


/* Additional import section end */

public class CreateMessageCommand extends PersistentObject implements PersistentCreateMessageCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateMessageCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.getClass(objectId);
        return (PersistentCreateMessageCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateMessageCommand createCreateMessageCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateMessageCommand(createDate,commitDate,false);
    }
    
    public static PersistentCreateMessageCommand createCreateMessageCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentCreateMessageCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
                .newDelayedCreateMessageCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
                .newCreateMessageCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentOperation type;
    protected PersistentMObject source;
    protected PersistentMObject target;
    protected CreateMessageCommand_ApProxi ap;
    protected Invoker invoker;
    protected PersistentMessageManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateMessageCommand(PersistentOperation type,PersistentMObject source,PersistentMObject target,Invoker invoker,PersistentMessageManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        this.source = source;
        this.target = target;
        this.ap = new CreateMessageCommand_ApProxi(this);
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 146) ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
            .newCreateMessageCommand(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.typeSet(this.getId(), getType());
        }
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getTarget() != null){
            this.getTarget().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.targetSet(this.getId(), getTarget());
        }
        this.getAp().store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentOperation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentMObject getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.sourceSet(this.getId(), newValue);
        }
    }
    public PersistentMObject getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(PersistentMObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentMObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.targetSet(this.getId(), newValue);
        }
    }
    public CreateMessageCommand_ApProxi getAp() throws PersistenceException {
        return this.ap;
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
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentMessageManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentMessageManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentMessageManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateMessageCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMessageCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateMessageCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMessageCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMessageCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMessageCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMessageCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMessageCommand(this);
    }
    public void accept(MessageManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMessageCommand(this);
    }
    public <R> R accept(MessageManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMessageCommand(this);
    }
    public <E extends UserException>  void accept(MessageManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMessageCommand(this);
    }
    public <R, E extends UserException> R accept(MessageManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMessageCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getType() != null) return 1;
        if (this.getSource() != null) return 1;
        if (this.getTarget() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        if (this.getAp().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().createMessage(this.getType(), this.getSource(), this.getTarget(), this.getAp().getList());
		}
		catch(model.DoubleDefinitionException e){
			this.commandException = e;
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
