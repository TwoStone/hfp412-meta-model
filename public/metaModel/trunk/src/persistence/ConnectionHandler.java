package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ConnectionHandler {

	private static final String AutoCommitName = "AUTO COMMIT (DEFAULT)";
	
	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();
	
	private static ConnectionHandler theConnectionHandler;

	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static Vector<ConnectionHandler> getConnections(){
		Vector<ConnectionHandler> result = new Vector<ConnectionHandler>();
		Iterator<CommitConnectionHandler> committers = connections.values().iterator();
		while (committers.hasNext())result.add(committers.next());
		result.add(theConnectionHandler);
		return result;
	}
	
	public static void disconnect() throws PersistenceException{
		Iterator<CommitConnectionHandler> connectionIterator = connections.values().iterator();
		try {
			while (connectionIterator.hasNext()){
				ConnectionHandler current = (ConnectionHandler)connectionIterator.next();
				if(!current.con.isClosed())current.con.close();
			}
			if (theConnectionHandler != null && theConnectionHandler.con != null && !theConnectionHandler.con.isClosed()){
				theConnectionHandler.con.close();
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler(thread.getName());
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		try {
			CommitConnectionHandler connection = connections.get(Thread.currentThread());
			if (connection != null && !connection.con.isClosed()){
				connection.con.close();
				connections.remove(Thread.currentThread());
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}

	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler(AutoCommitName);
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}
	
	private static String asString (char[] pw) {
		String result = "";
		for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		}
		return result;
	}

	private final String DatabaseProtocol = "jdbc:oracle:thin:@";

	private String schemaName;
	protected Connection con;
	private String name;

    public CreateMObjectCommandFacade theCreateMObjectCommandFacade;
    public CreateUnitTypeCommandFacade theCreateUnitTypeCommandFacade;
    public MComplexTypeFacade theMComplexTypeFacade;
    public MAbstractSumTypeFacade theMAbstractSumTypeFacade;
    public CreateAspectCommandFacade theCreateAspectCommandFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public AbsOperationFacade theAbsOperationFacade;
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
    public MEmptyProductTypeFacade theMEmptyProductTypeFacade;
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

	protected ConnectionHandler(String name) throws PersistenceException {
		this.name = name;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public String getName(){
		return this.name;
	}
	
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
		try {
			this.schemaName = currentSchemaName;
			this.con = new Connection(DriverManager.getConnection(this.DatabaseProtocol + databaseName, user, asString(pw)));
			this.con.setAutoCommit(autoCommit);
			CallableStatement callable = this.con.prepareCall("Begin " + this.schemaName + ".ClassFacade.initialize; end;");
			callable.execute();
			callable.close();
            this.theCreateMObjectCommandFacade= new CreateMObjectCommandFacade(this.schemaName, this.con);
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade(this.schemaName, this.con);
            this.theMComplexTypeFacade= new MComplexTypeFacade(this.schemaName, this.con);
            this.theMAbstractSumTypeFacade= new MAbstractSumTypeFacade(this.schemaName, this.con);
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade(this.schemaName, this.con);
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade(this.schemaName, this.con);
            this.theAbsOperationFacade= new AbsOperationFacade(this.schemaName, this.con);
            this.theCompoundQuantityFacade= new CompoundQuantityFacade(this.schemaName, this.con);
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade(this.schemaName, this.con);
            this.theRemoveAssoFrmHierCommandFacade= new RemoveAssoFrmHierCommandFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theMAtomicTypeFacade= new MAtomicTypeFacade(this.schemaName, this.con);
            this.theCompUnitTypeFacade= new CompUnitTypeFacade(this.schemaName, this.con);
            this.theMProductTypeFacade= new MProductTypeFacade(this.schemaName, this.con);
            this.theMeasurementFacade= new MeasurementFacade(this.schemaName, this.con);
            this.theAssociationFacade= new AssociationFacade(this.schemaName, this.con);
            this.theRemoveLinkCommandFacade= new RemoveLinkCommandFacade(this.schemaName, this.con);
            this.theFormalParameterFacade= new FormalParameterFacade(this.schemaName, this.con);
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade(this.schemaName, this.con);
            this.theOperationManagerFacade= new OperationManagerFacade(this.schemaName, this.con);
            this.theMEmptyProductTypeFacade= new MEmptyProductTypeFacade(this.schemaName, this.con);
            this.theQuantifObjectFacade= new QuantifObjectFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade(this.schemaName, this.con);
            this.theCreateMeasurementTypeCommandFacade= new CreateMeasurementTypeCommandFacade(this.schemaName, this.con);
            this.theMMeasurementTypeFacade= new MMeasurementTypeFacade(this.schemaName, this.con);
            this.theMQuantiObjectTypeFacade= new MQuantiObjectTypeFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theAccountTypeManagerFacade= new AccountTypeManagerFacade(this.schemaName, this.con);
            this.theMObjectFacade= new MObjectFacade(this.schemaName, this.con);
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade(this.schemaName, this.con);
            this.theInstanceObjectFacade= new InstanceObjectFacade(this.schemaName, this.con);
            this.theRemoveFpCommandFacade= new RemoveFpCommandFacade(this.schemaName, this.con);
            this.theMBooleanFacade= new MBooleanFacade(this.schemaName, this.con);
            this.theMessageFacade= new MessageFacade(this.schemaName, this.con);
            this.theMAbstractProductTypeFacade= new MAbstractProductTypeFacade(this.schemaName, this.con);
            this.theFunctionFacade= new FunctionFacade(this.schemaName, this.con);
            this.theAspectManagerFacade= new AspectManagerFacade(this.schemaName, this.con);
            this.theRemoveOperationCommandFacade= new RemoveOperationCommandFacade(this.schemaName, this.con);
            this.theCreateConstantCommandFacade= new CreateConstantCommandFacade(this.schemaName, this.con);
            this.theLinkFacade= new LinkFacade(this.schemaName, this.con);
            this.theMAspectFacade= new MAspectFacade(this.schemaName, this.con);
            this.theAccountManagerFacade= new AccountManagerFacade(this.schemaName, this.con);
            this.theMSumTypeFacade= new MSumTypeFacade(this.schemaName, this.con);
            this.theCompUnitFacade= new CompUnitFacade(this.schemaName, this.con);
            this.theCreateMessageCommandFacade= new CreateMessageCommandFacade(this.schemaName, this.con);
            this.theCreateAccountTypeCommandFacade= new CreateAccountTypeCommandFacade(this.schemaName, this.con);
            this.theOperationFacade= new OperationFacade(this.schemaName, this.con);
            this.theConversionManagerFacade= new ConversionManagerFacade(this.schemaName, this.con);
            this.theQuantityManagerFacade= new QuantityManagerFacade(this.schemaName, this.con);
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade(this.schemaName, this.con);
            this.theCreateProductTypeCommandFacade= new CreateProductTypeCommandFacade(this.schemaName, this.con);
            this.theCreateStaticOpCommandFacade= new CreateStaticOpCommandFacade(this.schemaName, this.con);
            this.theAssociationManagerFacade= new AssociationManagerFacade(this.schemaName, this.con);
            this.theCreateAccountCommandFacade= new CreateAccountCommandFacade(this.schemaName, this.con);
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade(this.schemaName, this.con);
            this.theCreateAtomicSubTypeCommandFacade= new CreateAtomicSubTypeCommandFacade(this.schemaName, this.con);
            this.theAbsQuantityFacade= new AbsQuantityFacade(this.schemaName, this.con);
            this.theCreateVoidOperationCommandFacade= new CreateVoidOperationCommandFacade(this.schemaName, this.con);
            this.theCreateLinkCommandFacade= new CreateLinkCommandFacade(this.schemaName, this.con);
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade(this.schemaName, this.con);
            this.theRemoveAssociationCommandFacade= new RemoveAssociationCommandFacade(this.schemaName, this.con);
            this.theHierarchyFacade= new HierarchyFacade(this.schemaName, this.con);
            this.theMAccountTypeFacade= new MAccountTypeFacade(this.schemaName, this.con);
            this.theAddFpCommandFacade= new AddFpCommandFacade(this.schemaName, this.con);
            this.theCreateStaticMessageCommandFacade= new CreateStaticMessageCommandFacade(this.schemaName, this.con);
            this.theTypeManagerFacade= new TypeManagerFacade(this.schemaName, this.con);
            this.theMessageManagerFacade= new MessageManagerFacade(this.schemaName, this.con);
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade(this.schemaName, this.con);
            this.theMTypeFacade= new MTypeFacade(this.schemaName, this.con);
            this.theCreateVoidMessageCommandFacade= new CreateVoidMessageCommandFacade(this.schemaName, this.con);
            this.theAbsUnitFacade= new AbsUnitFacade(this.schemaName, this.con);
            this.theAddAssociationCommandFacade= new AddAssociationCommandFacade(this.schemaName, this.con);
            this.theCreateConstCommandFacade= new CreateConstCommandFacade(this.schemaName, this.con);
            this.theFractionManagerFacade= new FractionManagerFacade(this.schemaName, this.con);
            this.theCreateOperationCommandFacade= new CreateOperationCommandFacade(this.schemaName, this.con);
            this.theConversionFacade= new ConversionFacade(this.schemaName, this.con);
            this.theReferenceFacade= new ReferenceFacade(this.schemaName, this.con);
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade(this.schemaName, this.con);
            this.theReferenceTypeFacade= new ReferenceTypeFacade(this.schemaName, this.con);
            this.theAccountFacade= new AccountFacade(this.schemaName, this.con);
            this.theUnitTypeFacade= new UnitTypeFacade(this.schemaName, this.con);
            this.theMFalseFacade= new MFalseFacade(this.schemaName, this.con);
            this.theMeasurementTypeManagerFacade= new MeasurementTypeManagerFacade(this.schemaName, this.con);
            this.theMEmptySumTypeFacade= new MEmptySumTypeFacade(this.schemaName, this.con);
            this.theLinkManagerFacade= new LinkManagerFacade(this.schemaName, this.con);
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade(this.schemaName, this.con);
            this.theMessageOrLinkFacade= new MessageOrLinkFacade(this.schemaName, this.con);
            this.theCreateAtomicRootTypeCommandFacade= new CreateAtomicRootTypeCommandFacade(this.schemaName, this.con);
            this.theMTrueFacade= new MTrueFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theQuantityFacade= new QuantityFacade(this.schemaName, this.con);
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade(this.schemaName, this.con);
            this.theActualParameterFacade= new ActualParameterFacade(this.schemaName, this.con);
            this.theCreateSumTypeCommandFacade= new CreateSumTypeCommandFacade(this.schemaName, this.con);
            this.theRemoveFpFromOpCommandFacade= new RemoveFpFromOpCommandFacade(this.schemaName, this.con);
            this.theRemoveMessageCommandFacade= new RemoveMessageCommandFacade(this.schemaName, this.con);
            this.theObjectManagerFacade= new ObjectManagerFacade(this.schemaName, this.con);
            this.theCreateFpCommandFacade= new CreateFpCommandFacade(this.schemaName, this.con);
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		Connection con = this.getConnection();
		CallableStatement callable;
		try {
			callable = con.prepareCall("Begin " + this.schemaName + ".ClassFacade.deleteObject(?,?); end;");
            callable.setLong(1, object.getId());
            callable.setLong(2, object.getClassId());
			callable.execute();
			callable.close();
		} catch (SQLException se) {
	           throw new PersistenceException(se.getMessage(), se.getErrorCode());
	    }
	}

	
	public Connection getConnection(){
		return this.con;
	}
	
}
