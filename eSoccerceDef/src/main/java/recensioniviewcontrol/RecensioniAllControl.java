package recensioniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recensione.RecensioniModelDS;


@WebServlet("/RecensioniAllControl")
public class RecensioniAllControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecensioniAllControl() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RecensioniModelDS model = new RecensioniModelDS();		
  		String nomeprodotto = request.getParameter("nomeprodotto");
  		try {
			request.setAttribute("recensioni", model.doRetrieveAll(nomeprodotto));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
  		getServletContext().getRequestDispatcher(response.encodeURL("/site/recensioni.jsp")).forward(request, response);
  	}	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
