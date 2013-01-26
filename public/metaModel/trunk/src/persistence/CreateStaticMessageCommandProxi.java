package persistence;

import model.UserException;

import model.visitor.*;

public class CreateStaticMessageCommandProxi extends PersistentProxi implements PersistentCreateStaticMessageCommand{
    
    public CreateStaticMessageCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateStaticMessageCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade
            .getCreateStaticMessageCommand(this.getId());
    }
    
    public long getClassId() {
        return 168;
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentInstanceObject getTarget() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setTarget(newValue);
    }
    public CreateStaticMessageCommand_ApProxi getAp() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getAp();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentMessageManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentMessageManager newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticMessageCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticMessageCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticMessageCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticMessageCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticMessageCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public void accept(MessageManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticMessageCommand(this);
    }
    public <R> R accept(MessageManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    public <E extends UserException>  void accept(MessageManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticMessageCommand(this);
    }
    public <R, E extends UserException> R accept(MessageManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticMessageCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateStaticMessageCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateStaticMessageCommand)this.getTheObject()).sendException(exception);
    }

    
}
