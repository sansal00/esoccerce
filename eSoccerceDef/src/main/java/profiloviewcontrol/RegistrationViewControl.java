package profiloviewcontrol;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import profilo.UserBean;


@WebServlet("/RegistrationViewControl")
public class RegistrationViewControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegistrationViewControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean) session.getAttribute("user");
		request.setAttribute("user", user);
		request.setAttribute("visitato", "");
		getServletContext().getRequestDispatcher(response.encodeURL("/site/registrazione.jsp")).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
