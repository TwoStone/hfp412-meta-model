package persistence;

import model.*;

public class TransactionManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentTransactionManager{
    
    public TransactionManagerICProxi(long objectId) {
        super(objectId);
    }
    public TransactionManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransactionManagerFacade
            .getTransactionManager(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public TransactionManager_AkteureProxi getAkteure() throws PersistenceException {
        return ((PersistentTransactionManager)this.getTheObject()).getAkteure();
    }
    public PersistentTransactionManager getThis() throws PersistenceException {
        return ((PersistentTransactionManager)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransactionManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransactionManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransactionManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransactionManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).addRole(akteur, rollenName, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAkteur(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).createAkteur(name, invoker);
    }
    public void createAkteur(final String name) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).createAkteur(name);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).initializeOnCreation();
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName) 
				throws PersistenceException{
        ((PersistentTransactionManager)this.getTheObject()).addRole(akteur, rollenName);
    }

    
}
