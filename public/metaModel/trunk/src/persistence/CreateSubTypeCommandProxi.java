package persistence;

import model.UserException;

import model.visitor.*;

public class CreateSubTypeCommandProxi extends PersistentProxi implements PersistentCreateSubTypeCommand{
    
    public CreateSubTypeCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateSubTypeCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade
            .getCreateSubTypeCommand(this.getId());
    }
    
    public long getClassId() {
        return 135;
    }
    
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getSuperType();
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setSuperType(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getSingletonType();
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setSingletonType(newValue);
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getAbstractType();
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setAbstractType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateSubTypeCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateSubTypeCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateSubTypeCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateSubTypeCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateSubTypeCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateSubTypeCommand)this.getTheObject()).sendException(exception);
    }

    
}
