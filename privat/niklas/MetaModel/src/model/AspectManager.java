
package model;

import persistence.*;


/* Additional import section end */

public class AspectManager extends PersistentObject implements PersistentAspectManager{
    
    private static PersistentAspectManager theAspectManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAspectManager getTheAspectManager() throws PersistenceException{
        if (theAspectManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AspectManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.getTheAspectManager();
                            theAspectManager = proxi;
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
                PersistentAspectManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAspectManager;
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
        return theAspectManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("aspects", this.getAspects().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AspectManager provideCopy() throws PersistenceException{
        AspectManager result = this;
        result = new AspectManager(this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AspectManager_AspectsProxi aspects;
    protected PersistentAspectManager This;
    
    public AspectManager(PersistentAspectManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.aspects = new AspectManager_AspectsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 131;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AspectManager_AspectsProxi getAspects() throws PersistenceException {
        return this.aspects;
    }
    protected void setThis(PersistentAspectManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAspectManager)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentAspectManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAspectManager result = new AspectManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAspectManager)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAspectManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAspectManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAspectManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAspectManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getAspects().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void createAspect(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        //TODO: implement method: createAspect
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAspectManager)This);
		if(this.equals(This)){
		}
    }
    public void createAspect(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAspectCommand command = model.meta.CreateAspectCommand.createCreateAspectCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}