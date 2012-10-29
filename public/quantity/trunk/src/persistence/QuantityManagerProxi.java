package persistence;

import model.UserException;

import model.visitor.*;

public class QuantityManagerProxi extends PersistentProxi implements PersistentQuantityManager{
    
    public QuantityManagerProxi(long objectId) {
        super(objectId);
    }
    public QuantityManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade
            .getQuantityManager(this.getId());
    }
    
    public long getClassId() {
        return 109;
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantityManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
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
