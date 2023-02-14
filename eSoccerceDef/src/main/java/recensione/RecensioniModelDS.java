package recensione;

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




public class RecensioniModelDS implements RecensioniModel<RecensioniBean> {
	
	private static DataSource ds;
	
	public RecensioniModelDS() {
		
	}
	
	public RecensioniModelDS(DataSource d) {
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
	
	private static final String TABLE_NAME = "recensione";

	
	public void doSave(RecensioniBean recensione) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + RecensioniModelDS.TABLE_NAME
				+ " (numero, nomeprodotto, descrizione, stelle, email) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, recensione.getNumero());
			preparedStatement.setString(2, recensione.getNomeProdotto());
			preparedStatement.setString(3, recensione.getDescrizione());
			preparedStatement.setInt(4, recensione.getStelle());
			preparedStatement.setString(5, recensione.getEmail());

			
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

	public boolean doDelete(int numero) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + RecensioniModelDS.TABLE_NAME + " WHERE numero = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, numero);

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



	public RecensioniBean doRetrieveByKey(String nomeprodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		RecensioniBean bean = new RecensioniBean();

		String selectSQL = "SELECT * FROM " + RecensioniModelDS.TABLE_NAME + " WHERE nomeprodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nomeprodotto);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNumero(rs.getInt("numero"));
				bean.setNomeProdotto(rs.getString("nomeprodotto"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setStelle(rs.getInt("stelle"));
				bean.setEmail(rs.getString("email"));
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
		if (bean.getNomeProdotto() != null) return bean;
		else return null;
	}


	public Collection<RecensioniBean> doRetrieveAll(String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<RecensioniBean> recensioni = new LinkedList<RecensioniBean>();

		String selectSQL = "SELECT * FROM " + RecensioniModelDS.TABLE_NAME + " WHERE nomeprodotto = ?";

		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RecensioniBean bean = new RecensioniBean();
				bean.setNumero(rs.getInt("numero"));
				bean.setNomeProdotto(rs.getString("nomeprodotto"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setStelle(rs.getInt("stelle"));
				bean.setEmail(rs.getString("email"));
				recensioni.add(bean);
			}
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return recensioni;
	}
	
}
