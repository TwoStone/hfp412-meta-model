package persistence;

import model.UserException;

import model.visitor.*;

public class CreateConstantCommandProxi extends PersistentProxi implements PersistentCreateConstantCommand{
    
    public CreateConstantCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateConstantCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateConstantCommandFacade
            .getCreateConstantCommand(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getTarget() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setTarget(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentOperationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentOperationManager newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateConstantCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateConstantCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateConstantCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConstantCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConstantCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConstantCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateConstantCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConstantCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConstantCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConstantCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateConstantCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConstantCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConstantCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConstantCommand(this);
    }
    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateConstantCommand(this);
    }
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConstantCommand(this);
    }
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConstantCommand(this);
    }
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConstantCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateConstantCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateConstantCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateConstantCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateConstantCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateConstantCommand)this.getTheObject()).sendException(exception);
    }

    
}
