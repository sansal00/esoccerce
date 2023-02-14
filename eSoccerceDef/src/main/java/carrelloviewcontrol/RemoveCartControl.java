package carrelloviewcontrol;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carrello.CartBean;


@WebServlet("/RemoveCartControl")
public class RemoveCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveCartControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		CartBean cart = (CartBean) session.getAttribute("cart");
		cart.svuotaCarrello();
		request.setAttribute("cart", cart);
		request.setAttribute("visitato", "");
		getServletContext().getRequestDispatcher(response.encodeURL("/site/cart.jsp")).forward(request, response);
	}

}
