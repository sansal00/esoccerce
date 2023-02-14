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

@WebServlet("/DeleteProdottoControl")
public class DeleteProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdottoModelDS model = new ProdottoModelDS();
    public DeleteProdottoControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoModelDS model = new ProdottoModelDS();
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean) session.getAttribute("user");
		int code = Integer.parseInt(request.getParameter("code"));
		boolean verità = checkExistence(code);
		if (verità) {
		try {
			model.doDelete(code, user.getEmail());
			getServletContext().getRequestDispatcher(response.encodeURL("/site/prodottoRimosso.jsp")).forward(request, response);
			return;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
		}
	


protected boolean checkExistence(int code) {
	ProdottoBean prodotto = null;
	try {
		prodotto = model.doRetrieveByKey(code);
		if(prodotto.getCode() == 0) return false;
		else return true;
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

}

