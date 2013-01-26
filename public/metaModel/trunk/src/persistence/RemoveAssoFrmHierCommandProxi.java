package persistence;

import model.UserException;

import model.visitor.*;

public class RemoveAssoFrmHierCommandProxi extends PersistentProxi implements PersistentRemoveAssoFrmHierCommand{
    
    public RemoveAssoFrmHierCommandProxi(long objectId) {
        super(objectId);
    }
    public RemoveAssoFrmHierCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theRemoveAssoFrmHierCommandFacade
            .getRemoveAssoFrmHierCommand(this.getId());
    }
    
    public long getClassId() {
        return 222;
    }
    
    public PersistentHierarchy getH() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getH();
    }
    public void setH(PersistentHierarchy newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setH(newValue);
    }
    public PersistentAssociation getA() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getA();
    }
    public void setA(PersistentAssociation newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setA(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAssociationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAssociationManager newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public void accept(AssociationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R> R accept(AssociationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <E extends UserException>  void accept(AssociationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveAssoFrmHierCommand(this);
    }
    public <R, E extends UserException> R accept(AssociationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveAssoFrmHierCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRemoveAssoFrmHierCommand)this.getTheObject()).sendException(exception);
    }

    
}
