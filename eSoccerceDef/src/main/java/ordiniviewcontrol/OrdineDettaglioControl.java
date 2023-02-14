package ordiniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordine.OrdineDettaglioModelDS;


@WebServlet("/OrdineDettaglioControl")
public class OrdineDettaglioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrdineDettaglioControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdineDettaglioModelDS model = new OrdineDettaglioModelDS();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			request.setAttribute("ordine", model.doRetrieveByKey(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(response.encodeURL("/site/ordineDettaglio.jsp")).forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
