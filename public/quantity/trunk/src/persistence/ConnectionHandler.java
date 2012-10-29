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



    public TypeManagerFacade theTypeManagerFacade;
    public ConversionManagerFacade theConversionManagerFacade;
    public QuantityFacade theQuantityFacade;
    public TransactionFcdeFacade theTransactionFcdeFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public FunctionFacade theFunctionFacade;
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public QuantityManagerFacade theQuantityManagerFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public UnitFacade theUnitFacade;
    public ServerFacade theServerFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public ConversionFacade theConversionFacade;
    public ReferenceFacade theReferenceFacade;
    public CompUnitFacade theCompUnitFacade;
    public UnitManagerFacade theUnitManagerFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theTransactionFcdeFacade= new TransactionFcdeFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theUnitFacade= new UnitFacade();
            this.theServerFacade= new ServerFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theCompUnitFacade= new CompUnitFacade();
            this.theUnitManagerFacade= new UnitManagerFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

