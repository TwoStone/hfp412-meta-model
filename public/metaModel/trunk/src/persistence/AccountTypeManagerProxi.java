package persistence;

import model.UserException;

import model.visitor.*;

public class AccountTypeManagerProxi extends PersistentProxi implements PersistentAccountTypeManager{
    
    public AccountTypeManagerProxi(long objectId) {
        super(objectId);
    }
    public AccountTypeManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade
            .getAccountTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 213;
    }
    
    public AccountTypeManager_AccountTypesProxi getAccountTypes() throws PersistenceException {
        return ((PersistentAccountTypeManager)this.getTheObject()).getAccountTypes();
    }
    public PersistentAccountTypeManager getThis() throws PersistenceException {
        return ((PersistentAccountTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountTypeManager(this);
    }
    
    
    public void createAccountType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).createAccountType(name, type, unitType, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccountType(final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).createAccountType(name, type, unitType);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountTypeManager)this.getTheObject()).initializeOnCreation();
    }

    
}
