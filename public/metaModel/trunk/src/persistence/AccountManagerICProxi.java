package persistence;

import model.UserException;

import model.visitor.*;

public class AccountManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountManager{
    
    public AccountManagerICProxi(long objectId) {
        super(objectId);
    }
    public AccountManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            .getAccountManager(this.getId());
    }
    
    public long getClassId() {
        return 141;
    }
    
    public AccountManager_AccountsProxi getAccounts() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getAccounts();
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnCreation();
    }
    public void createAccount(final String name, final PersistentMAccountType type, final PersistentInstanceObject object) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name, type, object);
    }
    public void createAccount(final String name, final PersistentMAccountType type, final PersistentInstanceObject object, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name, type, object, invoker);
    }

    
}
