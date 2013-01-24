package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAtomicRootTypeCommandICProxi extends PersistentInCacheProxi implements PersistentCreateAtomicRootTypeCommand{
    
    public CreateAtomicRootTypeCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateAtomicRootTypeCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAtomicRootTypeCommandFacade
            .getCreateAtomicRootTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 189;
    }
    
    public PersistentMAspect getAspect() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getAspect();
    }
    public void setAspect(PersistentMAspect newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setAspect(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getSingletonType();
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setSingletonType(newValue);
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getAbstractType();
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setAbstractType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentMAtomicType getCommandResult() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(PersistentMAtomicType newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAtomicRootTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAtomicRootTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAtomicRootTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
