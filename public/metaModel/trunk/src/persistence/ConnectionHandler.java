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
            this.theMProductTypeFacade= new MProductTypeFacade(this.schemaName, this.con);
            this.theTypeManagerFacade= new TypeManagerFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theCreateHierarchyCommandFacade= new CreateHierarchyCommandFacade(this.schemaName, this.con);
            this.theAspectManagerFacade= new AspectManagerFacade(this.schemaName, this.con);
            this.theAddToHierarchyCommandFacade= new AddToHierarchyCommandFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theAddSubTypeCommandFacade= new AddSubTypeCommandFacade(this.schemaName, this.con);
            this.theMFalseFacade= new MFalseFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theAssociationManagerFacade= new AssociationManagerFacade(this.schemaName, this.con);
            this.theMComplexTypeFacade= new MComplexTypeFacade(this.schemaName, this.con);
            this.theMAtomicTypeFacade= new MAtomicTypeFacade(this.schemaName, this.con);
            this.theCreateAspectCommandFacade= new CreateAspectCommandFacade(this.schemaName, this.con);
            this.theCreateAtomicTypeCommandFacade= new CreateAtomicTypeCommandFacade(this.schemaName, this.con);
            this.theMAHierarchyFacade= new MAHierarchyFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theMAspectFacade= new MAspectFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theMSumTypeFacade= new MSumTypeFacade(this.schemaName, this.con);
            this.theMAssociationFacade= new MAssociationFacade(this.schemaName, this.con);
            this.theCreateAssociationCommandFacade= new CreateAssociationCommandFacade(this.schemaName, this.con);
            this.theCreateSubTypeCommandFacade= new CreateSubTypeCommandFacade(this.schemaName, this.con);
            this.theMBooleanFacade= new MBooleanFacade(this.schemaName, this.con);
            this.theMTrueFacade= new MTrueFacade(this.schemaName, this.con);
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
