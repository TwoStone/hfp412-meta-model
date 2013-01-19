package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAtomicSubTypeCommandProxi extends PersistentProxi implements PersistentCreateAtomicSubTypeCommand{
    
    public CreateAtomicSubTypeCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateAtomicSubTypeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade
            .getCreateAtomicSubTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 155;
    }
    
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getSuperType();
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setSuperType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getSingletonType();
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setSingletonType(newValue);
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getAbstractType();
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setAbstractType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentMAtomicType getCommandResult() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(PersistentMAtomicType newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicSubTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAtomicSubTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
