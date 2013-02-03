package model.quantity;

import model.DoubleDefinitionException;
import model.NotFoundException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FractionManagerProxi;
import persistence.FractionManager_ManagedFractionsProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;
import persistence.PersistentFractionManager;
import persistence.PersistentFractionWrapper;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class FractionManager extends PersistentObject implements PersistentFractionManager{
    
    private static PersistentFractionManager theFractionManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentFractionManager getTheFractionManager() throws PersistenceException{
        if (theFractionManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        FractionManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theFractionManagerFacade.getTheFractionManager();
                            theFractionManager = proxi;
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
                PersistentFractionManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theFractionManager;
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
        return theFractionManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("managedFractions", this.getManagedFractions().getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FractionManager provideCopy() throws PersistenceException{
        FractionManager result = this;
        result = new FractionManager(this.This, 
                                     this.getId());
        result.managedFractions = this.managedFractions.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected FractionManager_ManagedFractionsProxi managedFractions;
    protected PersistentFractionManager This;
    
    public FractionManager(PersistentFractionManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.managedFractions = new FractionManager_ManagedFractionsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 177;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public FractionManager_ManagedFractionsProxi getManagedFractions() throws PersistenceException {
        return this.managedFractions;
    }
    protected void setThis(PersistentFractionManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFractionManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFractionManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentFractionManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFractionManager result = new FractionManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFractionManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFractionManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFractionManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFractionManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFractionManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getManagedFractions().getValues().getLength());
    }
    
    
    public void addFraction(final String key, final common.Fraction newFraction) 
				throws model.DoubleDefinitionException, PersistenceException{
		common.Fraction preExisting;
		try {
			preExisting = getThis().getFraction(key);
			if (preExisting != null)
				throw new DoubleDefinitionException("Fraction object " + key + " is already exists");
		} catch (NotFoundException e) {
			PersistentFractionWrapper newFractionWrapper = FractionWrapper.createFractionWrapper();
			newFractionWrapper.setFraction(newFraction);
			getThis().getManagedFractions().put(key, newFractionWrapper);
		}

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFractionManager)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public common.Fraction getFraction(final String key) 
				throws model.NotFoundException, PersistenceException{
		common.Fraction result = null;
		result = getThis().getManagedFractions().get(key).getFraction();
		if (result == null)
			throw new NotFoundException(key + " wasn't found in hashmap");
		return result;

	}
    public void addFraction(final String key, final common.Fraction newFraction, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddFractionCommand command = model.meta.AddFractionCommand.createAddFractionCommand(key, newFraction, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
