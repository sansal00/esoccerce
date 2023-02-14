package prodotto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class ProdottoModelDS implements ProdottoModel<ProdottoBean>{
	
	private static DataSource ds;
	
	public ProdottoModelDS() {
		
	}
	
	public ProdottoModelDS(DataSource d) {
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
	
	private static final String TABLE_NAME = "prodotto";
	public synchronized void doSave(ProdottoBean prodotto, String email) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProdottoModelDS.TABLE_NAME
				+ " (code, urlimage, nome, marca, descrizione, prezzo, quantita, taglia, numero, dimensione, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, prodotto.getCode());
			preparedStatement.setString(2, prodotto.getImage());
			preparedStatement.setString(3, prodotto.getNome());
			preparedStatement.setString(4, prodotto.getMarca());
			preparedStatement.setString(5, prodotto.getDescrizione());
			preparedStatement.setInt(6, prodotto.getPrezzo());
			preparedStatement.setInt(7, prodotto.getQuantita());
			preparedStatement.setString(8, prodotto.getTaglia());
			preparedStatement.setInt(9, prodotto.getNumero());
			preparedStatement.setString(10, prodotto.getDimensione());
			preparedStatement.setString(11, prodotto.getTipo());
			
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
	
	public synchronized ProdottoBean doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProdottoBean bean = new ProdottoBean();

		String selectSQL = "SELECT * FROM " + ProdottoModelDS.TABLE_NAME + " WHERE code = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCode(rs.getInt("code"));
				bean.setImage(rs.getString("urlimage"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setNumero(rs.getInt("numero"));
				bean.setDimensione(rs.getString("dimensione"));
				bean.setTipo(rs.getString("tipo"));
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
		if (bean.getNome() != null) return bean;
		else return null;
	}
	
	public synchronized boolean doDelete(int code, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		int result2 = 0;

		String deleteSQL = "DELETE FROM " + ProdottoModelDS.TABLE_NAME + " WHERE code = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

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
		return (result != 0) && (result2 != 0);
	}

	
	public synchronized Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();

		String selectSQL = "SELECT * FROM " + ProdottoModelDS.TABLE_NAME + " WHERE nome LIKE '" + order +"%'";

		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();

				bean.setCode(rs.getInt("code"));
				bean.setImage(rs.getString("urlimage"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setNumero(rs.getInt("numero"));
				bean.setDimensione(rs.getString("dimensione"));
				bean.setTipo(rs.getString("tipo"));
				prodotti.add(bean);
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
		return prodotti;
	}


	public synchronized void doUpdatePrice(int code, int prezzo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "UPDATE " + ProdottoModelDS.TABLE_NAME + " SET prezzo = " + prezzo +  " WHERE code = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
			preparedStatement.executeUpdate();

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
	
	public synchronized Collection<ProdottoBean> doRetrieveSearch(String ricerca) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> result = new LinkedList<ProdottoBean>();
		if (ricerca.equals("maglia") || ricerca.equals("divisa") || ricerca.equals("kit") || ricerca.equals("magliette")) {
			ricerca = "maglietta";
		}
		if (ricerca.equals("scarpette") || ricerca.equals("scarpini") || ricerca.equals("scarpino")) {
			ricerca = "scarpe calcio";
		}
		if (ricerca.equals("pantaloncino") || ricerca.equals("pantaloni") || ricerca.equals("kit")) {
			ricerca = "pantaloncini";
		}
		if (ricerca.equals("borsa") || ricerca.equals("borsoni")) {
			ricerca = "borsone";
		}
		if (ricerca.equals("gadgets")) {
			ricerca = "gadget";
		}
		String selectSQL = "SELECT * FROM " + ProdottoModelDS.TABLE_NAME + " WHERE nome LIKE '%" + ricerca + "%'";
		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();

				bean.setCode(rs.getInt("code"));
				bean.setImage(rs.getString("urlimage"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setNumero(rs.getInt("numero"));
				bean.setDimensione(rs.getString("dimensione"));
				bean.setTipo(rs.getString("tipo"));
				result.add(bean);
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
		return result;
	}
	public synchronized Collection<ProdottoBean> doRetrieveAllProducts() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> result = new LinkedList<ProdottoBean>();
		String selectSQL = "SELECT * FROM " + ProdottoModelDS.TABLE_NAME;
		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();
				bean.setCode(rs.getInt("code"));
				bean.setImage(rs.getString("urlimage"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setNumero(rs.getInt("numero"));
				bean.setDimensione(rs.getString("dimensione"));
				bean.setTipo(rs.getString("tipo"));
				result.add(bean);
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
		return result;
	}
	public synchronized void doUpdateQuantity(int quantità, int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "UPDATE " + ProdottoModelDS.TABLE_NAME + " SET quantita = quantita - " + quantità +  " WHERE code = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
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
	
	public synchronized void doIncreaseQuantity(int quantità, int code, String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;


		String updateSQL = "UPDATE " + ProdottoModelDS.TABLE_NAME + " SET quantita = quantita + " + quantità +  " WHERE code = ?";
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, code);
			
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
