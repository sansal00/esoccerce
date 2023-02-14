package recensioniviewcontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recensione.RecensioniBean;
import recensione.RecensioniModelDS;



@WebServlet("/RecensioniControl")
public class RecensioniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecensioniControl() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecensioniBean bean = null;
		RecensioniModelDS model = new RecensioniModelDS();
		Random random = new Random();
		int numero = random.nextInt(1000000);
		int stelle = 0;
		String nomeprodotto = request.getParameter("nomeprodotto");
		String email = request.getParameter("emailrecensione");
		String value = "";
		if (request.getParameter("star") != null) {
			value = request.getParameter("star");
		}
		if (value.equals("pessimo")) {
			stelle = 1;
		}
		else if (value.equals("discreto")) {
			stelle = 2;
		}
		else if (value.equals("buono")) {
			stelle = 3;
		}
		else if (value.equals("ottimo")) {
			stelle = 4;
		}
		else if (value.equals("eccellente")) {
			stelle = 5;
		}
		String descrizione = request.getParameter("textarea");
		if (stelle == 0) {
			request.setAttribute("message", "Recensione non valida! Inserire tutti i campi correttamente!");
			String redirect = response.encodeURL("/RecensioniAllControl") + "?nomeprodotto=" + nomeprodotto;
			getServletContext().getRequestDispatcher(response.encodeURL(redirect)).forward(request, response);
			return;
		}
		else {
		bean = new RecensioniBean(numero, nomeprodotto, descrizione, stelle, email);
		try {
			model.doSave(bean);
			request.setAttribute("message", "Recensione aggiunta con successo!");
			String redirect = response.encodeURL("/RecensioniAllControl") + "?nomeprodotto=" + nomeprodotto;
			getServletContext().getRequestDispatcher(response.encodeURL(redirect)).forward(request, response);
			return;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		}

	}


