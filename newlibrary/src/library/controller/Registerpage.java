package library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.database.*;
import library.model.Register;

@WebServlet("/Registerpage")
public class Registerpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registerpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 Dataconnection d=new Dataconnection();
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
			 String contact = request.getParameter("contactno");
			 String password = request.getParameter("pass");
			 String repeatpassword = request.getParameter("repeat-pass");
			 String emailexist=d.emailexist(email);
			 System.out.println("email exist "+emailexist+"email is "+email);
			 int userRegistered=0;
			 Register reg = new Register();
			 reg.setName(name);
			 reg.setEmail(email);
			 reg.setContact(contact);
			 reg.setPassword(password); 
			 System.out.println("values "+name+" "+reg.getName());
		/*	 if(password.contentEquals(repeatpassword))
			 {
				 Register reg = new Register();
				 reg.setName(name);
				 reg.setEmail(email);
				 reg.setContact(contact);
				 reg.setPassword(password); 
				 System.out.println("values "+name+" "+reg.getName());
				
				*/
				if(email.equals(emailexist))
				{
				
				
					out.println("<script type=\"text/javascript\">");
					 out.println("alert('Email exist');");
					 out.println("location='register.jsp';");
					 out.println("</script>");	
				}
			
				//else if(userRegistered!=0)  
				else 
				 {
					d.registerUser(reg);
					 out.println("<script type=\"text/javascript\">");
					 out.println("alert('Successfully registered...');");
					 out.println("location='login.jsp';");
					 out.println("</script>");	
				 }
			
			 
			 }
			/* else
			 {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Passwords do not match...Refill the registration form...');");
				 out.println("location='register.jsp';");
				 out.println("</script>");	           
			 }*/
		// }
				
		
	}




