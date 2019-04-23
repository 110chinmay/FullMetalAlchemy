package com.central;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MastanPOJO.Brotherhood;

/**
 * Servlet implementation class CreateAlchemy
 */
@WebServlet("/CreateAlchemy")
public class CreateAlchemy extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		 try {
//	            switch(){}
//		 }




		String action = request.getParameter("update");

		System.out.println("called update"+action);

		try {
            switch(action){
            case "null":
            	doPost(request,response);
                break;
            case "update":
            	editAlchemy(request,response);
                break;
            case "delete":
                deleteAlchemy(request, response);
                break;
            }
	 } catch (Exception ex) {
            throw new ServletException(ex);
        }

//		String action = request.getServletPath();
//		System.out.println("In the get call for action"+action);

		//System.out.println("In the get call");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

//		String Fname = request.getParameter("Fname");
//		System.out.println(Fname);
//		String Lname = request.getParameter("Lname");
//		System.out.println(Lname);
//		String email = request.getParameter("email");
//		System.out.println(email);
//		String pwd = request.getParameter("pwd");
//		System.out.println(pwd);
//		String checkbox = request.getParameter("checkbox");
//		String optradio = request.getParameter("optradio");
//		String selected = request.getParameter("selected");
        PrintWriter pw = response.getWriter();

		DaoAlchemy dbconfig = new DaoAlchemy();
		Connection status = dbconfig.open();
		if(status != null){
			 List<Brotherhood> ls = dbconfig.fetchAllData();
			System.out.println(ls);

			request.setAttribute("list", ls);
			RequestDispatcher rd = request.getRequestDispatcher("createAlchemyTable.jsp");

			rd.forward(request, response);
		}
		System.out.println("status status"+status);

	}

	protected void editAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DaoAlchemy daoId = new DaoAlchemy();
		 Brotherhood updateResult = daoId.fetchEdit(id);
		 System.out.println("URL data"+updateResult);
		 request.setAttribute("updateResult", updateResult);
		 RequestDispatcher rd = request.getRequestDispatcher("editAlchemy.jsp");
		 rd.forward(request, response);
		 System.out.println("Called the edit");
	}

	protected void deleteAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Called the delete button ");
	}



}
