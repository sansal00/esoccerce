package prodottoviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prodotto.ProdottoModelDS;
import profilo.UserBean;


@WebServlet("/AddScorteControl")
public class AddScorteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddScorteControl() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoModelDS model = new ProdottoModelDS();
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean) session.getAttribute("user");
		int code = Integer.parseInt(request.getParameter("code"));
		int quantità = Integer.parseInt(request.getParameter("quantità"));
		try {
			model.doIncreaseQuantity(quantità, code, user.getEmail());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(response.encodeURL("/site/updatedQuantity.jsp")).forward(request, response);
	}

}
