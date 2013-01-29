
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class MeasurementTypeManager extends PersistentObject implements PersistentMeasurementTypeManager{
    
    private static PersistentMeasurementTypeManager theMeasurementTypeManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMeasurementTypeManager getTheMeasurementTypeManager() throws PersistenceException{
        if (theMeasurementTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MeasurementTypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.getTheMeasurementTypeManager();
                            theMeasurementTypeManager = proxi;
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
                PersistentMeasurementTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMeasurementTypeManager;
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
        return theMeasurementTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("measurementTypes", this.getMeasurementTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MeasurementTypeManager provideCopy() throws PersistenceException{
        MeasurementTypeManager result = this;
        result = new MeasurementTypeManager(this.This, 
                                            this.getId());
        result.measurementTypes = this.measurementTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MeasurementTypeManager_MeasurementTypesProxi measurementTypes;
    protected PersistentMeasurementTypeManager This;
    
    public MeasurementTypeManager(PersistentMeasurementTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.measurementTypes = new MeasurementTypeManager_MeasurementTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 184;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public MeasurementTypeManager_MeasurementTypesProxi getMeasurementTypes() throws PersistenceException {
        return this.measurementTypes;
    }
    protected void setThis(PersistentMeasurementTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMeasurementTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMeasurementTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMeasurementTypeManager result = new MeasurementTypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMeasurementTypeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMeasurementTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMeasurementTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMeasurementTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMeasurementTypeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getMeasurementTypes().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateMeasurementTypeCommand command = model.meta.CreateMeasurementTypeCommand.createCreateMeasurementTypeCommand(name, now, now);
		command.setType(type);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMeasurementTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        this.getThis().getMeasurementTypes().add(MMeasurementType.createMMeasurementType(type, unitType));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
