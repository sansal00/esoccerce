package recensione;

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
import ordine.OrdiniModelDSTest;
import profilo.UserModelDSTest;


public class RecensioniModelDSTest extends DataSourceBasedDBTestCase{

	private RecensioniModelDS rm;
	private DataSource ds;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:dbinit/recensione.sql'");
        dataSource.setUser("admin");
        dataSource.setPassword("12345");
        return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dbinit/recensione.xml"));
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
        ds = this.getDataSource();
        rm = new RecensioniModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testdoSave() throws Exception {
		
		ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(OrdiniModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/recensionedoSave.xml"))
                .getTable("recensione");
		
		 RecensioniBean bean = new RecensioniBean();
		 bean.setNumero(5);
		 bean.setNomeProdotto("Calzettoni Juventus Home 2021/2022");
		 bean.setDescrizione("Prodotto davvero eccezionale!");
		 bean.setStelle(4);
		 bean.setEmail("brunofarano@outlook.it");
		 rm.doSave(bean);
		 
		 IDatabaseTester tester = this.getDatabaseTester();
		 ITable actualTable =  tester.getConnection().createDataSet().getTable("recensione");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
		
	}
	
	@Test
	public void testdoSaveNull() throws Exception {
		int i = 0;
		try {
			rm.doSave(null);
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
	public void testdoDelete() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/recensionedoDelete.xml"))
                 .getTable("recensione");
		 rm.doDelete(3);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("recensione");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoDeleteError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/recensionedoDeleteError.xml"))
                 .getTable("recensione");
		 rm.doDelete(5543);
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("recensione");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoRetrieveByKey() throws Exception {
		RecensioniBean bean = rm.doRetrieveByKey("Maglietta PSG Home 2021/2022");
		RecensioniBean bean2 = new RecensioniBean();
		
		 bean2.setNumero(1);
		 bean2.setNomeProdotto("Maglietta PSG Home 2021/2022");
		 bean2.setDescrizione("Prodotto veramente fantastico!");
		 bean2.setStelle(5);
		 bean2.setEmail("brunofarano@outlook.it");
		
		 	assertEquals(bean.getNumero(), bean2.getNumero());
			assertEquals(bean.getNomeProdotto(), bean2.getNomeProdotto());
			assertEquals(bean.getDescrizione(), bean2.getDescrizione());
			assertEquals(bean.getStelle(), bean2.getStelle());
			assertEquals(bean.getEmail(), bean2.getEmail());
	}
	
	@Test
	public void testdoRetrieveByKeyError() throws Exception {
		RecensioniBean bean = rm.doRetrieveByKey("Carne Cottura Media LOL");
		assertNull(bean);
	}
	
	@Test
	public void testdoRetrieveAll() throws Exception {
		Collection<RecensioniBean> re1 = rm.doRetrieveAll("Maglietta PSG Home 2021/2022");
		ArrayList<RecensioniBean> re2 = new ArrayList<RecensioniBean>();
		
		RecensioniBean bean = new RecensioniBean();
		bean.setNumero(1);
		 bean.setNomeProdotto("Maglietta PSG Home 2021/2022");
		 bean.setDescrizione("Prodotto veramente fantastico!");
		 bean.setStelle(5);
		 bean.setEmail("brunofarano@outlook.it");
		re2.add(bean);
		
		ArrayList<RecensioniBean> re1a = new ArrayList<RecensioniBean>(re1);
		for(int i=0; i<re1a.size();i++)
		{			
			assertEquals(re1a.get(i).getNumero(), re2.get(i).getNumero());
			assertEquals(re1a.get(i).getNomeProdotto(), re2.get(i).getNomeProdotto());
			assertEquals(re1a.get(i).getDescrizione(), re2.get(i).getDescrizione());
			assertEquals(re1a.get(i).getStelle(), re2.get(i).getStelle());
			assertEquals(re1a.get(i).getEmail(), re2.get(i).getEmail());
		}
	}
	
	@Test
	public void testdoRetrieveAllError() throws Exception {
			Collection<RecensioniBean> ordini = null;
			try {
				ordini = rm.doRetrieveAll("Arrosticini Di Pollo");
			}
				catch (SQLException e) {
					assertNull(ordini);
				}
			}
	
}
