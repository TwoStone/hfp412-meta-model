
package model;

import persistence.*;


/* Additional import section end */

public class AkteurManager extends PersistentObject implements PersistentAkteurManager{
    
    private static PersistentAkteurManager theAkteurManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAkteurManager getTheAkteurManager() throws PersistenceException{
        if (theAkteurManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AkteurManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade.getTheAkteurManager();
                            theAkteurManager = proxi;
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
                PersistentAkteurManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAkteurManager;
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
        return theAkteurManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("akteure", this.getAkteure().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AkteurManager provideCopy() throws PersistenceException{
        AkteurManager result = this;
        result = new AkteurManager(this.This, 
                                   this.getId());
        result.akteure = this.akteure.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AkteurManager_AkteureProxi akteure;
    protected PersistentAkteurManager This;
    
    public AkteurManager(PersistentAkteurManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.akteure = new AkteurManager_AkteureProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AkteurManager_AkteureProxi getAkteure() throws PersistenceException {
        return this.akteure;
    }
    protected void setThis(PersistentAkteurManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAkteurManager)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentAkteurManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAkteurManager result = new AkteurManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAkteurManager)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAkteurManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAkteurManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAkteurManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAkteurManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getAkteure().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddRoleCommand command = model.meta.AddRoleCommand.createAddRoleCommand(rollenName, now, now);
		command.setAkteur(akteur);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createAkteur(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAkteurCommand command = model.meta.CreateAkteurCommand.createCreateAkteurCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAkteurManager)This);
		if(this.equals(This)){
		}
    }
    public void createAkteur(final String name) 
				throws model.DoubleDefinition, PersistenceException{
        AkteurSearchList old = Akteur.getAkteurByName(name);
        if (old.iterator().hasNext()) throw new DoubleDefinition();
        getThis().getAkteure().add(Akteur.createAkteur(name));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void addRole(final PersistentAkteur akteur, final String rollenName) 
				throws PersistenceException{
        akteur.addRole(rollenName);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
