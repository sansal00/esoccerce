package prodotto;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel<T> {
	public void doSave(T prodotto, String email) throws SQLException;
	
	public void doUpdatePrice(int code, int prezzo) throws SQLException;

	public boolean doDelete(int code, String email) throws SQLException;

	public T doRetrieveByKey(int code) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public Collection<T> doRetrieveSearch(String ricerca) throws SQLException;
	
	public void doUpdateQuantity(int quantità, int code) throws SQLException;
	
	public Collection<T> doRetrieveAllProducts() throws SQLException;
	
	public void doIncreaseQuantity(int quantità, int code, String email) throws SQLException;
}
