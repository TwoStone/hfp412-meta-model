package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompUnit extends PersistentAbsUnit {
    
    public CompUnit_RefsProxi getRefs() throws PersistenceException ;
    public PersistentBooleanValue getIsFinal() throws PersistenceException ;
    public void setIsFinal(PersistentBooleanValue newValue) throws PersistenceException ;
    public PersistentCompUnit getThis() throws PersistenceException ;
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentBooleanValue isFinal() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void checkExponents() 
				throws model.ExponentMatchingException, PersistenceException;
    public void finishModeling() 
				throws model.AlreadyFinalizedException, model.ExponentMatchingException, PersistenceException;

}

