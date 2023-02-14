package profilo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import org.dbunit.Assertion;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserModelDSTest extends DataSourceBasedDBTestCase{
	
	private UserModelDS um;
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
        um = new UserModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testdoSave() throws Exception {
		
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentedoSave.xml"))
                 .getTable("utente");
		
		 UserBean bean = new UserBean();
		 bean.setEmail("pippopuppo@gmail.com");
		 bean.setPassword("Pippo2005");
		 bean.setNome("Pippo");
		 bean.setCognome("Puppo");
		 bean.setIndirizzo("Via Cinquegrana, 5");
		 bean.setCittà("Mercogliano (NA)");
		 
		 um.doSave(bean);
		 
		 IDatabaseTester tester = this.getDatabaseTester();
		 ITable actualTable =  tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
		 
	}
	
	@Test
	public void testdoSaveError() throws Exception {
		int i = 0;
		try {
			um.doSave(null);
		}
		catch (NullPointerException e) {
			i++;
		}
		catch (SQLException e) {
			i = 0;
		}
		assertEquals(1, i);
	}
	
	@Test
	public void testdoRetrieveByKey() throws Exception {
		UserBean user = um.doRetrieveByKey("admin@admin.it");
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
		UserBean user = um.doRetrieveByKey("pippomacello@live.it");
		assertNull(user);
	}
	
	@Test
	public void testdoRetrieveByKeyNull() throws Exception {
		UserBean user = null;
		try {
			user = um.doRetrieveByKey(null);
		}
		catch (NullPointerException e) {
			assertNull(user);
		}
	}
	
	@Test
	public void testdoRetrieveAll() throws Exception {
		Collection<UserBean> us1 = um.doRetrieveAll("nome");
		Collection<UserBean> us2 = new ArrayList<UserBean>();
		
		UserBean user1 = new UserBean();
		user1.setEmail("admin@admin.it");
		user1.setPassword("admin");
		user1.setNome("Administrator");
		user1.setCognome("eSoccerce");
		user1.setIndirizzo("Via Verde, 12");
		user1.setCittà("Salerno");
		us2.add(user1);
		
		UserBean user2 = new UserBean();
		user2.setEmail("brunofarano@outlook.it");
		user2.setPassword("Bruno2000");
		user2.setNome("Bruno");
		user2.setCognome("Farano");
		user2.setIndirizzo("Via Giallo, 15");
		user2.setCittà("Salerno");
		us2.add(user2);
		
		assertEquals(us1, us2);
	}
	
	@Test
	public void testdoRetrieveAllError() throws Exception {
		Collection<UserBean> user = null;
		try {
			user = um.doRetrieveAll("Pepp Scuppaett");
		}
			catch (SQLException e) {
				assertNull(user);
			}
		}
	
	@Test
	public void testdoRetrieveAllNull() throws Exception {
		Collection<UserBean> user = null;
		try {
			user = um.doRetrieveAll(null);
		}
			catch (SQLException e) {
				assertNull(user);
			}
		}
	
	public void testdoUpdate() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentedoUpdate.xml"))
                 .getTable("utente");
		 
		 UserBean useraggiornato = new UserBean();
		 useraggiornato.setEmail("admin@admin.it");
		 useraggiornato.setPassword("admin");
		 useraggiornato.setNome("Administrator");
		 useraggiornato.setCognome("eSoccerce");
		 useraggiornato.setIndirizzo("Via Verde, 12");
		 useraggiornato.setCittà("Genova");
		 
		 um.doUpdate(useraggiornato);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
		 
	}
	
	@Test
	public void testdoUpdateError() throws Exception {
		
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentedoUpdateError.xml"))
                 .getTable("utente");
		 
		 UserBean useraggiornato = new UserBean();
		 useraggiornato.setEmail("lda@lda.it");
		 useraggiornato.setCittà("Genova");
		 
		 um.doUpdate(useraggiornato);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
		 
	}
	
	@Test
	public void testdoUpdateNull() throws Exception {

		boolean flag = false;
		try {
			um.doUpdate(null);
		}
		catch(NullPointerException e){
			flag=true;
		}
		
		assertEquals(flag,true);
	}
	
	@Test
	public void testdoDelete() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentedoDelete.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.doDelete(user);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
		
	@Test
	public void testdoDeleteError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentedoDeleteError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("vivalamore@hotmail.it");
		 um.doDelete(user);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoDeleteNull() throws Exception {
		boolean flag = false;
		try {
			um.doDelete(null);
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag,true);
	}
	
	@Test
	public void testchangeEmail() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeEmail.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.changeEmail(user, "brunofarano1@outlook.it");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeEmailError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeEmailError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("fifone2000@outlook.it");
		 um.changeEmail(user, "brunofarano1@outlook.it");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeEmailUserNull() throws Exception {
		boolean flag = false;
		try {
			um.changeEmail(null, "scricchiolo@live.it");
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag, true);
	}
	
	@Test
	public void testchangeEmailExists() throws Exception {
		ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeEmailExists.xml"))
                .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("admin@admin.it");
		 um.changeEmail(user, "brunofarano@outlook.it");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	
	@Test
	public void testchangeName() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeName.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.changeName(user, "Carlo");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	
	@Test
	public void testchangeNameError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeNameError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("carletto@lol.it");
		 um.changeName(user, "Carlo");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeNameUserNull() throws Exception {
		boolean flag = false;
		try {
			um.changeName(null, "Pascael");
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag, true);
	}
	
	@Test
	public void testchangeSurname() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeSurname.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.changeSurname(user, "Santoriello");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeSurnameError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeSurnameError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("carletto@lol.it");
		 um.changeSurname(user, "Di Gregorio");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeSurnameUserNull() throws Exception {
		boolean flag = false;
		try {
			um.changeSurname(null, "Moriconi");
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag, true);
	}
	
	@Test
	public void testchangeAddress() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeAddress.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.changeAddress(user, "Via Marconi, 56");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeAddressError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeAddressError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("carletto@lol.it");
		 um.changeAddress(user, "Via Pietrasanta, 69");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeAddressUserNull() throws Exception {
		boolean flag = false;
		try {
			um.changeAddress(null, "Via Reggaeton, 22");
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag, true);
	}
	
	@Test
	public void testchangeCity() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeCity.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("brunofarano@outlook.it");
		 um.changeCity(user, "Napoli");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeCityError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/utentechangeCityError.xml"))
                 .getTable("utente");
		 UserBean user = new UserBean();
		 user.setEmail("carletto@lol.it");
		 um.changeCity(user, "Milano");
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("utente");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testchangeCityUserNull() throws Exception {
		boolean flag = false;
		try {
			um.changeCity(null, "Rio De Janeiro");
		}
		catch(NullPointerException e){
			flag = true;
		}
		
		assertEquals(flag, true);
	}
}
	
	
	

	
	
	
	
	
