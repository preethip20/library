package library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import library.database.*;
import library.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bookissue
 */
@WebServlet("/Bookissue")
public class Bookissue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookissue() {
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
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Addrequest ar=new Addrequest();
		Addbook1 add=new Addbook1();
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		String userid=request.getParameter("userid");
		String requestid=request.getParameter("requestid");
		System.out.println("book id "+bookid+"user id="+userid+"request id="+requestid);
		Dataconnection d=new Dataconnection();
		add.setBookname(bookname);
		ar.setBookid(bookid);
		ar.setUserid(userid);
		ar.setRequestid(requestid);
		int i1=d.booksavailable(bookid);
		if(i1>0)
		{
			d.addissuedbooks(ar);
			d.setstatus(bookid,bookname,userid);
//		System.out.println("value of i="+i);
//		if(i!=0)
//		{
//			d.updatestatus(bookid);
			d.updateavailablebook(bookid);
			d.setauditmsg2(bookname);
			d.removebook(bookid, requestid);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Book issued successfully');");
			out.println("location='issuebook.jsp';");
			out.println("</script>");
		}
		else
		{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Book not issued');");
				out.println("location='issuebook.jsp';");
			  	out.println("</script>");
		}
		}
	}


