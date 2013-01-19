package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAbsQuantity extends Anything, AbstractPersistentProxi {
    
    public abstract PersistentAbsQuantity getThis() throws PersistenceException ;
    
    public void accept(AbsQuantityVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentAbsQuantity sub(final PersistentAbsQuantity subtrahend) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) 
				throws PersistenceException;
    public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public PersistentAbsQuantity add(final PersistentAbsQuantity summand) 
				throws PersistenceException;

}

