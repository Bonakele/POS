<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchasing</title>

<script src="resources/js/knockout.js"></script>
<script src="resources/js/jquery.js"></script>


<script>


	function itemViewModel() {
		
		
		var self = this;
		 self.totalAmount = ko.observable("");
		   self.date = ko.observable("");
		   self.reason = ko.observable("");
		   
		   self.employee =ko.observable();
		   self.sale =ko.observable();
		   self.client =ko.observable();
		
	/* self.totalAmount = ko.computed(function() {
	        return a;
	    }); */
		
	
		
		
	
	 var exchange = {

			  totalAmount:self.totalAmount,
	          date:self.date,
			  reason:self.reason,
			
			 
			 employee:self.employee,
			 sale:self.sale,
			 client:self.client,

         };

		    self.exchange=ko.observable();
		    self.salesList=ko.observableArray([]);
		    self.employeeList=ko.observableArray([]);
		        
		$.getJSON('http://localhost:8080/PointOfSale/pos/ExchangeItemsController/getAllSales',
				
				null, function(Data, status, xhr) {
			alert("Retrieving sales")
			$.each(Data,function(index,value){
				
				self.salesList.push(value);
				
			});
			
			
		

				});
		
$.getJSON('http://localhost:8080/PointOfSale/pos/ExchangeItemsController/getAllEmployee',
				
				null, function(Data, status, xhr) {
			alert("Retrieving employees")
			$.each(Data,function(index,value){
				
				self.employeeList.push(value);
				
			});
			
			
		

				});
			
			
		 self.save = function(){
				  
			    $.ajax({
			            type:'POST',
			            url:'http://localhost:8080/PointOfSale/pos/ExchangeItemsController/saveExchange',
			            data: ko.toJSON(exchange),
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

<style type="text/css">
#reason-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	/* background: #fff; */
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
 

</head>
<body>
	<h3>Exchange</h3>
	<!-- <button data-bind="click: me">Edit</button> -->
	
			
		<table></table>
			<div class="form-group">
			
Sales Id <select class="form-control" 
data-bind="options: $root.salesList, value: sale, optionsText: 'id' " >
</select>

  Employee Id <select class="form-control" 
data-bind="options: $root.employeeList, value: employee, optionsText: 'empNum' " >
</select><br>
</div> <br>


			 <table border="1">
				<tr>
					<th>Sale Price</th>
					
				</tr> 
				<tbody data-bind='foreach:$root.salesList'>
					<tr>
						<td data-bind='text:totalAmount'></td>
						
						</tr>
			</table><br>

	 <!--  <table> -->
	<form class="form-horizontal" role="form" >
			<!-- <td>Reason</td> -->
			<!-- <td><input type="text" id="reason"
				data-bind="value: $root.reason"></td> -->
				<div>
				 <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Reason </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="reason" data-bind="value: $root.reason" placeholder="Enter Exchange Reason" name = "reason" size="12" required>
    </div>
  </div>
	<!-- </table><br> -->
	

 <button data-bind='click: save' class="btn btn-success">Submit Exchange</button>  
 </form>
</body>
</html>