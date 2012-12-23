package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompUnitType extends PersistentAbsUnitType {
    
    public CompUnitType_RefsProxi getRefs() throws PersistenceException ;
    public PersistentMBoolean getIsFinal() throws PersistenceException ;
    public void setIsFinal(PersistentMBoolean newValue) throws PersistenceException ;
    public PersistentCompUnitType getThis() throws PersistenceException ;
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentMBoolean isFinal() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void finishModeling() 
				throws model.AlreadyFinalizedException, PersistenceException;

}

