package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.RegistrationDao;
import com.library.model.Student;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
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
	/*	Connection con = null;
		try{
			if(request.getAttribute("myDBConnection")!=null){
				con=(Connection)request.getAttribute("myDBConnection");
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}*/
		/*int i=0;
		Student st = new Student();
		st.setName(request.getParameter("name"));
		st.setEmail(request.getParameter("email"));
		st.setPassword(request.getParameter("password"));
		st.setContact(request.getParameter("contact"));
		st.setAddress(request.getParameter("address"));
		RegistrationDao rgDao = new RegistrationDao();
		i=rgDao.AddStudent(st);
		if(i!=0){
			System.out.println("Registration successfull");
			request.setAttribute("student", st);
			request.setAttribute("msg", "Login ID: "+st.getEmail()+"<br>Password: "+st.getPassword()+"<br>Contact No.:"+st.getContact()+"<br>Password: "+st.getPassword());
			response.sendRedirect("registrationsuccess.jsp");
		}
	}*/
		   PrintWriter out = response.getWriter();
		 	String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String contact = request.getParameter("contact");
	        String address = request.getParameter("address");
	        if (name == null || name.isEmpty() || name == "" || email == null || email.isEmpty() || email == "" || password == null || password.isEmpty() || password == "" || contact == null || contact.isEmpty() || contact == "" || address == null || address.isEmpty() || address == "") {
	            request.setAttribute("error", "Name, Email, and Password are required fields.");
	            System.out.println("Registration failed");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }else{

	        // Additional validation for email format and password strength can be added here.

	        // If validation passed, proceed with database operation
	        Student st = new Student();
	        st.setName(name);
	        st.setEmail(email);
	        st.setPassword(password);
	        st.setContact(contact);
	        st.setAddress(address);

	        RegistrationDao rgDao = new RegistrationDao();
	        int i = rgDao.AddStudent(st);

	        if (i != 0) {
	            System.out.println("Registration successful");
	            request.setAttribute("student", st);
	            request.setAttribute("msg", "Login ID: " + st.getEmail() + "<br>Password: " + st.getPassword() + "<br>Contact No.:" + st.getContact() + "<br>Password: " + st.getPassword());
	            request.getRequestDispatcher("registrationsuccess.jsp").forward(request, response);
	           }
	      }
	}	
		
		
		

}
