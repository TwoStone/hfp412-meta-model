
package model;

import persistence.*;


/* Additional import section end */

public class ActorManager extends PersistentObject implements PersistentActorManager{
    
    private static PersistentActorManager theActorManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentActorManager getTheActorManager() throws PersistenceException{
        if (theActorManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        ActorManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theActorManagerFacade.getTheActorManager();
                            theActorManager = proxi;
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
                PersistentActorManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theActorManager;
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
        return theActorManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("actors", this.getActors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            result.put("nextOrderId", new Long(this.getNextOrderId()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ActorManager provideCopy() throws PersistenceException{
        ActorManager result = this;
        result = new ActorManager(this.nextOrderId, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ActorManager_ActorsProxi actors;
    protected long nextOrderId;
    protected PersistentActorManager This;
    
    public ActorManager(long nextOrderId,PersistentActorManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.actors = new ActorManager_ActorsProxi(this);
        this.nextOrderId = nextOrderId;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ActorManager_ActorsProxi getActors() throws PersistenceException {
        return this.actors;
    }
    public long getNextOrderId() throws PersistenceException {
        return this.nextOrderId;
    }
    public void setNextOrderId(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theActorManagerFacade.nextOrderIdSet(this.getId(), newValue);
        this.nextOrderId = newValue;
    }
    protected void setThis(PersistentActorManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentActorManager)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theActorManagerFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentActorManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentActorManager result = new ActorManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentActorManager)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActorManager(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActorManager(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActorManager(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActorManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getActors().getLength());
    }
    
    
    public void addPosition(final PersistentOrder order, final PersistentProduct product, final long quanitity, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddPositionCommand command = model.meta.AddPositionCommand.createAddPositionCommand(quanitity, now, now);
		command.setOrder(order);
		command.setProduct(product);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void addPosition(final PersistentOrder order, final PersistentProduct product, final long quanitity) 
				throws PersistenceException{
		order.addPosition(product, quanitity);
	}
    public void createOrder(final PersistentCustomer customer, final PersistentSupplier supplier, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateOrderCommand command = model.meta.CreateOrderCommand.createCreateOrderCommand(now, now);
		command.setCustomer(customer);
		command.setSupplier(supplier);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void addRole(final PersistentActor actor, final String roleName, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddRoleCommand command = model.meta.AddRoleCommand.createAddRoleCommand(roleName, now, now);
		command.setActor(actor);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeName(final PersistentActor actor, final String name) 
				throws model.DoubleDefinition, PersistenceException{
		ActorSearchList actorsWithName = Actor.getActorByName(name);
		if (actorsWithName.iterator().hasNext()) {
			throw new DoubleDefinition("Name kann nicht ge�ndert werden es existiert bereits eine Person mit dem Namen " + name);
		}
		actor.changeName(name);
	}
    public void changeName(final PersistentActor actor, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeNameCommand command = model.meta.ChangeNameCommand.createChangeNameCommand(name, now, now);
		command.setActor(actor);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createActor(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateActorCommand command = model.meta.CreateActorCommand.createCreateActorCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createProduct(final PersistentSupplier manufacturer, final String name) 
				throws model.DoubleDefinition, PersistenceException{
		manufacturer.createProduct(name);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void createActor(final String name) 
				throws model.DoubleDefinition, PersistenceException{
		ActorSearchList actorSearchList = Actor.getActorByName(name);
		if (actorSearchList.iterator().hasNext()) {
			throw new DoubleDefinition("Es existiert bereits eine Person mit dem Namen " + name);
		}
		this.getThis().getActors().add(Actor.createActor(name));
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentActorManager)This);
		if(this.equals(This)){
		}
    }
    public void createProduct(final PersistentSupplier manufacturer, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateProductCommand command = model.meta.CreateProductCommand.createCreateProductCommand(name, now, now);
		command.setManufacturer(manufacturer);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createOrder(final PersistentCustomer customer, final PersistentSupplier supplier) 
				throws PersistenceException{
		customer.createOrder(supplier, this.getThis().getNextOrderId());
		this.getThis().setNextOrderId(this.getThis().getNextOrderId() + 1);
	}
    public void addRole(final PersistentActor actor, final String roleName) 
				throws PersistenceException{
		actor.addRole(roleName);
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}