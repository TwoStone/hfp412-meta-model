package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AccountTypeManagerProxi;
import persistence.AccountTypeManager_AccountTypesProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentCreateAccountTypeCommand;
import persistence.PersistentDeleteAccountTypeCommand;
import persistence.PersistentMAccountType;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnitType;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class AccountTypeManager extends PersistentObject implements PersistentAccountTypeManager{
    
    private static PersistentAccountTypeManager theAccountTypeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAccountTypeManager getTheAccountTypeManager() throws PersistenceException{
        if (theAccountTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AccountTypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade.getTheAccountTypeManager();
                            theAccountTypeManager = proxi;
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
                PersistentAccountTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAccountTypeManager;
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
        return theAccountTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("accountTypes", this.getAccountTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountTypeManager provideCopy() throws PersistenceException{
        AccountTypeManager result = this;
        result = new AccountTypeManager(this.This, 
                                        this.getId());
        result.accountTypes = this.accountTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AccountTypeManager_AccountTypesProxi accountTypes;
    protected PersistentAccountTypeManager This;
    
    public AccountTypeManager(PersistentAccountTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.accountTypes = new AccountTypeManager_AccountTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public AccountTypeManager_AccountTypesProxi getAccountTypes() throws PersistenceException {
        return this.accountTypes;
    }
    protected void setThis(PersistentAccountTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountTypeManager result = new AccountTypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountTypeManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getAccountTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createAccountType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAccountTypeCommand command = model.meta.CreateAccountTypeCommand.createCreateAccountTypeCommand(name, now, now);
		command.setType(type);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void deleteAccountType(final PersistentMAccountType accountType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteAccountTypeCommand command = model.meta.DeleteAccountTypeCommand.createDeleteAccountTypeCommand(now, now);
		command.setAccountType(accountType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public PersistentMAccountType createAccountType(final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
		final PersistentMAccountType result = MAccountType.createMAccountType(type, unitType, name);
		this.getThis().getAccountTypes().add(result);
		return result;
	}
    public void deleteAccountType(final PersistentMAccountType accountType) 
				throws model.ConsistencyException, PersistenceException{
		this.getThis().getAccountTypes().removeFirstSuccess(new Predcate<PersistentMAccountType>() {

			@Override
			public boolean test(final PersistentMAccountType argument) throws PersistenceException {
				return accountType.equals(argument);
			}

		});
		accountType.delete();
	}
    public void initializeOnCreation() 
				throws PersistenceException{

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
