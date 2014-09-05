<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchasing</title>

<script src="resources/knockout.js"></script>
<script src="resources/jquery.js"></script>


<script src="viewModels/PurchaseViewModel.js">

</script>


 

</head>
<body><center>
	<h3>PURCHASE VIEW</h3>
	<!-- <button data-bind="click: me">Edit</button> -->
	
			
		
			<div class="form-group">
<select class="form-control" 
data-bind="options: $root.salesList, value: item, optionsText: 'id' " multiple="multiple">
</select>
</div>

		
	<table>

		<tr>
			<td>Enter Amount Payed:</td>
			<td><input type="text" id="amountPayed"
				data-bind="value: $root.amountPayed" /></td>
		</tr>
		
		<tr>
			<td>Date</td>
			<td><input type="date" id="date" data-bind="value: $root.date"></td>
		</tr>
		<tr>
			<td>Payment Type:</td>
			<td><select id="paymentType"
				data-bind="value: $root.paymentType">
					<option value="Credit Card">Credit Card</option>
					<option value="Cash">Cash</option>
			</select></td>
		</tr>

		
		
		<tr>
			<td>Change</td>
			<td><input type="text" id="change"
				data-bind="value: $root.change"></td>
		</tr>
			
		
	</table>
	
	


 <button data-bind='click: save'>Submit Purchase</button>  
</body></center>
</html>