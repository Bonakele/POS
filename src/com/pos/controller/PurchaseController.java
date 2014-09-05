package com.pos.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.pos.dao.SalesImplementation;
import com.pos.model.Employee;
import com.pos.model.Sales;


@Path("/PurchaseController")
public class PurchaseController {
	
	SalesImplementation salesDao=new SalesImplementation();
	@Path(value="/makePurchase")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Sales createAssetInJson(Sales sales){
		salesDao.saveSale(sales);    
		return sales;
	}
	
	
	@GET
	@Path("/getAllSales")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSales() throws JSONException {
		List<Sales> salesList = salesDao.getAllSales();

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < salesList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", salesList.get(i).getId());
			jsonObject.put("paymentType", salesList.get(i).getPaymentType());
			jsonObject.put("totalAmount", salesList.get(i).getTotalAmount());
			jsonObject.put("amountPayed", salesList.get(i).getAmountPayed());
			jsonObject.put("change", salesList.get(i).getChange());
			jsonObject.put("date", salesList.get(i).getDate());
			jsonObject.put("item", salesList.get(i).getItem());
			jsonObject.put("item", salesList.get(i).getItem());
			jsonObject.put("employee", salesList.get(i).getEmployee());

			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}

	

}
