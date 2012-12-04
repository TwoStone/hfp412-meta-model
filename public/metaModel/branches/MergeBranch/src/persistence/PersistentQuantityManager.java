package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentQuantityManager extends Anything, AbstractPersistentProxi {
    
    public QuantityManager_QuantitiesProxi getQuantities() throws PersistenceException ;
    public PersistentQuantityManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createQuantity(final PersistentAbsUnit unit, final common.Fraction amount) 
				throws model.NotFinalizedException, PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

