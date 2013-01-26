package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAbsUnitType extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentAbsUnitType getThis() throws PersistenceException ;
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

