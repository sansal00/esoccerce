package ordine;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdineDettaglioModel<T> {
	public void doSave(T prodotto) throws SQLException;
	public Collection<OrdineDettaglioBean> doRetrieveByKey(int id) throws SQLException;
}
