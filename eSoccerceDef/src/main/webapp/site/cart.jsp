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
	
	<title>eSoccerce - Carrello</title>
</head>
<body>
<% String servletadd = "/eSoccerce/AddProdottoCart";
String servletdecrease = "/eSoccerce/DecreaseProdottoCart";
%>
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
				<% CartBean cart2 = new CartBean();
				cart2 = (CartBean) sessione.getAttribute("cart");
				if (cart2 != null) { %>
				<button class="cartquantity-button" style="pointer-events:none;"><%= cart2.getProdotti().size() %></button> <% } %>
				<form method="GET" action="<%= response.encodeURL("./SearchControl")%>">
<input type="text" placeholder="Ricerca il tuo prodotto..." name="search"></form>
		</header>
		<div class="page-content">
	<%
	String visitato = (String) request.getAttribute("visitato");
	if (visitato == null) {
		response.sendRedirect(response.encodeRedirectURL("../CartViewControl"));
		return; }
	if (user == null) { %>
	<center><img src="<%=request.getContextPath() %>/images/cry.png" width="100px" height="100px"></center>
	<h5 align="center" style="color:red; font-weight:bold;" id="messaggionologin"><i>Spiacenti, per poter visualizzare il carrello occore essere loggati!</i></h5>
	<% } if (user != null) {
	ProdottoModelDS model = new ProdottoModelDS();
	CartBean cart = (CartBean) session.getAttribute("cart");
	Collection<?> magliette = model.doRetrieveAll("Maglietta");
	Collection<?> pantaloncini = model.doRetrieveAll("Pantaloncini");
	Collection<?> calzettoni = model.doRetrieveAll("Calzettoni");
	Collection<?> borsoni = model.doRetrieveAll("Borsone");
	Collection<?> gadgets = model.doRetrieveAll("Gadget");
	Collection<?> palloni = model.doRetrieveAll("Pallone");
	Collection<?> parastinchi = model.doRetrieveAll("Parastinchi");
	Collection<?> scarpecalcio = model.doRetrieveAll("Scarpe Calcio");
	Collection<?> scarperunning = model.doRetrieveAll("Scarpe Running");
	if (cart.getProdotti().size() == 0) { %>
		<center><img src="<%=request.getContextPath() %>/images/carrellov.png" width="100px" height="100px"></center>
	<h5 align="center" style="color:red; font-weight:bold;" id="messaggiovuoto"><i>Il tuo carrello è vuoto! Scorri le pagine dei nostri prodotti per riempirlo!</i></h5>
	<% } %>
	<% String message = (String) request.getAttribute("message");
	if (message != null) { %>
	<center><h5 align="center" style="color:green; font-weight:bold;" id="messaggio"><i><%= message %></i></h5></center>
	<%  } if(cart.getProdotti() != null && cart.getProdotti().size() > 0) { %>
	<center><form method="POST" action="<%= response.encodeURL("./RemoveCartControl")%>"><button type="submit"><i><b>Svuota carrello</b></i></button></form></center><br>
		<%  Iterator<?> it = cart.getProdotti().iterator(); 
			 %>
			<table style="text-align:center; border:5px solid orange; height:400px; width:580px; margin-left:auto; margin-right:auto">
			<%  while(it.hasNext())
			{
			ProdottoBean bean = (ProdottoBean) it.next(); 
if (bean.getNome().contains("Maglietta")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Taglia: </i><%=bean.getTaglia() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% 
int quantità = 0; 
Iterator<?> it2 = magliette.iterator();
	while (it2.hasNext()) {
	ProdottoBean bean2 = (ProdottoBean) it2.next(); 
	if (bean2.getNome().equals(bean.getNome())) {
	quantità = bean2.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità %></i></p></td></tr>
<% } else if (bean.getNome().contains("Pantaloncini")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Taglia: </i><%=bean.getTaglia() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% 
int quantità2 = 0; 
Iterator<?> it3 = pantaloncini.iterator();
	while (it3.hasNext()) {
	ProdottoBean bean3 = (ProdottoBean) it3.next(); 
	if (bean3.getNome().equals(bean.getNome())) {
	quantità2 = bean3.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità2 %></i></p></td></tr>
<% } else if (bean.getNome().contains("Calzettoni")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Taglia: </i><%=bean.getTaglia() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% 
int quantità3 = 0; 
Iterator<?> it4 = calzettoni.iterator();
	while (it4.hasNext()) {
	ProdottoBean bean4 = (ProdottoBean) it4.next(); 
	if (bean4.getNome().equals(bean.getNome())) {
	quantità3 = bean4.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità3 %></i></p></td></tr>
<% } else if (bean.getNome().contains("Scarpe Calcio")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Numero: </i><%=bean.getNumero() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità4 = 0; 
Iterator<?> it5 = scarpecalcio.iterator();
	while (it5.hasNext()) {
	ProdottoBean bean5 = (ProdottoBean) it5.next(); 
	if (bean5.getNome().equals(bean.getNome())) {
	quantità4 = bean5.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità4 %></i></p></td></tr>

<% } else if (bean.getNome().contains("Scarpe Running")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Numero: </i><%=bean.getNumero() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità5 = 0; 
Iterator<?> it6 = scarperunning.iterator();
	while (it6.hasNext()) {
	ProdottoBean bean6 = (ProdottoBean) it6.next(); 
	if (bean6.getNome().equals(bean.getNome())) {
	quantità5 = bean6.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità5 %></i></p></td></tr>

<% } else if (bean.getNome().contains("Pallone")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="190px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Numero: </i><%=bean.getNumero() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità6 = 0; 
Iterator<?> it7 = palloni.iterator();
	while (it7.hasNext()) {
	ProdottoBean bean7 = (ProdottoBean) it7.next(); 
	if (bean7.getNome().equals(bean.getNome())) {
	quantità6 = bean7.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità6 %></i></p></td></tr>

<% } else if (bean.getNome().contains("Parastinchi")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Marca: </i><%=bean.getMarca() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità7 = 0; 
Iterator<?> it8 = parastinchi.iterator();
	while (it8.hasNext()) {
	ProdottoBean bean8 = (ProdottoBean) it8.next(); 
	if (bean8.getNome().equals(bean.getNome())) {
	quantità7 = bean8.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità7 %></i></p></td></tr>

<% } else if (bean.getNome().contains("Gadget")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="170px" height="250px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Tipo: </i><%=bean.getTipo() %></h6></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità8 = 0; 
Iterator<?> it9 = gadgets.iterator();
	while (it9.hasNext()) {
	ProdottoBean bean9 = (ProdottoBean) it9.next(); 
	if (bean9.getNome().equals(bean.getNome())) {
	quantità8 = bean9.getQuantita(); }
	}
	%>
	<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità8 %></i></p></td></tr>
<% } else if (bean.getNome().contains("Borsone")) { %>
<tr><td rowspan="4"> <img src="<%= request.getContextPath() %><%= bean.getImage()%>" width="190px" height="210px"></td></tr>
<tr><td style="vertical-align:center;"><h5 style="color:orange;"><%=bean.getNome() %></h5></td></tr>
<tr><td style="vertical-align:center;"><h6><i>Dimensione: </i><%=bean.getDimensione() %></h6></td></tr>
<tr><td style="vertical-align:center;"s><h6><i>Prezzo: </i><%=bean.getPrezzo() %>&euro;</h6></td></tr>
<tr><td style="vertical-align:center;" colspan="2"><h4><input type="image" class="quantity" onclick="functionMinus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/minus.png" width="13px" height="13px">  <b id="quantità<%= bean.getCode()%>"> <%= bean.getQuantita() %></b>  <input type="image" class="quantity" onclick="functionPlus('<%= bean.getCode() %>')" src="<%= request.getContextPath() %>/images/plus.png" width="13px" height="13px"></h4>
<% int quantità9 = 0; 
Iterator<?> it0 = borsoni.iterator();
	while (it0.hasNext()) {
	ProdottoBean bean0 = (ProdottoBean) it0.next(); 
	if (bean0.getNome().equals(bean.getNome())) {
	quantità9 = bean0.getQuantita(); }
	}
	%>
<p style="font-size:50%; color:#00ff00;"><i>Quantit&agrave; disponibile: <%= quantità9 %></i></p></td></tr>
<% } 
if (!it.hasNext()) { %>
<tr><td style="vertical-align:center;" colspan="2"><form method="POST" action="<%= response.encodeURL("./RemoveProdottoCart")%>"><input type="hidden" name="code" value="<%= bean.getCode() %>"><button type="submit">Rimuovi prodotto</button></form>
<% } else { %>
<tr><td style="vertical-align:center;  border-bottom: 5px solid red;" colspan="2"><form method="POST" action="<%= response.encodeURL("./RemoveProdottoCart")%>"><input type="hidden" name="code" value="<%= bean.getCode() %>"><button type="submit">Rimuovi prodotto</button></form>
<% } } %>
</table>
<br>
<table class="totale" style="text-align:center; border:5px solid orange; height: 80px; width:580px; margin-left:auto; margin-right:auto">
<tr><td style="vertical-align:center; color: orange;"><b><i>Totale:   </i></b><div id="totale"><%= cart.getTotale() %>.00&euro; </div></td></tr>
<tr><td style="vertical-align:center; text-align:center; font-size:95%;"><a href="<%= response.encodeURL("./site/checkout.jsp")%>"><button>Vai al checkout!</button></a></td></tr></table>
<% } } %>

		</div>
	</div>
	
<script>
function functionPlus(code)
{
	var url = '<%= response.encodeURL(servletadd)%>'+"?code=" + encodeURIComponent(code); 
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = 
		function() 
		{
			if(xhr.readyState == 4 && xhr.status == 200)
			{
				var response = JSON.parse(xhr.responseText);
				document.getElementById("quantità"+code).innerHTML = response.quantità;
				document.getElementById("totale").innerHTML = response.totale+'.00&euro;';
			}
		}
	xhr.open("GET",url,true);
	xhr.send(null);
}

function functionMinus(code)
{
	var url ='<%= response.encodeURL(servletdecrease)%>'+"?code=" + encodeURIComponent(code);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = 
		function() 
		{
			if(xhr.readyState == 4 && xhr.status == 200)
			{
				var response = JSON.parse(xhr.responseText);
				document.getElementById("quantità"+code).innerHTML = response.quantità;
				document.getElementById("totale").innerHTML = response.totale+'.00&euro;';
			}
		}
	xhr.open("GET",url,true);
	xhr.send(null);
}


</script>
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>

</body>
</html>