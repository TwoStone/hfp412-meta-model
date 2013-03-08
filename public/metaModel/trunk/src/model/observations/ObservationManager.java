package model.observations;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.ObservationManagerProxi;
import persistence.ObservationManager_ObservationsProxi;
import persistence.PersistenceException;
import persistence.PersistentCreateObservationCommand;
import persistence.PersistentDeleteObservationCommand;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentObject;
import persistence.PersistentObservationManager;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class ObservationManager extends PersistentObject implements PersistentObservationManager{
    
    private static PersistentObservationManager theObservationManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentObservationManager getTheObservationManager() throws PersistenceException{
        if (theObservationManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        ObservationManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theObservationManagerFacade.getTheObservationManager();
                            theObservationManager = proxi;
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
                PersistentObservationManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theObservationManager;
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
        return theObservationManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("observations", this.getObservations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ObservationManager provideCopy() throws PersistenceException{
        ObservationManager result = this;
        result = new ObservationManager(this.This, 
                                        this.getId());
        result.observations = this.observations.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ObservationManager_ObservationsProxi observations;
    protected PersistentObservationManager This;
    
    public ObservationManager(PersistentObservationManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observations = new ObservationManager_ObservationsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 347;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ObservationManager_ObservationsProxi getObservations() throws PersistenceException {
        return this.observations;
    }
    protected void setThis(PersistentObservationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentObservationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theObservationManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentObservationManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentObservationManager result = new ObservationManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentObservationManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleObservationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleObservationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleObservationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleObservationManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObservations().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createObservation(final String name, final PersistentMObservationType theType, final PersistentMObject theObsObject, final PersistentMEnumValue enumValue, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateObservationCommand command = model.meta.CreateObservationCommand.createCreateObservationCommand(name, now, now);
		command.setTheType(theType);
		command.setTheObsObject(theObsObject);
		command.setEnumValue(enumValue);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void deleteObservation(final PersistentMObservation observation, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteObservationCommand command = model.meta.DeleteObservationCommand.createDeleteObservationCommand(now, now);
		command.setObservation(observation);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentObservationManager)This);
		if(this.equals(This)){
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void createObservation(final String name, final PersistentMObservationType theType, final PersistentMObject theObsObject, final PersistentMEnumValue enumValue) 
				throws PersistenceException{
		MObservation.createMObservation(name, theType, enumValue, theObsObject);
	}
    public void deleteObservation(final PersistentMObservation observation) 
				throws model.ConsistencyException, PersistenceException{
		if (observation.getDependentItems().getLength() == 0) {
			getThis().getObservations().removeFirstSuccess(new Predcate<PersistentMObservation>() {

				@Override
				public boolean test(final PersistentMObservation argument) throws PersistenceException {
					return observation.equals(argument);
				}
			});
		} else {
			throw new model.ConsistencyException("Cannot delete observation because there are dependent items.");
		}

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
