package com.pos.junit;





import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;  

import com.pos.dao.CashUpImplementation;
import com.pos.dao.EmployeeImplementation;
import com.pos.model.CashUp;
import com.pos.model.Cashier;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:hibernate.cfg.xml")
//@TransactionConfiguration(defaultRollback=true,transactionManager="hibernateTransactionManager")
public class TestCashup {

	@Test
	public void test() {
		
double totalCashUp = 0;
		
		List<CashUp> cash = new ArrayList <CashUp>();
		CashUpImplementation cashImple=new CashUpImplementation();
		EmployeeImplementation cashierImpl=new EmployeeImplementation();
		Date datum=new Date();
		Cashier cashier=new Cashier();
		cashier.setFirstName("Lwandile");
		//cashier.setEmpType("Admin");
		cashierImpl.saveOrUpdate(cashier);
		
		CashUp cashUp=new CashUp();
		CashUp cashUp1=new CashUp();
		cashUp1.setAmount(300.45);
//		cashUp1.setEmployee(cashier); //made changes commented by pablo
//		cashUp1.setcDate(datum);
		cashUp1.setComments("Also goood...");
		cashUp1.setRegisterAmount(45.5);
		cashUp1.setStatus("dont knoe this");
		
		
		
		

		cashUp.setAmount(400.78);
		cashUp.setComments("Everything well");
		cashUp.setRegisterAmount(4.5);
		cashUp.setStatus("Proccessing");
//		cashUp.setcDate(datum);//made changes commented by pablo
//		cashUp.setEmployee(cashier);//made changes commented by pablo
		
		
		cash.add(cashUp);
		cash.add(cashUp1);
		
		for(CashUp b :cash){
			
			totalCashUp+=b.getAmount();
//			b.setTotalCashUp(totalCashUp);//made changes commented by pablo
		}
		
		
		cashImple.saveCashUp(cashUp);
		cashImple.saveCashUp(cashUp1);
		
		
		assertNotNull(cashUp);
		assertNotNull(cashUp1);
	}

}
