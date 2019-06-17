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
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("iuserid");
		String bookid=request.getParameter("bookid");
		String bookname=request.getParameter("bookname");
		System.out.println("issue id "+userid+"book id "+bookid+"bookname="+bookname);
		Dataconnection d=new Dataconnection();
		int i=d.returnbook(bookid,userid);
		d.deletefrombookissue(bookid, userid);
		if(i!=0)
		{
			 //  d.increaseavailable(bookid);
			   d.setauditmsg5(bookname,userid);
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book returned successfully...');");
			   out.println("location='returnbook.jsp';");
			   out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book not returned...');");
			   out.println("location='returnbook.jsp';");
			   out.println("</script>");
		}
	}

}
