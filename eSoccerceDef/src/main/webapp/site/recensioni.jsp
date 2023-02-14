<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="profilo.*, java.util.*, prodotto.*, recensione.*, carrello.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	
	<title>eSoccerce - Recensioni</title>
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
		<%
	Collection<?> recensioni = (Collection<?>) request.getAttribute("recensioni"); 
	if (recensioni.size() == 0) { %>
	<center><img src="<%=request.getContextPath() %>/images/cry.png" width="100px" height="100px"></center>
		<h5 align="center" style="color:red; font-weight:bold;" id="norecensioni"><i>Uhm, credo non ci siano recensioni per questo prodotto. Passa pi&ugrave; tardi!</i></h5>
	<%  }
	String message = (String) request.getAttribute("message");
	if (message != null) {
%>
<h5 align="center" style="color: green; font-weight:bold;" id="messaggio"><i><%= message %></i></h5> <% } %>
	<% if(recensioni != null && recensioni.size() > 0)
		{ %>
		<%	Iterator<?> it = recensioni.iterator();
		int count = 0;
			while(it.hasNext())
			{
			RecensioniBean bean = (RecensioniBean) it.next(); 
			count++;
			if (count == 1) {%>
	<center><h4 style="color:orange;"><i>Recensioni per il prodotto: <%=bean.getNomeProdotto() %></i></h4></center> <% } %>
<table style="text-align:center; border:5px solid orange; height:300px; width:580px; margin-left:auto; margin-right:auto">	
<tr><td style="vertical-align:center;"> <h6><i><%= bean.getEmail() %></i></h6></td></tr>
<% if (bean.getEmail().equals(user.getEmail()))  { %>
<tr><td style="vertical-align:center;"><form action="<%= response.encodeURL("./DeleteRecensioneControl") %>" method="POST"><input type="hidden" name="nomeprodotto" value="<%= bean.getNomeProdotto() %>"><input type="hidden" name="numero" id="numero" value="<%=bean.getNumero() %>"><button type="submit" class="btn btn-primary">Elimina recensione</button></form></td></tr>
<% } %>
<% int stelle = bean.getStelle();
if (stelle == 1) { %>
<tr><td style="vertical-align:center;"><h6 style="color:yellow;"><img width="50" height="40" src="<%= request.getContextPath()%>/images/feedback1.png"></h6></td></tr>
<% } %>
<% if (stelle == 2) { %>
<tr><td style="vertical-align:center;"><h6 style="color:yellow;"><img width="100" height="40" src="<%= request.getContextPath()%>/images/feedback2.png"></h6></td></tr>
<% } %>
<% if (stelle == 3) { %>
<tr><td style="vertical-align:center;"><h6 style="color:yellow;"><img width="150" height="40" src="<%= request.getContextPath()%>/images/feedback3.png"></h6></td></tr>
<% } %>
<% if (stelle == 4) { %>
<tr><td style="vertical-align:center;"><h6 style="color:yellow;"><img width="200" height="40" src="<%= request.getContextPath()%>/images/feedback4.png"></h6></td></tr>
<% } %>
<% if (stelle == 5) { %>
<tr><td style="vertical-align:center;"><h6 style="color:yellow;"><img width="250" height="40" src="<%= request.getContextPath()%>/images/feedback5.png"></h6></td></tr>
<% } %>
<tr><td style="vertical-align:center;"><h6><i><%=bean.getDescrizione() %></i></h6></td></tr>
</table>
<br>
<% } } %>
		</div>
	</div>
	
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>
</body>
</html>