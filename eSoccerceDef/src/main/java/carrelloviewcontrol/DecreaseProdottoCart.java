package carrelloviewcontrol;

import java.io.IOException;

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

@WebServlet("/DecreaseProdottoCart")
public class DecreaseProdottoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int codice = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession(false);
		CartBean cart = (CartBean) session.getAttribute("cart");
		int quantit�nuova = 0;
		for (ProdottoBean prodotto : cart.getProdotti()) {
			if (prodotto.getCode() == codice) {
				if (prodotto.getQuantita() == 1) {
					prodotto.setQuantita(prodotto.getQuantita());
					quantit�nuova = prodotto.getQuantita(); 
				}
				else { 
				prodotto.setQuantita(prodotto.getQuantita() - 1);
				quantit�nuova = prodotto.getQuantita(); 		
				}
			}
		}
		
			JSONObject json = new JSONObject();
		try {
			json.put("quantit�", quantit�nuova);
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
