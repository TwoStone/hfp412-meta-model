
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbsUnitSearchList;
import persistence.AbsUnitTypeSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddDefaultUnitCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.TDObserver;
import persistence.UnitTypeManagerProxi;
import persistence.UnitTypeManager_UnitTypesProxi;
import persistence.UnitTypeManager_UnitsProxi;
import constants.ExceptionConstants;


/* Additional import section end */

public class UnitTypeManager extends PersistentObject implements PersistentUnitTypeManager{
    
    private static PersistentUnitTypeManager theUnitTypeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentUnitTypeManager getTheUnitTypeManager() throws PersistenceException{
        if (theUnitTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        UnitTypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.getTheUnitTypeManager();
                            theUnitTypeManager = proxi;
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
                PersistentUnitTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theUnitTypeManager;
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
        return theUnitTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("unitTypes", this.getUnitTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("units", this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public UnitTypeManager provideCopy() throws PersistenceException{
        UnitTypeManager result = this;
        result = new UnitTypeManager(this.This, 
                                     this.getId());
        result.unitTypes = this.unitTypes.copy(result);
        result.units = this.units.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected UnitTypeManager_UnitTypesProxi unitTypes;
    protected UnitTypeManager_UnitsProxi units;
    protected PersistentUnitTypeManager This;
    
    public UnitTypeManager(PersistentUnitTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.unitTypes = new UnitTypeManager_UnitTypesProxi(this);
        this.units = new UnitTypeManager_UnitsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 143;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public UnitTypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException {
        return this.unitTypes;
    }
    public UnitTypeManager_UnitsProxi getUnits() throws PersistenceException {
        return this.units;
    }
    protected void setThis(PersistentUnitTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentUnitTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentUnitTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitTypeManager result = new UnitTypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnitTypeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitTypeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getUnitTypes().getLength()
            + this.getUnits().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void createUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateUnitTypeCommand command = model.meta.CreateUnitTypeCommand.createCreateUnitTypeCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void createUnit(final PersistentUnitType type, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateUnitCommand command = model.meta.CreateUnitCommand.createCreateUnitCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createUnit(final PersistentUnitType type, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
    	AbsUnitSearchList old = Unit.getAbsUnitByName(name);
        if(old.iterator().hasNext()){
        	throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
        }
        getThis().getUnits().add(Unit.createUnit(type, name));
        
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddDefaultUnitCommand command = model.meta.AddDefaultUnitCommand.createAddDefaultUnitCommand(now, now);
		command.setType(type);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit) 
				throws PersistenceException{
    	//TODO Was passiert, wenn es schon eine Default-Unit gibt?
        type.setDefaultUnit(unit);
        
    }
    public void createUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
    	AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
    	if(old.iterator().hasNext()){
    		throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
    	}
    	this.getThis().getUnitTypes().add(UnitType.createUnitType(name));
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
