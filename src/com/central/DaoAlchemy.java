package com.central;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.DbConnect;

import MastanPOJO.Brotherhood;

public class DaoAlchemy {

	
	static {
		Connection con_1 = null;
		Statement stat_1 = null;
		try{
			System.out.println("Static Block Executed");
			con_1= DbConnect.getConnection();
			stat_1 = con_1.createStatement();

			stat_1.execute("CREATE TABLE IF NOT EXISTS employees (EMPLOYEE_ID INTEGER,'FIRST_NAME' TEXT,LAST_NAME TEXT,EMAIL TEXT,PHONE_NUMBER TEXT,HIRE_DATE NUMERIC)");
		    	//statement.execute("Insert into employees (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE) values (1,'Chinmay','Hendre','chinmay@gmail.com','987544655','05-03-2018')");
		}catch(Exception e){ 
			System.out.println(e);
		}finally {			
				try {
					if(stat_1!=null)
						stat_1.close();
					DbConnect.closeConnection(con_1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	

	/*public static Connection open(){
		try{
			System.out.println("In Open connection");
			if(con==null) {
				System.out.println("connection is null");
				//step1 load the driver class
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("org.sqlite.JDBC");

				//step2 create  the connection object
			    con = DriverManager.getConnection("jdbc:sqlite:E:\\testdb.db");
			    System.out.println("new connection has created");
			}
		}catch(Exception e){ System.out.println(e);}
		return con;
	}*/
	
	
	public String insert(Brotherhood data) throws ClassNotFoundException {
		String sql = "Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER) VALUES (?,?,?,?)";
		
		
		System.out.println("Called in DaoAlchemy for insert"+data.toString()); 
		try {
			System.out.println("Printing the sql"+sql);
			//Class.forName("org.sqlite.JDBC");
			//con = DriverManager.getConnection("jdbc:sqlite:E:\\testdb.db");
			Connection con2 = DbConnect.getConnection();
			//Connection con2 = DriverManager.getConnection("jdbc:sqlite:E:\\testdb.db");
			System.out.println("conn => " +con2);
			System.out.println(con2);
			PreparedStatement state = con2.prepareStatement(sql);
			state.setString(1,data.getFIRST_NAME());
			state.setString(2,data.getLAST_NAME());
			state.setString(3,data.getEMAIL());
			state.setString(4,data.getPHONE_NUMBER());
			int rs=state.executeUpdate();
			//con2.close();
			state.close();
			DbConnect.closeConnection(con2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Insert";	
	}
	
	

	public List<Brotherhood> fetchAllData(){

		Connection conn = DbConnect.getConnection();
		List<Brotherhood> list = new ArrayList<Brotherhood>();

		try {
			System.out.println("in the list structure");
			
			Statement stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM employees;" );
			while(rs.next()){
				Brotherhood BH = new Brotherhood();
				BH.setEMPLOYEE_ID(rs.getInt(1));
				BH.setFIRST_NAME(rs.getString(2));
				BH.setLAST_NAME(rs.getString(3));
				BH.setEMAIL(rs.getString(4));
				BH.setPHONE_NUMBER(rs.getString(5));
				BH.setHIRE_DATE(rs.getDate(6));
				list.add(BH);
			}
			stmt.close();
			DbConnect.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Brotherhood fetchEdit(String id){
		Connection con = null;
		System.out.println("String update id Dao"+id);
		Brotherhood BH = new Brotherhood();
		try {
			
			con = DbConnect.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM employees where employee_id =?;");
			preparedStatement.setString(1, id);
			 ResultSet rs = preparedStatement.executeQuery();
			 while(rs.next()){
				 	BH.setEMPLOYEE_ID(rs.getInt(1));
					BH.setFIRST_NAME(rs.getString(2));
					BH.setLAST_NAME(rs.getString(3));
					BH.setEMAIL(rs.getString(4));
					BH.setPHONE_NUMBER(rs.getString(5));
					BH.setHIRE_DATE(rs.getDate(6));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnect.closeConnection(con);
		}
		return BH;
	}
	
	




}
