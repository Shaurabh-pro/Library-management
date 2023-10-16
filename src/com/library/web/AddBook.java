package com.library.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.library.Dao.BookDao;
import com.library.model.Book;


/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		Book book=new Book();
		book.setCallno(request.getParameter("callno"));
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		book.setPublisher(request.getParameter("publisher"));

		/*int quantity = Integer.parseInt(request.getParameter("quantity"));
		int issued = Integer.parseInt(request.getParameter("issued"));
	    book.setQuantity(quantity);
	    book.setIssued(issued);*/
		
		String quantityParam = request.getParameter("quantity");
		String issuedParam = request.getParameter("issued");

		int quantity = 0;  // Default value if parameter is null
		int issued = 0;    // Default value if parameter is null

		if (quantityParam != null) {
		    try {
		        quantity = Integer.parseInt(quantityParam);
		    } catch (NumberFormatException e) {
		        // Handle the case where 'quantityParam' is not a valid integer
		    }
		}

		if (issuedParam != null) {
		    try {
		        issued = Integer.parseInt(issuedParam);
		    } catch (NumberFormatException e) {
		        // Handle the case where 'issuedParam' is not a valid integer
		    }
		}

		book.setQuantity(quantity);
		book.setIssued(issued);

		
		
		/*book.setQuantity(request.getParameter("quantity"));
		book.setIssued(request.getParameter("issued"));*/
		
		
		/*String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String quantity=request.getParameter("quantity");
		Book book=new Book(callno, name, author, publisher, quantity);*/
		int i = BookDao.save(book);
		if(i!=0){
			out.println("<h3>Book saved successfully</h3>");
		}
		System.out.println("plz try again");
		request.getRequestDispatcher("addbookform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	

}
