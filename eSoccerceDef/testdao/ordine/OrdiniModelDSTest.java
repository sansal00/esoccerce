package ordine;
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

import profilo.UserModelDSTest;

public class OrdiniModelDSTest extends DataSourceBasedDBTestCase{

	private OrdiniModelDS om;
	private DataSource ds;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:dbinit/ordine.sql'");
        dataSource.setUser("admin");
        dataSource.setPassword("12345");
        return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dbinit/ordine.xml"));
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
        ds = this.getDataSource();
        om = new OrdiniModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testdoSave() throws Exception {
		ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(OrdiniModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoSave.xml"))
                .getTable("ordine");
		
		 OrdiniBean bean = new OrdiniBean();
		 bean.setID(2347);
		 bean.setTotale(3042);
		 bean.setNumeroCarta("5254344324670943");
		 bean.setCVC(983);
		 bean.setDataScadenza("10/24");
		 bean.setNomeIntestatario("Bruno");
		 bean.setCognomeIntestatario("Farano");
		 bean.setDataOrdine("31/12/2022");
		 bean.setSpedizione("Spedizione in 2 giorni");
		 bean.setEmail("brunofarano@outlook.it");
		 
		 om.doSave(bean);
		 
		 IDatabaseTester tester = this.getDatabaseTester();
		 ITable actualTable =  tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoSaveNull() throws Exception {
		int i = 0;
		try {
			om.doSave(null);
		}
		catch (NullPointerException e) {
			i = 1;
		}
		catch (SQLException e) {
			i = 0;
		}
		assertEquals(1, i);
	}
	
	public void testdoDelete() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoDelete.xml"))
                 .getTable("ordine");
		 om.doDelete(2345);
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	public void testdoDeleteError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoDeleteError.xml"))
                .getTable("ordine");
		 om.doDelete(2348);
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoRetrieveAll() throws Exception {
		Collection<OrdiniBean> om1 = om.doRetrieveAll("brunofarano@outlook.it");
		ArrayList<OrdiniBean> om2 = new ArrayList<OrdiniBean>();
		
		 OrdiniBean bean = new OrdiniBean();
		 bean.setID(2342);
		 bean.setTotale(3042);
		 bean.setNumeroCarta("5254344324670943");
		 bean.setCVC(983);
		 bean.setDataScadenza("10/24");
		 bean.setNomeIntestatario("Bruno");
		 bean.setCognomeIntestatario("Farano");
		 bean.setDataOrdine("25/12/2022");
		 bean.setSpedizione("Spedizione in 3 giorni");
		 bean.setEmail("brunofarano@outlook.it"); 
		 om2.add(bean);
		
		 OrdiniBean bean2 = new OrdiniBean();
		 bean2.setID(2345);
		 bean2.setTotale(3042);
		 bean2.setNumeroCarta("5254344324670943");
		 bean2.setCVC(983);
		 bean2.setDataScadenza("10/24");
		 bean2.setNomeIntestatario("Bruno");
		 bean2.setCognomeIntestatario("Farano");
		 bean2.setDataOrdine("29/12/2022");
		 bean2.setSpedizione("Spedizione in 5 giorni");
		 bean2.setEmail("brunofarano@outlook.it"); 
		 om2.add(bean2);
		 
		ArrayList<OrdiniBean> om1a = new ArrayList<OrdiniBean>(om1);
		for(int i=0; i<om1a.size();i++)
		{			
			assertEquals(om1a.get(i).getID(), om2.get(i).getID());
			assertEquals(om1a.get(i).getTotale(), om2.get(i).getTotale());
			assertEquals(om1a.get(i).getNumeroCarta(), om2.get(i).getNumeroCarta());
			assertEquals(om1a.get(i).getCVC(), om2.get(i).getCVC());
			assertEquals(om1a.get(i).getNomeIntestatario(), om2.get(i).getNomeIntestatario());
			assertEquals(om1a.get(i).getCognomeIntestatario(), om2.get(i).getCognomeIntestatario());
			assertEquals(om1a.get(i).getDataOrdine(), om2.get(i).getDataOrdine());
			assertEquals(om1a.get(i).getSpedizione(), om2.get(i).getSpedizione());
			assertEquals(om1a.get(i).getEmail(), om2.get(i).getEmail());
		}
	}
	
	@Test
	public void testdoRetrieveAllError() throws Exception {
			Collection<OrdiniBean> ordini = null;
			try {
				ordini = om.doRetrieveAll("lollocapocollo@live.it");
			}
				catch (SQLException e) {
					assertNull(ordini);
				}
			}
	
	@Test
	public void testdoUpdateDelivery() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoUpdateDelivery.xml"))
                 .getTable("ordine");
		 
		 om.doUpdateDelivery(2342, "Spedizione arrivata con successo!");
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoUpdateDeliveryError() throws Exception {
		
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoUpdateDeliveryError.xml"))
                .getTable("ordine");
		 
		 om.doUpdateDelivery(54545, "Spedizione arrivata con successo!");
		 
		 IDatabaseTester tester= this.getDatabaseTester();		 
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
		 
	}
	
	@Test
	public void testdoUpdateOrder() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoUpdateOrder.xml"))
                 .getTable("ordine");
		 
		 om.doUpdateOrder(2342, "01/01/2023");
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoUpdateOrderError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedoUpdateOrderError.xml"))
                 .getTable("ordine");
		 
		 om.doUpdateOrder(232323, "01/01/2023");
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("ordine");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	}
	
	

