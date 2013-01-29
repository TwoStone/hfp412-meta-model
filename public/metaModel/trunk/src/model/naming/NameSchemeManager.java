package model.naming;

import model.PatternNotMatchException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;

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
            result.put("schemes", this.getSchemes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("names", this.getNames().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
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
        return (int) (0 
            + this.getSchemes().getLength()
            + this.getNames().getLength());
    }
    
    
    public void createNameScheme(final String name, final String regExpPattern, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateNameSchemeCommand command = model.meta.CreateNameSchemeCommand.createCreateNameSchemeCommand(name, regExpPattern, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentNameScheme createNameScheme(final String name, final String regExpPattern) 
				throws PersistenceException{
		PersistentNameScheme nameScheme = NameScheme.createNameScheme(regExpPattern, name);
		this.getThis().getSchemes().add(nameScheme);
		return nameScheme;
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNameSchemeManager)This);
		if(this.equals(This)){
		}
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
    public void assignName(final PersistentMObject object, final PersistentName name, final String value) 
				throws model.PatternNotMatchException, model.ConsistencyException, PersistenceException{
		PersistentName nameForObject = object.getPossibleNames().findFirst(new Predcate<PersistentName>() {

			@Override
			public boolean test(PersistentName argument) throws PersistenceException {
				return argument.equals(name);
			}
		});
		if (nameForObject == null) {
			throw new model.ConsistencyException("Das Objekt kann nicht in diesem Schema benannt werden!");
		}

		if (!name.getNameScheme().match(value).toBoolean()) {
			throw new PatternNotMatchException("Der angegebene Name entspricht nicht dem Schema!");
		}

		PersistentNameSchemeInstance nameSchemeInstance = NameSchemeInstance.createNameSchemeInstance(value,
				name.getNameScheme());
		NameInstance.createNameInstance(name, object, nameSchemeInstance);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
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
    public PersistentName assignType(final PersistentNameScheme scheme, final PersistentMAtomicType type) 
				throws PersistenceException{
		PersistentName name = Name.createName(type, scheme);
		this.getNames().add(name);

		return name;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
