
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class QuantityManager extends PersistentObject implements PersistentQuantityManager{
    
    private static PersistentQuantityManager theQuantityManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentQuantityManager getTheQuantityManager() throws PersistenceException{
        if (theQuantityManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        QuantityManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.getTheQuantityManager();
                            theQuantityManager = proxi;
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
                PersistentQuantityManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theQuantityManager;
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
        return theQuantityManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("quantities", this.getQuantities().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public QuantityManager provideCopy() throws PersistenceException{
        QuantityManager result = this;
        result = new QuantityManager(this.This, 
                                     this.getId());
        result.quantities = this.quantities.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected QuantityManager_QuantitiesProxi quantities;
    protected PersistentQuantityManager This;
    
    public QuantityManager(PersistentQuantityManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.quantities = new QuantityManager_QuantitiesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 109;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public QuantityManager_QuantitiesProxi getQuantities() throws PersistenceException {
        return this.quantities;
    }
    protected void setThis(PersistentQuantityManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentQuantityManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentQuantityManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQuantityManager result = new QuantityManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentQuantityManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getQuantities().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void createQuantity(final PersistentUnit unit, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateQuantityCommand command = model.meta.CreateQuantityCommand.createCreateQuantityCommand(amount, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQuantityManager)This);
		if(this.equals(This)){
		}
    }
    public void createQuantity(final PersistentUnit unit, final common.Fraction amount) 
				throws PersistenceException{
        //TODO: implement method: createQuantity
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
