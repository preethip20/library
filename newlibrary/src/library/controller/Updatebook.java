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
 * Servlet implementation class Updatebook
 */
@WebServlet("/Updatebook")
public class Updatebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatebook() {
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
		String bookname=request.getParameter("bookname");
		String description=request.getParameter("description");
		String author=request.getParameter("author");
		String price=request.getParameter("price");
		String publisher=request.getParameter("publisher");
		String noofcopies=request.getParameter("noofcopies");
		System.out.println("bookname="+bookname+"description="+description+"author="+author+"price="+price+"publisher="+publisher);
		String bookid=request.getParameter("bookid");
		System.out.println("id="+bookid);
		Addbook1 book1=new Addbook1();
		book1.setBookname(bookname);
		book1.setDescription(description);
		book1.setAuthor(author);
		book1.setPrice(price);
		book1.setPublisher(publisher);
		book1.setNoofcopies(noofcopies);
		Dataconnection d=new Dataconnection();
		int status1=d.updatebook(book1,bookid);
		if(status1!=0)
		{
			 d.setauditmsg6(bookname);
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('Updated successfully');");
			 out.println("location='adminview.jsp';");
			 out.println("</script>");	
		}
	}

}
