package prodottoviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prodotto.ProdottoModelDS;


@WebServlet("/ProdottoControl")
public class ProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdottoControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("stringa");
		ProdottoModelDS model = new ProdottoModelDS();		
		if (parametro.equals("Magliette")){ 
  		try {
			request.setAttribute("magliette", model.doRetrieveAll("Maglietta"));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
  		getServletContext().getRequestDispatcher(response.encodeURL("/site/abbigliamento/magliette.jsp")).forward(request, response);
		}
		if (parametro.equals("Pantaloncini")){ 
	  			try {
	  				request.setAttribute("pantaloncini", model.doRetrieveAll("Pantaloncini"));
	  			} catch (SQLException e) {
	  				e.printStackTrace();
	  				request.setAttribute("error", e.getMessage());
	  			}
	  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/abbigliamento/pantaloncini.jsp")).forward(request, response);
		}
		if (parametro.equals("Calzettoni")){ 
  			try {
  				request.setAttribute("calzettoni", model.doRetrieveAll("Calzettoni"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/abbigliamento/calzettoni.jsp")).forward(request, response);
	}
		if (parametro.equals("Scarpe da calcio")){ 
  			try {
  				request.setAttribute("scarpecalcio", model.doRetrieveAll("Scarpe Calcio"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/calzature/scarpecalcio.jsp")).forward(request, response);
	}
		if (parametro.equals("Scarpe da running")){ 
  			try {
  				request.setAttribute("scarperunning", model.doRetrieveAll("Scarpe Running"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/calzature/scarperunning.jsp")).forward(request, response);
	}
		if (parametro.equals("Borsoni")){ 
  			try {
  				request.setAttribute("borsoni", model.doRetrieveAll("Borsone"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/accessori/borsoni.jsp")).forward(request, response);
	}
		if (parametro.equals("Gadgets")){ 
  			try {
  				request.setAttribute("gadgets", model.doRetrieveAll("Gadget"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/accessori/gadgets.jsp")).forward(request, response);
	}
		if (parametro.equals("Palloni")){ 
  			try {
  				request.setAttribute("palloni", model.doRetrieveAll("Pallone"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/accessori/palloni.jsp")).forward(request, response);
	}
		if (parametro.equals("Parastinchi")){ 
  			try {
  				request.setAttribute("parastinchi", model.doRetrieveAll("Parastinchi"));
  			} catch (SQLException e) {
  				e.printStackTrace();
  				request.setAttribute("error", e.getMessage());
  			}
  	  		getServletContext().getRequestDispatcher(response.encodeURL("/site/accessori/parastinchi.jsp")).forward(request, response);
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
