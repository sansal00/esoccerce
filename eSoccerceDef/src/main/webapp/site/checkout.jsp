<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="carrello.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<meta name="description" content="eSoccerce">
	<meta name="author" content="Bruno Farano, Salvatore Santoriello, Gianmichele Cancellaro, Emanuele Milito">
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,700,700i" rel="stylesheet">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
	<title>eSoccerce - Checkout</title>
</head>
<body>
	<div class="page-container error">
		<header>
			<a href="<%= response.encodeURL("../site/index.jsp")%>"><img class="logo" src="<%= request.getContextPath() %>/images/logo.png"></a>
		</header>
		<div class="panel panel-xs">
			<header>
				<h2 style="font-weight: 900;"><i>Checkout</i></h2><br>
				<img src="<%= request.getContextPath() %>/images/paypal.png" width="60px" heigth="30px">   <img src="<%= request.getContextPath() %>/images/visa.png" width="60px" heigth="30px">   <img src="<%= request.getContextPath() %>/images/mastercard.png" width="60px" heigth="30px">   <img src="<%= request.getContextPath() %>/images/postepay.png" width="60px" heigth="30px">
				<div id="messaggio" style="font-weight: 700; font-size:65%; color:red"></div>
				</header>
			<div class="content">
				<% HttpSession sessione = request.getSession(false); 
				CartBean cart = (CartBean) sessione.getAttribute("cart"); 
				int totale = cart.getTotale();%>
				<br>
				<form action="<%=response.encodeURL("../OrdiniControl") %>" method="POST" onSubmit="return verify(this);"><table class="formtable" style="height:200px; width:400px;">
				<tr><td style="vertical-align:center;"><label for="numerocarta"><b><i>Numero carta</i></b></label></td><td style="vertical-align:center;"><input type="text" style="margin-right: 20px;"  placeholder="XXXX-XXXX-XXXX-XXXX" id="numerocarta" name="numerocarta" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="16" required></td></tr>
				<tr><td style="vertical-align:center;"><label for="scadenza"><b><i>Data scadenza</i></b></label></td><td style="vertical-align:center;"><input type="text" style="margin-right: 20px;" placeholder="XX/XX" id="scadenza" name="scadenza" maxlength="5" required pattern="[0-9/]*" title="(solo numeri e slash)"></td></tr>
				<tr><td style="vertical-align:center;"><label for="cvc"><b><i>Codice CVC</i></b></label></td><td style="vertical-align:center;"><input type="text" style="margin-right: 20px;" placeholder="XXX" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" id="cvc" name="cvc" maxlength="3" required></td></tr>
				<tr><td style="vertical-align:center;"><label for="nome"><b><i>Nome intestatario</i></b></label></td><td style="vertical-align:center;"><input type="text" style="margin-right: 20px;" placeholder="Nome intestatario" id="nomeintestatario" name="nomeintestatario" required pattern="[a-zA-Z ]*" title="(solo lettere e spazi)"></td></tr>
				<tr><td style="vertical-align:center;"><label for="cognome"><b><i>Cognome intestatario</i></b></label></td><td style="vertical-align:center;"><input type="text" style="margin-right: 20px;" placeholder="Cognome intestatario" id="cognomeintestatario" name="cognomeintestatario" required pattern="[a-zA-Z ]*" title="(solo lettere e spazi)"></td></tr>
				<% int spedizione = 5; 
				if (totale < 30) { %>
				<tr><td style="vertical-align:center;" colspan="2"><br>Importo parziale: <p style="color:#00ff00;"> <%= totale %>.00&euro;</p><br>
				Costi di spedizione:<p style="color:#00ff00"> <%= spedizione %>.00&euro;</p><br>
				<% totale += spedizione; %>
				Importo totale: <p style="color:#00ff00;"> <%= totale%>.00&euro;</p></td></tr> <% } 
				else { %>
				<tr><td style="vertical-align:center;" colspan="2"><br>Importo totale: <p style="color:#00ff00;"> <%= totale %>.00&euro;</p></td></tr> 
				<% } %>
				<tr><td style="vertical-align:center;" colspan="2"><button type="submit" id="submit"><i><b>Acquista!</b></i></button></td></tr>
				<tr><td style="vertical-align:center;" colspan="2"><a href="<%= response.encodeURL("../site/cart.jsp")%>">Ritorna al carrello!</a></td></tr></table></form>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script>
	function verify(x) {
	var numerocarta = x.elements["numerocarta"];
	var cvc = x.elements["cvc"];
	var length = numerocarta.value.length;
	if (length < 16) {
		numerocarta.style.border = "3px solid red";
		document.getElementById("messaggio").innerHTML = "Il numero della carta deve essere composto da 16 cifre!";
		return false;
	}
	var length2 = cvc.value.length;
	if (length2 < 3) {
		cvc.style.border = "3px solid red";
		document.getElementById("messaggio").innerHTML = "Il codice CVC deve essere composto da 3 cifre!";
		return false;
	}	
	}
	</script>
</body>
</html>