<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="profilo.*, java.util.*, prodotto.*, carrello.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	
	<title>eSoccerce - Scarpe running</title>
</head>
<body>
	<nav class="page-nav">
		<div class="title">
			<a href="<%= response.encodeURL("./site/index.jsp")%>"><img class="logo" src="<%= request.getContextPath() %>/images/logo.png"></a>
			<% UserBean user = new UserBean();
			HttpSession sessione = request.getSession(false);
	   	if (sessione != null)
	   {
			user = (UserBean) sessione.getAttribute("user");
			if(user != null)
			{ %>
			<h2>Bentornato, <%= user.getNome() %>!</h2>
			<h2><a href="<%= response.encodeURL("./site/profilo.jsp")%>">Il mio profilo</a>
			  |  
			<a href="<%= response.encodeURL("./site/ordini.jsp")%>">I miei ordini</a></h2>	
	 		<% } else { %>
			<h2>
				<a href="<%= response.encodeURL("./site/login.jsp")%>">Login</a>
				 | 
				<a href="<%= response.encodeURL("./site/registrazione.jsp")%>">Registrati</a>
			</h2>
			<% } }%>
		</div>
		<ul>
		<% if (user != null) {
		if (user.getEmail().equals("admin@admin.it") && user.getPassword().equals("admin")) { %>
				<li>
				<a class="dropdown">
					<span class="text">Amministratore</span>
					<span class="icon">></span>
				</a>
				<ul>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/admin/aggiungiProdotto.jsp")%>">
								<button type="submit"><b><i>Aggiungi prodotto</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/admin/rimuoviProdotto.jsp")%>">
								<button type="submit"><b><i>Rimuovi prodotto</i></b></button>
						</a>
					</li>
						<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/admin/aggiungiScorte.jsp")%>">
								<button type="submit"><b><i>Aggiungi scorte</i></b></button>
						</a>
					</li>
				</ul>
			</li>
			<% } }%>
			<li>
				<a class="dropdown">
					<span class="text">Abbigliamento</span>
					<span class="icon">></span>
				</a>
				<ul>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Magliette">
					<button type="submit" id="submit"><b><i>Magliette</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Pantaloncini">
					<button type="submit" id="submit"><b><i>Pantaloncini</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Calzettoni">
					<button type="submit" id="submit"><b><i>Calzettoni</i></b></button>
						</form>
					</li>
				</ul>
			</li>
			<li>
				<a class="dropdown">
					<span class="text">Calzature</span>
					<span class="icon">></span>
				</a>
				<ul>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Scarpe da calcio">
					<button type="submit" id="submit"><b><i>Scarpe da calcio</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Scarpe da running">
					<button type="submit" id="submit"><b><i>Scarpe da running</i></b></button>
						</form>
					</li>
				</ul>
			</li>
			<li>
				<a class="dropdown">
					<span class="text">Accessori</span>
					<span class="icon">></span>
				</a>
				<ul>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Borsoni">
					<button type="submit" id="submit"><b><i>Borsoni</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Gadgets">
					<button type="submit" id="submit"><b><i>Gadgets</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Palloni">
					<button type="submit" id="submit"><b><i>Palloni</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("./ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Parastinchi">
					<button type="submit" id="submit"><b><i>Parastinchi</i></b></button>
						</form>
					</li>
				</ul>
			</li>
			<li>
				<a class="dropdown">
					<span class="text">Servizi</span>
					<span class="icon">></span>
				</a>
				<ul>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/servizi/spedizione.jsp")%>">
								<button type="submit"><b><i>Spedizione</i></b></button>
						</a>
					</li>
				<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/servizi/assistenza.jsp")%>">
								<button type="submit"><b><i>Assistenza</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/servizi/guida.jsp")%>">
								<button type="submit"><b><i>Guida alle taglie</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("./site/servizi/guidanumeri.jsp")%>">
								<button type="submit"><b><i>Guida ai numeri</i></b></button>
						</a>
					</li>
				</ul>
			</li>
			<% if (user != null) { %>
				<li>
					<a href="<%= response.encodeURL("./site/logout.jsp")%>">
								<span class="text">Logout</span>
						</a>
					</li>
			<% } %>
		</ul>
	</nav>
	<div class="container">
		<header class="page-header">
			<button class="menu-button"></button> 
				<a href="<%= response.encodeURL("./site/cart.jsp")%>"><button class="cart-button"></button></a>	
				<% CartBean cart = new CartBean();
				cart = (CartBean) sessione.getAttribute("cart");
				if (cart != null) { %>
				<button class="cartquantity-button" style="pointer-events:none;"><%= cart.getProdotti().size() %></button> <% } %>
				<form method="GET" action="<%= response.encodeURL("./SearchControl")%>">
<input type="text" placeholder="Ricerca il tuo prodotto..." name="search"></form>
		</header>
		<div class="page-content">
		<center><h6><i>Hai dubbi sul tuo più adatto numero? </i><a href="<%= response.encodeURL("./site/servizi/guidanumeri.jsp")%>">Visita la nostra guida!</a></h6></center>
	<%
	Collection<?> scarperunning = (Collection<?>) request.getAttribute("scarperunning"); 
	String error = (String) request.getAttribute("error");
	if(scarperunning == null && error == null){ 
		response.sendRedirect(response.encodeRedirectURL("../../ProdottoControl"));
		return;
	}
	
%>    


<%
		if(scarperunning != null && scarperunning.size() > 0)
		{
			Iterator<?> it = scarperunning.iterator();
			while(it.hasNext())
			{
			ProdottoBean bean = (ProdottoBean) it.next(); 
		%>
<table style="text-align:center; border:5px solid orange; height:400px; width:580px;  margin-left:auto; margin-right:auto;">	
<tr><td> <img src=".<%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Numero: </i><%=bean.getNumero() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><%=bean.getDescrizione() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<% if (user == null) { %>
<tr><td style="vertical-align:center;"><h6 style="color:red;"><b><i>Devi essere loggato per poter acquistare il prodotto!</i></b></h6></td></tr>
<% } %>
<% 	if (sessione != null && user != null) { %>

<% if (bean.getQuantita() == 0) { %>
<tr><td style="vertical-align:center;"><h6 style="color:red;"><b><i>Prodotto non disponibile!</i></b></h6></td></tr>
<% } else { %> 
<tr><td style="vertical-align:center;"><form action="<%= response.encodeURL("./CartControl") %>" method="POST">
<input type="hidden" id="code" name="code" value="<%= bean.getCode() %>">
<input type="hidden" name="urlimage" value="<%= bean.getImage() %>">
<input type="hidden" name="nome" value="<%= bean.getNome() %>">
<input type="hidden" name="marca" value="<%= bean.getMarca() %>">
<input type="hidden" name="descrizione" value="<%= bean.getDescrizione() %>">
<input type="hidden" name="prezzo" value="<%= bean.getPrezzo() %>">
<input type="hidden" name="quantità" value="<%= bean.getQuantita() %>">
<input type="hidden" name="taglia" value="<%= bean.getTaglia() %>">
<input type="hidden" name="numero" value="<%= bean.getNumero() %>">
<input type="hidden" name="dimensione" value="<%= bean.getDimensione() %>">
<input type="hidden" name="tipo" value="<%= bean.getTipo() %>"><button type="submit">Aggiungi al carrello!</button></form></td></tr>
<% } %>
<tr><td style="vertical-align:center;"><form action="<%= response.encodeURL("./RecensioniControl") %>" method="POST" id="recensione"><input type="hidden" id="nomeprodotto" name="nomeprodotto" value="<%=bean.getNome()%>"><input type="hidden" id="emailrecensione" name="emailrecensione" value="<%=user.getEmail() %>"><button type="submit" class="btn btn-primary">Aggiungi una recensione!</button> <br>
<input type="radio" id="pessimo" name="star" value="pessimo"><img width="20px" height="20px"src="<%=request.getContextPath() %>/images/feedback1.png">      <input type="radio" id="discreto" name="star" value="discreto"><img width="40px" height="20px"src="<%=request.getContextPath() %>/images/feedback2.png">      <input type="radio" id="buono" name="star" value="buono"><img width="60px" height="20px"src="<%=request.getContextPath() %>/images/feedback3.png">      <input type="radio" id="ottimo" name="star" value="ottimo"><img width="80px" height="20px"src="<%=request.getContextPath() %>/images/feedback4.png">      <input type="radio" id="eccellente" name="star" value="eccellente"><img width="100px" height="20px"src="<%=request.getContextPath() %>/images/feedback5.png"><br>
<textarea id="textarea" name="textarea" style="margin-left:auto; margin-right:auto; background:lightgray; color:black;" rows="4" placeholder="Scrivi qui la tua recensione..."></textarea></form></td></tr>
<tr><td><form action="<%= response.encodeURL("./RecensioniAllControl") %>" method="GET"><input type="hidden" id="nomeprodotto" name="nomeprodotto" value="<%=bean.getNome()%>"><button type="submit">Guarda qui tutte le recensioni!</button></form></td></tr>
<% } %>
</table>
<br>
<% } } %>

		</div>
	</div>
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>
</body>
</html>