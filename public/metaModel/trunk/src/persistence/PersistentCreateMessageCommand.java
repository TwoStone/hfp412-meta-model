package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCreateMessageCommand extends MessageManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi {
    
    public PersistentOperation getType() throws PersistenceException ;
    public void setType(PersistentOperation newValue) throws PersistenceException ;
    public PersistentInstanceObject getSource() throws PersistenceException ;
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException ;
    public PersistentInstanceObject getTarget() throws PersistenceException ;
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException ;
    public CreateMessageCommand_ApProxi getAp() throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PersistentMessageManager getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PersistentMessageManager newValue) throws PersistenceException ;
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MessageManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(MessageManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MessageManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MessageManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void execute() 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;
    public void checkException() 
				throws UserException, PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;

}
