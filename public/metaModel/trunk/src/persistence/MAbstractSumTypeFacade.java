package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class MAbstractSumTypeFacade{

	private String schemaName;
	private Connection con;

	public MAbstractSumTypeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}


}

