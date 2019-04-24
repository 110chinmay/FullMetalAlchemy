package com.central;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MastanPOJO.Brotherhood;

public class DaoAlchemy {
	static Connection con;
	static Statement statement;
	static PreparedStatement preparedStatement;

	public static Connection open(){
		try{
			//step1 load the driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.sqlite.JDBC");

			//step2 create  the connection object
		    con = DriverManager.getConnection("jdbc:sqlite:E:\\testdb.db");
		     statement = con.createStatement();

		    	statement.execute("CREATE TABLE IF NOT EXISTS employees (EMPLOYEE_ID INTEGER,'FIRST_NAME' TEXT,LAST_NAME TEXT,EMAIL TEXT,PHONE_NUMBER TEXT,HIRE_DATE NUMERIC)");
		    	//statement.execute("Insert into employees (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE) values (1,'Chinmay','Hendre','chinmay@gmail.com','987544655','05-03-2018')");
		}catch(Exception e){ System.out.println(e);}
		return con;
	}

	public List<Brotherhood> fetchAllData(){

		List<Brotherhood> list = new ArrayList<Brotherhood>();

		//step3 create the statement object

		try {
			System.out.println("in the list structure");
//			preparedStatement = con.prepareStatement("select * from employees");
//			ResultSet rs = preparedStatement.executeQuery();

			statement = con.createStatement();
		      ResultSet rs = statement.executeQuery( "SELECT * FROM employees;" );
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Brotherhood fetchEdit(String id){
		System.out.println("String update id Dao"+id);
		Brotherhood BH = new Brotherhood();
		try {
			statement = con.createStatement();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BH;


	}




}
