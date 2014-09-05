package com.pos.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.pos.dao.SalesImplementation;
import com.pos.model.Sales;

public class Testing {

//	@RunWith(SpringJUnit4ClassRunner.class)
//	@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
//	@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
	public class Ordering {

		@BeforeClass
		public void setUpBeforeClass() throws Exception {
		}

		@AfterClass
		public void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		//@Ignore
		@Test
		public void test() {
			
			SalesImplementation salesImpl = new SalesImplementation();
			Sales sale = salesImpl.getSaleByEmployee(2);
			
			System.out.println("The Total Amount is " + sale.getEmployee().getFirstName() + " : " + sale.getTotalAmount() + " : " +sale.getDate());
			
		
			assertNotNull(sale);
		}
	}
}
