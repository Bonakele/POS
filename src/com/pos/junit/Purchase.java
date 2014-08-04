package com.pos.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pos.dao.EmployeeImplementation;
import com.pos.dao.ItemImplementation;
import com.pos.dao.SalesImplementation;
import com.pos.model.Cashier;
import com.pos.model.Item;
import com.pos.model.Sales;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "hibernateTransactionManager")
public class Purchase {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {

		ItemImplementation imp = new ItemImplementation();
		SalesImplementation salesImp = new SalesImplementation();
		EmployeeImplementation cashierImpl = new EmployeeImplementation();

		Sales sale = new Sales();
		Item item = new Item();
		Item item1 = new Item();
		Cashier cashier = new Cashier();

		double totalAmount = 0;
		double change = 0;
		double amountPayed = 100;
		Date date = new Date();

		List<Sales> listSales = new ArrayList<Sales>();
		List<Item> listItems = new ArrayList<Item>();

		item1.setDescription("for cleaning the teeth");
		item1.setDiscountPerc(0.3);
		item1.setItemName("ToothPrush");
		item1.setMarkDown(0);
		item1.setPrice(12.50);
		item1.setQuantity(7);

		item.setDescription("for cleaning the teeth");
		item.setDiscountPerc(0.2);
		item.setItemName("ToothPaste");
		item.setMarkDown(0);
		item.setPrice(8.50);
		item.setQuantity(20);

		listItems.add(item);
		listItems.add(item1);

		for (Item i : listItems) {

			totalAmount = totalAmount + i.getPrice();

			System.out.println(totalAmount);

		}

		change = amountPayed - totalAmount;

		cashier.setFirstName("Pabblo");
		// cashier.setEmpType("Cashier");

		// doing the sale

		sale.setPaymentType("Cash");
		sale.setTotalAmount(totalAmount);
		sale.setAmountPayed(amountPayed);
		sale.setChange(change);
		sale.setDate(date);

		sale.setCashier(cashier);

		listSales.add(sale);

		cashier.setSales(listSales);

		sale.setItems(listItems);

		item.setSalesList(listSales);
		item1.setSalesList(listSales);

		cashierImpl.save(cashier);

		salesImp.purchase(sale);

		item1.setQuantity(item1.getQuantity() - 1);
		item.setQuantity(item.getQuantity() - 1);

		imp.save(item);
		imp.save(item1);

		assertNotNull(sale);
	}

}
