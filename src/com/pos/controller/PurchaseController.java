package com.pos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pos.dao.EmployeeImplementation;
import com.pos.dao.ItemImplementation;
import com.pos.dao.SalesImplementation;
import com.pos.model.Cashier;
import com.pos.model.Item;
import com.pos.model.Sales;


/**
 * Servlet implementation class PurchaseController
 */
@WebServlet("/PurchaseController")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Sales>salesList=new ArrayList<Sales>();
		List<Item>itemsList=new ArrayList<Item>();
		 Sales sales =new Sales();
		 Gson gson = new Gson();
		 
		double totalAmount=0;
		double change=0;
		
		ItemImplementation itemImp=new ItemImplementation();
		SalesImplementation sale=new SalesImplementation();
		int id=Integer.parseInt(request.getParameter("item_id"));
		//getting Items
		  Item item=itemImp.getItem(id);
		  itemsList.add(item);
		  
		  for(Item i:itemsList){
	        	totalAmount=totalAmount+i.getPrice();
	        			
	        }
		  	EmployeeImplementation cashierImp=new EmployeeImplementation();
	        Cashier cashier=(Cashier) cashierImp.getEmployeeById(1);
	      
		// 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsons = "";
        if(br != null){
            jsons = br.readLine();
        }
        
        salesList.add(sales);
        
        sales.setCashier(cashier);
		
        salesList.add(sales);
	
		cashierImp.save(cashier);
		
		cashier.setSales(salesList);
		
		 sales.setItems(itemsList);
		 item.setSalesList(salesList);
		
		item.setQuantity(item.getQuantity()-1);
		itemImp.save(item);     
        
        sale.purchase(sales);
        
        sales=(Sales) gson.fromJson(jsons.toString(), Sales.class);
        
        response.getOutputStream().flush();
     
    }
	

}
