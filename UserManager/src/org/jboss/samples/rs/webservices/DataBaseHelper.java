package org.jboss.samples.rs.webservices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class DataBaseHelper {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "588pE3BCZ#4kQ@5";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "UserManager";
	
	/** The name of the table we are testing with */
	private final String tableName = "users";
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NamingException 
	 */
	public Connection getConnection() throws SQLException, NamingException {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:jboss/datasources/MySqlDS");
		Connection connection = ds.getConnection();

		return connection;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void run() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create a table
		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INTEGER NOT NULL, " +
			        "USERNAME varchar(40) NOT NULL, " +
			        "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
		
//		try {
//		    String createString =
//			        "INSERT TABLE " + this.tableName + " ( " +
//			        "ID INTEGER NOT NULL, " +
//			        "USERNAME varchar(40) NOT NULL, " +
//			        "PRIMARY KEY (ID))";
//			this.executeUpdate(conn, createString);
//			System.out.println("Created a table");
//	    } catch (SQLException e) {
//			System.out.println("ERROR: Could not create the table");
//			e.printStackTrace();
//			return;
//		}User
		
		// Drop the table
//		try {
//		    String dropString = "DROP TABLE " + this.tableName;
//			this.executeUpdate(conn, dropString);
//			System.out.println("Dropped the table");
//	    } catch (SQLException e) {
//			System.out.println("ERROR: Could not drop the table");
//			e.printStackTrace();
//			return;
//		}
	}
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DataBaseHelper app = new DataBaseHelper();
		app.run();
	}
}
