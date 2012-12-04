package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAspectCommandICProxi extends PersistentInCacheProxi implements PersistentCreateAspectCommand{
    
    public CreateAspectCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateAspectCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAspectCommandFacade
            .getCreateAspectCommand(this.getId());
    }
    
    public long getClassId() {
        return 139;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAspectManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAspectManager newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAspectCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAspectCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAspectCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAspectCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAspectCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAspectCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAspectCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAspectCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAspectCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAspectCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAspectCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAspectCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAspectCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAspectCommand(this);
    }
    public void accept(AspectManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAspectCommand(this);
    }
    public <R> R accept(AspectManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAspectCommand(this);
    }
    public <E extends UserException>  void accept(AspectManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAspectCommand(this);
    }
    public <R, E extends UserException> R accept(AspectManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAspectCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAspectCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAspectCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAspectCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAspectCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAspectCommand)this.getTheObject()).sendException(exception);
    }

    
}
