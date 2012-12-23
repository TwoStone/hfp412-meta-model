
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MBoolean extends PersistentObject implements PersistentMBoolean{
    
    private static PersistentMBoolean theMBoolean = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMBoolean getTheMBoolean() throws PersistenceException{
        if (theMBoolean == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MBooleanProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMBooleanFacade.getTheMBoolean();
                            theMBoolean = proxi;
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
                PersistentMBoolean getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMBoolean;
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
        return theMBoolean;
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
    
    public MBoolean provideCopy() throws PersistenceException{
        MBoolean result = this;
        result = new MBoolean(this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMBoolean This;
    
    public MBoolean(PersistentMBoolean This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 137;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    protected void setThis(PersistentMBoolean newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMBooleanFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMBoolean getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMBoolean result = new MBooleanProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMBoolean)this.This;
    }
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMBoolean(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMBoolean(this);
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
        this.setThis((PersistentMBoolean)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public PersistentMBoolean createFromBoolean(final boolean bool) 
				throws PersistenceException{
    	return bool ? MTrue.getTheMTrue() : MFalse.getTheMFalse();
    }
    public boolean toBoolean() 
				throws PersistenceException{
        //TODO: implement method: toBoolean
        try{
            throw new java.lang.UnsupportedOperationException("Method \"toBoolean\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }

    /* Start of protected part that is not overridden by persistence generator */
    public static PersistentMBoolean create(final boolean bool) 
				throws PersistenceException{
    	return bool ? MTrue.getTheMTrue() : MFalse.getTheMFalse();
    }
    /* End of protected part that is not overridden by persistence generator */
    
}
