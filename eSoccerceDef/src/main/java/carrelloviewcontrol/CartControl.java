package carrelloviewcontrol;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carrello.CartBean;
import prodotto.ProdottoBean;

@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoBean prodotto = new ProdottoBean();


    public CartControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession(false);
		CartBean cart = (CartBean) sessione.getAttribute("cart");
		int code = Integer.parseInt(request.getParameter("code"));
		String urlimage = request.getParameter("urlimage");
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String descrizione = request.getParameter("descrizione");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		String taglia = request.getParameter("taglia");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String dimensione = request.getParameter("dimensione");
		String tipo = request.getParameter("tipo");
		prodotto = new ProdottoBean(code, urlimage, nome, marca, descrizione, prezzo, 1, taglia, numero, dimensione, tipo);
		boolean truth = cart.checkExistence(prodotto);
		if (truth) {
			request.setAttribute("message", "Il prodotto è già presente nel carrello. Vuoi acquistarne altri? Usa l'apposito tool nel carrello!");
			HttpSession session = request.getSession(false);
			CartBean cart2 = (CartBean) session.getAttribute("cart");
			request.setAttribute("cart", cart2);
			request.setAttribute("visitato", "");
			getServletContext().getRequestDispatcher(response.encodeURL("/site/cart.jsp")).forward(request, response);
			return;
		}
		else { cart.addProdotto(prodotto);
		request.setAttribute("message", "Prodotto aggiunto con successo al carrello!");
		HttpSession session = request.getSession(false);
		CartBean cart2 = (CartBean) session.getAttribute("cart");
		request.setAttribute("cart", cart2);
		request.setAttribute("visitato", "");
		getServletContext().getRequestDispatcher(response.encodeURL("/site/cart.jsp")).forward(request, response);
		return;
	}
			}
		
		}



