<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" java.util.Date;"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exchange</title>

<script src="resources/knockout.js"></script>
<script src="resources/jquery.js"></script>

<script>
$(document).ready(function () {

    function itemViewModel()
    {
    	
		var self = this;
		
		   self.totalAmount = ko.observable("");
		   self.date = ko.observable("yy/mm/dd");
		   self.reason = ko.observable("");
		   
		   self.employee =ko.observable("");
		   elf.sale =ko.observable("");
		   self.client =ko.observable("");
    	
		var purchase=
		{
			 totalAmount:self.totalAmount,
			 date:self.date,
			 reason:self.reason,
			 
			 employeet:self.employee,
			 sale:self.sale,
			clien:self.clien,
		    
		}
		
		
		self.purchase=ko.observable();
		self.purchaseArrayList=ko.observableArray([]);
		
		
    	self.search = function(){
    		
    		var itemId=parseInt($('#item_Id').val());
    		alert()
    		$.ajax({
    			type:'GET',
    			
    		url:"http://localhost:8080/PointOfSale/pos/ExchangeItemsController/getSaleById/"+itemId,
    		
    		data: ko.toJSON(purchase),
    		dataType:'json',
    		contentType:"application/json",
    		 success:function(easyData){
    			
    			 self.purchaseArrayList.push(easyData);
    			 alert(" :hello world")
    			
    		 },
    		 error:function(easyData,status)
    		 {
    			 alert(status+" error occured")
    		 }
    		 
    		
    		});
    		
    		
    	};
    	
    	
    };

    ko.applyBindings(new itemViewModel());
    self.save = function(){
	    $.ajax({
	            type:'POST',
	            url:'http://localhost:8080/PointOfSale/pos/ExchangeItemsController/saveExchange',
	            //alert("Enterd function"),
	            data: ko.toJSON(new itemViewModel()),
	            contentType: 'application/json',
	            dataType:"json",
	            success: function(data){
	            	self.ClientObject.push(data);
	            	console.log(data);
	            alert("Saved Successfully");
	             self.totalAmount(data.totalAmount);
	             alert("Price :" + self.totalAmount());
	            },
	             error: function ()
	         {
	            	
	         }
	    });
	  };
});
   
</script>

</head>
<body>
<h3>Exchange Item</h3>

<div class="container">
		<div class="hero-unit">
			<input type="text"  id="item_Id">
			<input type="submit" data-bind="click: search" ><br><br>
			
			<table border="1">
				<tr>
					<th>Item Price</th>
					<th>Today's Date</th>
					<th>Reason</th>
					
				</tr>
				<tbody data-bind='foreach:purchaseArrayList'>
					<tr>
						<td data-bind='text:totalAmount'></td>
						<td data-bind='text: date' ></td> 
						<td> <input type="text"  id="reason" data-bind="text:reason"></td>
						
						<td><input type="submit" data-bind="click: save" value="SaveExchange"></td>
			
					</tr>
					
				</tbody>

			</table><br>
			
			
			
		</div>
	</div>
</body>
</html>