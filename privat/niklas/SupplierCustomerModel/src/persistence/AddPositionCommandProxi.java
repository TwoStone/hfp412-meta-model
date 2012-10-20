package persistence;

import model.*;

public class AddPositionCommandProxi extends PersistentProxi implements PersistentAddPositionCommand{
    
    public AddPositionCommandProxi(long objectId) {
        super(objectId);
    }
    public AddPositionCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddPositionCommandFacade
            .getAddPositionCommand(this.getId());
    }
    
    public long getClassId() {
        return 128;
    }
    
    public PersistentOrder getOrder() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getOrder();
    }
    public void setOrder(PersistentOrder newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setOrder(newValue);
    }
    public PersistentProduct getProduct() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getProduct();
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setProduct(newValue);
    }
    public long getQuanitity() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getQuanitity();
    }
    public void setQuanitity(long newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setQuanitity(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentActorManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentActorManager newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddPositionCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddPositionCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddPositionCommand(this);
    }
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPositionCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPositionCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPositionCommand(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddPositionCommand(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPositionCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPositionCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPositionCommand(this);
    }
    public void accept(model.visitor.CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPositionCommand(this);
    }
    public <R> R accept(model.visitor.CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPositionCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPositionCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPositionCommand(this);
    }
    public void accept(model.visitor.ActorManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPositionCommand(this);
    }
    public <R> R accept(model.visitor.ActorManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPositionCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ActorManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPositionCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ActorManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPositionCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentAddPositionCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddPositionCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddPositionCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddPositionCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddPositionCommand)this.getTheObject()).sendException(exception);
    }

    
}
