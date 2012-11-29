package persistence;

import model.UserException;

import model.visitor.*;

public class AddDefaultUnitCommandICProxi extends PersistentInCacheProxi implements PersistentAddDefaultUnitCommand{
    
    public AddDefaultUnitCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddDefaultUnitCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddDefaultUnitCommandFacade
            .getAddDefaultUnitCommand(this.getId());
    }
    
    public long getClassId() {
        return 125;
    }
    
    public PersistentAbsUnitType getType() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentAbsUnitType newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentAbsUnit getUnit() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getUnit();
    }
    public void setUnit(PersistentAbsUnit newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setUnit(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentUnitTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentUnitTypeManager newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddDefaultUnitCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddDefaultUnitCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddDefaultUnitCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddDefaultUnitCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddDefaultUnitCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddDefaultUnitCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddDefaultUnitCommand(this);
    }
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddDefaultUnitCommand(this);
    }
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddDefaultUnitCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddDefaultUnitCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddDefaultUnitCommand)this.getTheObject()).sendException(exception);
    }

    
}
