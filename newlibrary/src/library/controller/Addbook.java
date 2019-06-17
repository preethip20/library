package library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.database.*;
import library.model.*;
/**
 * Servlet implementation class Addbook
 */
@WebServlet("/Addbook")
public class Addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bookname=request.getParameter("bookname");
		String description=request.getParameter("description");
		String author=request.getParameter("author");
		String price=request.getParameter("price");
		String publisher=request.getParameter("publisher");
		String noofcopies=request.getParameter("noofcopies");
		Addbook1 add=new Addbook1();
		add.setBookname(bookname);
		add.setDescription(description);
		add.setAuthor(author);
		add.setPrice(price);
		add.setPublisher(publisher);
		add.setNoofcopies(noofcopies);
		add.setAvailable(noofcopies);
		Dataconnection d=new Dataconnection();
		int d1=d.findbook(add);
		if(d1==2)
		{
			 d.setauditmsg1(bookname);
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('Book added successfully');");	
			 out.println("location='addbook.jsp';");
			 out.println("</script>");
		}
		else
		{
			 System.out.println("Book not added");
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('Book not added');");	
			 out.println("location='addbook.jsp';");
			 out.println("</script>");
		}
	}

}
