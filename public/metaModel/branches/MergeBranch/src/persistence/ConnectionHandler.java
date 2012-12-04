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
    public QuantityManagerFacade theQuantityManagerFacade;
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public AssociationManagerFacade theAssociationManagerFacade;
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public MAHierarchyFacade theMAHierarchyFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public CreateCompUnitCommandFacade theCreateCompUnitCommandFacade;
    public CommonDateFacade theCommonDateFacade;
    public CreateCompUnitTypeCommandFacade theCreateCompUnitTypeCommandFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public UnitTypeManagerFacade theUnitTypeManagerFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public AddDefaultUnitCommandFacade theAddDefaultUnitCommandFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ServerFacade theServerFacade;
    public MAtomicTypeFacade theMAtomicTypeFacade;
    public CreateAtomicTypeCommandFacade theCreateAtomicTypeCommandFacade;
    public FractionManagerFacade theFractionManagerFacade;
    public ConversionFacade theConversionFacade;
    public ReferenceFacade theReferenceFacade;
    public CreateSubTypeCommandFacade theCreateSubTypeCommandFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;
    public MProductTypeFacade theMProductTypeFacade;
    public FinishModelingCommandFacade theFinishModelingCommandFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public CreateHierarchyCommandFacade theCreateHierarchyCommandFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public UnitFacade theUnitFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public MFalseFacade theMFalseFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public MAssociationFacade theMAssociationFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public CreateAssociationCommandFacade theCreateAssociationCommandFacade;
    public MBooleanFacade theMBooleanFacade;
    public MTrueFacade theMTrueFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public QuantityFacade theQuantityFacade;
    public AddReferenceTypeCommandFacade theAddReferenceTypeCommandFacade;
    public FunctionFacade theFunctionFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public AddToHierarchyCommandFacade theAddToHierarchyCommandFacade;
    public AddSubTypeCommandFacade theAddSubTypeCommandFacade;
    public MAspectFacade theMAspectFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public CompUnitFacade theCompUnitFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theAssociationManagerFacade= new AssociationManagerFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade();
            this.theMAHierarchyFacade= new MAHierarchyFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theServerFacade= new ServerFacade();
            this.theMAtomicTypeFacade= new MAtomicTypeFacade();
            this.theCreateAtomicTypeCommandFacade= new CreateAtomicTypeCommandFacade();
            this.theFractionManagerFacade= new FractionManagerFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theCreateSubTypeCommandFacade= new CreateSubTypeCommandFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
            this.theMProductTypeFacade= new MProductTypeFacade();
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theMFalseFacade= new MFalseFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theMAssociationFacade= new MAssociationFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade();
            this.theMBooleanFacade= new MBooleanFacade();
            this.theMTrueFacade= new MTrueFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade();
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade();
            this.theMAspectFacade= new MAspectFacade();
            this.theMSumTypeFacade= new MSumTypeFacade();
            this.theCompUnitFacade= new CompUnitFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

