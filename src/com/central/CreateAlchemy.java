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

		if("fetch".equals(request.getParameter("fetch"))) {
			System.out.println("In if call for fetch");
			action = request.getParameter("fetch");
			System.out.println("called action data for url ===>"+action);
		}
		else if("delete".equals(request.getParameter("delete"))) {
			 action = request.getParameter("delete");
			System.out.println("called action data for url ===>"+action);
		}
		else if("update".equals(request.getParameter("update"))) {
			System.out.println("In if call for update");
			action = request.getParameter("update");
			System.out.println("called action data for url ===>"+action);

		}else if("list".equals(request.getParameter("list"))) {
			System.out.println("In if call for list");
			action = request.getParameter("list");
			System.out.println("called action data for url ===>"+action);
		}


		try {
            switch(action){
            case "null":
            	listAlchemy(request,response);
                break;
            case "fetch":
            	editAlchemy(request,response);
                break;
            case "delete":
                deleteAlchemy(request, response);
                break;
            case "list":
            	listAlchemy(request,response);
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
		String action = null;
		DaoAlchemy doaInsert = new DaoAlchemy();
		if ("update".equals(request.getParameter("update"))) {
			action = "update";
			int empId = Integer.parseInt(request.getParameter("id"));
			System.out.println(empId);
			String Fname = request.getParameter("fname");
			System.out.println(Fname);
			String Lname = request.getParameter("lname");
			System.out.println(Lname);
			String email = request.getParameter("email");
			System.out.println(email);
			String phone = request.getParameter("phone");
			System.out.println(phone);

			Brotherhood bh = new Brotherhood(empId,Fname, Lname, email, phone);
			try {
				String result = doaInsert.update(bh);
			} catch (ClassNotFoundException e) {
				//	 TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			String Fname = request.getParameter("fname");
			System.out.println("Fname"+Fname);
			String Lname = request.getParameter("lname");
			System.out.println("Lname"+Lname);
			String email = request.getParameter("email");
			System.out.println("email"+email);
			String phone = request.getParameter("phone");
			System.out.println("phone"+phone);

			Brotherhood bh = new Brotherhood(Fname,Lname,email,phone);

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
				 out.println(jsonData);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	protected void editAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In the edit system call for editAlchemy");
		String id = request.getParameter("id");
		DaoAlchemy daoId = new DaoAlchemy();
		 Brotherhood fetchResult = daoId.fetchEdit(id);
		 System.out.println("URL data111"+fetchResult);

		 response.setCharacterEncoding("UTF-8");
         response.setContentType("application/json; charset=utf-8");

         Gson gson = new Gson();

         String jsonData = gson.toJson(fetchResult);

         PrintWriter out = response.getWriter();

		 System.out.println("URL data222"+fetchResult);
		 out.println(jsonData);
	}

	protected void deleteAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1= request.getParameter("EMPLOYEE_ID");
		System.out.println(id1);
		int id = Integer.parseInt(id1.trim());
		DaoAlchemy daoId = new DaoAlchemy();
		int ls = daoId.delete(id);
		 response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json; charset=utf-8");

	        Gson gson = new Gson();

	        String jsonData = gson.toJson(ls);

	        PrintWriter out = response.getWriter();

	        out.println(jsonData);
	}


	protected void listAlchemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("After the if else statement");
		PrintWriter pw = response.getWriter();
		DaoAlchemy doalist = new DaoAlchemy();
		 List<Brotherhood> ls = doalist.fetchAllData();
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        Gson gson = new Gson();

        String jsonData = gson.toJson(ls);

        PrintWriter out = response.getWriter();

        out.println(jsonData);
	}




}
