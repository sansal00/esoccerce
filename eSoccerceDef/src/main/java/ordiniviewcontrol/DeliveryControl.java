package ordiniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import ordine.OrdiniModelDS;

@WebServlet("/DeliveryControl")
public class DeliveryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeliveryControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		OrdiniModelDS model = new OrdiniModelDS();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			model.doUpdateDelivery(id, "Spedizione conclusa e ordine consegnato con successo!");
			model.doUpdateOrder(id, "");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		try {
			json.put("messaggio", "Spedizione conclusa e ordine consegnato con successo!");
			json.put("ordine", "");
		}
		catch (JSONException w) {
			w.printStackTrace();
		}
		response.getWriter().print(json.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
