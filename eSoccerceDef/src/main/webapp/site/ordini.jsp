<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="profilo.*, java.util.*, prodotto.*, recensione.*, carrello.*, ordine.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	
	<title>eSoccerce - Ordini</title>
</head>
<body>
	<nav class="page-nav">
		<div class="title">
			<a href="<%= response.encodeURL("../site/index.jsp")%>"><img class="logo" src="<%= request.getContextPath() %>/images/logo.png"></a>
			<% UserBean user = new UserBean();
			HttpSession sessione = request.getSession(false);
	   	if (sessione != null)
	   {
			user = (UserBean) sessione.getAttribute("user");
			if(user != null)
			{ %>
			<h2>Bentornato, <%= user.getNome() %>!</h2>
			<h2><a href="<%= response.encodeURL("../site/profilo.jsp")%>">Il mio profilo</a>
			  |  
			<a href="<%= response.encodeURL("../site/ordini.jsp")%>">I miei ordini</a></h2>	
	 		<% } else { %>
			<h2>
				<a href="<%= response.encodeURL("../site/login.jsp")%>">Login</a>
				 | 
				<a href="<%= response.encodeURL("../site/registrazione.jsp")%>">Registrati</a>
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
						<a href="<%= response.encodeURL("../site/admin/aggiungiProdotto.jsp")%>">
								<button type="submit"><b><i>Aggiungi prodotto</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("../site/admin/rimuoviProdotto.jsp")%>">
								<button type="submit"><b><i>Rimuovi prodotto</i></b></button>
						</a>
					</li>
						<li style="text-align:center;">
						<a href="<%= response.encodeURL("../site/admin/aggiungiScorte.jsp")%>">
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
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Magliette">
					<button type="submit" id="submit"><b><i>Magliette</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Pantaloncini">
					<button type="submit" id="submit"><b><i>Pantaloncini</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
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
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Scarpe da calcio">
					<button type="submit" id="submit"><b><i>Scarpe da calcio</i></b></button>
						</form>
					</li>
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
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
					<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Borsoni">
					<button type="submit" id="submit"><b><i>Borsoni</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Gadgets">
					<button type="submit" id="submit"><b><i>Gadgets</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
					<input type="hidden" name="stringa" value="Palloni">
					<button type="submit" id="submit"><b><i>Palloni</i></b></button>
						</form>
					</li>
						<li style="text-align:center;"><form method="GET" action="<%= response.encodeURL("../ProdottoControl")%>">
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
						<a href="<%= response.encodeURL("../site/servizi/spedizione.jsp")%>">
								<button type="submit"><b><i>Spedizione</i></b></button>
						</a>
					</li>
				<li style="text-align:center;">
						<a href="<%= response.encodeURL("../site/servizi/assistenza.jsp")%>">
								<button type="submit"><b><i>Assistenza</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("../site/servizi/guida.jsp")%>">
								<button type="submit"><b><i>Guida alle taglie</i></b></button>
						</a>
					</li>
					<li style="text-align:center;">
						<a href="<%= response.encodeURL("../site/servizi/guidanumeri.jsp")%>">
								<button type="submit"><b><i>Guida ai numeri</i></b></button>
						</a>
					</li>
				</ul>
			</li>
			<% if (user != null) { %>
				<li>
					<a href="<%= response.encodeURL("../site/logout.jsp")%>">
								<span class="text">Logout</span>
						</a>
					</li>
			<% } %>
		</ul>
	</nav>
	<div class="container">
		<header class="page-header">
			<button class="menu-button"></button> 
				<a href="<%= response.encodeURL("../site/cart.jsp")%>"><button class="cart-button"></button></a>	
				<% CartBean cart = new CartBean();
				cart = (CartBean) sessione.getAttribute("cart");
				if (cart != null) { %>
				<button class="cartquantity-button" style="pointer-events:none;"><%= cart.getProdotti().size() %></button> <% } %>
				<form method="GET" action="<%= response.encodeURL("../SearchControl")%>">
<input type="text" placeholder="Ricerca il tuo prodotto..." name="search"></form>
		</header>
		<div class="page-content">
		<% if (user == null ) { %>
	   <center><img src="<%=request.getContextPath() %>/images/cry.png" width="100px" height="100px"></center>
	<h5 align="center" style="color:red; font-weight:bold;"><i>Spiacenti, per poter visualizzare la pagina occore essere loggati!</i></h5> 
	<% } else { %>
		<%
		OrdiniModelDS model = new OrdiniModelDS();
	Collection<?> ordini = model.doRetrieveAll(user.getEmail()); 
	if (ordini.size() == 0) { %>
	<center><img src="<%=request.getContextPath() %>/images/cry.png" width="100px" height="100px"></center>
		<h5 align="center" style="color:red; font-weight:bold;" id="noordini"><i>Non hai ancora effettuato ordini. Naviga nel nostro sito e acquista i nostri articoli!</i></h5>
	<%  } %>

	<% if(ordini != null && ordini.size() > 0)
		{ %>
		<%	
			Iterator<?> it = ordini.iterator();
			int count = 0;
			while(it.hasNext())
			{
			OrdiniBean bean = (OrdiniBean) it.next(); 
			count++;
			if (count == 1) {%>
	<center><h6><i>Dubbi sulla spedizione? <a href="<%= response.encodeURL("../site/servizi/spedizione.jsp")%>">Tempi di spedizione</a></i></h6></center>
	<center><h4 style="color:orange; font-weight:900;"><i>Tutti gli ordini effettuati da te, <%=user.getNome() %>!</i></h4></center> <% } %>
<table style="text-align:center; border:5px solid orange; height:300px; width:580px; margin-left:auto; margin-right:auto">	
<tr><td style="vertical-align:center;"> <h3 style="color:orange;"><i>ORDINE NUMERO <%= bean.getID() %></i></h3>
<p id="messaggio2" style="font-size:60%;"><i><%=bean.getDataOrdine() %></i></p>
<p id="messaggio" style="font-size:60%; color:#00ff00;"><i><%= bean.getSpedizione() %></i></p>
<tr><td style="vertical-align:center;"><p style="color:orange; font-size:80%;"><i>Metodo di pagamento: ************<%= bean.getNumeroCarta().substring(12) %></i></p></td></tr>
<tr><td style="vertical-align:center;"><p style="color:#00ff00; font-size:80%;"><i>Totale dell'ordine: <%=bean.getTotale() %>.00&euro;</i></p></td></tr>
<tr><td style="vertical-align:center;"><form action="<%= response.encodeURL("../OrdineDettaglioControl") %>" method="GET"><input type="hidden" name="id" id="id" value="<%= bean.getID() %>"><button type="submit">Dettaglio ordine</button></form>
<button onClick="delivery(<%= bean.getID() %>)">Ordine ricevuto!</button></td></tr>
</table>
<br>
<% } } %>
		</div>
	</div>
<% } %>
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>
	<script>
function delivery(id)
{
	var url = '<%= response.encodeURL("/eSoccerce/DeliveryControl")%>'+"?id=" + encodeURIComponent(id); 
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = 
		function() 
		{
			if(xhr.readyState == 4 && xhr.status == 200)
			{
				var response = JSON.parse(xhr.responseText);
				document.getElementById("messaggio").innerHTML = response.messaggio;
				document.getElementById("messaggio2").innerHTML = response.ordine;
			}
		}
	xhr.open("GET",url,true);
	xhr.send(null);
}
</script>
</body>

</html>