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
	<title>eSoccerce - Login errato!</title>
</head>
<body>
	<div class="page-container error">
		<header>
			<a href="<%= response.encodeURL("./site/index.jsp")%>"><img class="logo" src="<%= request.getContextPath() %>/images/logo.png"></a>
			
		</header>
		<div class="panel panel-xs">
			<header>
				<h3>Login errato!</h3>
						<img src="<%= request.getContextPath() %>/images/cry.png" width="50px" height="50px">
			</header>
			<div class="content">
				<br>Email o password non correttamente inseriti.<br>
				Puoi ritornare alla pagina di login. <br>
				<a class="btn btn-primary btn-lg" href="<%= response.encodeURL("./site/login.jsp")%>" role="button">Login</a>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body></html>