package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentConversion extends Anything, AbstractPersistentProxi {
    
    public PersistentUnit getSource() throws PersistenceException ;
    public void setSource(PersistentUnit newValue) throws PersistenceException ;
    public PersistentUnitType getType() throws PersistenceException ;
    public void setType(PersistentUnitType newValue) throws PersistenceException ;
    public PersistentFunction getMyFunction() throws PersistenceException ;
    public void setMyFunction(PersistentFunction newValue) throws PersistenceException ;
    public PersistentConversion getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentQuantity convert(final common.Fraction amount) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentQuantity convertInverse(final common.Fraction amount) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

