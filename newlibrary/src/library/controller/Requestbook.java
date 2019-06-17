package library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.database.Dataconnection;
import library.model.*;


/**
 * Servlet implementation class Requestbook
 */
@WebServlet("/Requestbook")
public class Requestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Requestbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		System.out.println("user id "+userid+"book id "+bookid);
		Addrequest ar=new Addrequest();
		Addbook1 add=new Addbook1();
		Dataconnection d=new Dataconnection();
		ar.setBookid(bookid);
		ar.setUserid(userid);
		add.setBookname(bookname);
		int i1=d.booksavailable(bookid);
		int i2=d.noduplicates(ar);
		System.out.println("Value of i2="+i2);
		 if(i2==2)
		 {
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('Book requested already..cant be requested again');");	
			 out.println("location='request.jsp';");
			 out.println("</script>");
		 }
		 else if(i1>0)
		 {
			  d.addrequest(ar); 
			 // d.updateavailablebook(bookid);
			  d.setauditmsg4(bookname,userid);
			  out.println("<script type=\"text/javascript\">");
			  out.println("alert('Book requested...');");
			  out.println("location='request.jsp';");
			  out.println("</script>");
		 }
		 else
		 {
			  out.println("<script type=\"text/javascript\">");
			  out.println("alert('Request failed...');");
			  out.println("location='request.jsp';");
			  out.println("</script>");
		 }
	}

}
