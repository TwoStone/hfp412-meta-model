
package model.basic;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MBooleanExceptionVisitor;
import model.visitor.MBooleanReturnExceptionVisitor;
import model.visitor.MBooleanReturnVisitor;
import model.visitor.MBooleanVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MFalseProxi;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.TDObserver;


/* Additional import section end */

public class MFalse extends model.basic.MBoolean implements PersistentMFalse{
    
    private static PersistentMFalse theMFalse = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMFalse getTheMFalse() throws PersistenceException{
        if (theMFalse == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MFalseProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMFalseFacade.getTheMFalse();
                            theMFalse = proxi;
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
                PersistentMFalse getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMFalse;
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
        return theMFalse;
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
    
    public MFalse provideCopy() throws PersistenceException{
        MFalse result = this;
        result = new MFalse(this.This, 
                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public MFalse(PersistentMBoolean This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMBoolean)This,id);        
    }
    
    static public long getTypeId() {
        return 185;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentMFalse getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMFalse result = new MFalseProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMFalse)this.This;
    }
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException {
        visitor.handleMFalse(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFalse(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFalse(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFalse(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMFalse(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFalse(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFalse(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFalse(this);
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
        this.setThis((PersistentMFalse)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public boolean toBoolean() 
				throws PersistenceException{
		return false;
	}
    public PersistentMBoolean invert() 
				throws PersistenceException{
		return MTrue.getTheMTrue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
