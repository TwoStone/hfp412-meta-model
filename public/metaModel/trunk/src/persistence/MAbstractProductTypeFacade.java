package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class MAbstractProductTypeFacade{

	private String schemaName;
	private Connection con;

	public MAbstractProductTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}


}

