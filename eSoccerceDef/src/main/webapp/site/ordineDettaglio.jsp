<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="profilo.*, java.util.*, prodotto.*, carrello.*, ordine.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">

	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	
	<title>eSoccerce - Dettaglio ordine</title>
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
				<a href="<%= response.encodeURL("./site/cart.jsp")%>"><button class="cart-button"></button></a>	
				<% CartBean cart = new CartBean();
				cart = (CartBean) sessione.getAttribute("cart");
				if (cart != null) { %>
				<button class="cartquantity-button" style="pointer-events:none;"><%= cart.getProdotti().size() %></button> <% } %>
				<form method="GET" action="<%= response.encodeURL("./SearchControl")%>">
<input type="text" placeholder="Ricerca il tuo prodotto..." name="search"></form>
		</header>
		<div class="page-content">
		<center><h6><i>Hai dubbi sulla spedizione?</i><a href="<%= response.encodeURL("./site/servizi/spedizione.jsp")%>"> Visita questa pagina!</a></h6></center>
	<%
	Collection<?> ordine = (Collection<?>) request.getAttribute("ordine"); 
	String message = (String) request.getAttribute("message");
	String error = (String) request.getAttribute("error");
	if(ordine == null && error == null){ 
		response.sendRedirect(response.encodeRedirectURL("./OrdineDettaglioControl"));
		return;
	}
%>    
<% 
int totale = 0;
		if(ordine != null && ordine.size() > 0)
		{
			Iterator<?> it = ordine.iterator();
			int count = 0;
			while(it.hasNext())
			{
			OrdineDettaglioBean bean = (OrdineDettaglioBean) it.next();
			count++; 
		if (count == 1) { %>
		<h3 style="color: orange; font-weight: 900;" align="center"><i>Dettaglio ordine numero <%= bean.getID() %></i></h3>
		<table style="text-align:center; border:5px solid orange; height:100px; width:780px; margin-left:auto; margin-right:auto">	
		<% } 
if (it.hasNext()) { %>
<tr><td style="vertical-align:center; border-bottom:5px solid red;" rowspan="4"><img src=".<%= bean.getImage()%>" width="190px" height="210px"></td></tr> <% } 
else { %>
<tr><td style="vertical-align:center;" rowspan="4"><img src=".<%= bean.getImage()%>" width="190px" height="210px"></td></tr> <% } %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<%if (bean.getNome().contains("Maglietta") || bean.getNome().contains("Pantaloncini") || bean.getNome().contains("Calzettoni")) { %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;">Taglia: <%=bean.getTaglia() %></h5></td></tr>
<%  } %>
<%if (bean.getNome().contains("Scarpe") ||  bean.getNome().contains("Pallone")) { %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;">Numero: <%=bean.getNumero() %></h5></td></tr>
<%  } %>
<%if (bean.getNome().contains("Borsone")) { %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;">Dimensione: <%=bean.getDimensione() %></h5></td></tr>
<%  } %>
<%if (bean.getNome().contains("Gadget")) { %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;">Tipo: <%=bean.getTipo() %></h5></td></tr>
<%  } %>
<%if (bean.getNome().contains("Parastinchi")) { %>
<tr><td style="vertical-align:center;"><h5 style="color:orange;">Marca: <%=bean.getMarca() %></h5></td></tr>
<%  } 
if (it.hasNext()) { %>
<tr><td style="vertical-align:center; border-bottom: 5px solid red;"><p style="font-size:70%; color:orange;">X<%=bean.getQuantitaAcquistata() %></p></td></tr> 
<% } 
 else { %>
<tr><td style="vertical-align:center;"><p style="font-size:70%; color:orange;">X<%=bean.getQuantitaAcquistata() %></p></td></tr>
 <% } %>
<% totale += bean.getPrezzo() * bean.getQuantitaAcquistata(); %>
<% } } %>
</table>
<br>
<br>
<% Iterator<?> it = ordine.iterator(); %>
<table style="text-align:center; border:5px solid orange; height:100px; width:780px; margin-left:auto; margin-right:auto">
<tr><td style="vertical-align:center;"><p style="font-size:80%; color:white;"><b>Nome prodotto</b></p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:white;"><b>Quantit&agrave;</b></p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:white;"><b>Prezzo</b></p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:white;"><b>Importo</b></p></td></tr>
<% while(it.hasNext())
{
OrdineDettaglioBean bean = (OrdineDettaglioBean) it.next(); %>
<tr><td style="vertical-align:center;"><p style="font-size:80%; color:orange"><%=bean.getNome() %></p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:orange"><%=bean.getQuantitaAcquistata()%>pz.</p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:orange"><%=bean.getPrezzo() %>.00&euro;</p></td>
<td style="vertical-align:center;"><p style="font-size:80%; color:orange"><%=bean.getPrezzo() * bean.getQuantitaAcquistata()%>.00&euro;</p></td></tr>
<% } 
if (totale >= 30) { %>
<tr><td style="vertical-align:center;" colspan="4"><h3 style="color:orange;"><i>IMPORTO TOTALE: </i><%=totale%>.00&euro;</h3></td></tr> <% } 
else { 
	int spedizione = 5; %>
	<tr><td style="vertical-align:center;" colspan="4"><h3 style="color:orange;">IMPORTO PARZIALE: <%= totale %>.00&euro;<br>
	COSTI DI SPEDIZIONE: <%=spedizione %>.00&euro;<br>
	<i>IMPORTO TOTALE: </i><%=totale + spedizione%>.00&euro;</h3></td></tr>
<% } %>
</table>
<center><h4><a href="<%= response.encodeURL("./site/ordini.jsp")%>">Torna agli ordini</a></h4></center>
		</div>
	</div>
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>
</body>
</html>