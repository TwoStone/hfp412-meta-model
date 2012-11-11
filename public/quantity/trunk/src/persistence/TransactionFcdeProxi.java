package persistence;

import model.UserException;

import model.visitor.*;

public class TransactionFcdeProxi extends PersistentProxi implements PersistentTransactionFcde{
    
    public TransactionFcdeProxi(long objectId) {
        super(objectId);
    }
    public TransactionFcdeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransactionFcdeFacade
            .getTransactionFcde(this.getId());
    }
    
    public long getClassId() {
        return 104;
    }
    
    public PersistentTransactionFcde getThis() throws PersistenceException {
        return ((PersistentTransactionFcde)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransactionFcde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransactionFcde(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransactionFcde(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransactionFcde(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransactionFcde)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransactionFcde)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransactionFcde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransactionFcde)this.getTheObject()).initializeOnCreation();
    }

    
}
