package persistence;

import model.*;

public class AddRoleCommandProxi extends PersistentProxi implements PersistentAddRoleCommand{
    
    public AddRoleCommandProxi(long objectId) {
        super(objectId);
    }
    public AddRoleCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddRoleCommandFacade
            .getAddRoleCommand(this.getId());
    }
    
    public long getClassId() {
        return 120;
    }
    
    public PersistentAkteur getAkteur() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getAkteur();
    }
    public void setAkteur(PersistentAkteur newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setAkteur(newValue);
    }
    public String getRollenName() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getRollenName();
    }
    public void setRollenName(String newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setRollenName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTransactionManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTransactionManager newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddRoleCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddRoleCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(model.visitor.CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddRoleCommand(this);
    }
    public <R> R accept(model.visitor.CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddRoleCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddRoleCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddRoleCommand(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddRoleCommand(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddRoleCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddRoleCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddRoleCommand(this);
    }
    public void accept(model.visitor.CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddRoleCommand(this);
    }
    public <R> R accept(model.visitor.CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddRoleCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddRoleCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddRoleCommand(this);
    }
    public void accept(model.visitor.TransactionManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddRoleCommand(this);
    }
    public <R> R accept(model.visitor.TransactionManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddRoleCommand(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.TransactionManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddRoleCommand(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.TransactionManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddRoleCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentAddRoleCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddRoleCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddRoleCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddRoleCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddRoleCommand)this.getTheObject()).sendException(exception);
    }

    
}
