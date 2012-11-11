package persistence;

import model.UserException;

import model.visitor.*;

public class CreateUnitCommandICProxi extends PersistentInCacheProxi implements PersistentCreateUnitCommand{
    
    public CreateUnitCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateUnitCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateUnitCommandFacade
            .getCreateUnitCommand(this.getId());
    }
    
    public long getClassId() {
        return 131;
    }
    
    public PersistentUnitType getType() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentUnitManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentUnitManager newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateUnitCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateUnitCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateUnitCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateUnitCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateUnitCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateUnitCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateUnitCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateUnitCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateUnitCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateUnitCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateUnitCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateUnitCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateUnitCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateUnitCommand(this);
    }
    public void accept(UnitManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateUnitCommand(this);
    }
    public <R> R accept(UnitManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateUnitCommand(this);
    }
    public <E extends UserException>  void accept(UnitManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateUnitCommand(this);
    }
    public <R, E extends UserException> R accept(UnitManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateUnitCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateUnitCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateUnitCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateUnitCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateUnitCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateUnitCommand)this.getTheObject()).sendException(exception);
    }

    
}
