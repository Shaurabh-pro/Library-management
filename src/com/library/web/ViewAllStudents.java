package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.BookDao;
import com.library.Dao.StudentDao;
import com.library.model.Student;

/**
 * Servlet implementation class ViewAllStudents
 */
@WebServlet("/ViewAllStudents")
public class ViewAllStudents extends HttpServlet {
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
		out.println("<title>List Of Students</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		List<Student> list=StudentDao.viewListOfStudents();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Student Id</th><th>Student Name</th><th>Email</th><th>contact</th><th>Address</th><th>Edit</th><th>Delete</th></tr>");
		for(Student bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getContact()+"</td><td>"+bean.getAddress()+"</td><td><a href='EditStudentForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteStudent?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
