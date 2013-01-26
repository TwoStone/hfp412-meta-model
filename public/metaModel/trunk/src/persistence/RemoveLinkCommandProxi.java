package persistence;

import model.UserException;

import model.visitor.*;

public class RemoveLinkCommandProxi extends PersistentProxi implements PersistentRemoveLinkCommand{
    
    public RemoveLinkCommandProxi(long objectId) {
        super(objectId);
    }
    public RemoveLinkCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theRemoveLinkCommandFacade
            .getRemoveLinkCommand(this.getId());
    }
    
    public long getClassId() {
        return 224;
    }
    
    public PersistentLink getLink() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getLink();
    }
    public void setLink(PersistentLink newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setLink(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentLinkManager getCommandReceiver() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentLinkManager newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentRemoveLinkCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveLinkCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleRemoveLinkCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveLinkCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveLinkCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveLinkCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemoveLinkCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveLinkCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveLinkCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveLinkCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveLinkCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveLinkCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveLinkCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveLinkCommand(this);
    }
    public void accept(LinkManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveLinkCommand(this);
    }
    public <R> R accept(LinkManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveLinkCommand(this);
    }
    public <E extends UserException>  void accept(LinkManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveLinkCommand(this);
    }
    public <R, E extends UserException> R accept(LinkManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveLinkCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentRemoveLinkCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentRemoveLinkCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentRemoveLinkCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentRemoveLinkCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRemoveLinkCommand)this.getTheObject()).sendException(exception);
    }

    
}
