package profiloviewcontrol;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carrello.CartBean;
import profilo.LoginModelDS;
import profilo.UserBean;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserBean u = new UserBean();
		LoginModelDS login = new LoginModelDS();
		try {
			u = login.doRetrieveByKey(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (u == null) {
			getServletContext().getRequestDispatcher(response.encodeURL("/site/loginErrato.jsp")).forward(request, response);
			return;
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);
			session.setAttribute("cart", new CartBean());
			getServletContext().getRequestDispatcher(response.encodeURL("/site/loginSuccesso.jsp")).forward(request, response);
			return;

		}
	}

}
