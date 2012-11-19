package persistence;

import model.UserException;

import model.visitor.*;

public class QuantityManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentQuantityManager{
    
    public QuantityManagerICProxi(long objectId) {
        super(objectId);
    }
    public QuantityManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade
            .getQuantityManager(this.getId());
    }
    
    public long getClassId() {
        return 104;
    }
    
    public QuantityManager_QuantitiesProxi getQuantities() throws PersistenceException {
        return ((PersistentQuantityManager)this.getTheObject()).getQuantities();
    }
    public PersistentQuantityManager getThis() throws PersistenceException {
        return ((PersistentQuantityManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantityManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantityManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantityManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantityManager(this);
    }
    
    
    public void createQuantity(final PersistentUnit unit, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).createQuantity(unit, amount, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createQuantity(final PersistentUnit unit, final common.Fraction amount) 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).createQuantity(unit, amount);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).initializeOnCreation();
    }

    
}
