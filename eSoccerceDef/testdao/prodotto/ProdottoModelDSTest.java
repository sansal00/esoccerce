package prodotto;

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


public class ProdottoModelDSTest extends DataSourceBasedDBTestCase{

	private ProdottoModelDS pm;
	private DataSource ds;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:dbinit/prodotto.sql'");
        dataSource.setUser("admin");
        dataSource.setPassword("12345");
        return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dbinit/prodotto.xml"));
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
        ds = this.getDataSource();
        pm = new ProdottoModelDS(ds);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testdoSave() throws Exception {
		ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoSave.xml"))
                .getTable("prodotto");

		ProdottoBean bean = new ProdottoBean();	
		 bean.setCode(77);
		 bean.setImage("/images/magliettamilan.png");
		 bean.setNome("Maglietta Milan Home 2021/2022");
		 bean.setMarca("Puma");
		 bean.setDescrizione("Maglietta Milan Home 2021/2022");
		 bean.setPrezzo(75);
		 bean.setQuantita(40);
		 bean.setTaglia("M");
		 bean.setNumero(0);
		 bean.setDimensione("NULL");
		 bean.setTipo("NULL");
		 
		 pm.doSave(bean, "admin@admin.it");
		 
		 IDatabaseTester tester = this.getDatabaseTester();
		 ITable actualTable =  tester.getConnection().createDataSet().getTable("prodotto");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));

	}
	
	@Test
	public void testdoSaveProductNull() throws Exception {
		int i = 0;
		try {
			pm.doSave(null, "admin@admin.it");
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
		ProdottoBean bean2 = pm.doRetrieveByKey(1);
		ProdottoBean bean = new ProdottoBean();
		bean.setCode(1);
		bean.setImage("/images/magliettapsg.png");
		bean.setNome("Maglietta PSG Home 2021/2022");
		bean.setMarca("Nike Jordan");
		bean.setDescrizione("Maglietta PSG Home 2021/2022 Authentic Man");
		bean.setPrezzo(65);
		bean.setQuantita(50);
		bean.setTaglia("M");
		bean.setNumero(0);
		bean.setDimensione("NULL");
		bean.setTipo("NULL");
		assertEquals(bean.getCode(), bean2.getCode());
		assertEquals(bean.getImage(), bean2.getImage());
		assertEquals(bean.getNome(), bean2.getNome());
		assertEquals(bean.getMarca(), bean2.getMarca());
		assertEquals(bean.getDescrizione(), bean2.getDescrizione());
		assertEquals(bean.getPrezzo(), bean2.getPrezzo());
		assertEquals(bean.getQuantita(), bean2.getQuantita());
		assertEquals(bean.getTaglia(), bean2.getTaglia());
		assertEquals(bean.getNumero(), bean2.getNumero());
		assertEquals(bean.getDimensione(), bean2.getDimensione());
		assertEquals(bean.getTipo(), bean2.getTipo());
		}
	
	@Test
	public void testdoRetrieveByKeyError() throws Exception {
		ProdottoBean prodotto = null;
		try {
			prodotto = pm.doRetrieveByKey(2323);
		}
			catch (SQLException e) {
				assertNull(prodotto);
			}
		}
	
	@Test
	public void testdoDelete() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                 .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoDelete.xml"))
                 .getTable("prodotto");
		 pm.doDelete(1, "admin@admin.it");
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoDeleteError() throws Exception {
		 ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(UserModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoDeleteError.xml"))
                .getTable("prodotto");
		 pm.doDelete(3434333, "admin@admin.it");
		 
		 IDatabaseTester tester= this.getDatabaseTester();
		 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
		 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
	}
	
	@Test
	public void testdoRetrieveAll() throws Exception {
		
		Collection<ProdottoBean> om1 = pm.doRetrieveAll("nome");
		ArrayList<ProdottoBean> om2 = new ArrayList<ProdottoBean>();
		
		ProdottoBean bean = new ProdottoBean();
		 bean.setCode(1);
		 bean.setImage("/images/magliettapsg.png");
		 bean.setNome("Maglietta PSG Home 2021/2022");
		 bean.setMarca("Nike Jordan");
		 bean.setDescrizione("Maglietta PSG Home 2021/2022 Authentic Man");
		 bean.setPrezzo(65);
		 bean.setQuantita(50);
		 bean.setTaglia("M");
		 bean.setNumero(0);
		 bean.setDimensione("NULL");
		 bean.setTipo("NULL");
		om2.add(bean);
		
		ProdottoBean bean2 = new ProdottoBean();
		 bean2.setCode(2);
		 bean2.setImage("/images/magliettajuve.png");
		 bean2.setNome("Maglietta Juventus Home 2021/2022");
		 bean2.setMarca("Adidas");
		 bean2.setDescrizione("Maglietta Juventus Home 2021/2022");
		 bean2.setPrezzo(65);
		 bean2.setQuantita(50);
		 bean2.setTaglia("M");
		 bean2.setNumero(0);
		 bean2.setDimensione("NULL");
		 bean2.setTipo("NULL");
		om2.add(bean2);
		
		ProdottoBean bean3 = new ProdottoBean();
		 bean3.setCode(3);
		 bean3.setImage("/images/magliettamanutd.png");
		 bean3.setNome("Maglietta Manchester United Home 2021/2022");
		 bean3.setMarca("Adidas");
		 bean3.setDescrizione("Maglietta Manchester United Home 2021/2022");
		 bean3.setPrezzo(65);
		 bean3.setQuantita(50);
		 bean3.setTaglia("XL");
		 bean3.setNumero(0);
		 bean3.setDimensione("NULL");
		 bean3.setTipo("NULL");
		om2.add(bean3);
		
		ProdottoBean bean4 = new ProdottoBean();
		 bean4.setCode(4);
		 bean4.setImage("/images/magliettarealmadrid.png");
		 bean4.setNome("Maglietta Real Madrid Home 2021/2022");
		 bean4.setMarca("Adidas");
		 bean4.setDescrizione("Maglietta Real Madrid Home 2021/2022");
		 bean4.setPrezzo(90);
		 bean4.setQuantita(50);
		 bean4.setTaglia("M");
		 bean4.setNumero(0);
		 bean4.setDimensione("NULL");
		 bean4.setTipo("NULL");
		om2.add(bean4);
		
		ProdottoBean bean5 = new ProdottoBean();
		 bean5.setCode(5);
		 bean5.setImage("/images/magliettabvb.png");
		 bean5.setNome("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setMarca("Puma");
		 bean5.setDescrizione("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setPrezzo(65);
		 bean5.setQuantita(50);
		 bean5.setTaglia("3XL");
		 bean5.setNumero(0);
		 bean5.setDimensione("NULL");
		 bean5.setTipo("NULL");
		om2.add(bean5);
		
		ProdottoBean bean6 = new ProdottoBean();
		 bean6.setCode(6);
		 bean6.setImage("/images/magliettachelsea.png");
		 bean6.setNome("Maglietta Chelsea Home 2021/2022");
		 bean6.setMarca("Nike");
		 bean6.setDescrizione("Maglietta Chelsea Home 2021/2022");
		 bean6.setPrezzo(75);
		 bean6.setQuantita(50);
		 bean6.setTaglia("M");
		 bean6.setNumero(0);
		 bean6.setDimensione("NULL");
		 bean6.setTipo("NULL");
		om2.add(bean6);
		
		ProdottoBean bean7 = new ProdottoBean();
		 bean7.setCode(7);
		 bean7.setImage("/images/pantaloncinibvb.png");
		 bean7.setNome("Pantaloncini Borussia Dortmund Home 2021/2022");
		 bean7.setMarca("Puma");
		 bean7.setDescrizione("Pantaloncini Borussia Dortmund Home 2021/2022");
		 bean7.setPrezzo(45);
		 bean7.setQuantita(50);
		 bean7.setTaglia("M");
		 bean7.setNumero(0);
		 bean7.setDimensione("NULL");
		 bean7.setTipo("NULL");
		om2.add(bean7);
		
		ProdottoBean bean8 = new ProdottoBean();
		 bean8.setCode(8);
		 bean8.setImage("/images/pantaloncinichelsea.png");
		 bean8.setNome("Pantaloncini Chelsea Home 2021/2022");
		 bean8.setMarca("Nike");
		 bean8.setDescrizione("Pantaloncini Chelsea Home 2021/2022");
		 bean8.setPrezzo(35);
		 bean8.setQuantita(40);
		 bean8.setTaglia("M");
		 bean8.setNumero(0);
		 bean8.setDimensione("NULL");
		 bean8.setTipo("NULL");
		om2.add(bean8);
		
		ProdottoBean bean9 = new ProdottoBean();
		 bean9.setCode(9);
		 bean9.setImage("/images/pantaloncinijuve.png");
		 bean9.setNome("Pantaloncini Juventus Home 2021/2022");
		 bean9.setMarca("Adidas");
		 bean9.setDescrizione("Pantaloncini Juventus Home 2021/2022");
		 bean9.setPrezzo(35);
		 bean9.setQuantita(40);
		 bean9.setTaglia("M");
		 bean9.setNumero(0);
		 bean9.setDimensione("NULL");
		 bean9.setTipo("NULL");
		om2.add(bean9);
		
		ProdottoBean bean10 = new ProdottoBean();
		 bean10.setCode(10);
		 bean10.setImage("/images/calzettonijuve.png");
		 bean10.setNome("Calzettoni Juventus Home 2021/2022");
		 bean10.setMarca("Adidas");
		 bean10.setDescrizione("Calzettoni Juventus Home 2021/2022");
		 bean10.setPrezzo(15);
		 bean10.setQuantita(20);
		 bean10.setTaglia("NULL");
		 bean10.setNumero(46);
		 bean10.setDimensione("NULL");
		 bean10.setTipo("NULL");
		om2.add(bean10);
		
		ProdottoBean bean11 = new ProdottoBean();
		 bean11.setCode(11);
		 bean11.setImage("/images/tiempo.png");
		 bean11.setNome("Scarpe Calcio Nike Tiempo 9 Electric Blue");
		 bean11.setMarca("Nike");
		 bean11.setDescrizione("Scarpe Calcio Nike Tiempo 9 Electric Blue");
		 bean11.setPrezzo(39);
		 bean11.setQuantita(50);
		 bean11.setTaglia("NULL");
		 bean11.setNumero(47);
		 bean11.setDimensione("NULL");
		 bean11.setTipo("NULL");
		om2.add(bean11);
		
		ProdottoBean bean12 = new ProdottoBean();
		 bean12.setCode(12);
		 bean12.setImage("/images/pegasus.png");
		 bean12.setNome("Scarpe Running Nike Air Zoom Pegasus Pink");
		 bean12.setMarca("Nike");
		 bean12.setDescrizione("Scarpe Running Nike Air Zoom Pegasus Pink");
		 bean12.setPrezzo(39);
		 bean12.setQuantita(50);
		 bean12.setTaglia("NULL");
		 bean12.setNumero(42);
		 bean12.setDimensione("NULL");
		 bean12.setTipo("NULL");
		om2.add(bean12);
		
		ProdottoBean bean13 = new ProdottoBean();
		 bean13.setCode(13);
		 bean13.setImage("/images/orologiomilan.png");
		 bean13.setNome("Gadget Orologio Milan Da Polso Black");
		 bean13.setMarca("Puma");
		 bean13.setDescrizione("Gadget Orologio Milan Da Polso Black");
		 bean13.setPrezzo(25);
		 bean13.setQuantita(50);
		 bean13.setTaglia("NULL");
		 bean13.setNumero(0);
		 bean13.setDimensione("NULL");
		 bean13.setTipo("Orologio");
		om2.add(bean13);
		
		ProdottoBean bean14 = new ProdottoBean();
		 bean14.setCode(14);
		 bean14.setImage("/images/portachiavicalcio.png");
		 bean14.setNome("Gadget Portachiavi Calcio Gold");
		 bean14.setMarca("Gold");
		 bean14.setDescrizione("Gadget Portachiavi Calcio Gold");
		 bean14.setPrezzo(15);
		 bean14.setQuantita(10);
		 bean14.setTaglia("NULL");
		 bean14.setNumero(0);
		 bean14.setDimensione("NULL");
		 bean14.setTipo("Portachiavi");
		om2.add(bean14);
		
		ProdottoBean bean15 = new ProdottoBean();
		 bean15.setCode(15);
		 bean15.setImage("/images/borsonenike.png");
		 bean15.setNome("Borsone Nike New Style Red");
		 bean15.setMarca("Nike Jordan");
		 bean15.setDescrizione("Borsone Nike New Style Red Authentic Man/Woman");
		 bean15.setPrezzo(55);
		 bean15.setQuantita(50);
		 bean15.setTaglia("M");
		 bean15.setNumero(0);
		 bean15.setDimensione("50x70x90");
		 bean15.setTipo("NULL");
		om2.add(bean15);
		
		ProdottoBean bean16 = new ProdottoBean();
		 bean16.setCode(16);
		 bean16.setImage("/images/parastinchinike.png");
		 bean16.setNome("Parastinchi Nike Red + Accessories");
		 bean16.setMarca("Nike");
		 bean16.setDescrizione("Parastinchi Nike Red Authentic + Accessories");
		 bean16.setPrezzo(15);
		 bean16.setQuantita(50);
		 bean16.setTaglia("NULL");
		 bean16.setNumero(0);
		 bean16.setDimensione("NULL");
		 bean16.setTipo("Parastinchi");
		om2.add(bean16);
		
		ArrayList<ProdottoBean> om1a = new ArrayList<ProdottoBean>(om1);
		for(int i=0; i<om1a.size();i++)
		{			
			assertEquals(om1a.get(i).getCode(), om2.get(i).getCode());
			assertEquals(om1a.get(i).getImage(), om2.get(i).getImage());
			assertEquals(om1a.get(i).getNome(), om2.get(i).getNome());
			assertEquals(om1a.get(i).getMarca(), om2.get(i).getMarca());
			assertEquals(om1a.get(i).getDescrizione(), om2.get(i).getDescrizione());
			assertEquals(om1a.get(i).getPrezzo(), om2.get(i).getPrezzo());
			assertEquals(om1a.get(i).getQuantita(), om2.get(i).getQuantita());
			assertEquals(om1a.get(i).getTaglia(), om2.get(i).getTaglia());
			assertEquals(om1a.get(i).getNumero(), om2.get(i).getNumero());
			assertEquals(om1a.get(i).getDimensione(), om2.get(i).getDimensione());
			assertEquals(om1a.get(i).getTipo(), om2.get(i).getTipo());
		}

	}
	
	@Test
	public void testdoRetrieveAllError() throws Exception {
			Collection<ProdottoBean> prodotti = null;
			try {
				prodotti = pm.doRetrieveAll("famiglia");
			}
				catch (SQLException e) {
					assertNull(prodotti);
				}
			}
	
	@Test
	public void testdoUpdatePrice() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoUpdatePrice.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doUpdatePrice(1, 100);
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
		
	@Test
	public void testdoUpdatePriceError() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoUpdatePriceError.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doUpdatePrice(34343434, 20);
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
	
	@Test 
	public void testdoRetrieveSearch() throws Exception {
		
		Collection<ProdottoBean> om1 = pm.doRetrieveSearch("maglia");
		ArrayList<ProdottoBean> om2 = new ArrayList<ProdottoBean>();
		
		ProdottoBean bean = new ProdottoBean();
		 bean.setCode(1);
		 bean.setImage("/images/magliettapsg.png");
		 bean.setNome("Maglietta PSG Home 2021/2022");
		 bean.setMarca("Nike Jordan");
		 bean.setDescrizione("Maglietta PSG Home 2021/2022 Authentic Man");
		 bean.setPrezzo(65);
		 bean.setQuantita(50);
		 bean.setTaglia("M");
		 bean.setNumero(0);
		 bean.setDimensione("NULL");
		 bean.setTipo("NULL");
		om2.add(bean);
		
		ProdottoBean bean2 = new ProdottoBean();
		 bean2.setCode(2);
		 bean2.setImage("/images/magliettajuve.png");
		 bean2.setNome("Maglietta Juventus Home 2021/2022");
		 bean2.setMarca("Adidas");
		 bean2.setDescrizione("Maglietta Juventus Home 2021/2022");
		 bean2.setPrezzo(65);
		 bean2.setQuantita(50);
		 bean2.setTaglia("M");
		 bean2.setNumero(0);
		 bean2.setDimensione("NULL");
		 bean2.setTipo("NULL");
		om2.add(bean2);
		
		ProdottoBean bean3 = new ProdottoBean();
		 bean3.setCode(3);
		 bean3.setImage("/images/magliettamanutd.png");
		 bean3.setNome("Maglietta Manchester United Home 2021/2022");
		 bean3.setMarca("Adidas");
		 bean3.setDescrizione("Maglietta Manchester United Home 2021/2022");
		 bean3.setPrezzo(65);
		 bean3.setQuantita(50);
		 bean3.setTaglia("XL");
		 bean3.setNumero(0);
		 bean3.setDimensione("NULL");
		 bean3.setTipo("NULL");
		om2.add(bean3);
		
		ProdottoBean bean4 = new ProdottoBean();
		 bean4.setCode(4);
		 bean4.setImage("/images/magliettarealmadrid.png");
		 bean4.setNome("Maglietta Real Madrid Home 2021/2022");
		 bean4.setMarca("Adidas");
		 bean4.setDescrizione("Maglietta Real Madrid Home 2021/2022");
		 bean4.setPrezzo(90);
		 bean4.setQuantita(50);
		 bean4.setTaglia("M");
		 bean4.setNumero(0);
		 bean4.setDimensione("NULL");
		 bean4.setTipo("NULL");
		om2.add(bean4);
		
		ProdottoBean bean5 = new ProdottoBean();
		 bean5.setCode(5);
		 bean5.setImage("/images/magliettabvb.png");
		 bean5.setNome("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setMarca("Puma");
		 bean5.setDescrizione("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setPrezzo(65);
		 bean5.setQuantita(50);
		 bean5.setTaglia("3XL");
		 bean5.setNumero(0);
		 bean5.setDimensione("NULL");
		 bean5.setTipo("NULL");
		om2.add(bean5);
		
		ProdottoBean bean6 = new ProdottoBean();
		 bean6.setCode(6);
		 bean6.setImage("/images/magliettachelsea.png");
		 bean6.setNome("Maglietta Chelsea Home 2021/2022");
		 bean6.setMarca("Nike");
		 bean6.setDescrizione("Maglietta Chelsea Home 2021/2022");
		 bean6.setPrezzo(75);
		 bean6.setQuantita(50);
		 bean6.setTaglia("M");
		 bean6.setNumero(0);
		 bean6.setDimensione("NULL");
		 bean6.setTipo("NULL");
		om2.add(bean6);
		
		ArrayList<ProdottoBean> om1a = new ArrayList<ProdottoBean>(om1);
		for(int i=0; i<om1a.size();i++)
		{			
			assertEquals(om1a.get(i).getCode(), om2.get(i).getCode());
			assertEquals(om1a.get(i).getImage(), om2.get(i).getImage());
			assertEquals(om1a.get(i).getNome(), om2.get(i).getNome());
			assertEquals(om1a.get(i).getMarca(), om2.get(i).getMarca());
			assertEquals(om1a.get(i).getDescrizione(), om2.get(i).getDescrizione());
			assertEquals(om1a.get(i).getPrezzo(), om2.get(i).getPrezzo());
			assertEquals(om1a.get(i).getQuantita(), om2.get(i).getQuantita());
			assertEquals(om1a.get(i).getTaglia(), om2.get(i).getTaglia());
			assertEquals(om1a.get(i).getNumero(), om2.get(i).getNumero());
			assertEquals(om1a.get(i).getDimensione(), om2.get(i).getDimensione());
			assertEquals(om1a.get(i).getTipo(), om2.get(i).getTipo());
		}

	}
	
	@Test
	public void testdoRetrieveSearchError() throws Exception {
			Collection<ProdottoBean> prodotti = null;
			try {
				prodotti = pm.doRetrieveSearch("banana");
			}
				catch (SQLException e) {
					assertNull(prodotti);
				}
			}
	
	@Test
	public void testdoRetrieveAllProducts() throws Exception {
		
		Collection<ProdottoBean> om1 = pm.doRetrieveAllProducts();
		ArrayList<ProdottoBean> om2 = new ArrayList<ProdottoBean>();
		
		ProdottoBean bean = new ProdottoBean();
		 bean.setCode(1);
		 bean.setImage("/images/magliettapsg.png");
		 bean.setNome("Maglietta PSG Home 2021/2022");
		 bean.setMarca("Nike Jordan");
		 bean.setDescrizione("Maglietta PSG Home 2021/2022 Authentic Man");
		 bean.setPrezzo(65);
		 bean.setQuantita(50);
		 bean.setTaglia("M");
		 bean.setNumero(0);
		 bean.setDimensione("NULL");
		 bean.setTipo("NULL");
		om2.add(bean);
		
		ProdottoBean bean2 = new ProdottoBean();
		 bean2.setCode(2);
		 bean2.setImage("/images/magliettajuve.png");
		 bean2.setNome("Maglietta Juventus Home 2021/2022");
		 bean2.setMarca("Adidas");
		 bean2.setDescrizione("Maglietta Juventus Home 2021/2022");
		 bean2.setPrezzo(65);
		 bean2.setQuantita(50);
		 bean2.setTaglia("M");
		 bean2.setNumero(0);
		 bean2.setDimensione("NULL");
		 bean2.setTipo("NULL");
		om2.add(bean2);
		
		ProdottoBean bean3 = new ProdottoBean();
		 bean3.setCode(3);
		 bean3.setImage("/images/magliettamanutd.png");
		 bean3.setNome("Maglietta Manchester United Home 2021/2022");
		 bean3.setMarca("Adidas");
		 bean3.setDescrizione("Maglietta Manchester United Home 2021/2022");
		 bean3.setPrezzo(65);
		 bean3.setQuantita(50);
		 bean3.setTaglia("XL");
		 bean3.setNumero(0);
		 bean3.setDimensione("NULL");
		 bean3.setTipo("NULL");
		om2.add(bean3);
		
		ProdottoBean bean4 = new ProdottoBean();
		 bean4.setCode(4);
		 bean4.setImage("/images/magliettarealmadrid.png");
		 bean4.setNome("Maglietta Real Madrid Home 2021/2022");
		 bean4.setMarca("Adidas");
		 bean4.setDescrizione("Maglietta Real Madrid Home 2021/2022");
		 bean4.setPrezzo(90);
		 bean4.setQuantita(50);
		 bean4.setTaglia("S");
		 bean4.setNumero(0);
		 bean4.setDimensione("NULL");
		 bean4.setTipo("NULL");
		om2.add(bean4);
		
		ProdottoBean bean5 = new ProdottoBean();
		 bean5.setCode(5);
		 bean5.setImage("/images/magliettabvb.png");
		 bean5.setNome("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setMarca("Puma");
		 bean5.setDescrizione("Maglietta Borussia Dortmund Home 2021/2022");
		 bean5.setPrezzo(65);
		 bean5.setQuantita(50);
		 bean5.setTaglia("3XL");
		 bean5.setNumero(0);
		 bean5.setDimensione("NULL");
		 bean5.setTipo("NULL");
		om2.add(bean5);
		
		ProdottoBean bean6 = new ProdottoBean();
		 bean6.setCode(6);
		 bean6.setImage("/images/magliettachelsea.png");
		 bean6.setNome("Maglietta Chelsea Home 2021/2022");
		 bean6.setMarca("Nike");
		 bean6.setDescrizione("Maglietta Chelsea Home 2021/2022");
		 bean6.setPrezzo(75);
		 bean6.setQuantita(50);
		 bean6.setTaglia("M");
		 bean6.setNumero(0);
		 bean6.setDimensione("NULL");
		 bean6.setTipo("NULL");
		om2.add(bean6);
		
		ProdottoBean bean7 = new ProdottoBean();
		 bean7.setCode(7);
		 bean7.setImage("/images/pantaloncinibvb.png");
		 bean7.setNome("Pantaloncini Borussia Dortmund Home 2021/2022");
		 bean7.setMarca("Puma");
		 bean7.setDescrizione("Pantaloncini Borussia Dortmund Home 2021/2022");
		 bean7.setPrezzo(45);
		 bean7.setQuantita(50);
		 bean7.setTaglia("M");
		 bean7.setNumero(0);
		 bean7.setDimensione("NULL");
		 bean7.setTipo("NULL");
		om2.add(bean7);
		
		ProdottoBean bean8 = new ProdottoBean();
		 bean8.setCode(8);
		 bean8.setImage("/images/pantaloncinichelsea.png");
		 bean8.setNome("Pantaloncini Chelsea Home 2021/2022");
		 bean8.setMarca("Nike");
		 bean8.setDescrizione("Pantaloncini Chelsea Home 2021/2022");
		 bean8.setPrezzo(35);
		 bean8.setQuantita(40);
		 bean8.setTaglia("M");
		 bean8.setNumero(0);
		 bean8.setDimensione("NULL");
		 bean8.setTipo("NULL");
		om2.add(bean8);
		
		ProdottoBean bean9 = new ProdottoBean();
		 bean9.setCode(9);
		 bean9.setImage("/images/pantaloncinijuve.png");
		 bean9.setNome("Pantaloncini Juventus Home 2021/2022");
		 bean9.setMarca("Adidas");
		 bean9.setDescrizione("Pantaloncini Juventus Home 2021/2022");
		 bean9.setPrezzo(35);
		 bean9.setQuantita(40);
		 bean9.setTaglia("M");
		 bean9.setNumero(0);
		 bean9.setDimensione("NULL");
		 bean9.setTipo("NULL");
		om2.add(bean9);
		
		ProdottoBean bean10 = new ProdottoBean();
		 bean10.setCode(10);
		 bean10.setImage("/images/calzettonijuve.png");
		 bean10.setNome("Calzettoni Juventus Home 2021/2022");
		 bean10.setMarca("Adidas");
		 bean10.setDescrizione("Calzettoni Juventus Home 2021/2022");
		 bean10.setPrezzo(15);
		 bean10.setQuantita(20);
		 bean10.setTaglia("NULL");
		 bean10.setNumero(46);
		 bean10.setDimensione("NULL");
		 bean10.setTipo("NULL");
		om2.add(bean10);
		
		ProdottoBean bean11 = new ProdottoBean();
		 bean11.setCode(11);
		 bean11.setImage("/images/tiempo.png");
		 bean11.setNome("Scarpe Calcio Nike Tiempo 9 Electric Blue");
		 bean11.setMarca("Nike");
		 bean11.setDescrizione("Scarpe Calcio Nike Tiempo 9 Electric Blue");
		 bean11.setPrezzo(39);
		 bean11.setQuantita(50);
		 bean11.setTaglia("NULL");
		 bean11.setNumero(47);
		 bean11.setDimensione("NULL");
		 bean11.setTipo("NULL");
		om2.add(bean11);
		
		ProdottoBean bean12 = new ProdottoBean();
		 bean12.setCode(12);
		 bean12.setImage("/images/pegasus.png");
		 bean12.setNome("Scarpe Running Nike Air Zoom Pegasus Pink");
		 bean12.setMarca("Nike");
		 bean12.setDescrizione("Scarpe Running Nike Air Zoom Pegasus Pink");
		 bean12.setPrezzo(39);
		 bean12.setQuantita(50);
		 bean12.setTaglia("NULL");
		 bean12.setNumero(42);
		 bean12.setDimensione("NULL");
		 bean12.setTipo("NULL");
		om2.add(bean12);
		
		ProdottoBean bean13 = new ProdottoBean();
		 bean13.setCode(13);
		 bean13.setImage("/images/orologiomilan.png");
		 bean13.setNome("Gadget Orologio Milan Da Polso Black");
		 bean13.setMarca("Puma");
		 bean13.setDescrizione("Gadget Orologio Milan Da Polso Black");
		 bean13.setPrezzo(25);
		 bean13.setQuantita(50);
		 bean13.setTaglia("NULL");
		 bean13.setNumero(0);
		 bean13.setDimensione("NULL");
		 bean13.setTipo("Orologio");
		om2.add(bean13);
		
		ProdottoBean bean14 = new ProdottoBean();
		 bean14.setCode(14);
		 bean14.setImage("/images/portachiavicalcio.png");
		 bean14.setNome("Gadget Portachiavi Calcio Gold");
		 bean14.setMarca("Gold");
		 bean14.setDescrizione("Gadget Portachiavi Calcio Gold");
		 bean14.setPrezzo(15);
		 bean14.setQuantita(10);
		 bean14.setTaglia("NULL");
		 bean14.setNumero(0);
		 bean14.setDimensione("NULL");
		 bean14.setTipo("Portachiavi");
		om2.add(bean14);
		
		ProdottoBean bean15 = new ProdottoBean();
		 bean15.setCode(15);
		 bean15.setImage("/images/borsonenike.png");
		 bean15.setNome("Borsone Nike New Style Red");
		 bean15.setMarca("Nike Jordan");
		 bean15.setDescrizione("Borsone Nike New Style Red Authentic Man/Woman");
		 bean15.setPrezzo(55);
		 bean15.setQuantita(50);
		 bean15.setTaglia("NULL");
		 bean15.setNumero(0);
		 bean15.setDimensione("50x70x90");
		 bean15.setTipo("NULL");
		om2.add(bean15);
		
		ProdottoBean bean16 = new ProdottoBean();
		 bean16.setCode(16);
		 bean16.setImage("/images/parastinchinike.png");
		 bean16.setNome("Parastinchi Nike Red + Accessories");
		 bean16.setMarca("Nike");
		 bean16.setDescrizione("Parastinchi Nike Red Authentic + Accessories");
		 bean16.setPrezzo(15);
		 bean16.setQuantita(50);
		 bean16.setTaglia("NULL");
		 bean16.setNumero(0);
		 bean16.setDimensione("NULL");
		 bean16.setTipo("Parastinchi");
		om2.add(bean16);
		
		ArrayList<ProdottoBean> om1a = new ArrayList<ProdottoBean>(om1);
		for(int i=0; i<om1a.size();i++)
		{			
			assertEquals(om1a.get(i).getCode(), om2.get(i).getCode());
			assertEquals(om1a.get(i).getImage(), om2.get(i).getImage());
			assertEquals(om1a.get(i).getNome(), om2.get(i).getNome());
			assertEquals(om1a.get(i).getMarca(), om2.get(i).getMarca());
			assertEquals(om1a.get(i).getDescrizione(), om2.get(i).getDescrizione());
			assertEquals(om1a.get(i).getPrezzo(), om2.get(i).getPrezzo());
			assertEquals(om1a.get(i).getQuantita(), om2.get(i).getQuantita());
			assertEquals(om1a.get(i).getTaglia(), om2.get(i).getTaglia());
			assertEquals(om1a.get(i).getNumero(), om2.get(i).getNumero());
			assertEquals(om1a.get(i).getDimensione(), om2.get(i).getDimensione());
			assertEquals(om1a.get(i).getTipo(), om2.get(i).getTipo());
		}

	}
	
	@Test
	public void testdoUpdateQuantity() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoUpdateQuantity.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doUpdateQuantity(20, 1);
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
		
	@Test
	public void testdoUpdateQuantityError() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoUpdateQuantityError.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doUpdateQuantity(20, 2323232);
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
	
	@Test
	public void testdoIncreaseQuantity() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoIncreaseQuantity.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doIncreaseQuantity(20, 1, "admin@admin.it");
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
		
	@Test
	public void testdoIncreaseQuantityError() throws Exception {
			 ITable expectedTable = new FlatXmlDataSetBuilder()
	                 .build(ProdottoModelDSTest.class.getClassLoader().getResourceAsStream("dbexpected/prodottodoIncreaseQuantityError.xml"))
	                 .getTable("prodotto");
			 	
			 pm.doIncreaseQuantity(20, 2323232, "admin@admin.it");
			 
			 IDatabaseTester tester= this.getDatabaseTester();		 
			 ITable actualTable = tester.getConnection().createDataSet().getTable("prodotto");
			 Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
			 
		}
	
	
		
	}
	


