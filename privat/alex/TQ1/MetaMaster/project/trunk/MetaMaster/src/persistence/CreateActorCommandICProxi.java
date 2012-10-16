package persistence;

import model.*;

public class CreateActorCommandICProxi extends PersistentInCacheProxi implements PersistentCreateActorCommand{
    
    public CreateActorCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateActorCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateActorCommandFacade
            .getCreateActorCommand(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentActorManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentActorManager newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateActorCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateActorCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    public void accept(model.visitor.ActorManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateActorCommand(this);
    }
    public <R> R accept(model.visitor.ActorManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateActorCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateActorCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateActorCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateActorCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateActorCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateActorCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateActorCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateActorCommand)this.getTheObject()).sendException(exception);
    }

    
}
