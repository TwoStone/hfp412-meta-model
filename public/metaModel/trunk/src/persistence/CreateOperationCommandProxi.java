package persistence;

import model.UserException;

import model.visitor.*;

public class CreateOperationCommandProxi extends PersistentProxi implements PersistentCreateOperationCommand{
    
    public CreateOperationCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateOperationCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade
            .getCreateOperationCommand(this.getId());
    }
    
    public long getClassId() {
        return 243;
    }
    
    public PersistentMType getSource() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getSource();
    }
    public void setSource(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setSource(newValue);
    }
    public PersistentMType getTarget() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setTarget(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setName(newValue);
    }
    public CreateOperationCommand_FpProxi getFp() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getFp();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentOperationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentOperationManager newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateOperationCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateOperationCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    public void accept(OperationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateOperationCommand(this);
    }
    public <R> R accept(OperationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateOperationCommand(this);
    }
    public <E extends UserException>  void accept(OperationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateOperationCommand(this);
    }
    public <R, E extends UserException> R accept(OperationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateOperationCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateOperationCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateOperationCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateOperationCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateOperationCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateOperationCommand)this.getTheObject()).sendException(exception);
    }

    
}
