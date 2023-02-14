package profiloviewcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profilo.UserBean;
import profilo.UserModelDS;


@WebServlet("/RegistrationControl")
public class RegistrationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserModelDS model = new UserModelDS();
    public RegistrationControl() {
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = null;
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String indirizzo= request.getParameter("indirizzo");
		String città= request.getParameter("città");
					
					boolean exists= checkExistence(email);
					
					if(exists) {
						getServletContext().getRequestDispatcher(response.encodeURL("/site/emailExists.jsp")).forward(request, response);
						return;
					}
					
					else {
						user = new UserBean(email, password, nome, cognome, indirizzo, città);
						try {
							model.doSave(user);
						} catch (SQLException e) {
							e.printStackTrace();
						}				
						getServletContext().getRequestDispatcher(response.encodeURL("/site/registrazioneConclusa.jsp")).forward(request, response);
						return;
					}
					
			
			}
	
	protected boolean checkExistence(String email) {
		UserBean u = null;
		
		try {
			u = model.doRetrieveByKey(email);
			if(u == null) u = null;
			else return true;		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
