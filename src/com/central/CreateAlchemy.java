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

import com.google.gson.Gson;


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
		
	String action = null;

		System.out.println("CAll in the doget method");
		
		String test = request.getParameter("update");
		System.out.println("request get parameter test"+test);

		
		if("update".equals(request.getParameter("update"))) {
			System.out.println("In if call");
			action = request.getParameter("update");
			System.out.println("called action data for url ===>"+action);
		}
		
		else if("update".equals(request.getParameter("delete"))) {
			 action = request.getParameter("delete");
			System.out.println("called action data for url ===>"+action);
		}
		

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);

		String Fname = request.getParameter("Fname");
		System.out.println(Fname);
		String Lname = request.getParameter("Lname");
		System.out.println(Lname);
		String email = request.getParameter("email");
		System.out.println(email);
		String phone = request.getParameter("phone");
		System.out.println(phone);
//		String checkbox = request.getParameter("checkbox");
//		String optradio = request.getParameter("optradio");
//		String selected = request.getParameter("selected");
		
		
		
		Brotherhood bh = new Brotherhood(Fname,Lname,email,phone);
		DaoAlchemy doaInsert = new DaoAlchemy();
		String result;
		try {
			result = doaInsert.insert(bh);
			System.out.println(result);
			
			 response.setCharacterEncoding("UTF-8");
	         response.setContentType("application/json; charset=utf-8");

	         Gson gson = new Gson();

	         String jsonData = gson.toJson(result);

	         PrintWriter out = response.getWriter();
	         
	    	 System.out.println("URL data222"+result);
			 out.println("JSON reponse for the servlet in INSERT"+jsonData);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
       PrintWriter pw = response.getWriter();

		/*DaoAlchemy dbconfig = new DaoAlchemy();
		Connection status = doaInsert.open();
		if(status != null){*/
			 List<Brotherhood> ls = doaInsert.fetchAllData();
			System.out.println(ls);

			request.setAttribute("list", ls);
			RequestDispatcher rd = request.getRequestDispatcher("createAlchemyTable.jsp");

			rd.forward(request, response);
	}

	protected void editAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In the edit system call for editAlchemy");
		String id = request.getParameter("id");
		DaoAlchemy daoId = new DaoAlchemy();
		 Brotherhood updateResult = daoId.fetchEdit(id);
		 System.out.println("URL data111"+updateResult);

		 response.setCharacterEncoding("UTF-8");
         response.setContentType("application/json; charset=utf-8");

         Gson gson = new Gson();

         String jsonData = gson.toJson(updateResult);

         PrintWriter out = response.getWriter();

		 System.out.println("URL data222"+updateResult);
		 out.println(jsonData);
	}

	protected void deleteAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Called the delete button ");
	}



}
