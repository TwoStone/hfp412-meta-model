package persistence;

import java.util.Hashtable;


public class ConnectionHandler {

	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();

	private static ConnectionHandler theConnectionHandler;

	public static void disconnect() throws PersistenceException {
	}
	

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler();
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		connections.remove(Thread.currentThread());
	}

	protected static ConnectionHandler getDefaultConnectionHandler() throws PersistenceException{
		if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
		return theConnectionHandler;
	}
	
	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}

	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}



    public CustomerFacade theCustomerFacade;
    public ActorManagerFacade theActorManagerFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public AddRoleCommandFacade theAddRoleCommandFacade;
    public ProductFacade theProductFacade;
    public JuristicPersonFacade theJuristicPersonFacade;
    public OrderFacade theOrderFacade;
    public CreateActorCommandFacade theCreateActorCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ServerFacade theServerFacade;
    public NaturalPersonFacade theNaturalPersonFacade;
    public SupplierFacade theSupplierFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public ActorFacade theActorFacade;
    public CommonDateFacade theCommonDateFacade;
    public PositionFacade thePositionFacade;
    public RoleFacade theRoleFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theCustomerFacade= new CustomerFacade();
            this.theActorManagerFacade= new ActorManagerFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddRoleCommandFacade= new AddRoleCommandFacade();
            this.theProductFacade= new ProductFacade();
            this.theJuristicPersonFacade= new JuristicPersonFacade();
            this.theOrderFacade= new OrderFacade();
            this.theCreateActorCommandFacade= new CreateActorCommandFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theServerFacade= new ServerFacade();
            this.theNaturalPersonFacade= new NaturalPersonFacade();
            this.theSupplierFacade= new SupplierFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theActorFacade= new ActorFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.thePositionFacade= new PositionFacade();
            this.theRoleFacade= new RoleFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

