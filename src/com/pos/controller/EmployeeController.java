package com.pos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import com.pos.dao.EmployeeImplementation;
import com.pos.model.Cashier;


/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		  Cashier employee = new Cashier();
//		  employee.setEmpName("Zilungile");
//		  employee.setEmpType("Admin");
//		  String json1 = new Gson().toJson(employee); 
//		  
//		  response.setContentType("application/json"); 
//		  response.setCharacterEncoding("utf-8"); 
//		  response.getWriter().write(json1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("******************");
		
		EmployeeImplementation employeeImpl=new EmployeeImplementation();
		
		String jsonString = request.getParameter("jsonData");
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
		
		Gson gson = new Gson(); 
		Cashier employee= gson.fromJson(jsonString, Cashier.class);
		
		employeeImpl.save(employee);
		
		response.setContentType("application/json"); 
				
		System.out.println(jsonObject.toString());
		 
	}

}
