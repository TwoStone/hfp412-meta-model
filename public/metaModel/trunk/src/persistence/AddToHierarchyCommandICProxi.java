package persistence;

import model.UserException;

import model.visitor.*;

public class AddToHierarchyCommandICProxi extends PersistentInCacheProxi implements PersistentAddToHierarchyCommand{
    
    public AddToHierarchyCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddToHierarchyCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddToHierarchyCommandFacade
            .getAddToHierarchyCommand(this.getId());
    }
    
    public long getClassId() {
        return 145;
    }
    
    public PersistentMAssociation getAssociation() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getAssociation();
    }
    public void setAssociation(PersistentMAssociation newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setAssociation(newValue);
    }
    public PersistentMAHierarchy getTheHierarchy() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getTheHierarchy();
    }
    public void setTheHierarchy(PersistentMAHierarchy newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setTheHierarchy(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAssociationManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAssociationManager newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddToHierarchyCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddToHierarchyCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddToHierarchyCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddToHierarchyCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddToHierarchyCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddToHierarchyCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddToHierarchyCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public void accept(AssociationManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddToHierarchyCommand(this);
    }
    public <R> R accept(AssociationManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddToHierarchyCommand(this);
    }
    public <E extends UserException>  void accept(AssociationManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddToHierarchyCommand(this);
    }
    public <R, E extends UserException> R accept(AssociationManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddToHierarchyCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentAddToHierarchyCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddToHierarchyCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddToHierarchyCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddToHierarchyCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddToHierarchyCommand)this.getTheObject()).sendException(exception);
    }

    
}
