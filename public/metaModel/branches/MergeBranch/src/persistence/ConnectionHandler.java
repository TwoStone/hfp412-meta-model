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
    public CreateHierarchyCommandFacade theCreateHierarchyCommandFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public AddToHierarchyCommandFacade theAddToHierarchyCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public AddSubTypeCommandFacade theAddSubTypeCommandFacade;
    public MFalseFacade theMFalseFacade;
    public ServerFacade theServerFacade;
    public AssociationManagerFacade theAssociationManagerFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public MAtomicTypeFacade theMAtomicTypeFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public CreateAtomicTypeCommandFacade theCreateAtomicTypeCommandFacade;
    public MAHierarchyFacade theMAHierarchyFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public MAspectFacade theMAspectFacade;
    public CommonDateFacade theCommonDateFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public MAssociationFacade theMAssociationFacade;
    public CreateAssociationCommandFacade theCreateAssociationCommandFacade;
    public CreateSubTypeCommandFacade theCreateSubTypeCommandFacade;
    public MBooleanFacade theMBooleanFacade;
    public MTrueFacade theMTrueFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theMProductTypeFacade= new MProductTypeFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade();
            this.theMFalseFacade= new MFalseFacade();
            this.theServerFacade= new ServerFacade();
            this.theAssociationManagerFacade= new AssociationManagerFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theMAtomicTypeFacade= new MAtomicTypeFacade();
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade();
            this.theCreateAtomicTypeCommandFacade= new CreateAtomicTypeCommandFacade();
            this.theMAHierarchyFacade= new MAHierarchyFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theMAspectFacade= new MAspectFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theMSumTypeFacade= new MSumTypeFacade();
            this.theMAssociationFacade= new MAssociationFacade();
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade();
            this.theCreateSubTypeCommandFacade= new CreateSubTypeCommandFacade();
            this.theMBooleanFacade= new MBooleanFacade();
            this.theMTrueFacade= new MTrueFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

