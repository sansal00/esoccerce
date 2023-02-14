package prodottoviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prodotto.ProdottoBean;
import prodotto.ProdottoModelDS;
import profilo.UserBean;


@WebServlet("/AddProdottoControl")
public class AddProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddProdottoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoModelDS model = new ProdottoModelDS();
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean) session.getAttribute("user");
		int code = Integer.parseInt(request.getParameter("code"));
		String nomeprodotto = request.getParameter("nomeprodotto");
		String urlimage = request.getParameter("urlimage");
		String marca = request.getParameter("marca");
		String descrizione = request.getParameter("descrizione");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		int quantità = Integer.parseInt(request.getParameter("quantità"));
		String taglia = request.getParameter("taglia");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String dimensione = request.getParameter("dimensione");
		String tipo = request.getParameter("tipo");
		ProdottoBean prodotto = new ProdottoBean(code, urlimage, nomeprodotto, marca, descrizione, prezzo, quantità, taglia, numero, dimensione, tipo);
		try {
			model.doSave(prodotto, user.getEmail());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(response.encodeURL("/site/prodottoAggiunto.jsp")).forward(request, response);
	}

}
