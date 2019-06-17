<%@page import="java.sql.*"%>
<%@page import="library.database.*,library.model.*,java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<title>Update</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor2/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor2/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor2/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor2/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util2.css">
	<link rel="stylesheet" type="text/css" href="css/main2.css">
<!--===============================================================================================-->
</head>
<body>
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/newlibrary";
String userId = "root";
String password = "Mahirocks@1";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>	
              	<div class="limiter">
			    <div class="container-table100">
				<div class="wrap-table100">
				<h1 style="text-align:center">Updating Record</h1>	
				<hr>
				<div class="table100">
				<form action="Updatebook" method="post">
						<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Book Name</th>
								<th class="column1">Description</th>
								<th class="column1">Author</th>
								<th class="column1">Price</th>
								<th class="column1">Publisher</th>
								<th class="column1">No of copies</th>
								<th class="column1">Update</th>
								</tr>
						</thead>
						
            	<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
//statement=connection.createStatement();
PreparedStatement ps=null;
String bookid=request.getParameter("bookid");
System.out.println("Bookid"+bookid);
String sql ="select bookname,description,author,price,publisher,noofcopies from book where bookid=?";
ps = connection.prepareStatement(sql); 
ps.setString(1, bookid);
resultSet = ps.executeQuery();
Dataconnection d=new Dataconnection();
String noofcopies=request.getParameter("noofcopies");
d.updateavailablecount(bookid,noofcopies);
while(resultSet.next()){
%>
            	
                <tbody>
					<tr>
					<td class="column1"><input type="text" name="bookname" required value="<%=resultSet.getString("bookname") %>"></td>
					<td class="column1"><input type="text" name="description" required value="<%=resultSet.getString("description") %>"></td>
                    <td class="column1"><input type="text" pattern="[A-Za-z ]*" required title="Number and special character not allowed" name="author" value="<%=resultSet.getString("author") %>"></td>
                   <td class="column1"><input type="number" name="price" min="1" max="100000000" required value="<%=resultSet.getString("price") %>"></td>
                    <td class="column1"><input type="text" name="publisher" pattern="[A-Za-z ]*" required title="Number and special character not allowed" value="<%=resultSet.getString("publisher") %>"></td>
                   <td class="column1"><input type="number" name="noofcopies" min="1" max="10000" required value="<%=resultSet.getString("noofcopies") %>"></td>
                <input type="hidden" name="bookid" value="<%=bookid%>">
                <td class="column6"><input class="btn btn-primary" type="submit" value="update"> 
<%--                 <a class="btn btn-primary" href="Updatebook?bookid=<%=bookid%>">UPDATE</a> --%>
                </td>
                                   </tr>
                
                 <% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
                       </table> 
                       </form>
                       </div>
			</div>
		</div>
	</div>    
                       </form>    

</body>
</html>