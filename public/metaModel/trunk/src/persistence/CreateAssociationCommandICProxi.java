package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAssociationCommandICProxi extends PersistentInCacheProxi implements PersistentCreateAssociationCommand{
    
    public CreateAssociationCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateAssociationCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade
            .getCreateAssociationCommand(this.getId());
    }
    
    public long getClassId() {
        return 146;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setName(newValue);
    }
    public MType getSource() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getSource();
    }
    public void setSource(MType newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setSource(newValue);
    }
    public MType getTarget() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(MType newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setTarget(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAssociationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAssociationManager newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAssociationCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAssociationCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAssociationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAssociationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAssociationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAssociationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAssociationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAssociationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAssociationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAssociationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAssociationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAssociationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAssociationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAssociationCommand(this);
    }
    public void accept(AssociationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAssociationCommand(this);
    }
    public <R> R accept(AssociationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAssociationCommand(this);
    }
    public <E extends UserException>  void accept(AssociationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAssociationCommand(this);
    }
    public <R, E extends UserException> R accept(AssociationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAssociationCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAssociationCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAssociationCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAssociationCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAssociationCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAssociationCommand)this.getTheObject()).sendException(exception);
    }

    
}
