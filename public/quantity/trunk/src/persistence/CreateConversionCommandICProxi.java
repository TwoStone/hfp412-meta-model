package persistence;

import model.UserException;

import model.visitor.*;

public class CreateConversionCommandICProxi extends PersistentInCacheProxi implements PersistentCreateConversionCommand{
    
    public CreateConversionCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateConversionCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateConversionCommandFacade
            .getCreateConversionCommand(this.getId());
    }
    
    public long getClassId() {
        return 109;
    }
    
    public PersistentUnit getUnit() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getUnit();
    }
    public void setUnit(PersistentUnit newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setUnit(newValue);
    }
    public common.Fraction getFactor() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getFactor();
    }
    public void setFactor(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setFactor(newValue);
    }
    public common.Fraction getConstant() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getConstant();
    }
    public void setConstant(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setConstant(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentConversionManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentConversionManager newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateConversionCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateConversionCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateConversionCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConversionCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConversionCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConversionCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateConversionCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConversionCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConversionCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConversionCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateConversionCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConversionCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConversionCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConversionCommand(this);
    }
    public void accept(ConversionManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateConversionCommand(this);
    }
    public <R> R accept(ConversionManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateConversionCommand(this);
    }
    public <E extends UserException>  void accept(ConversionManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateConversionCommand(this);
    }
    public <R, E extends UserException> R accept(ConversionManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateConversionCommand(this);
    }
    
    
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateConversionCommand)this.getTheObject()).execute();
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateConversionCommand)this.getTheObject()).sendResult();
    }
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateConversionCommand)this.getTheObject()).checkException();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateConversionCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateConversionCommand)this.getTheObject()).sendException(exception);
    }

    
}
