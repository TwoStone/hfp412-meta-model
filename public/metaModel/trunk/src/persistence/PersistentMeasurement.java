package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMeasurement extends PersistentQuantifObject {
    
    public PersistentMMeasurementType getType() throws PersistenceException ;
    public void setType(PersistentMMeasurementType newValue) throws PersistenceException ;
    public PersistentAbsQuantity getQuantity() throws PersistenceException ;
    public void setQuantity(PersistentAbsQuantity newValue) throws PersistenceException ;
    public PersistentMeasurement getThis() throws PersistenceException ;
    
    public void accept(QuantifObjectVisitor visitor) throws PersistenceException;
    public <R> R accept(QuantifObjectReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(QuantifObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

