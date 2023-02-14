<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="profilo.*, carrello.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
		
	<title>eSoccerce - Registrazione</title>
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
			<% String visitato = (String) request.getAttribute("visitato");
	if (visitato == null) {
		response.sendRedirect(response.encodeRedirectURL("../RegistrationViewControl"));
		return; } %>
	<div class="text-left" style="length:350px; width:350px; align-content: center; width: 50%; margin: 0 auto;">
  	<h1 align="center" style="color:orange; font-weight: 900;"><i>Registrazione</i></h1>
  	</div>
  	<center><div id="messaggio" style="font-weight: 900; color:red"></div></center>
  	 <br>
  	<div><% 
    	String error = "ciao";
    	error = (String) request.getAttribute("error");
    	if(error != "" && error != null)
    	{
    %>
    		<center><p style= "color:red;"><%=error %></p></center>
 	<%  } %>
    	</div>
	<form action="<%=response.encodeURL("./RegistrationControl")%>" method="POST" onSubmit="return controlloValori(this);"> 
	<center><table class="formtable" style="text-align:center; border:5px solid orange; width: 650px; height:520px;">   
     <tr><td style="vertical-align:center;"><label for="email"><b>Email</b></label></td>
      <td style="vertical-align:center;"><input type="text" name="email" id="email" required></td></tr> 
    <tr><td style="vertical-align:center;"><label for="password"><b>Password</b></label></td>
      <td style="vertical-align:center;"><input type="password" name="password" id="password" required>  <img src="<%= request.getContextPath()%>/images/eye.png" width="20px" height="20px" onClick="toggle()" style="margin-top:13px;"></td></tr>
      <tr><td style="vertical-align:center;"><label for="confermaPassword"><b>Conferma password</b></label></td>
      <td style="vertical-align:center;"><input type="password"name="confermaPassword" id="confermaPassword" required> <img src="<%= request.getContextPath()%>/images/eye.png" width="20px" height="20px" onClick="toggle2()" style="margin-top:13px;"></td></tr>
       <tr><td style="vertical-align:center;"><label for="nome"><b>Nome</b></label></td>
      <td style="vertical-align:center;"><input type="text" name="nome" id="nome" required pattern="[a-zA-Z ]*" title="(solo lettere e spazi)"></td></tr>
      <tr><td style="vertical-align:center;"><label for="cognome"><b>Cognome</b></label></td>
      <td style="vertical-align:center;"><input type="text" name="cognome" id="cognome" required pattern="[a-zA-Z ]*" title="(solo lettere e spazi)"></td></tr> 
       <tr><td style="vertical-align:center;"><label for="indirizzo"><b>Indirizzo</b></label></td>
      <td style="vertical-align:center;"><input type="text" name="indirizzo" id="indirizzo" required pattern="[a-zA-Z0-9, ]*" title="(solo lettere, spazi, virgole e numeri)"></td></tr>   
       <tr><td style="vertical-align:center;"><label for="città"><b>Citt&agrave;</b></label></td>
      <td style="vertical-align:center;"><input type="text" name="città" id="città" pattern="[a-zA-Z ()]*" title="(solo lettere, spazi e parentesi tonde)"></td></tr>         
      <tr><td style="vertical-align:center;" colspan="2"><button type="submit" id="submit"><b><i>Registrati</i></b></button>
      <button type="reset"><b><i>Resetta campi</i></b></button></td></tr>
</table></center></form>
</div>
	</div>
	<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/app.js"></script>
	
	<script>
function controlloValori(x) {
	var email = x.elements["email"];
	var password = x.elements["password"];
	var confermaPassword = x.elements["confermaPassword"];
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (!(email.value.match(mailformat))) {
		email.style.border = "3px solid red";
		document.getElementById("messaggio").innerHTML = "Il formato dell'email è errato! Riprova.";
		return false;
	}
	if (password.value != confermaPassword.value) {
		password.style.border = "3px solid red";
		confermaPassword.style.border = "3px solid red";
		document.getElementById("messaggio").innerHTML = "I campi di password e conferma password non coincidono! Riprova.";
		return false;
	}
	var num = password.value.length;
	if (num < 5) {
		password.style.border = "3px solid red";
		document.getElementById("messaggio").innerHTML = "La password deve contenere almeno 5 caratteri!";
		return false;
	}
}
</script>
  <script>
        function toggle() {
            var temp = document.getElementById("password");
            if (temp.type === "password") {
                temp.type = "text";
            }
            else {
                temp.type = "password";
            }
        }
        function toggle2() {
            var temp = document.getElementById("confermaPassword");
            if (temp.type === "password") {
                temp.type = "text";
            }
            else {
                temp.type = "password";
            }
        }
</script>
</body>
</html>
