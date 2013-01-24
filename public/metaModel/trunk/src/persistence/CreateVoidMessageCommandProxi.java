package persistence;

import model.UserException;

import model.visitor.*;

public class CreateVoidMessageCommandProxi extends PersistentProxi implements PersistentCreateVoidMessageCommand{
    
    public CreateVoidMessageCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateVoidMessageCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateVoidMessageCommandFacade
            .getCreateVoidMessageCommand(this.getId());
    }
    
    public long getClassId() {
        return 171;
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentInstanceObject getSource() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getSource();
    }
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setSource(newValue);
    }
    public CreateVoidMessageCommand_ApProxi getAp() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getAp();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentMessageManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentMessageManager newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateVoidMessageCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateVoidMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateVoidMessageCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateVoidMessageCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateVoidMessageCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateVoidMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public void accept(MessageManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateVoidMessageCommand(this);
    }
    public <R> R accept(MessageManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    public <E extends UserException>  void accept(MessageManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateVoidMessageCommand(this);
    }
    public <R, E extends UserException> R accept(MessageManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateVoidMessageCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateVoidMessageCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateVoidMessageCommand)this.getTheObject()).sendException(exception);
    }

    
}
