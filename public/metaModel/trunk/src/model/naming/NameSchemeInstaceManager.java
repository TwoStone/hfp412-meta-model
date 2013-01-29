package model.naming;

import model.PatternNotMatchException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;

/* Additional import section end */

public class NameSchemeInstaceManager extends PersistentObject implements PersistentNameSchemeInstaceManager{
    
    private static PersistentNameSchemeInstaceManager theNameSchemeInstaceManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentNameSchemeInstaceManager getTheNameSchemeInstaceManager() throws PersistenceException{
        if (theNameSchemeInstaceManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        NameSchemeInstaceManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theNameSchemeInstaceManagerFacade.getTheNameSchemeInstaceManager();
                            theNameSchemeInstaceManager = proxi;
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
                PersistentNameSchemeInstaceManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theNameSchemeInstaceManager;
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
        return theNameSchemeInstaceManager;
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
    
    public NameSchemeInstaceManager provideCopy() throws PersistenceException{
        NameSchemeInstaceManager result = this;
        result = new NameSchemeInstaceManager(this.This, 
                                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentNameSchemeInstaceManager This;
    
    public NameSchemeInstaceManager(PersistentNameSchemeInstaceManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 250;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    protected void setThis(PersistentNameSchemeInstaceManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentNameSchemeInstaceManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theNameSchemeInstaceManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentNameSchemeInstaceManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNameSchemeInstaceManager result = new NameSchemeInstaceManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNameSchemeInstaceManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNameSchemeInstaceManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNameSchemeInstaceManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNameSchemeInstaceManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNameSchemeInstaceManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void createInstance(final String name, final PersistentNameScheme scheme, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateInstanceCommand command = model.meta.CreateInstanceCommand.createCreateInstanceCommand(name, now, now);
		command.setScheme(scheme);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNameSchemeInstaceManager)This);
		if(this.equals(This)){
		}
    }
    public PersistentNameSchemeInstance createInstance(final String name, final PersistentNameScheme scheme) 
				throws model.PatternNotMatchException, PersistenceException{

		if (!scheme.match(name).toBoolean()) {
			throw new PatternNotMatchException(String.format(
					"Der eingeben Name (%s) passt nicht zum benötigen Muster (%s)!", name, scheme.getRegExpPattern()));
		}
		PersistentNameSchemeInstance first = scheme.getNames().findFirst(new Predcate<PersistentNameSchemeInstance>() {

			@Override
			public boolean test(PersistentNameSchemeInstance argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		});

		if (first != null) {
			return first;
		}

		return NameSchemeInstance.createNameSchemeInstance(name, scheme);
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
				throws model.PatternNotMatchException, PersistenceException{
		PersistentNameSchemeInstance nameSchemeInstance = createInstance(value, name.getNameScheme());
		NameInstance.createNameInstance(name, object, nameSchemeInstance);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
