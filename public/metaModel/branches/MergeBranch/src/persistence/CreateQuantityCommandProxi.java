package persistence;

import model.UserException;

import model.visitor.*;

public class CreateQuantityCommandProxi extends PersistentProxi implements PersistentCreateQuantityCommand{
    
    public CreateQuantityCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateQuantityCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateQuantityCommandFacade
            .getCreateQuantityCommand(this.getId());
    }
    
    public long getClassId() {
        return 180;
    }
    
    public PersistentAbsUnit getUnit() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getUnit();
    }
    public void setUnit(PersistentAbsUnit newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setUnit(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setAmount(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentQuantityManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentQuantityManager newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateQuantityCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateQuantityCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateQuantityCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateQuantityCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateQuantityCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateQuantityCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateQuantityCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateQuantityCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateQuantityCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateQuantityCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateQuantityCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateQuantityCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateQuantityCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateQuantityCommand(this);
    }
    public void accept(QuantityManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateQuantityCommand(this);
    }
    public <R> R accept(QuantityManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateQuantityCommand(this);
    }
    public <E extends UserException>  void accept(QuantityManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateQuantityCommand(this);
    }
    public <R, E extends UserException> R accept(QuantityManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateQuantityCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateQuantityCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateQuantityCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateQuantityCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateQuantityCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateQuantityCommand)this.getTheObject()).sendException(exception);
    }

    
}
