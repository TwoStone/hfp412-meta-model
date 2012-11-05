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



    public MProductTypeFacade theMProductTypeFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public AddAspectCommandFacade theAddAspectCommandFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ServerFacade theServerFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public MAtomicTypeFacade theMAtomicTypeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public MAspectFacade theMAspectFacade;
    public CommonDateFacade theCommonDateFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public AddAtomicTypeCommandFacade theAddAtomicTypeCommandFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theMProductTypeFacade= new MProductTypeFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddAspectCommandFacade= new AddAspectCommandFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theServerFacade= new ServerFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theMAtomicTypeFacade= new MAtomicTypeFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theMAspectFacade= new MAspectFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theMSumTypeFacade= new MSumTypeFacade();
            this.theAddAtomicTypeCommandFacade= new AddAtomicTypeCommandFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

