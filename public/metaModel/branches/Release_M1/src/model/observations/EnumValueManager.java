package model.observations;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.EnumValueManagerProxi;
import persistence.EnumValueManager_EnumValuesProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCreateEnumValueCommand;
import persistence.PersistentDeleteEnumValueCommand;
import persistence.PersistentEnumValueManager;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class EnumValueManager extends PersistentObject implements PersistentEnumValueManager{
    
    private static PersistentEnumValueManager theEnumValueManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentEnumValueManager getTheEnumValueManager() throws PersistenceException{
        if (theEnumValueManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        EnumValueManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theEnumValueManagerFacade.getTheEnumValueManager();
                            theEnumValueManager = proxi;
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
                PersistentEnumValueManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theEnumValueManager;
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
        return theEnumValueManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("enumValues", this.getEnumValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public EnumValueManager provideCopy() throws PersistenceException{
        EnumValueManager result = this;
        result = new EnumValueManager(this.This, 
                                      this.getId());
        result.enumValues = this.enumValues.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected EnumValueManager_EnumValuesProxi enumValues;
    protected PersistentEnumValueManager This;
    
    public EnumValueManager(PersistentEnumValueManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.enumValues = new EnumValueManager_EnumValuesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 360;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public EnumValueManager_EnumValuesProxi getEnumValues() throws PersistenceException {
        return this.enumValues;
    }
    protected void setThis(PersistentEnumValueManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEnumValueManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEnumValueManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentEnumValueManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEnumValueManager result = new EnumValueManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentEnumValueManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEnumValueManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEnumValueManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEnumValueManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEnumValueManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEnumValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createEnumValue(final String name, final PersistentMEnum type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateEnumValueCommand command = model.meta.CreateEnumValueCommand.createCreateEnumValueCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void deleteEnumValue(final PersistentMEnumValue enumValue, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteEnumValueCommand command = model.meta.DeleteEnumValueCommand.createDeleteEnumValueCommand(now, now);
		command.setEnumValue(enumValue);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEnumValueManager)This);
		if(this.equals(This)){
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentMEnumValue createEnumValue(final String name, final PersistentMEnum type) 
				throws model.DoubleDefinitionException, PersistenceException{
		final PersistentMEnumValue enumVal = type.inverseGetTheType().findFirst(new Predcate<PersistentMEnumValue>() {

			@Override
			public boolean test(final PersistentMEnumValue argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		});

		if (enumVal == null) {
			final PersistentMEnumValue ret = MEnumValue.createMEnumValue(name, type);
			getThis().getEnumValues().add(ret);
			return ret;
		} else {
			throw new model.DoubleDefinitionException("An enum value with name " + name + " already exists for enumeration.");
		}

	}
    public void deleteEnumValue(final PersistentMEnumValue enumValue) 
				throws model.ConsistencyException, PersistenceException{
		if (enumValue.fetchDependentItems().getLength() == 0) {
			getThis().getEnumValues().removeFirstSuccess(new Predcate<PersistentMEnumValue>() {

				@Override
				public boolean test(final PersistentMEnumValue argument) throws PersistenceException {
					return argument.equals(enumValue);
				}
			});

			enumValue.delete();
		} else {
			throw new model.ConsistencyException("Deletion not possible. There are observations connected with the enum value!");
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
