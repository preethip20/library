<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,library.database.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>View Book</title>
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
      if (session != null) {
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            } 
      }
   %>
   		<%
String name = (String) session.getAttribute("user");
	
Dataconnection d=new Dataconnection();
String id=d.getid(name);
request.setAttribute("id", id);
%>
<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/newlibrary";
String userId = "root";
String password = "Mahirocks@1";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
PreparedStatement ps=null;
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>	
	<div class="limiter">
			<div class="container-table100">
				
			<div class="wrap-table100">
				<h1 style="text-align:center">Available Books</h1>	
				<hr>
				<div class="table100">
				<form action="Hirebook" method="post">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Book ID</th>
								<th class="column1">Book Name</th>
								<th class="column1">Description</th>
								<th class="column1">Author</th>
								<th class="column1">Price</th>
								<th class="column1">Publisher</th>
							</tr>
						</thead>
						<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
String sql ="SELECT bookid,bookname,description,author,price,publisher FROM book where available>0";
ps = connection.prepareStatement(sql); 
resultSet = ps.executeQuery();
while(resultSet.next()){
%>
						<tbody>
								<tr>
								<%--<input type="hidden" name="bookid" value=<%=resultSet.getString("bookid") %>> --%>
									<td class="column1"><%=resultSet.getString("bookid") %></td>
									<td class="column1"><%=resultSet.getString("bookname") %></td>
									<td class="column1"><%=resultSet.getString("description") %></td>
									<td class="column1"><%=resultSet.getString("author") %></td>
									<td class="column1"><%=resultSet.getString("price") %></td>
									<td class="column1"><%=resultSet.getString("publisher") %></td>
								</tr>
								
								
								
						</tbody><% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
					</table>
					<a class="btn btn-primary" style="margin-top:20px;margin-left:450px;padding:20px 70px" href="request.jsp?userid=<%=id%>">REQUEST BOOK</a>
					</form>
					<hr>
					<h1 style="text-align:center">Books not available currently</h1>	
					<hr>
					<form action="Hirebook" method="post">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Book ID</th>
								<th class="column2">Book Name</th>
								<th class="column3">Description</th>
								<th class="column4">Author</th>
								<th class="column5">Price</th>
								<th class="column6">Publisher</th>
							</tr>
						</thead>
						<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
String sql ="SELECT bookid,bookname,description,author,price,publisher FROM book where available=0";
ps=connection.prepareStatement(sql);
resultSet = ps.executeQuery();
while(resultSet.next()){
%>
						<tbody>
								<tr>
								<%--<input type="hidden" name="bookid" value=<%=resultSet.getString("bookid") %>> --%>
									<td class="column1"><%=resultSet.getString("bookid") %></td>
									<td class="column2"><%=resultSet.getString("bookname") %></td>
									<td class="column3"><%=resultSet.getString("description") %></td>
									<td class="column4"><%=resultSet.getString("author") %></td>
									<td class="column5"><%=resultSet.getString("price") %></td>
									<td class="column6"><%=resultSet.getString("publisher") %></td>
								</tr>
								
								
								
						</tbody><% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
					</table>
					<a class="btn btn-primary" style="margin-top:20px;margin-left:450px;padding:20px 70px" href="userlogin.jsp?userid=<%=id%>">GO TO HOMEPAGE</a>
					</form>
				</div>
			</div>
		</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="vendor2/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor2/bootstrap/js/popper.js"></script>
	<script src="vendor2/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor2/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main2.js"></script>

</body>
</html>