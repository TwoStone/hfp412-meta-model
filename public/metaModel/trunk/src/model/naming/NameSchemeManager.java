package model.naming;

import model.ConsistencyException;
import model.PatternNotMatchException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.NameSchemeManagerProxi;
import persistence.NameSchemeManager_NamesProxi;
import persistence.NameSchemeManager_SchemesProxi;
import persistence.PersistenceException;
import persistence.PersistentAssignNameCommand;
import persistence.PersistentAssignTypeCommand;
import persistence.PersistentCreateNameSchemeCommand;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMObject;
import persistence.PersistentName;
import persistence.PersistentNameInstance;
import persistence.PersistentNameScheme;
import persistence.PersistentNameSchemeInstance;
import persistence.PersistentNameSchemeManager;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.SearchListRoot;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class NameSchemeManager extends PersistentObject implements PersistentNameSchemeManager{
    
    private static PersistentNameSchemeManager theNameSchemeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentNameSchemeManager getTheNameSchemeManager() throws PersistenceException{
        if (theNameSchemeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        NameSchemeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theNameSchemeManagerFacade.getTheNameSchemeManager();
                            theNameSchemeManager = proxi;
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
                PersistentNameSchemeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theNameSchemeManager;
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
        return theNameSchemeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("schemes", this.getSchemes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("names", this.getNames().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public NameSchemeManager provideCopy() throws PersistenceException{
        NameSchemeManager result = this;
        result = new NameSchemeManager(this.This, 
                                       this.getId());
        result.schemes = this.schemes.copy(result);
        result.names = this.names.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected NameSchemeManager_SchemesProxi schemes;
    protected NameSchemeManager_NamesProxi names;
    protected PersistentNameSchemeManager This;
    
    public NameSchemeManager(PersistentNameSchemeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.schemes = new NameSchemeManager_SchemesProxi(this);
        this.names = new NameSchemeManager_NamesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 252;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public NameSchemeManager_SchemesProxi getSchemes() throws PersistenceException {
        return this.schemes;
    }
    public NameSchemeManager_NamesProxi getNames() throws PersistenceException {
        return this.names;
    }
    protected void setThis(PersistentNameSchemeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentNameSchemeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNameSchemeManager result = new NameSchemeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNameSchemeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNameSchemeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameSchemeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameSchemeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameSchemeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSchemes().getLength() > 0) return 1;
        if (this.getNames().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void assignName(final PersistentMObject object, final PersistentName name, final String value, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAssignNameCommand command = model.meta.AssignNameCommand.createAssignNameCommand(value, now, now);
		command.setObject(object);
		command.setName(name);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void assignType(final PersistentNameScheme scheme, final PersistentMAtomicType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAssignTypeCommand command = model.meta.AssignTypeCommand.createAssignTypeCommand(now, now);
		command.setScheme(scheme);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createNameScheme(final String name, final String regExpPattern, final PersistentMBoolean isIterable, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateNameSchemeCommand command = model.meta.CreateNameSchemeCommand.createCreateNameSchemeCommand(name, regExpPattern, now, now);
		command.setIsIterable(isIterable);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNameSchemeManager)This);
		if(this.equals(This)){
		}
    }
    public void assignName(final PersistentMObject object, final PersistentName name, final String value) 
				throws model.PatternNotMatchException, model.ConsistencyException, PersistenceException{
		checkTypeIsAssignable(object, name);
		checkNameSchemeIsNotPresent(object, name);
		checkNameIsValid(name, value);

		final PersistentNameSchemeInstance nameSchemeInstance = NameSchemeInstance.createNameSchemeInstance(value, name.getNameScheme());
		NameInstance.createNameInstance(name, object, nameSchemeInstance);
	}
    public PersistentName assignType(final PersistentNameScheme scheme, final PersistentMAtomicType type) 
				throws PersistenceException{
		final PersistentName name = Name.createName(type, scheme);
		this.getNames().add(name);

		return name;
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentNameScheme createNameScheme(final String name, final String regExpPattern, final PersistentMBoolean isIterable) 
				throws PersistenceException{
		final PersistentNameScheme nameScheme = NameScheme.createNameScheme(regExpPattern, name, isIterable);
		this.getThis().getSchemes().add(nameScheme);
		return nameScheme;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	private static void checkTypeIsAssignable(final PersistentMObject object, final PersistentName name) throws PersistenceException,
			ConsistencyException {
		final SearchListRoot<PersistentMAtomicType> fittingTypes = object.getTypes().findAll(new Predcate<PersistentMAtomicType>() {

			@Override
			public boolean test(final PersistentMAtomicType argument) throws PersistenceException {
				return argument.isLessOrEqual(name.getFromType()).toBoolean();
			}
		});

		if (!fittingTypes.iterator().hasNext()) {
			throw new model.ConsistencyException(ExceptionConstants.CE_OBJ_NOT_THIS_SCHEME);
		}
	}

	private static void checkNameSchemeIsNotPresent(final PersistentMObject object, final PersistentName name) throws PersistenceException,
			ConsistencyException {
		final PersistentNameInstance nameWithScheme = object.getNames().findFirst(new Predcate<PersistentNameInstance>() {

			@Override
			public boolean test(final PersistentNameInstance argument) throws PersistenceException {
				return argument.getType().equals(name);
			}
		});
		if (nameWithScheme != null) {
			throw new ConsistencyException(ExceptionConstants.CE_OBJ_NAME_WITH_SCHEME);
		}
	}

	private static void checkNameIsValid(final PersistentName name, final String value) throws PersistenceException, PatternNotMatchException {
		if (!name.getNameScheme().match(value).toBoolean()) {
			throw new PatternNotMatchException(ExceptionConstants.CE_NAME_NOT_VALID_FOR_SCHEME);
		}
	}

	/* End of protected part that is not overridden by persistence generator */
    
}
