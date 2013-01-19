
package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ConversionManagerProxi;
import persistence.ConversionManager_ConversionsProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentConversionManager;
import persistence.PersistentCreateConversionCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnit;
import persistence.TDObserver;


/* Additional import section end */

public class ConversionManager extends PersistentObject implements PersistentConversionManager{
    
    private static PersistentConversionManager theConversionManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentConversionManager getTheConversionManager() throws PersistenceException{
        if (theConversionManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        ConversionManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade.getTheConversionManager();
                            theConversionManager = proxi;
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
                PersistentConversionManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theConversionManager;
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
        return theConversionManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("conversions", this.getConversions().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ConversionManager provideCopy() throws PersistenceException{
        ConversionManager result = this;
        result = new ConversionManager(this.This, 
                                       this.getId());
        result.conversions = this.conversions.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ConversionManager_ConversionsProxi conversions;
    protected PersistentConversionManager This;
    
    public ConversionManager(PersistentConversionManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.conversions = new ConversionManager_ConversionsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 147;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ConversionManager_ConversionsProxi getConversions() throws PersistenceException {
        return this.conversions;
    }
    protected void setThis(PersistentConversionManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentConversionManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentConversionManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversionManager result = new ConversionManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentConversionManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversionManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversionManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversionManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversionManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getConversions().getLength());
    }
    
    
    public void createConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws PersistenceException{
        //TODO: implement method: createConversion
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentConversionManager)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void createConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateConversionCommand command = model.meta.CreateConversionCommand.createCreateConversionCommand(factor, constant, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
