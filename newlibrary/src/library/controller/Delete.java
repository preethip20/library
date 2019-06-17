package library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.database.Dataconnection;
import library.model.Addbook1;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		Addbook1 add=new Addbook1();
		add.setBookid(bookid);
		add.setBookname(bookname);
		Dataconnection d=new Dataconnection();
		int bookdelete=d.deletebook(add);
		if(bookdelete!=0)  
		 {
		 d.setauditmsg7(bookname);
		 out.println("<script type=\"text/javascript\">");
		 out.println("alert('Book deleted successfully');");
		 out.println("location='adminview.jsp';");
		 out.println("</script>");	
		 }
		else
		{
			out.println("<script type=\"text/javascript\">");
			 out.println("alert('Book not deleted');");
			 out.println("location='adminview.jsp';");
			 out.println("</script>");	
		}
	}

}
