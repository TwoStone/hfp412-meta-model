package persistence;

import model.UserException;

import model.visitor.*;

public class CreateStaticOpCommandProxi extends PersistentProxi implements PersistentCreateStaticOpCommand{
    
    public CreateStaticOpCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateStaticOpCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateStaticOpCommandFacade
            .getCreateStaticOpCommand(this.getId());
    }
    
    public long getClassId() {
        return 232;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getTarget() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setTarget(newValue);
    }
    public CreateStaticOpCommand_FpProxi getFp() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getFp();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentOperationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentOperationManager newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStaticOpCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticOpCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticOpCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticOpCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticOpCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticOpCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticOpCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStaticOpCommand(this);
    }
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStaticOpCommand(this);
    }
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStaticOpCommand(this);
    }
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStaticOpCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateStaticOpCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateStaticOpCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateStaticOpCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateStaticOpCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateStaticOpCommand)this.getTheObject()).sendException(exception);
    }

    
}
