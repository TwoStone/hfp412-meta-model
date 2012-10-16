
package model;

import persistence.*;


/* Additional import section end */

public class Server extends PersistentObject implements PersistentServer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentServer getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theServerFacade.getClass(objectId);
        return (PersistentServer)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentServer createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
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
    
    public static PersistentServer createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,PersistentServer This) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
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
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot actorManager = (AbstractPersistentRoot)this.getActorManager();
            if (actorManager != null) {
                result.put("actorManager", actorManager.createProxiInformation());
                if(depth > 1) {
                    actorManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && actorManager.hasEssentialFields())actorManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            result.put("user", this.getUser());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ServerSearchList getServerByUser(String index) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theServerFacade
            .getServerByUser(index);
    }
    
    public Server provideCopy() throws PersistenceException{
        Server result = this;
        result = new Server(this.This, 
                            this.password, 
                            this.user, 
                            this.hackCount, 
                            this.hackDelay, 
                            this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
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
    
    public Server(PersistentServer This,String password,String user,long hackCount,java.sql.Timestamp hackDelay,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;
        this.errors = new Server_ErrorsProxi(this);
        this.password = password;
        this.user = user;
        this.hackCount = hackCount;
        this.hackDelay = hackDelay;        
    }
    
    static public long getTypeId() {
        return -102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    protected void setThis(PersistentServer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), newValue);
    }
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return this.errors;
    }
    public String getPassword() throws PersistenceException {
        return this.password;
    }
    public void setPassword(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theServerFacade.passwordSet(this.getId(), newValue);
        this.password = newValue;
    }
    public String getUser() throws PersistenceException {
        return this.user;
    }
    public void setUser(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theServerFacade.userSet(this.getId(), newValue);
        this.user = newValue;
    }
    public long getHackCount() throws PersistenceException {
        return this.hackCount;
    }
    public void setHackCount(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theServerFacade.hackCountSet(this.getId(), newValue);
        this.hackCount = newValue;
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return this.hackDelay;
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theServerFacade.hackDelaySet(this.getId(), newValue);
        this.hackDelay = newValue;
    }
    public PersistentServer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServer result = new ServerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentServer)this.This;
    }
    
    public void accept(model.visitor.InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(model.visitor.RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getActorManager() == null ? 0 : this.getActorManager().getTheObject().getLeafInfo()));
    }
    
    
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void connected(final String user) 
				throws PersistenceException{
           
    }
    public PersistentActorManager getActorManager(final TDObserver observer) 
				throws PersistenceException{
        PersistentActorManager result = getThis().getActorManager();
		observer.updateTransientDerived(getThis(), "actorManager", result);
		return result;
    }
    public void deleteErrors() 
				throws PersistenceException{
    	getThis().getErrors().filter(new Predcate<PersistentErrorDisplay>() {
			public boolean test(PersistentErrorDisplay argument)
					throws PersistenceException {
				return false;
			}
		});
    	getThis().signalChanged(true);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void changeName(final PersistentActor actor, final String nme) 
				throws PersistenceException{
        //TODO: implement method: changeName
        
    }
    public boolean hasChanged() 
				throws PersistenceException{
        boolean result = this.changed;
		this.changed = false;
		return result;
    }
    public void disconnected() 
				throws PersistenceException{
           
    }
    public PersistentActorManager getActorManager() 
				throws PersistenceException{
        return model.ActorManager.getTheActorManager();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createActor(final String name) 
				throws PersistenceException{
        //TODO: implement method: createActor
        
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
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
    public void addRole(final PersistentActor actor, final String roleName) 
				throws PersistenceException{
        //TODO: implement method: addRole
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
