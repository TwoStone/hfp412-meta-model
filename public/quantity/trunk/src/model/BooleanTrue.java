
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BooleanTrue extends model.BooleanValue implements PersistentBooleanTrue{
    
    private static PersistentBooleanTrue theBooleanTrue = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentBooleanTrue getTheBooleanTrue() throws PersistenceException{
        if (theBooleanTrue == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        BooleanTrueProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theBooleanTrueFacade.getTheBooleanTrue();
                            theBooleanTrue = proxi;
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
                PersistentBooleanTrue getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theBooleanTrue;
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
        return theBooleanTrue;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public BooleanTrue provideCopy() throws PersistenceException{
        BooleanTrue result = this;
        result = new BooleanTrue(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public BooleanTrue(PersistentBooleanValue This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentBooleanValue)This,id);        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentBooleanTrue getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBooleanTrue result = new BooleanTrueProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentBooleanTrue)this.This;
    }
    
    public void accept(BooleanValueVisitor visitor) throws PersistenceException {
        visitor.handleBooleanTrue(this);
    }
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanTrue(this);
    }
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanTrue(this);
    }
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanTrue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanTrue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanTrue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanTrue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanTrue(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
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
        this.setThis((PersistentBooleanTrue)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
