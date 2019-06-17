<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,library.database.*,java.util.*"%>

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
				<h1 style="text-align:center">List of Books</h1>	
				<hr>
				<div class="table100">
				
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Book Name</th>
								<th class="column1">Description</th>
								<th class="column1">Author</th>
								<th class="column1">Price</th>
								<th class="column1">Publisher</th>
								<th class="column1">No of copies</th>
								<th class="column1">Update Book</th>
								<th class="column1">Delete Book</th>
							</tr>
						</thead>
						<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM book";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
						
						<tbody>
								<tr>
									<td class="column1"><%=resultSet.getString("bookname") %></td>
									<td class="column1"><%=resultSet.getString("description") %></td>
									<td class="column1"><%=resultSet.getString("author") %></td>
									<td class="column1"><%=resultSet.getString("price") %></td>
									<td class="column1"><%=resultSet.getString("publisher") %></td>
									<td class="column1"><%=resultSet.getString("noofcopies") %></td>
									<td class="column1"><a class="btn btn-primary" href="update.jsp?bookid=<%=resultSet.getString("bookid")%>">Update</a></td>
									<td class="column1"><a class="btn btn-primary" href="Delete?bookid=<%=resultSet.getString("bookid") %>&bookname=<%=resultSet.getString("bookname") %>">Delete</a></td>
								</tr>
																		
						</tbody>
<%
}

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

					</table>
					<a class="btn btn-primary" style="margin-top:20px;margin-left:250px;padding:20px 50px" href="adminlogin.jsp">GO TO HOMEPAGE</a>
					<a class="btn btn-primary" style="margin-top:20px;margin-left:280px;padding:20px 50px" href="issuebook.jsp?userid=<%=id%>">ISSUE BOOKS</a>
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