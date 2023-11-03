package employeemanagement.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	static final String JDBC_DRIVER ="Com.mysql.cj.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql:/localhost:3306/projectprep";
	
	static Connection conn;
	
	static final String user ="root";
	static final String password ="abc123@098";
	
	public static Connection createConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,user,password);
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
				return conn;
	}
	
	
	
	

}
