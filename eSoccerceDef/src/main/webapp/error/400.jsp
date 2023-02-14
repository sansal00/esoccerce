<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	<title>eSoccerce</title>
</head>
<body>
	<div class="page-container error">
		<header>
			<a href="<%= request.getContextPath() %>/site/index.jsp"><img class="logo" src="<%= request.getContextPath() %>/images/logo.png"></a>
			
		</header>
		<div class="panel panel-xs">
			<header>
				<h3>Errore 400</h3>
				<img src="<%= request.getContextPath() %>/images/cry.png" width="50px" height="50px">
			</header>
			<div class="content">
				<br>	La richiesta non è stata effettuata nel modo corretto. <br>
				<% if(request.getAttribute("javax.servlet.error.message") != null) { %>
					<%= request.getAttribute("javax.servlet.error.message") %>
				<% } %>
			</div>
		</div>
	</div>
</body>
</html>