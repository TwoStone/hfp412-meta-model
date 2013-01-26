package persistence;

import model.UserException;

import model.visitor.*;

public class CreateMObjectCommandProxi extends PersistentProxi implements PersistentCreateMObjectCommand{
    
    public CreateMObjectCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateMObjectCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateMObjectCommandFacade
            .getCreateMObjectCommand(this.getId());
    }
    
    public long getClassId() {
        return 101;
    }
    
    public CreateMObjectCommand_TypesProxi getTypes() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getTypes();
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentObjectManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentObjectManager newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentMObject getCommandResult() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(PersistentMObject newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateMObjectCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMObjectCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateMObjectCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMObjectCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMObjectCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMObjectCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateMObjectCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMObjectCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMObjectCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMObjectCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMObjectCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMObjectCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMObjectCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMObjectCommand(this);
    }
    public void accept(ObjectManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMObjectCommand(this);
    }
    public <R> R accept(ObjectManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMObjectCommand(this);
    }
    public <E extends UserException>  void accept(ObjectManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMObjectCommand(this);
    }
    public <R, E extends UserException> R accept(ObjectManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMObjectCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateMObjectCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateMObjectCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateMObjectCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateMObjectCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateMObjectCommand)this.getTheObject()).sendException(exception);
    }

    
}
