package persistence;

import model.UserException;

import model.visitor.*;

public class CreateMessageCommandProxi extends PersistentProxi implements PersistentCreateMessageCommand{
    
    public CreateMessageCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateMessageCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade
            .getCreateMessageCommand(this.getId());
    }
    
    public long getClassId() {
        return 144;
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentInstanceObject getSource() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getSource();
    }
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setSource(newValue);
    }
    public PersistentInstanceObject getTarget() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setTarget(newValue);
    }
    public CreateMessageCommand_ApProxi getAp() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getAp();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentMessageManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentMessageManager newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateMessageCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMessageCommand)this.getTheObject()).setCommitDate(newValue);
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
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateMessageCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateMessageCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateMessageCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateMessageCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateMessageCommand)this.getTheObject()).sendException(exception);
    }

    
}
