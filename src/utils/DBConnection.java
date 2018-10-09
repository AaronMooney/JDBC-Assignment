package utils;

import java.sql.*;
import java.util.Properties;

public class DBConnection {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "assignment1";
	
	/** The name of the table we are testing with */
	private final String tableName = "Employee";
	
	private PreparedStatement statement = null;
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}
	
	public ResultSet getResult() {
		String query = "SELECT * FROM Employee";
		ResultSet rs = null;
		try {
			statement = getConnection().prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Exception occured in method 'getResult' in class 'DBConnection'");
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closeConnection() {
		if (statement != null) { try {
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception occured in method 'getResult' in class 'DBConnection'");
			e.printStackTrace();
			} 
		}
	}
}
