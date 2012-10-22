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



    public CreateAkteurCommandFacade theCreateAkteurCommandFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public TransactionManagerFacade theTransactionManagerFacade;
    public AddRoleCommandFacade theAddRoleCommandFacade;
    public AuftragFacade theAuftragFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ServerFacade theServerFacade;
    public KundeFacade theKundeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public AkteurFacade theAkteurFacade;
    public RolleFacade theRolleFacade;
    public CommonDateFacade theCommonDateFacade;
    public PositionFacade thePositionFacade;
    public LieferantFacade theLieferantFacade;
    public ProduktFacade theProduktFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theCreateAkteurCommandFacade= new CreateAkteurCommandFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theTransactionManagerFacade= new TransactionManagerFacade();
            this.theAddRoleCommandFacade= new AddRoleCommandFacade();
            this.theAuftragFacade= new AuftragFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theServerFacade= new ServerFacade();
            this.theKundeFacade= new KundeFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theAkteurFacade= new AkteurFacade();
            this.theRolleFacade= new RolleFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.thePositionFacade= new PositionFacade();
            this.theLieferantFacade= new LieferantFacade();
            this.theProduktFacade= new ProduktFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

