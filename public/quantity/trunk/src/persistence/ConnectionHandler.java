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



    public ConversionManagerFacade theConversionManagerFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public QuantityManagerFacade theQuantityManagerFacade;
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public UnitFacade theUnitFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public CommonDateFacade theCommonDateFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public QuantityFacade theQuantityFacade;
    public TransactionFcdeFacade theTransactionFcdeFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public AddDefaultUnitCommandFacade theAddDefaultUnitCommandFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ServerFacade theServerFacade;
    public CompUnitFacade theCompUnitFacade;
    public ReferenceFacade theReferenceFacade;
    public ConversionFacade theConversionFacade;
    public UnitManagerFacade theUnitManagerFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theTransactionFcdeFacade= new TransactionFcdeFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theServerFacade= new ServerFacade();
            this.theCompUnitFacade= new CompUnitFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theUnitManagerFacade= new UnitManagerFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

