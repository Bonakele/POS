/*package com.pos.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.pos.dao.EmployeeImplementation;
import com.pos.dao.ExchangeImplementation;
import com.pos.dao.ItemImplementation;
import com.pos.dao.SalesImplementation;
import com.pos.model.Cashier;
import com.pos.model.Employee;
import com.pos.model.Exchange;
import com.pos.model.Item;
import com.pos.model.Sales;

public class Main {

	public static void main(String[] args) {
		
		ItemImplementation imp=new ItemImplementation();
		SalesImplementation salesImp=new SalesImplementation();
		EmployeeImplementation cashierImpl=new EmployeeImplementation();
		ExchangeImplementation exchangeImpl=new ExchangeImplementation();
			
			Sales sale=new Sales();
			Item item=new Item();
			Item item1=new Item();
			Employee cashier=new Employee();
			Exchange exchange=new Exchange();
			
			double totalAmount = 0;
			double change=0;
			double amountPayed=100;
			long daysBtnsalesAndExchange;
			Date date=new Date();
		    Calendar salesDate = null;
			Calendar exchangeDate=null;
			
			List<Sales> listSales=new ArrayList<Sales>();
			List<Item> listItems=new ArrayList<Item>();
			List<Exchange> listExchange=new ArrayList<Exchange>();
			
			//Add items
			item.setDescription("for cleaning the teeth");
			item.setDiscountPerc(0.2);
			item.setItemName("ToothPaste");
			item.setMarkDown(0);
			item.setPrice(8.50);
			item.setQuantity(20);
			
			item1.setDescription("for cleaning the teeth");
			item1.setDiscountPerc(1.4);
			item1.setItemName("ToothPrush");
			item1.setMarkDown(0);;
			item1.setPrice(12.50);
			item1.setQuantity(7);
			
			listItems.add(item);
			listItems.add(item1);
			
			for(Item i:listItems){
				
				totalAmount=totalAmount+i.getPrice();
				//sale.setItem(i.getItemName());
//			    sale.setItems(listItems); //made changes commented by pablo
				System.out.println(totalAmount);
				
			}
			change=amountPayed-totalAmount;
		
			
			
			//Add sale
			
			sale.setPaymentType("Cash");
			sale.setTotalAmount(totalAmount);
			sale.setAmountPayed(amountPayed);
			sale.setChange(change);
			sale.setDate(date);
			//sale.setExchangeDate(salesImp.exchangeDate());
			//sale.setCashier(cashier);
			listSales.add(sale);

			//Add cashier
			//cashier.setEmpName("Pabblo");
			//cashier.setEmpType("Cashier");
			cashierImpl.saveOrUpdate(cashier);
			//cashier.setSales(listSales);
			
			// Number between days for exchange
	for(Sales saless:listSales){
			Date date1=saless.getDate();
			Date date2 = new Date();

			Calendar cal1=Calendar.getInstance();
			Calendar cal2=Calendar.getInstance();
			cal1.setTime(date1);
			cal2.setTime(date2);
			
			int numberOfDays=0;
			while(cal1.before(cal2)){
				if((Calendar.SATURDAY !=cal1.get(Calendar.DAY_OF_WEEK))&&(Calendar.SUNDAY !=cal1.get(Calendar.DAY_OF_WEEK))){
				numberOfDays++;
				cal1.add(Calendar.DATE, 1);
				}else{
					cal1.add(Calendar.DATE, 1);
				}
			}
			
			System.out.println("number of days  " + numberOfDays);
			
			if(numberOfDays < 3){
				//Add exchange
				exchange.setReason("Breake");
				exchange.setDate(date);
				//exchange.setEmployee(cashier);
				//exchange.setListSales(listSales);
				listExchange.add(exchange);
				exchange.setAmount(saless.getTotalAmount());
				exchangeImpl.saveExchange(exchange);

			}else{
				System.out.println("You exceeded exchange days");
			}
			}
			
			//Add exchange
			exchange.setReason("Roted");
			exchange.setDate(date);
			//exchange.setCashier(cashier);
			exchange.setListSales(listSales);
			listExchange.add(exchange);
		
			for(Sales saless:listSales){
				exchange.setAmount(saless.getTotalAmount());
				//exchange.setItem(saless.getItem());
				
				
			}
//			 sale.setItems(listItems); //made changes commented by pablo
			 item.setSalesList(listSales);
			 item1.setSalesList(listSales); //changed from List to Set by pablo
			 
			   item1.setQuantity(item1.getQuantity()-1);
				item.setQuantity(item.getQuantity()-1);

			  exchangeImpl.saveExchange(exchange);
			  //sale.setExchange(exchange);
			 // imp.save(item);
         	// imp.save(item1);
			//  salesImp.purchase(sale);
			
            	
                 
            	 		
	}

}
*/