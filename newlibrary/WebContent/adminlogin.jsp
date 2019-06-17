<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="library.database.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
</head>
<body>

<div class="container">	
			
			<header class="clearfix">
				<h1>Library Management System</span></h1>	
			</header>
			<div class="main">
				<p>Welcome ADMIN...<img class="center" src="images/admin-banner.jpg" alt="admin"/></p>
				
				<div class="side">
					<nav class="dr-menu">
						<div class="dr-trigger"><span class="dr-icon dr-icon-menu"></span><a class="dr-label">Account</a></div>
						<ul>
							<li><a class="dr-icon dr-icon-user" href="addbook.jsp" target="">Add Book</a></li>
							<li><a class="dr-icon dr-icon-camera" href="issuebook.jsp">Issue Book</a></li>
							<li><a class="dr-icon dr-icon-heart" href="adminview.jsp">View All Books</a></li>
							<li><a class="dr-icon dr-icon-heart" href="auditrecord.jsp">Audit Record</a></li>
							<li><a class="dr-icon dr-icon-switch" href="login.jsp">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/ytmenu.js"></script>
		
</body>
</html>