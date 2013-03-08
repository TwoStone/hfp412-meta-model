package model.observations;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.EnumerationManagerProxi;
import persistence.EnumerationManager_EnumTypesProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCreateEnumCommand;
import persistence.PersistentDeleteEnumCommand;
import persistence.PersistentEnumerationManager;
import persistence.PersistentMEnum;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class EnumerationManager extends PersistentObject implements PersistentEnumerationManager{
    
    private static PersistentEnumerationManager theEnumerationManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentEnumerationManager getTheEnumerationManager() throws PersistenceException{
        if (theEnumerationManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        EnumerationManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theEnumerationManagerFacade.getTheEnumerationManager();
                            theEnumerationManager = proxi;
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
                PersistentEnumerationManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theEnumerationManager;
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
        return theEnumerationManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("enumTypes", this.getEnumTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public EnumerationManager provideCopy() throws PersistenceException{
        EnumerationManager result = this;
        result = new EnumerationManager(this.This, 
                                        this.getId());
        result.enumTypes = this.enumTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected EnumerationManager_EnumTypesProxi enumTypes;
    protected PersistentEnumerationManager This;
    
    public EnumerationManager(PersistentEnumerationManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.enumTypes = new EnumerationManager_EnumTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 352;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public EnumerationManager_EnumTypesProxi getEnumTypes() throws PersistenceException {
        return this.enumTypes;
    }
    protected void setThis(PersistentEnumerationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEnumerationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEnumerationManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentEnumerationManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEnumerationManager result = new EnumerationManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentEnumerationManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEnumerationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEnumerationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEnumerationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEnumerationManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEnumTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createEnum(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateEnumCommand command = model.meta.CreateEnumCommand.createCreateEnumCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void deleteEnum(final PersistentMEnum type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteEnumCommand command = model.meta.DeleteEnumCommand.createDeleteEnumCommand(now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEnumerationManager)This);
		if(this.equals(This)){
		}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void createEnum(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
		if (MEnum.getMEnumByName(name).getLength() == 0) {
			getThis().getEnumTypes().add(MEnum.createMEnum(name));
		} else {
			throw new model.DoubleDefinitionException("An enum with name " + name + " already exists.");
		}
	}
    public void deleteEnum(final PersistentMEnum type) 
				throws model.ConsistencyException, PersistenceException{
		if (type.getDependentItems().getLength() == 0) {
			getThis().getEnumTypes().removeFirstSuccess(new Predcate<PersistentMEnum>() {

				@Override
				public boolean test(final PersistentMEnum argument) throws PersistenceException {
					return type.equals(argument);
				}
			});
		} else {
			throw new model.ConsistencyException(
					"Deletion not possible. There are enumeration values connected with the enum type!");
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
