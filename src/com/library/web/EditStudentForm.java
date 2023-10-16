package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.StudentDao;
import com.library.model.Student;

/**
 * Servlet implementation class EditStudentForm
 */
@WebServlet("/EditStudentForm")
public class EditStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit Librarian Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
	
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		/*out.println("<h3>Updadte Student Details<h3/>");*/
		out.println("<div class='container'>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Student bean=StudentDao.viewStudentById(id);
		out.print("<form action='EditStudent' method='post' style='width:300px'>");
		
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		
		out.print("<label for='name1'>Name</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email address</label>");
		out.print("<input type='email' class='form-control' value='"+bean.getEmail()+"'  name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		
		/*out.print("<div class='form-group'>");
		out.print("<label for='password1'>Password</label>");
		out.print("<input type='password' class='form-control' value='"+bean.getPassword()+"'  name='password' id='password1' placeholder='Password'/>");
		out.print("</div>  ");*/
		
		out.print("<div class='form-group'>");
		out.print("<label for='contact1'>contact</label>");
		out.print("<input type='number' class='form-control' value='"+bean.getContact()+"'  name='contact' id='contact1' placeholder='contact'/>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='address1'>Address</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getAddress()+"'  name='address' id='address1' placeholder='address'/>");
		out.print("</div>");
		
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
