package model.observations;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.ObsTypeManagerProxi;
import persistence.ObsTypeManager_ObservationTypesProxi;
import persistence.PersistenceException;
import persistence.PersistentCreateObsTypeCommand;
import persistence.PersistentDeleteObsTypeCommand;
import persistence.PersistentMEnum;
import persistence.PersistentMObservationType;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentObsTypeManager;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class ObsTypeManager extends PersistentObject implements PersistentObsTypeManager{
    
    private static PersistentObsTypeManager theObsTypeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentObsTypeManager getTheObsTypeManager() throws PersistenceException{
        if (theObsTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        ObsTypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theObsTypeManagerFacade.getTheObsTypeManager();
                            theObsTypeManager = proxi;
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
                PersistentObsTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theObsTypeManager;
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
        return theObsTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("observationTypes", this.getObservationTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ObsTypeManager provideCopy() throws PersistenceException{
        ObsTypeManager result = this;
        result = new ObsTypeManager(this.This, 
                                    this.getId());
        result.observationTypes = this.observationTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ObsTypeManager_ObservationTypesProxi observationTypes;
    protected PersistentObsTypeManager This;
    
    public ObsTypeManager(PersistentObsTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observationTypes = new ObsTypeManager_ObservationTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 361;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ObsTypeManager_ObservationTypesProxi getObservationTypes() throws PersistenceException {
        return this.observationTypes;
    }
    protected void setThis(PersistentObsTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentObsTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theObsTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentObsTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentObsTypeManager result = new ObsTypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentObsTypeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleObsTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleObsTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleObsTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleObsTypeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObservationTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createObsType(final String name, final PersistentMEnum enumType, final PersistentMType theType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateObsTypeCommand command = model.meta.CreateObsTypeCommand.createCreateObsTypeCommand(name, now, now);
		command.setEnumType(enumType);
		command.setTheType(theType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void deleteObsType(final PersistentMObservationType theType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteObsTypeCommand command = model.meta.DeleteObsTypeCommand.createDeleteObsTypeCommand(now, now);
		command.setTheType(theType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentObsTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void createObsType(final String name, final PersistentMEnum enumType, final PersistentMType theType) 
				throws model.DoubleDefinitionException, PersistenceException{
		if (MObservationType.getMObservationTypeByName(name).getLength() == 0) {
			getThis().getObservationTypes().add(MObservationType.createMObservationType(name, enumType, theType));
		} else {
			throw new model.DoubleDefinitionException("An observation type with name " + name + " already exists.");
		}
	}
    public void deleteObsType(final PersistentMObservationType theType) 
				throws model.ConsistencyException, PersistenceException{
		if (theType.fetchDependentItems().getLength() == 0) {
			getThis().getObservationTypes().removeFirstSuccess(new Predcate<PersistentMObservationType>() {

				@Override
				public boolean test(final PersistentMObservationType argument) throws PersistenceException {
					return theType.equals(argument);
				}
			});
			theType.delete();
		} else {
			throw new model.ConsistencyException("Cannot delete Observation Type because there are dependent observations");
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
