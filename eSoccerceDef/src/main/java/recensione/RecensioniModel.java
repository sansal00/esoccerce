package recensione;

import java.sql.SQLException;
import java.util.Collection;

public interface RecensioniModel<T>{
	
	public void doSave(T recensione) throws SQLException;

	public boolean doDelete(int numero) throws SQLException;

	public T doRetrieveByKey(String nomeprodotto) throws SQLException;
	
	public Collection<T> doRetrieveAll(String email) throws SQLException;

}
