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

			stat_1.execute("CREATE TABLE IF NOT EXISTS employees (EMPLOYEE_ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,EMAIL TEXT,PHONE_NUMBER TEXT,HIRE_DATE NUMERIC)");
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


	public String insert(Brotherhood data) throws ClassNotFoundException {
		String sql = "Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER) VALUES (?,?,?,?)";

		try {
			Connection con2 = DbConnect.getConnection();

			PreparedStatement state = con2.prepareStatement(sql);
			state.setString(1,data.getFIRST_NAME());
			state.setString(2,data.getLAST_NAME());
			state.setString(3,data.getEMAIL());
			state.setString(4,data.getPHONE_NUMBER());
			int rs=state.executeUpdate();

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


	public String update(Brotherhood data) throws ClassNotFoundException {
		String sql = "update EMPLOYEES set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PHONE_NUMBER=? where EMPLOYEE_ID = ?";

		try {
			Connection con2 = DbConnect.getConnection();

			PreparedStatement state = con2.prepareStatement(sql);
			state.setString(1,data.getFIRST_NAME());
			state.setString(2,data.getLAST_NAME());
			state.setString(3,data.getEMAIL());
			state.setString(4,data.getPHONE_NUMBER());
			state.setInt(5,data.getEMPLOYEE_ID());
			int rs=state.executeUpdate();

			state.close();
			DbConnect.closeConnection(con2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Insert";
	}

	public int delete(int id) {
		Connection con = null;
		int delStatus1= 0;
		String sql="delete from employees where EMPLOYEE_ID = ?";
		try {
			con = DbConnect.getConnection();
			PreparedStatement prepareStatement =  con.prepareStatement(sql);
			prepareStatement.setInt(1,id);
			  delStatus1 = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delStatus1;

	}




}
