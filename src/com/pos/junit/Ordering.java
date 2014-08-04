package com.pos.junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.pos.dao.ClientImplementation;
import com.pos.dao.EmployeeImplementation;
import com.pos.dao.ItemImplementation;
import com.pos.dao.OrderImplemantation;
import com.pos.dao.ReturnItemImplementation;
import com.pos.model.Admin;
import com.pos.model.Cashier;
import com.pos.model.Client;
import com.pos.model.Employee;
import com.pos.model.Item;
import com.pos.model.Order;
import com.pos.model.ReturnItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class Ordering {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {

		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();

		Order order = new Order();

		Client client = new Client();

		ItemImplementation itemImpl = new ItemImplementation();
		OrderImplemantation orderImpl = new OrderImplemantation();
		ClientImplementation clientImpl = new ClientImplementation();

		client.setFirstName("Thabo");
		client.setSurname("Khauleza");
		// client.setOrder(order);
		client.setIdNum("901245891308");

		// if (!(client.getIdNum().equals(null))) {
		// List<Client> foundClient = clientImpl.search(client.getIdNum());
		//
		// for (Client c : foundClient) {
		// if ((c.equals(null))) {
		//
		clientImpl.save(client);
		// }
		// }
		// }

		item1.setDescription("Clothing");
		item1.setItemName("Tracksuit");
		item1.setQuantity(50);
		item1.setDiscountPerc(0.23);
		item1.setMarkDown(0.12);
		item1.setPrice(20.50);

		item1.setPriceAfterDiscMark(item1.getPrice()
				- ((item1.getPrice() * item1.getDiscountPerc()) + (item1
						.getPrice() * item1.getMarkDown())));

		item2.setDescription("Clothing");
		item2.setItemName("Dress");
		item2.setQuantity(25);
		item2.setPrice(89.50);
		item2.setPriceAfterDiscMark(item2.getPrice()
				- ((item2.getPrice() * item2.getDiscountPerc()) + (item2
						.getPrice() * item2.getMarkDown())));

		item3.setDescription("Food");
		item3.setItemName("Burger");
		item3.setQuantity(89);
		item3.setPrice(38.50);

		Set<Item> itemList = new HashSet<Item>();

		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);

		itemImpl.save(item1);
		itemImpl.save(item2);
		itemImpl.save(item3);

		Set<Order> orderlist = new HashSet<Order>();

		order.setComment("I want to buy");
		order.setStatus("pending");
		order.setItem(itemList);

		order.setClient(client);

		order.setAmount(item1.getPriceAfterDiscMark()
				+ item2.getPriceAfterDiscMark() + item3.getPriceAfterDiscMark());

		orderlist.add(order);

		item1.setOrder(orderlist);
		item2.setOrder(orderlist);
		item3.setOrder(orderlist);

		orderImpl.save(order);

	}

	 @Ignore
		@Test
		public void testReturnOfItems() {
			ItemImplementation item1 = new ItemImplementation();
			ItemImplementation item2 = new ItemImplementation();
			ClientImplementation clientImpl = new ClientImplementation();
			ReturnItemImplementation returnItemImpl = new ReturnItemImplementation();
			EmployeeImplementation employeeImpl = new EmployeeImplementation();

			Item itemFound1 = new Item();
			Item itemFound2 = new Item();

			Date todayDate = new Date();

			ReturnItem returnItem = new ReturnItem();

			Employee cashier = new Cashier();

			Employee admin = new Admin();

			Client client = new Client();

			client = clientImpl.getClientById("9012458935678");

			itemFound1 = item1.getItem(1);
			itemFound2 = item2.getItem(2);

			Set<Item> itemList = new HashSet<Item>();
			Set<Employee> employeeList = new HashSet<Employee>();

			itemList.add(itemFound1);
			itemList.add(itemFound2);

			cashier.setFirstName("Lerato");
			cashier.setSurname("Pule");
			cashier.setSA_id("78965234158");
			cashier.setTitle("Miss");

			admin.setFirstName("Ponie");
			admin.setSurname("Moloisane");
			admin.setSA_id("7896523415789");
			admin.setTitle("Miss");

			employeeImpl.save(admin);
			employeeImpl.save(cashier);

			employeeList.add(admin);
			employeeList.add(cashier);

			returnItem.setClient(client);
			returnItem.setEmployee(employeeList);
			returnItem.setItem(itemList);
			returnItem.setReturnDate(todayDate);

			returnItemImpl.save(returnItem);

		}
		
		@Test
		public void testCancelOrder() {
			Order order = new Order();
			OrderImplemantation orderImpl = new OrderImplemantation();
			
			Date today = new Date();
			order = orderImpl.getOrderById(1);
			
			order.setDateDeliverd(today);
			orderImpl.updateOrder(order);
			
			if(today.before(order.getDateDeliverd())){
				orderImpl.delete(order.getId());
			}

}
}
