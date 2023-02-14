package recensioniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recensione.RecensioniModelDS;

@WebServlet("/DeleteRecensioneControl")
public class DeleteRecensioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteRecensioneControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecensioniModelDS model = new RecensioniModelDS();
		int numero = Integer.parseInt(request.getParameter("numero"));
		String nomeprodotto = request.getParameter("nomeprodotto");
		try {
			model.doDelete(numero);
			request.setAttribute("message", "Recensione eliminata con successo!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		String redirect = response.encodeURL("/RecensioniAllControl") + "?nomeprodotto=" + nomeprodotto;
		getServletContext().getRequestDispatcher(redirect).forward(request, response);
		return;
	}

}
