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


public class OrdineDettaglioModelDSTest extends DataSourceBasedDBTestCase{
	
	private OrdineDettaglioModelDS om;
	private DataSource ds;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:dbinit/ordinedettaglio.sql'");
        dataSource.setUser("admin");
        dataSource.setPassword("12345");
        return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dbinit/ordinedettaglio.xml"));
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
        ds = this.getDataSource();
        om = new OrdineDettaglioModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testdoSave() throws Exception {
		ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(OrdiniModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/ordinedettagliodoSave.xml"))
                .getTable("ordinedettaglio");
		
		 OrdineDettaglioBean bean = new OrdineDettaglioBean();
		 bean.setCode(6);
		 bean.setImage("/images/magliettachelsea.png");
		 bean.setNome("Maglietta Chelsea Home 2021/2022");
		 bean.setMarca("Nike");
		 bean.setDescrizione("Maglietta Chelsea Home 2021/2022");
		 bean.setPrezzo(75);
		 bean.setQuantitaAcquistata(1);
		 bean.setTaglia("M");
		 bean.setNumero(0);
		 bean.setDimensione("");
		 bean.setTipo("");
		 bean.setID(2345);
		 om.doSave(bean);
		 
		 IDatabaseTester tester = this.getDatabaseTester();
		 ITable actualTable =  tester.getConnection().createDataSet().getTable("ordinedettaglio");
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
		
	@Test
	public void testdoRetrieveByKey() throws Exception {
			Collection<OrdineDettaglioBean> om1 = om.doRetrieveByKey(2342);
			ArrayList<OrdineDettaglioBean> om2 = new ArrayList<OrdineDettaglioBean>();
			
			OrdineDettaglioBean bean = new OrdineDettaglioBean();
			 bean.setCode(1);
			 bean.setImage("/images/magliettapsg.png");
			 bean.setNome("Maglietta PSG Home 2021/2022");
			 bean.setMarca("Nike Jordan");
			 bean.setDescrizione("Maglietta PSG Home 2021/2022 Authentic Man");
			 bean.setPrezzo(65);
			 bean.setQuantitaAcquistata(45);
			 bean.setTaglia("M");
			 bean.setNumero(0);
			 bean.setDimensione("NULL");
			 bean.setTipo("NULL");
			 bean.setID(2342);
			om2.add(bean);
			
			OrdineDettaglioBean bean2 = new OrdineDettaglioBean();
			 bean2.setCode(11);
			 bean2.setImage("/images/tiempo.png");
			 bean2.setNome("Scarpe Calcio Nike Tiempo 9 Electric Blue");
			 bean2.setMarca("Nike");
			 bean2.setDescrizione("Scarpe Calcio Nike Tiempo 9 Electric Blue");
			 bean2.setPrezzo(39);
			 bean2.setQuantitaAcquistata(3);
			 bean2.setTaglia("NULL");
			 bean2.setNumero(47);
			 bean2.setDimensione("NULL");
			 bean2.setTipo("NULL");
			 bean2.setID(2342);
			om2.add(bean2);
			
			ArrayList<OrdineDettaglioBean> om1a = new ArrayList<OrdineDettaglioBean>(om1);
			for(int i=0; i<om1a.size();i++)
			{			
				assertEquals(om1a.get(i).getCode(), om2.get(i).getCode());
				assertEquals(om1a.get(i).getImage(), om2.get(i).getImage());
				assertEquals(om1a.get(i).getNome(), om2.get(i).getNome());
				assertEquals(om1a.get(i).getMarca(), om2.get(i).getMarca());
				assertEquals(om1a.get(i).getDescrizione(), om2.get(i).getDescrizione());
				assertEquals(om1a.get(i).getPrezzo(), om2.get(i).getPrezzo());
				assertEquals(om1a.get(i).getQuantitaAcquistata(), om2.get(i).getQuantitaAcquistata());
				assertEquals(om1a.get(i).getTaglia(), om2.get(i).getTaglia());
				assertEquals(om1a.get(i).getNumero(), om2.get(i).getNumero());
				assertEquals(om1a.get(i).getDimensione(), om2.get(i).getDimensione());
				assertEquals(om1a.get(i).getTipo(), om2.get(i).getTipo());
				assertEquals(om1a.get(i).getID(), om2.get(i).getID());
			}
			
		}
	
	@Test
	public void testdoRetrieveByKeyError() throws Exception {
		Collection<OrdineDettaglioBean> ordini = null;
		try {
			ordini = om.doRetrieveByKey(555);
		}
			catch (SQLException e) {
				assertNull(ordini);
			}
		}
	}
		
	
		
		
	