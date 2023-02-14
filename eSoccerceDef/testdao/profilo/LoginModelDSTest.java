package profilo;

import javax.sql.DataSource;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginModelDSTest extends DataSourceBasedDBTestCase{
	
	private LoginModelDS lm;
	private DataSource ds;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:dbinit/utente.sql'");
        dataSource.setUser("admin");
        dataSource.setPassword("12345");
        return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dbinit/utente.xml"));
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
        ds = this.getDataSource();
        lm = new LoginModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testdoRetrieveByKey() throws Exception {		
		UserBean user = lm.doRetrieveByKey("admin@admin.it", "admin");
		UserBean u = new UserBean();
		u.setEmail("admin@admin.it");
		u.setPassword("admin");
		u.setNome("Administrator");
		u.setCognome("eSoccerce");
		u.setIndirizzo("Via Verde, 12");
		u.setCittà("Salerno");
		
		assertEquals(user.getEmail(), u.getEmail());
		assertEquals(user.getPassword(), u.getPassword());
		assertEquals(user.getNome(), u.getNome());
		assertEquals(user.getCognome(), u.getCognome());
		assertEquals(user.getIndirizzo(), u.getIndirizzo());
		assertEquals(user.getCittà(), u.getCittà());		
	}
	
	@Test
	public void testdoRetrieveByKeyError() throws Exception {
		UserBean user = lm.doRetrieveByKey("pippomacello@live.it", "admin");
		assertNull(user);
	}
	
	@Test
	public void testdoRetrieveByKeyPasswordError() throws Exception {
		UserBean user = lm.doRetrieveByKey("admin@admin.it", "ShesFromItalia");
		assertNull(user);
	}
}

