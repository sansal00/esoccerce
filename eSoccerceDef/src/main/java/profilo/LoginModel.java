package profilo;

import java.sql.SQLException;

public interface LoginModel<T>{
	
	public T doRetrieveByKey(String email, String password) throws SQLException;
	

}
