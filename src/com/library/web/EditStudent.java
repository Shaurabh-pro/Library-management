package com.library.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.StudentDao;
import com.library.model.Student;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
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
		
		String sTid=request.getParameter("id");
		int id=Integer.parseInt(sTid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		/*String password=request.getParameter("password");*/
		String contact = request.getParameter("contact");
		String address =request.getParameter("address");
		Student bean=new Student(id, name, email, contact, address);
		StudentDao.updateStudent(bean);
		response.sendRedirect("ViewAllStudents");
	}

}
