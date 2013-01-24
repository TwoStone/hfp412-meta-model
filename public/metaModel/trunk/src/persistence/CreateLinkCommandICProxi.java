package persistence;

import model.UserException;

import model.visitor.*;

public class CreateLinkCommandICProxi extends PersistentInCacheProxi implements PersistentCreateLinkCommand{
    
    public CreateLinkCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateLinkCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade
            .getCreateLinkCommand(this.getId());
    }
    
    public long getClassId() {
        return 158;
    }
    
    public PersistentAssociation getType() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getType();
    }
    public void setType(PersistentAssociation newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setType(newValue);
    }
    public PersistentInstanceObject getSource() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getSource();
    }
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setSource(newValue);
    }
    public PersistentInstanceObject getTarget() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setTarget(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentLinkManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentLinkManager newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateLinkCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateLinkCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateLinkCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateLinkCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateLinkCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateLinkCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateLinkCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateLinkCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateLinkCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateLinkCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateLinkCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateLinkCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateLinkCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateLinkCommand(this);
    }
    public void accept(LinkManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateLinkCommand(this);
    }
    public <R> R accept(LinkManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateLinkCommand(this);
    }
    public <E extends UserException>  void accept(LinkManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateLinkCommand(this);
    }
    public <R, E extends UserException> R accept(LinkManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateLinkCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateLinkCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateLinkCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateLinkCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateLinkCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateLinkCommand)this.getTheObject()).sendException(exception);
    }

    
}
