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
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public QuantityManagerFacade theQuantityManagerFacade;
    public CreateProductTypeCommandFacade theCreateProductTypeCommandFacade;
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public AssociationManagerFacade theAssociationManagerFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public CreateAtomicSubTypeCommandFacade theCreateAtomicSubTypeCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public MAbstractSumTypeFacade theMAbstractSumTypeFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public MAHierarchyFacade theMAHierarchyFacade;
    public CreateCompUnitCommandFacade theCreateCompUnitCommandFacade;
    public CreateCompUnitTypeCommandFacade theCreateCompUnitTypeCommandFacade;
    public CommonDateFacade theCommonDateFacade;
    public MAccountTypeFacade theMAccountTypeFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public MTypeFacade theMTypeFacade;
    public MEmptyProductFacade theMEmptyProductFacade;
    public UnitTypeManagerFacade theUnitTypeManagerFacade;
    public AddDefaultUnitCommandFacade theAddDefaultUnitCommandFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public ServerFacade theServerFacade;
    public MAtomicTypeFacade theMAtomicTypeFacade;
    public FractionManagerFacade theFractionManagerFacade;
    public ReferenceFacade theReferenceFacade;
    public ConversionFacade theConversionFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;
    public MeasurementFacade theMeasurementFacade;
    public MProductTypeFacade theMProductTypeFacade;
    public FinishModelingCommandFacade theFinishModelingCommandFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public AccountFacade theAccountFacade;
    public MOperationFacade theMOperationFacade;
    public CreateHierarchyCommandFacade theCreateHierarchyCommandFacade;
    public QuantifObjectFacade theQuantifObjectFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public MFalseFacade theMFalseFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public UnitFacade theUnitFacade;
    public CreateMeasurementTypeCommandFacade theCreateMeasurementTypeCommandFacade;
    public MeasurementTypeManagerFacade theMeasurementTypeManagerFacade;
    public MMeasurementTypeFacade theMMeasurementTypeFacade;
    public MEmptySumTypeFacade theMEmptySumTypeFacade;
    public MQuantiObjectTypeFacade theMQuantiObjectTypeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public AccountTypeManagerFacade theAccountTypeManagerFacade;
    public MFormalParameterFacade theMFormalParameterFacade;
    public MAssociationFacade theMAssociationFacade;
    public CreateAssociationCommandFacade theCreateAssociationCommandFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public MessageOrLinkFacade theMessageOrLinkFacade;
    public InstanceObjectFacade theInstanceObjectFacade;
    public MAbsOperationFacade theMAbsOperationFacade;
    public CreateAtomicRootTypeCommandFacade theCreateAtomicRootTypeCommandFacade;
    public MBooleanFacade theMBooleanFacade;
    public MTrueFacade theMTrueFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public AddReferenceTypeCommandFacade theAddReferenceTypeCommandFacade;
    public QuantityFacade theQuantityFacade;
    public MAbstractProductTypeFacade theMAbstractProductTypeFacade;
    public MessageFacade theMessageFacade;
    public FunctionFacade theFunctionFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public ActualParameterFacade theActualParameterFacade;
    public AddToHierarchyCommandFacade theAddToHierarchyCommandFacade;
    public AddSubTypeCommandFacade theAddSubTypeCommandFacade;
    public CreateSumTypeCommandFacade theCreateSumTypeCommandFacade;
    public LinkFacade theLinkFacade;
    public MAspectFacade theMAspectFacade;
    public AccountManagerFacade theAccountManagerFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public CompUnitFacade theCompUnitFacade;
    public CreateAccountTypeCommandFacade theCreateAccountTypeCommandFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theCreateProductTypeCommandFacade= new CreateProductTypeCommandFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theAssociationManagerFacade= new AssociationManagerFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theCreateAtomicSubTypeCommandFacade= new CreateAtomicSubTypeCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theMAbstractSumTypeFacade= new MAbstractSumTypeFacade();
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theMAHierarchyFacade= new MAHierarchyFacade();
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade();
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theMAccountTypeFacade= new MAccountTypeFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theMTypeFacade= new MTypeFacade();
            this.theMEmptyProductFacade= new MEmptyProductFacade();
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade();
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theServerFacade= new ServerFacade();
            this.theMAtomicTypeFacade= new MAtomicTypeFacade();
            this.theFractionManagerFacade= new FractionManagerFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
            this.theMeasurementFacade= new MeasurementFacade();
            this.theMProductTypeFacade= new MProductTypeFacade();
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theAccountFacade= new AccountFacade();
            this.theMOperationFacade= new MOperationFacade();
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade();
            this.theQuantifObjectFacade= new QuantifObjectFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theMFalseFacade= new MFalseFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theUnitFacade= new UnitFacade();
            this.theCreateMeasurementTypeCommandFacade= new CreateMeasurementTypeCommandFacade();
            this.theMeasurementTypeManagerFacade= new MeasurementTypeManagerFacade();
            this.theMMeasurementTypeFacade= new MMeasurementTypeFacade();
            this.theMEmptySumTypeFacade= new MEmptySumTypeFacade();
            this.theMQuantiObjectTypeFacade= new MQuantiObjectTypeFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theAccountTypeManagerFacade= new AccountTypeManagerFacade();
            this.theMFormalParameterFacade= new MFormalParameterFacade();
            this.theMAssociationFacade= new MAssociationFacade();
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theMessageOrLinkFacade= new MessageOrLinkFacade();
            this.theInstanceObjectFacade= new InstanceObjectFacade();
            this.theMAbsOperationFacade= new MAbsOperationFacade();
            this.theCreateAtomicRootTypeCommandFacade= new CreateAtomicRootTypeCommandFacade();
            this.theMBooleanFacade= new MBooleanFacade();
            this.theMTrueFacade= new MTrueFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theMAbstractProductTypeFacade= new MAbstractProductTypeFacade();
            this.theMessageFacade= new MessageFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theActualParameterFacade= new ActualParameterFacade();
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade();
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade();
            this.theCreateSumTypeCommandFacade= new CreateSumTypeCommandFacade();
            this.theLinkFacade= new LinkFacade();
            this.theMAspectFacade= new MAspectFacade();
            this.theAccountManagerFacade= new AccountManagerFacade();
            this.theMSumTypeFacade= new MSumTypeFacade();
            this.theCompUnitFacade= new CompUnitFacade();
            this.theCreateAccountTypeCommandFacade= new CreateAccountTypeCommandFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

