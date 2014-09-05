<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cashup</title>

<script src="js/jquery.js"></script>
<script src="resources/knockout.js"></script>

<script src="scripts/cashup.js"></script>

</head>


<body>
<center><h2>CASHUP</h2></center>


	<table width="65%">
		 <thead>
	        <tr>
	            <th width='10%'>Coins</th>
	            <th width='5%'>Quantity</th>
	            <th class='price' width='10%'>SubTotal</th>
	            <th width='5%'>Notes</th>
	            <th width='5%'>Quantity</th>
	            <th class='price' width='10%'>SubTotal</th>
	        </tr>
     	</thead>
     	
     	
       <tbody>
	        <tr>
	            <td>5c</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td>R10</td>
	            <td><input type="text" /></td>
	            <td><span></span></td>
	        </tr>
	        
	        <tr>
	            <td>10c</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td>R20</td>
	            <td><input type="text" /></td>
	            <td><span></span></td>
	        </tr>
	        
	        <tr>
	            <td>20c</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td>R50</td>
	            <td><input type="text" /></td>
	            <td><span></span></td>
	        </tr>
	        
	        <tr>
	            <td>50c</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td>R100</td>
	            <td><input type="text" /></td>
	            <td><span></span></td>
	        </tr>
	        
	        <tr>
	            <td>R1</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td>R200</td>
	            <td><input type="text" /></td>
	            <td><span></span></td>
	        </tr>
	        
	        <tr>
	            <td>R2</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td></td>
	            <td></td>
	            <td></td>
	        </tr>
	        
	        <tr>
	            <td>R5</td>
	            <td><input type="text" align="right"/></td>
	            <td><span></span></td>
	            <td></td>
	            <td></td>
	            <td></td>
	        </tr> 
    	</tbody>
    
	    <tfoot>
	    	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	    	<tr>
	    		<td>Grand Total</td>
	    		<td><input type="text" align="right"/></td>
	    		<td></td>
	    		<td>Status</td>
	    		<td><input type="text" align="right"/></td>
	    	<tr>
	    	
	    	<tr>
	    	<td>Cash Register</td>
	    	<td><select class="form-control" data-bind="options: $root.allSales, value: sale, optionsText : 'paymentType' "></select></td>
	    	<td></td>
	    	<td>Date</td>
	    	<td><input type="date" id="cashUpDate" name="cashUpDate" class="form-control" data-bind="value: cashUpDate"/></td>
	    	</tr>
	    	
	    	<tr>
	    	<td>Cashier </td>
	    		<td>
	    			<select class="form-control" data-bind="options: $root.allCashiers, value: employee, optionsText: 'firstName' "></select>
	    		</td>
	    	</tr>
	    	
	    	<tr></tr><tr></tr>
	    	<tr><td><input type="submit" value="Cashup" data-bind="click: saveCashup" class="btn btn-success"> </td></tr>
	    </tfoot>
	</table>
	Comments :
	<textarea rows="5" cols="20">Enter Reason Here...</textarea>
</body>

</html>