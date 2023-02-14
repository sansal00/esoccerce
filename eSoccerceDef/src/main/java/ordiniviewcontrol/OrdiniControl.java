package ordiniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carrello.CartBean;
import ordine.OrdineDettaglioBean;
import ordine.OrdineDettaglioModelDS;
import ordine.OrdiniBean;
import ordine.OrdiniModelDS;
import prodotto.ProdottoBean;
import prodotto.ProdottoModelDS;
import profilo.UserBean;


@WebServlet("/OrdiniControl")
public class OrdiniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrdiniControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrdiniModelDS model = new OrdiniModelDS();
		ProdottoModelDS model2 = new ProdottoModelDS();
		OrdineDettaglioModelDS model3 = new OrdineDettaglioModelDS();
		Random random = new Random();
		int id = random.nextInt(100000);
		HttpSession sessione = request.getSession(false);
		CartBean cart = (CartBean) sessione.getAttribute("cart");
		int totale = cart.getTotale();
		if (totale < 30) {
			totale += 5;
		}
		String numerocarta = request.getParameter("numerocarta");
		String datascadenza = request.getParameter("scadenza");
		int cvc = Integer.parseInt(request.getParameter("cvc"));
		String nomeintestatario = request.getParameter("nomeintestatario");
		String cognomeintestatario = request.getParameter("cognomeintestatario");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		String dataordine = formatter.format(date).toString();
		UserBean user = (UserBean) sessione.getAttribute("user");
		String email = user.getEmail();
		OrdiniBean ordine = new OrdiniBean(id, totale, numerocarta, cvc, datascadenza, nomeintestatario, cognomeintestatario, "Ordine effettuato il: " + dataordine, "", email);
		try {
			model.doSave(ordine);
			for (ProdottoBean prodotto : cart.getProdotti()) {
				model2.doUpdateQuantity(prodotto.getQuantita(), prodotto.getCode());
			}
			for (ProdottoBean prodotto : cart.getProdotti()) {
				OrdineDettaglioBean dettaglio = new OrdineDettaglioBean(prodotto.getCode(), prodotto.getImage(), prodotto.getNome(), prodotto.getMarca(), prodotto.getDescrizione(), prodotto.getPrezzo(), prodotto.getQuantita(), prodotto.getTaglia(), prodotto.getNumero(), prodotto.getDimensione(), prodotto.getTipo(), id);
				model3.doSave(dettaglio);
			}
			cart.svuotaCarrello();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(response.encodeURL("/site/ordineCompletato.jsp")).forward(request, response);
		return;
	}

}
