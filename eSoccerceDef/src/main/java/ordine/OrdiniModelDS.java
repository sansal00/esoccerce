package ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class OrdiniModelDS implements OrdiniModel<OrdiniBean>{
	private static DataSource ds;
	private static final String TABLE_NAME = "ordine";
	
	public OrdiniModelDS() {
		
	}
	
	public OrdiniModelDS(DataSource d) {
		ds = d;
	}
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/esoccerce");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	public synchronized void doSave(OrdiniBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrdiniModelDS.TABLE_NAME
				+ " (id, totale, numerocarta, cvc, datascadenza, nomeintestatario, cognomeintestatario, dataordine, spedizione, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, ordine.getID());
			preparedStatement.setInt(2, ordine.getTotale());
			preparedStatement.setString(3, ordine.getNumeroCarta());
			preparedStatement.setInt(4, ordine.getCVC());
			preparedStatement.setString(5, ordine.getDataScadenza());
			preparedStatement.setString(6, ordine.getNomeIntestatario());
			preparedStatement.setString(7, ordine.getCognomeIntestatario());
			preparedStatement.setString(8, ordine.getDataOrdine());
			preparedStatement.setString(9, ordine.getSpedizione());
			preparedStatement.setString(10, ordine.getEmail());
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}

	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + OrdiniModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

	public synchronized Collection<OrdiniBean> doRetrieveAll(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdiniBean> ordini = new LinkedList<OrdiniBean>();

		String selectSQL = "SELECT * FROM " + OrdiniModelDS.TABLE_NAME + " WHERE email = ?";

		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdiniBean bean = new OrdiniBean();
				
				bean.setID(rs.getInt("id"));
				bean.setTotale(rs.getInt("totale"));
				bean.setNumeroCarta(rs.getString("numerocarta"));
				bean.setCVC(rs.getInt("cvc"));
				bean.setDataScadenza(rs.getString("datascadenza"));
				bean.setNomeIntestatario(rs.getString("nomeintestatario"));
				bean.setCognomeIntestatario(rs.getString("cognomeintestatario"));
				bean.setDataOrdine(rs.getString("dataordine"));
				bean.setSpedizione(rs.getString("spedizione"));
				bean.setEmail(rs.getString("email"));
				ordini.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return ordini;
	}
	
	public synchronized void doUpdateDelivery(int id, String spedizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + OrdiniModelDS.TABLE_NAME
				+ " SET spedizione = ? WHERE id = ?";
		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, spedizione);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	public synchronized void doUpdateOrder(int id, String ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + OrdiniModelDS.TABLE_NAME
				+ " SET dataordine = ? WHERE id = ?";
		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, ordine);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}

}
