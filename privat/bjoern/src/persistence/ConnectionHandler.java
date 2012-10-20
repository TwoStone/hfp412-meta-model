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
    public AddRoleCommandFacade theAddRoleCommandFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public AkteurFacade theAkteurFacade;
    public CommonDateFacade theCommonDateFacade;
    public RolleFacade theRolleFacade;
    public PositionFacade thePositionFacade;
    public AuftragFacade theAuftragFacade;
    public AkteurManagerFacade theAkteurManagerFacade;
    public LieferantFacade theLieferantFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ProduktFacade theProduktFacade;
    public ServerFacade theServerFacade;
    public KundeFacade theKundeFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theCreateAkteurCommandFacade= new CreateAkteurCommandFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddRoleCommandFacade= new AddRoleCommandFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theAkteurFacade= new AkteurFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theRolleFacade= new RolleFacade();
            this.thePositionFacade= new PositionFacade();
            this.theAuftragFacade= new AuftragFacade();
            this.theAkteurManagerFacade= new AkteurManagerFacade();
            this.theLieferantFacade= new LieferantFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theProduktFacade= new ProduktFacade();
            this.theServerFacade= new ServerFacade();
            this.theKundeFacade= new KundeFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

