package persistence;

import model.UserException;

import model.visitor.*;

public class AddReferenceTypeCommandProxi extends PersistentProxi implements PersistentAddReferenceTypeCommand{
    
    public AddReferenceTypeCommandProxi(long objectId) {
        super(objectId);
    }
    public AddReferenceTypeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddReferenceTypeCommandFacade
            .getAddReferenceTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 152;
    }
    
    public PersistentCompUnitType getCompUnitType() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getCompUnitType();
    }
    public void setCompUnitType(PersistentCompUnitType newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setCompUnitType(newValue);
    }
    public PersistentUnitType getUnitType() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getUnitType();
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setUnitType(newValue);
    }
    public long getExponent() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getExponent();
    }
    public void setExponent(long newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setExponent(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentUnitTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentUnitTypeManager newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceTypeCommand(this);
    }
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceTypeCommand(this);
    }
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddReferenceTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddReferenceTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
