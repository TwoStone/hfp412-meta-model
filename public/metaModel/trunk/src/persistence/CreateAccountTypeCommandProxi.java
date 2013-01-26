package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAccountTypeCommandProxi extends PersistentProxi implements PersistentCreateAccountTypeCommand{
    
    public CreateAccountTypeCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateAccountTypeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAccountTypeCommandFacade
            .getCreateAccountTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 147;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMType getType() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentMType newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentUnitType getUnitType() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getUnitType();
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setUnitType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccountTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccountTypeManager newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public void accept(AccountTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountTypeCommand(this);
    }
    public <R> R accept(AccountTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    public <E extends UserException>  void accept(AccountTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AccountTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAccountTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAccountTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
