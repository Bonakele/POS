package com.pos.controller;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.pos.dao.EmployeeImplementation;
import com.pos.dao.TimeSheetImplementation;
import com.pos.model.Admin;
import com.pos.model.Cashier;
import com.pos.model.Employee;
import com.pos.model.TimeSheet;

@Path("EmployeeController")
public class EmployeeController {
	EmployeeImplementation empImpl = new EmployeeImplementation();
	TimeSheetImplementation timeImpl = new TimeSheetImplementation();
	int timeloggedIn;
	int holdEmpNum;
	
	Employee currentEmp;
	java.net.URI location = null;

	@Path("saveEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(Employee employee) {

		if (employee.getOccupation().equalsIgnoreCase("admin")) {
			currentEmp = new Admin();
			// currentEmp.setEmpNum(employee.getEmpNum());
			currentEmp.setSA_id(employee.getSA_id());
			currentEmp.setFirstName(employee.getFirstName());
			currentEmp.setOccupation(employee.getOccupation());
			currentEmp.setSurname(employee.getSurname());
			currentEmp.setTitle(employee.getTitle());
			currentEmp.setTelNumberWork(employee.getTelNumberWork());
			currentEmp.setTelNumberMobile(employee.getTelNumberMobile());

			empImpl.saveOrUpdate(currentEmp);

		} else if (employee.getOccupation().equalsIgnoreCase("cashier")) {
			currentEmp = new Cashier();

			// currentEmp.setEmpNum(employee.getEmpNum());
			currentEmp.setSA_id(employee.getSA_id());
			currentEmp.setFirstName(employee.getFirstName());
			currentEmp.setOccupation(employee.getOccupation());
			currentEmp.setSurname(employee.getSurname());
			currentEmp.setTitle(employee.getTitle());
			currentEmp.setTelNumberWork(employee.getTelNumberWork());
			currentEmp.setTelNumberMobile(employee.getTelNumberMobile());

			empImpl.saveOrUpdate(currentEmp);
		}

		return Response.status(Status.ACCEPTED).build();
	}

	@GET
	@Path("/getEmpById/{empNum}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmpById(@PathParam("empNum") int empNum) {
		Employee employee = empImpl.getEmployeeByEmpNum(empNum);

		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put("SA_id", employee.getSA_id());
			jsonObject.put("firstName", employee.getFirstName());
			jsonObject.put("surname", employee.getSurname());
			jsonObject.put("title", employee.getTitle());
			jsonObject.put("telNumberWork", employee.getTelNumberWork());
			jsonObject.put("telNumberMobile", employee.getTelNumberMobile());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@GET
	@Path("/getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEmployees() throws JSONException {
		List<Employee> empList = empImpl.getAllEmployees();

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < empList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("empNum;", empList.get(i).getEmpNum());
			jsonObject.put("SA_id", empList.get(i).getSA_id());
			jsonObject.put("firstName", empList.get(i).getFirstName());
			jsonObject.put("surname", empList.get(i).getSurname());
			jsonObject.put("title", empList.get(i).getTitle());
			jsonObject.put("telNumberWork", empList.get(i).getTelNumberWork());
			jsonObject.put("telNumberMobile", empList.get(i)
					.getTelNumberMobile());

			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}

	@Path("employeeLoginResult")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response employeeLoginResult(@FormParam("empNum") String empNum, 
			@FormParam("password") String password) throws URISyntaxException {
		System.out.print("I am in employeeLoginResult " + "empNum " + empNum
				+ " password: " + password);
		

		int intEmpNum = Integer.parseInt(empNum);
		Employee emp = empImpl.getEmployeeByEmpNum(intEmpNum);
		TimeSheet time = new TimeSheet();
		Date login  = new Date();
		

		if (emp != null) {

			if (emp.getPassword().equalsIgnoreCase(password)) {
				time.setDate(login);
				time.setLogInTime(login);
				time.setEmployee(emp);
				
				holdEmpNum = intEmpNum;
				
			    timeloggedIn = timeImpl.saveOrUpdate(time);
			    
			    System.out.print(timeloggedIn + "timeloggedIn");
			
				location = new java.net.URI(
						"http://localhost:8080/PointOfSale/Home.jsp");
			} else {
				
			}
		} else {
			
		}

	

		return Response.seeOther(location).build();
	}
	
	@Path("employeeLogOutResult")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response employeeLogOutResult() throws URISyntaxException{

		TimeSheet time = timeImpl.getTimeSheetById(timeloggedIn);
		Date login  = new Date();
		
		System.out.print(timeloggedIn + "timeloggedIn");
		
//				time.setLogOutTime(login);
//			
//			    timeImpl.saveOrUpdate(time);
			
				location = new java.net.URI(
						"http://localhost:8080/PointOfSale/item.jsp");
	
		return Response.seeOther(location).build();
	}
	
	
	public void hrsWorked() {
		TimeSheet  time = timeImpl.getTimeSheetById(1);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		
		Date loginTime = time.getLogInTime();
		Date logoutTime = new Date();
		
		String login = df.format(loginTime);
		String logout = df.format(logoutTime);
		
		try {
			loginTime = df.parse(login);
			logoutTime = df.parse(logout);
			
			long diff = logoutTime.getTime() - loginTime.getTime();
			
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			Date hrsWorked = new Date(diff);
			
			time.setTotalHrsWorked(hrsWorked);
			
			timeImpl.saveOrUpdate(time);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
