package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	private static Connection con=null;

	private DbConnect() {}

	public static Connection getConnection() {
		System.out.println("In Connection :: getConnection");
		if(con==null) {
			System.out.println("connection is null");
			//step1 load the driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Class.forName("org.sqlite.JDBC");
				//step2 create  the connection object
			    con = DriverManager.getConnection("jdbc:sqlite:E:\\testdb_3.db");
			    System.out.println("new connection has created");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		return con;
	}
	public static void closeConnection(Connection local_con) {
		if(con!=null) {
			try {
				con.close();
				con = null;
				System.out.println("In the close con");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing global connection= "+e);
			}
		}

		if(local_con!=null) {
			try {
				local_con.close();
				local_con = null;
				System.out.println("In the close local_con");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing local_con connection= "+e);
			}
		}

	}

}
