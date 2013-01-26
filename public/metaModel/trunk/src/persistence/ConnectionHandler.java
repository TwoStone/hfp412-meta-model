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



    public CreateMObjectCommandFacade theCreateMObjectCommandFacade;
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public MAbstractSumTypeFacade theMAbstractSumTypeFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public AbsOperationFacade theAbsOperationFacade;
    public MEmptyProductFacade theMEmptyProductFacade;
    public CompoundQuantityFacade theCompoundQuantityFacade;
    public AddDefaultUnitCommandFacade theAddDefaultUnitCommandFacade;
    public RemoveAssoFrmHierCommandFacade theRemoveAssoFrmHierCommandFacade;
    public ServerFacade theServerFacade;
    public MAtomicTypeFacade theMAtomicTypeFacade;
    public CompUnitTypeFacade theCompUnitTypeFacade;
    public MProductTypeFacade theMProductTypeFacade;
    public MeasurementFacade theMeasurementFacade;
    public AssociationFacade theAssociationFacade;
    public RemoveLinkCommandFacade theRemoveLinkCommandFacade;
    public FormalParameterFacade theFormalParameterFacade;
    public CreateHierarchyCommandFacade theCreateHierarchyCommandFacade;
    public OperationManagerFacade theOperationManagerFacade;
    public QuantifObjectFacade theQuantifObjectFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public UnitFacade theUnitFacade;
    public CreateMeasurementTypeCommandFacade theCreateMeasurementTypeCommandFacade;
    public MMeasurementTypeFacade theMMeasurementTypeFacade;
    public MQuantiObjectTypeFacade theMQuantiObjectTypeFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public AccountTypeManagerFacade theAccountTypeManagerFacade;
    public MObjectFacade theMObjectFacade;
    public CreateQuantityCommandFacade theCreateQuantityCommandFacade;
    public InstanceObjectFacade theInstanceObjectFacade;
    public RemoveFpCommandFacade theRemoveFpCommandFacade;
    public MBooleanFacade theMBooleanFacade;
    public MessageFacade theMessageFacade;
    public MAbstractProductTypeFacade theMAbstractProductTypeFacade;
    public FunctionFacade theFunctionFacade;
    public AspectManagerFacade theAspectManagerFacade;
    public RemoveOperationCommandFacade theRemoveOperationCommandFacade;
    public CreateConstantCommandFacade theCreateConstantCommandFacade;
    public LinkFacade theLinkFacade;
    public MAspectFacade theMAspectFacade;
    public AccountManagerFacade theAccountManagerFacade;
    public MSumTypeFacade theMSumTypeFacade;
    public CompUnitFacade theCompUnitFacade;
    public CreateMessageCommandFacade theCreateMessageCommandFacade;
    public CreateAccountTypeCommandFacade theCreateAccountTypeCommandFacade;
    public OperationFacade theOperationFacade;
    public ConversionManagerFacade theConversionManagerFacade;
    public QuantityManagerFacade theQuantityManagerFacade;
    public AbsUnitTypeFacade theAbsUnitTypeFacade;
    public CreateProductTypeCommandFacade theCreateProductTypeCommandFacade;
    public CreateStaticOpCommandFacade theCreateStaticOpCommandFacade;
    public AssociationManagerFacade theAssociationManagerFacade;
    public CreateAccountCommandFacade theCreateAccountCommandFacade;
    public CreateConversionCommandFacade theCreateConversionCommandFacade;
    public CreateAtomicSubTypeCommandFacade theCreateAtomicSubTypeCommandFacade;
    public AbsQuantityFacade theAbsQuantityFacade;
    public CreateVoidOperationCommandFacade theCreateVoidOperationCommandFacade;
    public CreateLinkCommandFacade theCreateLinkCommandFacade;
    public CreateCompUnitCommandFacade theCreateCompUnitCommandFacade;
    public CommonDateFacade theCommonDateFacade;
    public CreateCompUnitTypeCommandFacade theCreateCompUnitTypeCommandFacade;
    public RemoveAssociationCommandFacade theRemoveAssociationCommandFacade;
    public HierarchyFacade theHierarchyFacade;
    public MAccountTypeFacade theMAccountTypeFacade;
    public AddFpCommandFacade theAddFpCommandFacade;
    public CreateStaticMessageCommandFacade theCreateStaticMessageCommandFacade;
    public TypeManagerFacade theTypeManagerFacade;
    public MessageManagerFacade theMessageManagerFacade;
    public UnitTypeManagerFacade theUnitTypeManagerFacade;
    public MTypeFacade theMTypeFacade;
    public CreateVoidMessageCommandFacade theCreateVoidMessageCommandFacade;
    public AbsUnitFacade theAbsUnitFacade;
    public AddAssociationCommandFacade theAddAssociationCommandFacade;
    public CreateConstCommandFacade theCreateConstCommandFacade;
    public FractionManagerFacade theFractionManagerFacade;
    public CreateOperationCommandFacade theCreateOperationCommandFacade;
    public ConversionFacade theConversionFacade;
    public ReferenceFacade theReferenceFacade;
    public FinishModelingCommandFacade theFinishModelingCommandFacade;
    public ReferenceTypeFacade theReferenceTypeFacade;
    public AccountFacade theAccountFacade;
    public UnitTypeFacade theUnitTypeFacade;
    public MFalseFacade theMFalseFacade;
    public MeasurementTypeManagerFacade theMeasurementTypeManagerFacade;
    public MEmptySumTypeFacade theMEmptySumTypeFacade;
    public LinkManagerFacade theLinkManagerFacade;
    public CreateAssociationCommandFacade theCreateAssociationCommandFacade;
    public MessageOrLinkFacade theMessageOrLinkFacade;
    public CreateAtomicRootTypeCommandFacade theCreateAtomicRootTypeCommandFacade;
    public MTrueFacade theMTrueFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public QuantityFacade theQuantityFacade;
    public AddReferenceTypeCommandFacade theAddReferenceTypeCommandFacade;
    public ActualParameterFacade theActualParameterFacade;
    public CreateSumTypeCommandFacade theCreateSumTypeCommandFacade;
    public RemoveFpFromOpCommandFacade theRemoveFpFromOpCommandFacade;
    public RemoveMessageCommandFacade theRemoveMessageCommandFacade;
    public ObjectManagerFacade theObjectManagerFacade;
    public CreateFpCommandFacade theCreateFpCommandFacade;

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theCreateMObjectCommandFacade= new CreateMObjectCommandFacade();
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade();
            this.theMComplexTypeFacade= new MComplexTypeFacade();
            this.theMAbstractSumTypeFacade= new MAbstractSumTypeFacade();
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade();
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade();
            this.theAbsOperationFacade= new AbsOperationFacade();
            this.theMEmptyProductFacade= new MEmptyProductFacade();
            this.theCompoundQuantityFacade= new CompoundQuantityFacade();
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade();
            this.theRemoveAssoFrmHierCommandFacade= new RemoveAssoFrmHierCommandFacade();
            this.theServerFacade= new ServerFacade();
            this.theMAtomicTypeFacade= new MAtomicTypeFacade();
            this.theCompUnitTypeFacade= new CompUnitTypeFacade();
            this.theMProductTypeFacade= new MProductTypeFacade();
            this.theMeasurementFacade= new MeasurementFacade();
            this.theAssociationFacade= new AssociationFacade();
            this.theRemoveLinkCommandFacade= new RemoveLinkCommandFacade();
            this.theFormalParameterFacade= new FormalParameterFacade();
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade();
            this.theOperationManagerFacade= new OperationManagerFacade();
            this.theQuantifObjectFacade= new QuantifObjectFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade();
            this.theCreateMeasurementTypeCommandFacade= new CreateMeasurementTypeCommandFacade();
            this.theMMeasurementTypeFacade= new MMeasurementTypeFacade();
            this.theMQuantiObjectTypeFacade= new MQuantiObjectTypeFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theAccountTypeManagerFacade= new AccountTypeManagerFacade();
            this.theMObjectFacade= new MObjectFacade();
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade();
            this.theInstanceObjectFacade= new InstanceObjectFacade();
            this.theRemoveFpCommandFacade= new RemoveFpCommandFacade();
            this.theMBooleanFacade= new MBooleanFacade();
            this.theMessageFacade= new MessageFacade();
            this.theMAbstractProductTypeFacade= new MAbstractProductTypeFacade();
            this.theFunctionFacade= new FunctionFacade();
            this.theAspectManagerFacade= new AspectManagerFacade();
            this.theRemoveOperationCommandFacade= new RemoveOperationCommandFacade();
            this.theCreateConstantCommandFacade= new CreateConstantCommandFacade();
            this.theLinkFacade= new LinkFacade();
            this.theMAspectFacade= new MAspectFacade();
            this.theAccountManagerFacade= new AccountManagerFacade();
            this.theMSumTypeFacade= new MSumTypeFacade();
            this.theCompUnitFacade= new CompUnitFacade();
            this.theCreateMessageCommandFacade= new CreateMessageCommandFacade();
            this.theCreateAccountTypeCommandFacade= new CreateAccountTypeCommandFacade();
            this.theOperationFacade= new OperationFacade();
            this.theConversionManagerFacade= new ConversionManagerFacade();
            this.theQuantityManagerFacade= new QuantityManagerFacade();
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade();
            this.theCreateProductTypeCommandFacade= new CreateProductTypeCommandFacade();
            this.theCreateStaticOpCommandFacade= new CreateStaticOpCommandFacade();
            this.theAssociationManagerFacade= new AssociationManagerFacade();
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade();
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade();
            this.theCreateAtomicSubTypeCommandFacade= new CreateAtomicSubTypeCommandFacade();
            this.theAbsQuantityFacade= new AbsQuantityFacade();
            this.theCreateVoidOperationCommandFacade= new CreateVoidOperationCommandFacade();
            this.theCreateLinkCommandFacade= new CreateLinkCommandFacade();
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade();
            this.theRemoveAssociationCommandFacade= new RemoveAssociationCommandFacade();
            this.theHierarchyFacade= new HierarchyFacade();
            this.theMAccountTypeFacade= new MAccountTypeFacade();
            this.theAddFpCommandFacade= new AddFpCommandFacade();
            this.theCreateStaticMessageCommandFacade= new CreateStaticMessageCommandFacade();
            this.theTypeManagerFacade= new TypeManagerFacade();
            this.theMessageManagerFacade= new MessageManagerFacade();
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade();
            this.theMTypeFacade= new MTypeFacade();
            this.theCreateVoidMessageCommandFacade= new CreateVoidMessageCommandFacade();
            this.theAbsUnitFacade= new AbsUnitFacade();
            this.theAddAssociationCommandFacade= new AddAssociationCommandFacade();
            this.theCreateConstCommandFacade= new CreateConstCommandFacade();
            this.theFractionManagerFacade= new FractionManagerFacade();
            this.theCreateOperationCommandFacade= new CreateOperationCommandFacade();
            this.theConversionFacade= new ConversionFacade();
            this.theReferenceFacade= new ReferenceFacade();
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade();
            this.theReferenceTypeFacade= new ReferenceTypeFacade();
            this.theAccountFacade= new AccountFacade();
            this.theUnitTypeFacade= new UnitTypeFacade();
            this.theMFalseFacade= new MFalseFacade();
            this.theMeasurementTypeManagerFacade= new MeasurementTypeManagerFacade();
            this.theMEmptySumTypeFacade= new MEmptySumTypeFacade();
            this.theLinkManagerFacade= new LinkManagerFacade();
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade();
            this.theMessageOrLinkFacade= new MessageOrLinkFacade();
            this.theCreateAtomicRootTypeCommandFacade= new CreateAtomicRootTypeCommandFacade();
            this.theMTrueFacade= new MTrueFacade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.theQuantityFacade= new QuantityFacade();
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade();
            this.theActualParameterFacade= new ActualParameterFacade();
            this.theCreateSumTypeCommandFacade= new CreateSumTypeCommandFacade();
            this.theRemoveFpFromOpCommandFacade= new RemoveFpFromOpCommandFacade();
            this.theRemoveMessageCommandFacade= new RemoveMessageCommandFacade();
            this.theObjectManagerFacade= new ObjectManagerFacade();
            this.theCreateFpCommandFacade= new CreateFpCommandFacade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

