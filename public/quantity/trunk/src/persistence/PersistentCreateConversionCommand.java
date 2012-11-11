package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCreateConversionCommand extends ConversionManagerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi {
    
    public PersistentUnit getUnit() throws PersistenceException ;
    public void setUnit(PersistentUnit newValue) throws PersistenceException ;
    public common.Fraction getFactor() throws PersistenceException ;
    public void setFactor(common.Fraction newValue) throws PersistenceException ;
    public common.Fraction getConstant() throws PersistenceException ;
    public void setConstant(common.Fraction newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PersistentConversionManager getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PersistentConversionManager newValue) throws PersistenceException ;
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
    public void accept(ConversionManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(ConversionManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ConversionManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ConversionManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void execute() 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;
    public void checkException() 
				throws UserException, PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;

}

