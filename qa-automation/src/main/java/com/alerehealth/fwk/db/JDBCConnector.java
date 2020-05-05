package com.alerehealth.fwk.db;

import com.alerehealth.fwk.common.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnector {
 
	
	public static Connection conn = null;

	/**
	 * Helper method to open JDBC connection
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(String dbHost,String db, String userName, String password) throws Exception{

			Class.forName(Constants.DB_JDBC_DRIVER);



			String dbURL = "jdbc:oracle:thin:@"+dbHost+":1521/"+db;

			

			try {
				conn = DriverManager.getConnection(dbURL, userName, password);

			}catch (Exception e){

				e.printStackTrace();

				throw e;
			}

			return conn;

	}



	/**
	 * Helper method to close connection
	 * @param conn
	 */
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}


}

