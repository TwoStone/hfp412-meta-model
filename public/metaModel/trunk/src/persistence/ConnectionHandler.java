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
            this.theConversionManagerFacade= new ConversionManagerFacade(this.schemaName, this.con);
            this.theQuantityManagerFacade= new QuantityManagerFacade(this.schemaName, this.con);
            this.theAbsUnitTypeFacade= new AbsUnitTypeFacade(this.schemaName, this.con);
            this.theAssociationManagerFacade= new AssociationManagerFacade(this.schemaName, this.con);
            this.theCreateUnitTypeCommandFacade= new CreateUnitTypeCommandFacade(this.schemaName, this.con);
            this.theMComplexTypeFacade= new MComplexTypeFacade(this.schemaName, this.con);
            this.theCreateConversionCommandFacade= new CreateConversionCommandFacade(this.schemaName, this.con);
            this.theAbsQuantityFacade= new AbsQuantityFacade(this.schemaName, this.con);
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade(this.schemaName, this.con);
            this.theMAHierarchyFacade= new MAHierarchyFacade(this.schemaName, this.con);
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade(this.schemaName, this.con);
            this.theCreateCompUnitCommandFacade= new CreateCompUnitCommandFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theCreateCompUnitTypeCommandFacade= new CreateCompUnitTypeCommandFacade(this.schemaName, this.con);
            this.theTypeManagerFacade= new TypeManagerFacade(this.schemaName, this.con);
            this.theUnitTypeManagerFacade= new UnitTypeManagerFacade(this.schemaName, this.con);
            this.theCompoundQuantityFacade= new CompoundQuantityFacade(this.schemaName, this.con);
            this.theAddDefaultUnitCommandFacade= new AddDefaultUnitCommandFacade(this.schemaName, this.con);
            this.theAbsUnitFacade= new AbsUnitFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theMAtomicTypeFacade= new MAtomicTypeFacade(this.schemaName, this.con);
            this.theCreateAtomicTypeCommandFacade= new CreateAtomicTypeCommandFacade(this.schemaName, this.con);
            this.theFractionManagerFacade= new FractionManagerFacade(this.schemaName, this.con);
            this.theConversionFacade= new ConversionFacade(this.schemaName, this.con);
            this.theReferenceFacade= new ReferenceFacade(this.schemaName, this.con);
            this.theCreateSubTypeCommandFacade= new CreateSubTypeCommandFacade(this.schemaName, this.con);
            this.theCompUnitTypeFacade= new CompUnitTypeFacade(this.schemaName, this.con);
            this.theMProductTypeFacade= new MProductTypeFacade(this.schemaName, this.con);
            this.theFinishModelingCommandFacade= new FinishModelingCommandFacade(this.schemaName, this.con);
            this.theReferenceTypeFacade= new ReferenceTypeFacade(this.schemaName, this.con);
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theUnitFacade= new UnitFacade(this.schemaName, this.con);
            this.theUnitTypeFacade= new UnitTypeFacade(this.schemaName, this.con);
            this.theMFalseFacade= new MFalseFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theMAssociationFacade= new MAssociationFacade(this.schemaName, this.con);
            this.theCreateQuantityCommandFacade= new CreateQuantityCommandFacade(this.schemaName, this.con);
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade(this.schemaName, this.con);
            this.theMBooleanFacade= new MBooleanFacade(this.schemaName, this.con);
            this.theMTrueFacade= new MTrueFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theQuantityFacade= new QuantityFacade(this.schemaName, this.con);
            this.theAddReferenceTypeCommandFacade= new AddReferenceTypeCommandFacade(this.schemaName, this.con);
            this.theFunctionFacade= new FunctionFacade(this.schemaName, this.con);
            this.theAspectManagerFacade= new AspectManagerFacade(this.schemaName, this.con);
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade(this.schemaName, this.con);
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade(this.schemaName, this.con);
            this.theMAspectFacade= new MAspectFacade(this.schemaName, this.con);
            this.theMSumTypeFacade= new MSumTypeFacade(this.schemaName, this.con);
            this.theCompUnitFacade= new CompUnitFacade(this.schemaName, this.con);
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
