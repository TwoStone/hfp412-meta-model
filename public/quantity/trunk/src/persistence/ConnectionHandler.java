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



    public QuantityFacade theQuantityFacade;
    public TypeReferenceFacade theTypeReferenceFacade;
    public CompoundUnitTypeFacade theCompoundUnitTypeFacade;
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ServerFacade theServerFacade;
    public FractionFacade theFractionFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public UnitFacade theUnitFacade;
    public UnitReferenceFacade theUnitReferenceFacade;
    public ConversionRateFacade theConversionRateFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CompoundUnitFacade theCompoundUnitFacade;
    public ComposedQuantityFacade theComposedQuantityFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theQuantityFacade= new QuantityFacade();
            this.theTypeReferenceFacade= new TypeReferenceFacade();
            this.theCompoundUnitTypeFacade= new CompoundUnitTypeFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theServerFacade= new ServerFacade();
            this.theFractionFacade= new FractionFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theUnitFacade= new UnitFacade();
            this.theUnitReferenceFacade= new UnitReferenceFacade();
            this.theConversionRateFacade= new ConversionRateFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCompoundUnitFacade= new CompoundUnitFacade();
            this.theComposedQuantityFacade= new ComposedQuantityFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

