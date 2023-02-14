package prodottoviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prodotto.ProdottoModelDS;

@WebServlet("/SearchControl")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ricerca = request.getParameter("search");
		ProdottoModelDS model = new ProdottoModelDS();

  		try {
			request.setAttribute("result", model.doRetrieveSearch(ricerca));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Ops! Sembra proprio che i prodotti che stai ricercando non ci siano. Riprova!");
		}
  		  		
  		getServletContext().getRequestDispatcher(response.encodeURL("/site/ricerca.jsp")).forward(request, response);
  	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
