package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAddDefaultUnitCommand extends TypeManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi {
    
    public PersistentAbsUnitType getType() throws PersistenceException ;
    public void setType(PersistentAbsUnitType newValue) throws PersistenceException ;
    public PersistentAbsUnit getUnit() throws PersistenceException ;
    public void setUnit(PersistentAbsUnit newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PersistentTypeManager getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException ;
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
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void execute() 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;
    public void checkException() 
				throws UserException, PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;

}

