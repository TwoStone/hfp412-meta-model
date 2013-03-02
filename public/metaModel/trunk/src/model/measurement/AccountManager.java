package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AccountManagerProxi;
import persistence.AccountManager_AccountsProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAccountManager;
import persistence.PersistentCreateAccountCommand;
import persistence.PersistentMAccountType;
import persistence.PersistentMObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class AccountManager extends PersistentObject implements PersistentAccountManager{
    
    private static PersistentAccountManager theAccountManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAccountManager getTheAccountManager() throws PersistenceException{
        if (theAccountManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AccountManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getTheAccountManager();
                            theAccountManager = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.Hashtable<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentAccountManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAccountManager;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theAccountManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("accounts", this.getAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountManager provideCopy() throws PersistenceException{
        AccountManager result = this;
        result = new AccountManager(this.This, 
                                    this.getId());
        result.accounts = this.accounts.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AccountManager_AccountsProxi accounts;
    protected PersistentAccountManager This;
    
    public AccountManager(PersistentAccountManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.accounts = new AccountManager_AccountsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 143;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public AccountManager_AccountsProxi getAccounts() throws PersistenceException {
        return this.accounts;
    }
    protected void setThis(PersistentAccountManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountManager result = new AccountManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getAccounts().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{

	}
    public void createAccount(final String name, final PersistentMAccountType type, final PersistentMObject object, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAccountCommand command = model.meta.CreateAccountCommand.createCreateAccountCommand(name, now, now);
		command.setType(type);
		command.setObject(object);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountManager)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{

	}
    public void createAccount(final String name, final PersistentMAccountType type, final PersistentMObject object) 
				throws PersistenceException{
		this.getThis().getAccounts().add(Account.createAccount(object, type));
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    

	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
