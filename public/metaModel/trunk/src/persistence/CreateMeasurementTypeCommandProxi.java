package persistence;

import model.UserException;

import model.visitor.*;

public class CreateMeasurementTypeCommandProxi extends PersistentProxi implements PersistentCreateMeasurementTypeCommand{
    
    public CreateMeasurementTypeCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateMeasurementTypeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateMeasurementTypeCommandFacade
            .getCreateMeasurementTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 216;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getType() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentUnitType getUnitType() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getUnitType();
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setUnitType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentMeasurementTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentMeasurementTypeManager newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public void accept(MeasurementTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R> R accept(MeasurementTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <E extends UserException>  void accept(MeasurementTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMeasurementTypeCommand(this);
    }
    public <R, E extends UserException> R accept(MeasurementTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMeasurementTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateMeasurementTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
