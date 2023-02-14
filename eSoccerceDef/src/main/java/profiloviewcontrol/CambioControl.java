package profiloviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profilo.UserBean;
import profilo.UserModelDS;

@WebServlet("/CambioControl")
public class CambioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean u = new UserBean();
	private UserModelDS model = new UserModelDS();
    public CambioControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		u = (UserBean) session.getAttribute("user");
		String vecchiodato = request.getParameter("vecchiodato");
		String nuovodato = request.getParameter("nuovodato");
		UserBean u2 = new UserBean();
		try {
			u2 = model.doRetrieveByKey(nuovodato);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (u2 != null) {
			getServletContext().getRequestDispatcher(response.encodeURL("/site/changeErrorData.jsp")).forward(request, response);
			return;
		}
		String confermanuovodato = request.getParameter("confermanuovodato");
		String datodacambiare = searchDataType(vecchiodato);
		if (datodacambiare == null) {
			getServletContext().getRequestDispatcher(response.encodeURL("/site/changeErrorData.jsp")).forward(request, response);
			return;
		}
		
		if (nuovodato.equals(confermanuovodato)) {
		if(datodacambiare != null) {
		if (datodacambiare.equals("email")) {
			try {
				model.changeEmail(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (datodacambiare.equals("nome")) {
			try {
				model.changeName(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (datodacambiare.equals("cognome")) {
			try {
				model.changeSurname(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (datodacambiare.equals("indirizzo")) {
			try {
				model.changeAddress(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (datodacambiare.equals("password")) {
			try {
				model.changePassword(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (datodacambiare.equals("città")) {
			try {
				model.changeCity(u, nuovodato);
				getServletContext().getRequestDispatcher(response.encodeURL("/site/changePage.jsp")).forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		}
	}

	public String searchDataType(String vecchiodato) {
		if (vecchiodato.equals(u.getEmail())) {
			return "email";
		}
		if (vecchiodato.equals(u.getNome())) {
			return "nome";
		}
		if (vecchiodato.equals(u.getCognome())) {
			return "cognome";
		}
		if (vecchiodato.equals(u.getIndirizzo())) {
			return "indirizzo";
		}
		if (vecchiodato.equals(u.getPassword())) {
			return "password";
		}
		if (vecchiodato.equals(u.getCittà())) {
			return "città";
		}
		return null;
	}
	
}
