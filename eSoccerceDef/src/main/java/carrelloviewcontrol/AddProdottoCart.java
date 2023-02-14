package carrelloviewcontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import carrello.CartBean;
import prodotto.ProdottoBean;
import prodotto.ProdottoModelDS;

@WebServlet("/AddProdottoCart")
public class AddProdottoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProdottoCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ProdottoModelDS model = new ProdottoModelDS();
		Collection<ProdottoBean> magliette = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> pantaloncini = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> calzettoni = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> scarpecalcio = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> scarperunning = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> parastinchi = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> borsoni = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> gadgets = new LinkedList<ProdottoBean>();
		Collection<ProdottoBean> palloni = new LinkedList<ProdottoBean>();
		try {
			magliette = model.doRetrieveAll("Maglietta");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pantaloncini = model.doRetrieveAll("Pantaloncini");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			calzettoni = model.doRetrieveAll("Calzettoni");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			scarpecalcio = model.doRetrieveAll("Scarpe Calcio");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			scarperunning = model.doRetrieveAll("Scarpe Running");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			borsoni = model.doRetrieveAll("Borsone");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			palloni = model.doRetrieveAll("Pallone");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			gadgets = model.doRetrieveAll("Gadget");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			parastinchi = model.doRetrieveAll("Parastinchi");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int codice = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession(false);
		CartBean cart = (CartBean) session.getAttribute("cart");
		int quantitànuova = 0;
		for (ProdottoBean prodotto : cart.getProdotti()) {
			if (prodotto.getCode() == codice) {
				for (ProdottoBean appoggio : magliette) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : pantaloncini) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : calzettoni) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : scarpecalcio) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : scarperunning) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : palloni) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : gadgets) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : parastinchi) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
				for (ProdottoBean appoggio : borsoni) {
					if (appoggio.getNome().equals(prodotto.getNome())) {
						if (prodotto.getQuantita() < appoggio.getQuantita()) {
						prodotto.setQuantita(prodotto.getQuantita() + 1);
					}
						else  {
							prodotto.setQuantita(prodotto.getQuantita());
							}
						quantitànuova = prodotto.getQuantita();
				}
				}
			}
		}

		JSONObject json = new JSONObject();
		try {
			json.put("quantità", quantitànuova);
			json.put("totale", cart.getTotale());
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		response.getWriter().print(json.toString());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
