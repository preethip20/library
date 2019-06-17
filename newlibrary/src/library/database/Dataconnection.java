package library.database;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.*;

import library.model.*; 
public class Dataconnection{

	static Connection con=null;
	static PreparedStatement ps;
	
	public static Connection getcon()
	{
	try 
	{
		String url = "jdbc:mysql://localhost:3306/newlibrary"; //MySQL URL followed by the database name
		String username = "root"; //MySQL username
		String password = "Mahirocks@1"; //MySQL password
	Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	con = DriverManager.getConnection(url,username,password);
	//System.out.println("Printing connection object "+con);
	} 
	catch (Exception e) 
	{
	System.out.println(e);
	}
	return con; 
	}
	
	public int registerUser(Register reg1)
	{
		int status=0;
		try
		{
		 con =Dataconnection.getcon();
		 String query = "insert into registration(name,email,password,contact,role) values (?,?,?,?,?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, reg1.getName());
	 ps.setString(2, reg1.getEmail());
	 ps.setString(3, reg1.getPassword());
	 ps.setString(4, reg1.getContact());
	 ps.setString(5, "user");
	 status=ps.executeUpdate();
	 System.out.println("Reg status "+status);
	con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int addingbook(Addbook1 add1)
	{
		int status=0;
		try
		{
	 con =Dataconnection.getcon();
	 String query = "insert into book(bookname,description,author,price,publisher,noofcopies,available) values (?,?,?,?,?,?,?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, add1.getBookname());
	 ps.setString(2, add1.getDescription());
	 ps.setString(3, add1.getAuthor());
	 ps.setString(4, add1.getPrice());
	 ps.setString(5, add1.getPublisher());
	 ps.setString(6, add1.getNoofcopies());
	 ps.setString(7, add1.getAvailable());
	 status=ps.executeUpdate();
	 con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int findbook(Addbook1 add)
	{
		int i=0;
		String bookid="",noofcopies="";
		noofcopies=add.getNoofcopies();
		Dataconnection d=new Dataconnection();
		try
		{
			con =Dataconnection.getcon();
			String query = "select * from book where bookname=? and author=? and publisher=?";
			
			ps = con.prepareStatement(query);
			 ps.setString(1, add.getBookname());
			 ps.setString(2, add.getAuthor());
			 ps.setString(3, add.getPublisher());
		
			ps.execute();
			ResultSet rs = ps.getResultSet();
			System.out.println("Bookname="+add.getBookname()+"Author="+add.getAuthor()+"Publisher="+add.getPublisher());
			if(rs.next())
			{
				/*String bookname1=rs.getString("bookname");
				String author1=rs.getString("author");
				String publisher1=rs.getString("publisher");
				System.out.println("Bookname="+bookname1+"Author="+author1+"Publisher="+publisher1);
				if (add.getBookname().equals(bookname1) && add.getAuthor().equals(author1)&& add.getPublisher().equals(publisher1)) 
				{*/
					System.out.println("inside copy");
					bookid = rs.getString("bookid");
					System.out.println("Bookid="+bookid+"No of copies="+noofcopies);
					d.incrementcopies(bookid,noofcopies);
					i=2;
				} 
				else 
				{
					System.out.println("inside new");
					i = d.addingbook(add);
					i=2;
				}
				//}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}
	public int incrementcopies(String bookid,String copies) {
		int available = 0;
		try {
			con = Dataconnection.getcon();
			System.out.println("Bookid="+bookid+"No of copies="+copies);
			String query = "update book set noofcopies=noofcopies+"+copies+", available=available+"+copies+" where bookid=?";
			ps = con.prepareStatement(query);
			ps.setString(1, bookid);
			ps.executeUpdate();
			available=2;
			}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return available;

	}
	public int increaseavailable(String bookid) {
		int available = 0;
		System.out.println("book id " + bookid);
		try {
			con = Dataconnection.getcon();
			String query = "update book set available=available+1 where bookid=?";
			ps = con.prepareStatement(query);
			ps.setString(1, bookid);
			available = ps.executeUpdate();
			}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return available;

	}
	public int setauditmsg6(String bookname)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book updated successfully");
	 ps.setString(3, "admin");
	 status=ps.executeUpdate();
	con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg1(String bookname)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book added successfully");
	 ps.setString(3, "admin");
	 status=ps.executeUpdate();
		con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg2(String bookname)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book issued to user");
	 ps.setString(3, "admin");
	 status=ps.executeUpdate();
	 con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg3(String bookname)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book not issued to user");
	 ps.setString(3, "admin");
	 status=ps.executeUpdate();
   	con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg4(String bookname,String userid)
	{
		int status=0;
		try
		{
			con =Dataconnection.getcon();
			System.out.println("User id="+userid);
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book requested by the user");
	 ps.setString(3, "user id="+userid);
	 status=ps.executeUpdate();
   	con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg5(String bookname,String userid)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book returned by user");
	 ps.setString(3, "user id="+userid);
	 status=ps.executeUpdate();
		con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int setauditmsg7(String bookname)
	{
		int status=0;
		try
		{
			 con =Dataconnection.getcon();
	 String query = "insert into auditrecord(bookname,auditmsg,auditdate,audituser) values (?,?,CURTIME(),?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.setString(2, "Book deleted successfully");
	 ps.setString(3, "admin");
	 status=ps.executeUpdate();
		con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	public int deleteissued(String bookid,String issueid)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "delete from book_issued where bookid=? and id=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 ps.setString(2, issueid);
	 i= ps.executeUpdate();
	}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int deletebook(Addbook1 add1)
	{
		int status=0;
		try
		{
	 con =Dataconnection.getcon();
	 String query = "delete from book where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, add1.getBookid());
	 status=ps.executeUpdate();
	 //System.out.println("Reg status "+status);
	con.close();	
	 }
	 catch(SQLException e)
	 {
	 System.out.println(e);
	 }
		return status;
	 }
	
	public String login(String email,String password)
	{
		String isValid="";
		
		System.out.println("email in login "+email+" password "+password);
		String sql="select email from registration where email=? and password=?";
		try
		{
	 con = Dataconnection.getcon();
	// isValid = "select email from registration where email=? and password=?"; 
	 ps = con.prepareStatement(sql); 
	 ps.setString(1, email);
	 ps.setString(2, password);
	 ResultSet rs = ps.executeQuery();
	 System.out.println("RS "+rs);
	 boolean isnext=rs.next();
	 System.out.println("is next "+isnext);
     if(isnext) {
    	 //isValid=rs.getString("isValid");
    	 //isValid=rs.getString("email");
    	 System.out.println("rs get "+rs.getString("email"));
    	 isValid=email;
		}
     System.out.println("email "+isValid);
     con.close();
     }
	catch (Exception e) {
		// TODO: handle exception
	}
		return isValid;
	}
	public String getid(String email)
	{
		String id = null;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select id from registration where email=?";
	 ps = con.prepareStatement(query); 
	 ps.setString(1, email);
	 ps.execute();
	 ResultSet rs=ps.getResultSet();
	 while(rs.next())
	 {
		 id=rs.getString("id");
     }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return id;
	
	 }
	public int addrequest(Addrequest ar)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "insert into book_request(userid,bookid) values (?,?)"; 
	 System.out.println("user id="+ar.getUserid()+"book id="+ar.getBookid());
	 ps = con.prepareStatement(query); 
	 ps.setString(1, ar.getUserid());
	 ps.setString(2, ar.getBookid());
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int deleterequest(Addrequest ar)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set status=? where bookid=?"; 
	 System.out.println("user id="+ar.getUserid()+"book id="+ar.getBookid());
	 ps = con.prepareStatement(query); 
	 ps.setString(1, "requested");
	 ps.setString(2, ar.getBookid());
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int setstatus(String bookid,String bookname,String userid)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "insert into bookstatus(bookid,bookname,bookstatus,statusdate,updatedby,userid) values(?,?,?,CURTIME(),?,?)"; 
	 System.out.println("book id="+bookid);
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 ps.setString(2, bookname);
	 ps.setString(3, "Book issued by admin");
	 ps.setString(4, "admin");
	 ps.setString(5, userid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int setstatus1(String bookid,String bookname,String userid)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "insert into bookstatus(bookid,bookname,bookstatus,statusdate,updatedby,userid) values(?,?,?,CURTIME(),?,?)"; 
	 System.out.println("book id="+bookid);
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 ps.setString(2, bookname);
	 ps.setString(3, "Book rejected by admin..not issued");
	 ps.setString(4, "admin");
	 ps.setString(5, userid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public List requestbook()
	{
		String id = null;
		List l=new ArrayList();
		//System.out.println("email  "+email);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select s.requestid,u.email,u.name,b.bookname,b.available,b.bookid from books b,user u,bookrequest s where s.bookid=b.bookid and s.userid=u.id";
	 ps= con.prepareStatement(query); 
			
	 ps.execute();
	 ResultSet rs=ps.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getString("email"));
		 l.add(rs.getString("name"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("available"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("requestid"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("requestid"));
		 //l.add(rs.getString("name"));
		
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	 }
	public int booksavailable(String bookid)
	{
	String available="";
	int book=0;
	try
	{
	 con = Dataconnection.getcon();
	 System.out.println("Bookid="+bookid);
	 String query = "select available from book where bookid=?";
	 ps= con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 ps.execute();
	 ResultSet rs=ps.getResultSet();
	 while(rs.next())
	 {
		  available=rs.getString("available");
		  System.out.println("Available="+available);
		
	 }
	 book=Integer.parseInt(available);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return book;
	 }
	public int noduplicates(Addrequest add) {
			int i = 0;
		try {
			con = Dataconnection.getcon();
			String bookid=add.getBookid();
			String userid=add.getUserid();
			System.out.println("Bookid="+bookid+"Userid="+userid);
			String query = "select userid, bookid from book_request where bookid=? and userid=?";
			ps = con.prepareStatement(query);
			ps.setString(1, add.getBookid());
			ps.setString(2, add.getUserid());
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				if (bookid.equals(rs.getString("bookid")) && userid.equals(rs.getString("userid")))
				{
					System.out.println("already requested for same book");
					i = 2;
				} 
				else
				{
					System.out.println("No such record" + i);
					i=0;
				}
				}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updateavailablebook(String bookid) {
		int available = 0;
		System.out.println("book id " + bookid);
		try {
			con = Dataconnection.getcon();
			String query = "update book set available=available-1 where bookid=? and available > 0";
			ps = con.prepareStatement(query);
			ps.setString(1, bookid);
			available = ps.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return available;

	}
	public int updateavailablecount(String bookid,String noofcopies) {
		int available = 0;
		System.out.println("book id " + bookid+"noofcopies="+noofcopies);
		try {
			con = Dataconnection.getcon();
			String query = "update book set available=available+"+noofcopies+" where bookid=? and available > 0";
			ps = con.prepareStatement(query);
			ps.setString(1, bookid);
			available = ps.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return available;

	}
	public String findbook(String bookname)
	{
	String available="";
	System.out.println("book name "+bookname);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select bookname from books where bookname=?";
	 ps= con.prepareStatement(query); 
	 ps.setString(1, bookname);
	 ps.execute();
	 ResultSet rs=ps.getResultSet();
	 while(rs.next())
	 {
		 available=rs.getString("bookname");
		
	 }
	}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return available;
	
	 }
	public int addissuedbooks(Addrequest ar)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "insert into book_issued(iuserid,ibookid) values (?,?)"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, ar.getUserid() );
	 ps.setString(2, ar.getBookid());
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public List getissuedbooks()
	{
		String id = null;
		List l=new ArrayList();
			try
		{
	 con = Dataconnection.getcon();
		 String query = "select s.id,u.email,u.name,b.bookname,b.bookid from books b,user u,issuedbooks s where s.ibookid=b.bookid and s.iuserid=u.id";
	  ps = con.prepareStatement(query); 
			
	 ps.execute();
	 ResultSet rs=ps.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getString("email"));
		 l.add(rs.getString("email"));
		 l.add(rs.getString("name"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("id"));
					
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	 }
	
	public int removebook(String bookid,String requestid)
	{
		int i=0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "delete from book_request where bookid=? and requestid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 ps.setString(2, requestid);
	i= ps.executeUpdate();
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public String role1(String email,String password)
	{
		String role="";
				try
		{
	 con = Dataconnection.getcon();
	 role="select role from registration where email=? and password=?";
	 ps = con.prepareStatement(role); 
	 ps.setString(1, email);
	 ps.setString(2, password);
	 ResultSet rs = ps.executeQuery();
	 if(rs.next())
	 {
		 role=rs.getString("role");
		 
	 }
	 System.out.println("role "+role);
	 con.close();
       
		}
	catch (Exception e) {
		// TODO: handle exception
	}
		return role;
	}
	public List view1()
	{
		List l=new ArrayList();
	
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select * from books"; 
	 Statement s = con.createStatement();

	  s.executeQuery(query);
	 ResultSet rs=s.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getInt("bookid"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("description"));
		 l.add(rs.getString("author"));
		 l.add(rs.getString("price"));
		 l.add(rs.getString("publisher"));
		 l.add(rs.getString("status"));
		 
	 }
	 
	//System.out.println(l);
	
	Iterator itr = l.iterator();
    while (itr.hasNext()) {
    	itr.next();
    	System.out.println("bookname"+itr.next());
    	System.out.println("description"+itr.next());
    	System.out.println("author"+itr.next());
    	System.out.println("price"+itr.next());
    	System.out.println("publisher"+itr.next());
    	System.out.println("status"+itr.next());
    }
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	
	 }
	public List booktoupdate(String bookid)
	{
		List l=new ArrayList();
	
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select bookname,description,author,price,publisher from book where bookid="+bookid+""; 
	 Statement s = con.createStatement();

	  s.executeQuery(query);
	 ResultSet rs=s.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("description"));
		 l.add(rs.getString("author"));
		 l.add(rs.getString("price"));
		 l.add(rs.getString("publisher"));
			 
	 }
	
		}
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return l;
		
		
		 }
	public int updatebook(Addbook1 ad,String bookid)
	{
		int i=0;
		Dataconnection d=new Dataconnection();
		System.out.println("book id "+bookid);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set bookname=?,description=?,author=?,price=?,publisher=?,noofcopies=? where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, ad.getBookname());
	 ps.setString(2, ad.getDescription());
	 ps.setString(3, ad.getAuthor());
	 ps.setString(4, ad.getPrice());
	 ps.setString(5, ad.getPublisher());
	 ps.setString(6, ad.getNoofcopies());
	 ps.setString(7, bookid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
	 String noofcopies=ad.getNoofcopies();
	// int noofcopies1=Integer.parseInt(noofcopies);
	 d.checkavailable(noofcopies,bookid);
		 con.close();
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int checkavailable(String noofcopies,String bookid)
	{
		int i=0;
		//String noofcopy=ad.getNoofcopies();
		//int noofcopy1=Integer.parseInt(noofcopy);
		System.out.println("Bookid="+bookid);
		System.out.println("no of copies="+noofcopies);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set available=? where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, noofcopies);
	 ps.setString(2, bookid);
	 i= ps.executeUpdate();
	 
	 System.out.println("i "+i);
		 		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	}
	public int returnbook(String bookid,String userid)
	{
		int i=0;
		System.out.println("book id="+bookid+"user id="+userid);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set available=available+1 where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
	 con.close();
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int updaterejectstatus(String bookid)
	{
		int i=0;
		System.out.println("book id="+bookid);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set status=? where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, "available");
	 ps.setString(2, bookid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
	 con.close();
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int deletefrombookissue(String bookid,String userid)
	{
		int i=0;
		System.out.println("book id="+bookid+"user id="+userid);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "delete from book_issued where ibookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, bookid);
	 i= ps.executeUpdate();
	 System.out.println("i "+i);
	 con.close();
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public String emailexist(String email)
	{
		String isValid ="";
		System.out.println("email in method "+email);
		try
		{
	 con = Dataconnection.getcon();
	 String query = "select email from registration where email=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, email);
	 ResultSet rs = ps.executeQuery();
	
	 boolean next=rs.next();
	System.out.println("next record exist? "+next);
     if(rs.next()) {
    	 
       System.out.println("Email Exist");
       isValid = rs.getString("email"); 
     }
    
	 
		}
	catch (Exception e) {
		// TODO: handle exception
	}
		System.out.println("is valid "+isValid);
		return isValid;
		
	}
	public int updatestatus(String bookid)
	{
		int isValid = 0;
		try
		{
	 con = Dataconnection.getcon();
	 String query = "update book set status=? where bookid=?"; 
	 ps = con.prepareStatement(query); 
	 ps.setString(1, "issued");
	 ps.setString(2, bookid);
	 ResultSet rs = ps.executeQuery();
	   if(rs.next()) {
                  isValid = 1; 
	   			}
	 	}
	catch (Exception e) {
		// TODO: handle exception
	}
		return isValid;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//createConnection();
		Dataconnection d=new Dataconnection();
		//int i=d.updatestatus("1");
		//d.login("prisha@gmail.com", "prisha");
		List l=d.booktoupdate("4");
		System.out.println(l);
	}

}
