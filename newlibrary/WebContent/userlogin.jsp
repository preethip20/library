<%@page import="library.database.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>User Login</title>
		
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
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
		<div class="container">	
			
			<header class="clearfix">
				<h1>Library Management System</span></h1>	
			</header>
			<div class="main">
				<p>Welcome USER...<img class="center" style="height:600px;width:1000px" src="images/education-books.jpg" alt="admin"/></p>
				<div class="side">
					<nav class="dr-menu">
						<div class="dr-trigger"><span class="dr-icon dr-icon-menu"></span><a class="dr-label">Account</a></div>
						<ul>
							<li><a class="dr-icon dr-icon-heart" href="view.jsp">View All Books</a></li>
							<li><a class="dr-icon dr-icon-heart" href="request.jsp?userid=<%=id%>">Request Book</a></li>
							<li><a class="dr-icon dr-icon-heart" href="requestedbooks.jsp?userid=<%=id%>">Requested Books</a></li>
							<li><a class="dr-icon dr-icon-heart" href="requestedbookstatus.jsp?userid=<%=id%>">Book Status</a></li>
							<li><a class="dr-icon dr-icon-camera" href="returnbook.jsp?userid=<%=id%>">Return Book</a></li>
							<li><a class="dr-icon dr-icon-bullhorn" href="Logout">Logout</a></li>
							
						</ul>
					</nav>
				</div>
			</div>
		</div><!-- /container -->
		
		<script src="js/ytmenu.js"></script>

	</body>
</html>