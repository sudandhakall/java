import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
public class DBManager {
	Connection conn; //for connection
	Statement stmt;//to execute query
	public DBManager() throws Exception {
	String url="jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=javaDB;";
	DriverManager.registerDriver(new SQLServerDriver()); //register drivers
	conn = DriverManager.getConnection (url, "sa", "sudan123");
	stmt = conn.createStatement();
	}
	public void insertUpdateDelete(String query) throws Exception {
		stmt.execute(query);
	}
	public ResultSet select(String query) throws Exception{
		ResultSet objRes = stmt.executeQuery(query);
		return objRes;
	}

}
