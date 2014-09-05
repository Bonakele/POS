<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Return Item</title>

 <link rel="stylesheet" type="text/css" href="resources/css/return.css">
 <script src="resources/js/jquery.js"></script>
 <script src="resources/js/knockout.js"></script>
 <script type="text/javascript" src="scripts/return.js"></script>
 
</head>

<body>

<div class='return'> 
	<table width='100%'>
	
		<thead>
            <tr>
                <th width='25%'>Order No.</th>
                <th width='25%'>Item</th>
                <th class='price' width='15%'>Price</th>
                <th class='quantity' width='10%'>Quantity</th>
                <th class='price' width='15%'>Subtotal</th>
                <th width='10%'> </th>
            </tr>
        </thead>
        
         <tbody data-bind='foreach: lines'>
            <tr>
                <td>
                	<!-- FETCH ORDERS FROM DATABASE -->
                    <select data-bind='options: allOrders, optionsText: "id", optionsCaption: "Select...", value: order'> </select>
                </td>
               <td data-bind="with: order">
                	<!-- FETCH ITEMS RELATED TO SPECIFIC ORDER FROM DATABASE -->
                    <select data-bind='options: $parent.orderedItems, optionsText: "itemName", optionsCaption: "Select...", value : $parent.item'> </select>
                </td>
              	<td class = 'price' data-bind = "with : item">
                    <span data-bind='text: price()'> </span>
                </td>
                <td class='quantity'>
                    <input data-bind='visible: item, value: quantityRequested, valueUpdate: "afterkeydown"' />
                </td>
               <td class='price'>
                    <span data-bind='visible: item, text: subtotal()' > </span>
                </td>
                <td>
                    <a href='#' data-bind='click: $parent.removeLine'>Remove</a>
                </td>
            </tr>
        </tbody>

	</table>

         Total Refund : <span data-bind='text : grandTotal()'> </span><br>

    
    <button data-bind='click: addLine'>Select Item</button>
    <button data-bind='click: save'>Return Items</button>
    
</div>

</body>
</html>