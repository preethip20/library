package library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.database.*;
import library.model.Login;
/**
 * Servlet implementation class Loginpage
 */
@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginpage() {
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
		 String email = request.getParameter("email");
		 
		 System.out.println("email in controller  "+email);
		 String password = request.getParameter("pass");
		 Login log = new Login();
		 log.setEmail(email);
		 log.setPassword(password); 
		 Dataconnection d=new Dataconnection();
		 //String emailexist="";
		 //emailexist=d.emailexist(email);
		 //if(emailexist.equals(email))
		 //{
		
		 String userLogin="";
		 userLogin = d.login(email,password);
		 System.out.println("user login "+userLogin);
		 String role=d.role1(email, password);
		 System.out.println("role "+role);
		 if(userLogin.equals(email))
		 {
		
	
		 if(role.equals("admin"))  
		 {
			
		     request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
		 }
		 else  
		 {
			 
			 HttpSession session = request.getSession(true);
			 session.setAttribute("user", email);
			 request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
		 }
		 }
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
		 out.println("alert('Email ID or password do not exist...');");
		 out.println("location='login.jsp';");
		 out.println("</script>");	
		 }
		 
	
	}
}
		 
	

