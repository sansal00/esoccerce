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

public class OrdineDettaglioModelDS implements OrdineDettaglioModel<OrdineDettaglioBean> {
	private static DataSource ds;

	public OrdineDettaglioModelDS() {
		
	}
	
	public OrdineDettaglioModelDS(DataSource d) {
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
	
	private static final String TABLE_NAME = "ordinedettaglio";

	public synchronized void doSave(OrdineDettaglioBean prodotto) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrdineDettaglioModelDS.TABLE_NAME
				+ " (code, urlimage, nome, marca, descrizione, prezzo, quantitaacquistata, taglia, numero, dimensione, tipo, id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
			preparedStatement.setInt(7, prodotto.getQuantitaAcquistata());
			preparedStatement.setString(8, prodotto.getTaglia());
			preparedStatement.setInt(9, prodotto.getNumero());
			preparedStatement.setString(10, prodotto.getDimensione());
			preparedStatement.setString(11, prodotto.getTipo());
			preparedStatement.setInt(12, prodotto.getID());
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

	public synchronized Collection<OrdineDettaglioBean> doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineDettaglioBean> dettaglio = new LinkedList<OrdineDettaglioBean>();

		String selectSQL = "SELECT * FROM " + OrdineDettaglioModelDS.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineDettaglioBean bean = new OrdineDettaglioBean();
				bean.setCode(rs.getInt("code"));
				bean.setImage(rs.getString("urlimage"));
				bean.setNome(rs.getString("nome"));
				bean.setMarca(rs.getString("marca"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuantitaAcquistata(rs.getInt("quantitaacquistata"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setNumero(rs.getInt("numero"));
				bean.setDimensione(rs.getString("dimensione"));
				bean.setTipo(rs.getString("tipo"));
				bean.setID(rs.getInt("id"));
				dettaglio.add(bean);
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
		if (dettaglio.size() != 0) return dettaglio;
		else return null;
	}

}
