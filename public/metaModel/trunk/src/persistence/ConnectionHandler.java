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
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public AssociationManagerFacade theAssociationManagerFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public MAHierarchyFacade theMAHierarchyFacade;
    public CreateCompUnitCommandFacade theCreateCompUnitCommandFacade;
    public CreateCompUnitTypeCommandFacade theCreateCompUnitTypeCommandFacade;
    public CommonDateFacade theCommonDateFacade;
    public MAccountTypeFacade theMAccountTypeFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public MEmptySumFacade theMEmptySumFacade;
    public UnitTypeManagerFacade theUnitTypeManagerFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public MEmptyProductFacade theMEmptyProductFacade;
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
    public MeasurementFacade theMeasurementFacade;
    public FinishModelingCommandFacade theFinishModelingCommandFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public MOperationFacade theMOperationFacade;
    public AccountFacade theAccountFacade;
    public CreateHierarchyCommandFacade theCreateHierarchyCommandFacade;
    public QuantifObjectFacade theQuantifObjectFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public UnitFacade theUnitFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public MFalseFacade theMFalseFacade;
    public MMeasurementTypeFacade theMMeasurementTypeFacade;
    public MQuantiObjectTypeFacade theMQuantiObjectTypeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public MFormalParameterFacade theMFormalParameterFacade;
    public MAssociationFacade theMAssociationFacade;
    public CreateAssociationCommandFacade theCreateAssociationCommandFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public MessageOrLinkFacade theMessageOrLinkFacade;
    public InstanceObjectFacade theInstanceObjectFacade;
    public MAbsOperationFacade theMAbsOperationFacade;
    public MBooleanFacade theMBooleanFacade;
    public MTrueFacade theMTrueFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public AddReferenceTypeCommandFacade theAddReferenceTypeCommandFacade;
    public QuantityFacade theQuantityFacade;
    public MessageFacade theMessageFacade;
    public FunctionFacade theFunctionFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public ActualParameterFacade theActualParameterFacade;
    public AddToHierarchyCommandFacade theAddToHierarchyCommandFacade;
    public AddSubTypeCommandFacade theAddSubTypeCommandFacade;
    public LinkFacade theLinkFacade;
    public MAspectFacade theMAspectFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public CompUnitFacade theCompUnitFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theAssociationManagerFacade= new AssociationManagerFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theMAHierarchyFacade= new MAHierarchyFacade();
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade();
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theMAccountTypeFacade= new MAccountTypeFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theMEmptySumFacade= new MEmptySumFacade();
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theMEmptyProductFacade= new MEmptyProductFacade();
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
            this.theMeasurementFacade= new MeasurementFacade();
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theMOperationFacade= new MOperationFacade();
            this.theAccountFacade= new AccountFacade();
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade();
            this.theQuantifObjectFacade= new QuantifObjectFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theMFalseFacade= new MFalseFacade();
            this.theMMeasurementTypeFacade= new MMeasurementTypeFacade();
            this.theMQuantiObjectTypeFacade= new MQuantiObjectTypeFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theMFormalParameterFacade= new MFormalParameterFacade();
            this.theMAssociationFacade= new MAssociationFacade();
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theMessageOrLinkFacade= new MessageOrLinkFacade();
            this.theInstanceObjectFacade= new InstanceObjectFacade();
            this.theMAbsOperationFacade= new MAbsOperationFacade();
            this.theMBooleanFacade= new MBooleanFacade();
            this.theMTrueFacade= new MTrueFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theMessageFacade= new MessageFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theActualParameterFacade= new ActualParameterFacade();
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade();
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade();
            this.theLinkFacade= new LinkFacade();
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

