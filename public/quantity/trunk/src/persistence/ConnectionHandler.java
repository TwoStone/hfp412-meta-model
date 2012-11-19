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
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public UnitFacade theUnitFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public BooleanValueFacade theBooleanValueFacade;
    public CreateCompUnitTypeCommandFacade theCreateCompUnitTypeCommandFacade;
    public BooleanTrueFacade theBooleanTrueFacade;
    public CommonDateFacade theCommonDateFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public AddReferenceTypeCommandFacade theAddReferenceTypeCommandFacade;
    public QuantityFacade theQuantityFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public UnitTypeManagerFacade theUnitTypeManagerFacade;
    public AddDefaultUnitCommandFacade theAddDefaultUnitCommandFacade;
    public FunctionFacade theFunctionFacade;
    public BooleanFalseFacade theBooleanFalseFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ServerFacade theServerFacade;
    public FractionManagerFacade theFractionManagerFacade;
    public CompUnitFacade theCompUnitFacade;
    public ReferenceFacade theReferenceFacade;
    public ConversionFacade theConversionFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theUnitFacade= new UnitFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theBooleanValueFacade= new BooleanValueFacade();
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade();
            this.theBooleanTrueFacade= new BooleanTrueFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade();
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theBooleanFalseFacade= new BooleanFalseFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theServerFacade= new ServerFacade();
            this.theFractionManagerFacade= new FractionManagerFacade();
            this.theCompUnitFacade= new CompUnitFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

