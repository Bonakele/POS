<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchasing</title>

<script src="resources/knockout.js"></script>
<script src="resources/jquery.js"></script>


<script>


	function itemViewModel() {
		
		var self = this;
		self.reason = ko.observable();
		self.returnDate = ko.observable();
		self.returnAmount = ko.observable();
		self.employee=ko.observable();
		self.client=ko.observable();
		self.sale=ko.observable();	
	
	 var returnItem = {
			 reason: self.reason,
			 returnDate: self.returnDate,
			 returnAmount: self.returnAmount,
			 employee: self.employee,
			 totalAmount:self.totalAmount,
			 client:self.client,
			 sale:self.sale

         };

		    self.returnItem=ko.observable();
		    self.returnItemList=ko.observableArray([]);
		    self.saleList=ko.observableArray([]);
		    self.employeeList=ko.observableArray([]);
		    	
		
		$.getJSON('http://localhost:8080/PointOfSale/pos/EmployeeController/getAllEmployees',
				null, function(Data, status, xhr) {
				
			$.each(Data,function(index,value){
				 alert("gets in")
				self.employeeList.push(value);
				console.log(value);
			});
			
			

				});
		
		
		$.getJSON('http://localhost:8080/PointOfSale/pos/SalesController/getAllSales',
				null, function(Data, status, xhr) {
				
			$.each(Data,function(index,value){
				
				self.saleList.push(value);
				
			});
			
		});
		
			
		 self.save = function(){
				   alert("gets in")
			    $.ajax({
			            type:'POST',
			            url:'http://localhost:8080/PointOfSale/pos/ReturnItemsController/saveReturn',
			            data: ko.toJSON(returnItem),
			            contentType: 'application/json',
			            dataType:"json",
			            success: function(data){
			            	
			            alert("Record Added Successfully");
			             
			            },
			             error: function (data,status,err)
			         {
			            	
			         }
			    });
			
		
		
		};

	};
	
	
	$(document).ready(function() {
		var viewModel=new itemViewModel();
		ko.applyBindings(viewModel);

	});
</script>


 

</head>
<body>
	<h3>Order Page</h3>
	<!-- <button data-bind="click: me">Edit</button> -->
	
		
			<div class="form-group">
employee :<select class="form-control" 
data-bind="options: $root.employeeList, value: employee, optionsText: 'empNum' " multiple="multiple">
</select>
</div>

<div class="form-group">
totaAmount :<select class="form-control" 
data-bind="options: $root.saleList, value: sale, optionsText: 'totalAmount' " multiple="multiple">
</select>


</div>
 <button data-bind='click: save'>Submit Purchase</button>   
</body>
</html>