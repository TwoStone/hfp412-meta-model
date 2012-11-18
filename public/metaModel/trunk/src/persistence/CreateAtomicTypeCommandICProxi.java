package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAtomicTypeCommandICProxi extends PersistentInCacheProxi implements PersistentCreateAtomicTypeCommand{
    
    public CreateAtomicTypeCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateAtomicTypeCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAtomicTypeCommandFacade
            .getCreateAtomicTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 140;
    }
    
    public PersistentMAspect getAspect() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getAspect();
    }
    public void setAspect(PersistentMAspect newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setAspect(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAtomicTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAtomicTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
