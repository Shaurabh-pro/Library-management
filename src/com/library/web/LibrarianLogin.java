package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.Dao.StudentDao;
import com.library.model.Student;
import com.library.utility.DB;

@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Connection con= null;
		try{
			if(request.getAttribute("myDBConnection")!=null){
				con = (Connection)request.getAttribute("myDBConnection");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		try{
		Connection con=DB.getCon();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Librarian Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		Student stu = new Student();
		stu.setEmail(request.getParameter("email"));
		stu.setPassword(request.getParameter("password"));
		StudentDao stDao = new StudentDao();
		Student st = stDao.StudentLogin(stu, con);
		
		String email=request.getParameter("email");
		 String password=request.getParameter("password");
		
		 /* if(LibrarianDao.authenticate(email, password,null)){
			HttpSession session=request.getSession();
			session.setAttribute("email",email);
			request.getRequestDispatcher("navlibrarian.html").include(request, response);
			request.getRequestDispatcher("librariancarousel.html").include(request, response);*/
			
		/*if(email.equals("user@gmail.com")&& password.equals("user123")){
			HttpSession session=request.getSession();
			session.setAttribute("user","true");
			request.getRequestDispatcher("navlibrarian.html").include(request, response);
			request.getRequestDispatcher("librariancarousel.html").include(request, response);
			*/
		 	/*if(email.equals(email)&& password.equals(password)){
			 HttpSession session=request.getSession();
				session.setAttribute("user","true");
				request.getRequestDispatcher("navlibrarian.html").include(request, response);
				request.getRequestDispatcher("librariancarousel.html").include(request, response); }*/
		

			/*Student stu = new Student();
			stu.setEmail(request.getParameter("email"));
			stu.setPassword(request.getParameter("password"));
			StudentDao lgDao = new StudentDao();
		    Student st = lgDao.StudentLogin(stu, con);*/
		 if ( email == null || email.isEmpty() || email == "" || password == null || password.isEmpty() || password == "") {
	           /* request.setAttribute("error", "Name, Email, and Password are required fields.");
	            System.out.println("Registration failed");
	            request.getRequestDispatcher("error.jsp").forward(request, response);*/
			 request.getRequestDispatcher("navhome.html").include(request, response);
				out.println("<div class='container'>");
				out.println("<h3> Incorrect Username or password</h3>");
				request.getRequestDispatcher("librarianloginform.html").include(request, response);
				out.println("</div>");
	        }
		
		 else if(st!=null) {
			System.out.println("Login seccessfull");
			request.getRequestDispatcher("navlibrarian.html").include(request, response);
			request.getRequestDispatcher("librariancarousel.html").include(request, response);
	    }/*else{
			request.getRequestDispatcher("navhome.html").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3> Incorrect Username or password</h3>");
			request.getRequestDispatcher("librarianloginform.html").include(request, response);
			out.println("</div>");
		}*/
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
       }catch(Exception e){
    	   e.printStackTrace();
       }
   }
}

