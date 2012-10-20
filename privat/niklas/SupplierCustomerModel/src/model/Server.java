
package model;

import persistence.*;


/* Additional import section end */

public class Server extends PersistentObject implements PersistentServer{

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentServer getById(final long objectId) throws PersistenceException{
		long classId = ConnectionHandler.getTheConnectionHandler().theServerFacade.getClass(objectId);
		return (PersistentServer)PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentServer createServer(final String password,final String user,final long hackCount,final java.sql.Timestamp hackDelay) throws PersistenceException {
		if (password == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		if (user == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		PersistentServer result = ConnectionHandler.getTheConnectionHandler().theServerFacade
				.newServer(password,user,hackCount,hackDelay);
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		final$$Fields.put("password", password);
		final$$Fields.put("user", user);
		final$$Fields.put("hackCount", hackCount);
		final$$Fields.put("hackDelay", hackDelay);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentServer createServer(final String password,final String user,final long hackCount,final java.sql.Timestamp hackDelay,final PersistentServer This) throws PersistenceException {
		if (password == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		if (user == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		PersistentServer result = ConnectionHandler.getTheConnectionHandler().theServerFacade
				.newServer(password,user,hackCount,hackDelay);
		java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
		final$$Fields.put("password", password);
		final$$Fields.put("user", user);
		final$$Fields.put("hackCount", hackCount);
		final$$Fields.put("hackDelay", hackDelay);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String,Object> toHashtable(final java.util.Hashtable<String,Object> allResults, final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String,Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			AbstractPersistentRoot actors = this.getActors();
			if (actors != null) {
				result.put("actors", actors.createProxiInformation());
				if(depth > 1) {
					actors.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
				}else{
					if(forGUI && actors.hasEssentialFields()) {
						actors.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
					}
				}
			}
			result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
			result.put("user", this.getUser());
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey)) {
				allResults.put(uniqueKey, result);
			}
		}
		return result;
	}

	public static ServerSearchList getServerByUser(final String index) throws PersistenceException{
		return ConnectionHandler.getTheConnectionHandler().theServerFacade
				.getServerByUser(index);
	}

	@Override
	public Server provideCopy() throws PersistenceException{
		Server result = this;
		result = new Server(this.This,
				this.password,
				this.user,
				this.hackCount,
				this.hackDelay,
				this.getId());
		result.errors = this.errors.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException{
		return false;
	}
	protected PersistenceException exception = null;
	protected model.UserException userException = null;
	protected boolean changed = false;

	protected PersistentServer This;
	protected Server_ErrorsProxi errors;
	protected String password;
	protected String user;
	protected long hackCount;
	protected java.sql.Timestamp hackDelay;

	public Server(final PersistentServer This,final String password,final String user,final long hackCount,final java.sql.Timestamp hackDelay,final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
				if (This != null && !(this.equals(This))) {
					this.This = This;
				}
				this.errors = new Server_ErrorsProxi(this);
				this.password = password;
				this.user = user;
				this.hackCount = hackCount;
				this.hackDelay = hackDelay;
	}

	static public long getTypeId() {
		return -109;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	protected void setThis(final PersistentServer newValue) throws PersistenceException {
		if (newValue == null) {
			throw new PersistenceException("Null values not allowed!", 0);
		}
		if (newValue.equals(this)){
			this.This = null;
			return;
		}
		if(newValue.equals(this.This)) {
			return;
		}
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.This = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
		ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), newValue);
	}
	@Override
	public Server_ErrorsProxi getErrors() throws PersistenceException {
		return this.errors;
	}
	@Override
	public String getPassword() throws PersistenceException {
		return this.password;
	}
	@Override
	public void setPassword(final String newValue) throws PersistenceException {
		if (newValue == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		ConnectionHandler.getTheConnectionHandler().theServerFacade.passwordSet(this.getId(), newValue);
		this.password = newValue;
	}
	@Override
	public String getUser() throws PersistenceException {
		return this.user;
	}
	@Override
	public void setUser(final String newValue) throws PersistenceException {
		if (newValue == null) {
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		}
		ConnectionHandler.getTheConnectionHandler().theServerFacade.userSet(this.getId(), newValue);
		this.user = newValue;
	}
	@Override
	public long getHackCount() throws PersistenceException {
		return this.hackCount;
	}
	@Override
	public void setHackCount(final long newValue) throws PersistenceException {
		ConnectionHandler.getTheConnectionHandler().theServerFacade.hackCountSet(this.getId(), newValue);
		this.hackCount = newValue;
	}
	@Override
	public java.sql.Timestamp getHackDelay() throws PersistenceException {
		return this.hackDelay;
	}
	@Override
	public void setHackDelay(final java.sql.Timestamp newValue) throws PersistenceException {
		ConnectionHandler.getTheConnectionHandler().theServerFacade.hackDelaySet(this.getId(), newValue);
		this.hackDelay = newValue;
	}
	@Override
	public PersistentServer getThis() throws PersistenceException {
		if(this.This == null){
			PersistentServer result = new ServerProxi(this.getId());
			result.getTheObject();
			return result;
		}return this.This;
	}

	@Override
	public void accept(final model.visitor.InvokerVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}
	@Override
	public <R> R accept(final model.visitor.InvokerReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}
	@Override
	public void accept(final model.visitor.RemoteVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}
	@Override
	public <R> R accept(final model.visitor.RemoteReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}
	@Override
	public void accept(final model.visitor.AnythingVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}
	@Override
	public <R> R accept(final model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}
	@Override
	public <E extends model.UserException>  void accept(final model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}
	@Override
	public <R, E extends model.UserException> R accept(final model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}
	@Override
	public int getLeafInfo() throws PersistenceException{
		return 0
				+ (this.getActors() == null ? 0 : this.getActors().getTheObject().getLeafInfo());
	}


	@Override
	public void handleResult(final Command command)
			throws PersistenceException{
		new Thread(new Runnable(){
			@Override
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
						Server.this.signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						Server.this.getErrors().add(visitor.getResult());
						Server.this.signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
	}
	@Override
	public PersistentActorManager getActors()
			throws PersistenceException{
		return model.ActorManager.getTheActorManager();
	}
	@Override
	public void signalChanged(final boolean signal)
			throws PersistenceException{
		this.changed = signal;
	}
	@Override
	public void initializeOnInstantiation()
			throws PersistenceException{
	}
	@Override
	public void addPosition(final PersistentOrder order, final PersistentProduct product, final long quanitity)
			throws PersistenceException{
		this.getThis().getActors().addPosition(order, product, quanitity, this.getThis());
	}
	@Override
	public void connected(final String user)
			throws PersistenceException{
	}
	@Override
	public PersistentActorManager getActors(final TDObserver observer)
			throws PersistenceException{
		PersistentActorManager result = this.getThis().getActors();
		observer.updateTransientDerived(this.getThis(), "actors", result);
		return result;
	}
	@Override
	public void deleteErrors()
			throws PersistenceException{
		this.getThis().getErrors().filter(new Predcate<PersistentErrorDisplay>() {

			@Override
			public boolean test(final PersistentErrorDisplay argument)
					throws PersistenceException {
				return false;
			}
		});
		this.getThis().signalChanged(true);
	}
	@Override
	public void initializeOnCreation()
			throws PersistenceException{
	}
	@Override
	public void changeName(final PersistentActor actor, final String name)
			throws PersistenceException{
		this.getThis().getActors().changeName(actor, name, this.getThis());
	}
	@Override
	public boolean hasChanged()
			throws PersistenceException{
		boolean result = this.changed;
		this.changed = false;
		return result;
	}
	@Override
	public void disconnected()
			throws PersistenceException{
	}
	@Override
	public void createProduct(final PersistentSupplier manufacturer, final String name)
			throws PersistenceException{
		this.getThis().getActors().createProduct(manufacturer, name, this.getThis());

	}
	@Override
	public void copyingPrivateUserAttributes(final Anything copy)
			throws PersistenceException{
		//TODO: implement method: copyingPrivateUserAttributes

	}
	@Override
	public void createActor(final String name)
			throws PersistenceException{
		this.getThis().getActors().createActor(name, this.getThis());
	}
	@Override
	public void handleException(final Command command, final PersistenceException exception)
			throws PersistenceException{
		new Thread(new Runnable(){
			@Override
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
	}
	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields)
			throws PersistenceException{
		this.setThis((PersistentServer)This);
		if(this.equals(This)){
			this.setPassword((String)final$$Fields.get("password"));
			this.setUser((String)final$$Fields.get("user"));
			this.setHackCount((Long)final$$Fields.get("hackCount"));
			this.setHackDelay((java.sql.Timestamp)final$$Fields.get("hackDelay"));
		}
	}
	@Override
	public void createOrder(final PersistentCustomer customer, final PersistentSupplier supplier)
			throws PersistenceException{
		this.getThis().getActors().createOrder(customer, supplier, this.getThis());
	}
	@Override
	public void addRole(final PersistentActor actor, final String roleName)
			throws PersistenceException{
		this.getThis().getActors().addRole(actor, roleName, this.getThis());
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}
