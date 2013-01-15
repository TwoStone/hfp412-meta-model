package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMQuantiObjectType extends Anything, AbstractPersistentProxi {
    
    public MType getType() throws PersistenceException ;
    public void setType(MType newValue) throws PersistenceException ;
    public PersistentAbsUnitType getUnitType() throws PersistenceException ;
    public void setUnitType(PersistentAbsUnitType newValue) throws PersistenceException ;
    public abstract PersistentMQuantiObjectType getThis() throws PersistenceException ;
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

