package ordine;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdiniModel<T> {
	
	public void doSave(T ordine) throws SQLException;
	public boolean doDelete(int id) throws SQLException;
	public Collection<T> doRetrieveAll(String email) throws SQLException;
	public void doUpdateDelivery(int id, String spedizione) throws SQLException;
	public void doUpdateOrder(int id, String ordine) throws SQLException;
}
