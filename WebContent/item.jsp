<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	var readInData = function() {

		var itemName = $("#itemName").val();
		

		var jsonObject = {
			"itemName" : itemName,
			"description" : description,
			"quantity" : quantity,
			"price" : price,
			"colour" : colour,
			"type" : type,
			"size" : size,
		};

		alert("hello in function " + name);

		$
				.ajax({

					url : "http://localhost:8080/PointOfSale/pos/ItemController/saveItem",
					type : 'post',
					dataType : 'json',
					data : JSON.stringify(jsonObject),
					contentType : "application/json; charset=utf-8",

					success : function(data) {
						alert(data.name + " " + data.surname)
					},
					error : function(XHR, status, er) {
						alert(XHR.status + " : " + er + " : " + status);
					}
				});
	}
</script>
</head>
<body>

	<form action="http://localhost:8080/PointOfSale/pos/EmployeeController/employeeLogOutResult" method="post">


		<h2 align="center">STOCK DETAILS</h2>
		<table align="center" border="1">
			<tr>
				<td><label>Item Name</label></td>
				<td><input type="text" id="itemName" /></td>
			</tr>

			<tr>
				<td><label>Type</label></td>
				<td><input type="text" id="type" /></td>
			</tr>

			<tr>
				<td><label>Colour</label></td>
				<td><input type="text" id="colour" /></td>
			</tr>

			<tr>
				<td><label>Size</label></td>
				<td><input type="text" id="size" /></td>
			</tr>

			<tr>
				<td><label>Quantity</label></td>
				<td><input type="text" id="quantity" /></td>
			</tr>

			<tr>
				<td><label>Category</label></td>
				<td><input type="text" id="category" /></td>
			</tr>

			<tr>
				<td><label>Price</label></td>
				<td><input type="text" id="price" /></td>
			</tr>

			<tr>
				<td><label>Description</label></td>
				<td><input type="text" id="description" /></td>
			</tr>


			<tr>
				<td>Specify the price of the Item in Stock: <a
					href="priceListForm.html">Set Price</a></td>
				<td>How much will you charge for the late return of this item:
					<a href="setCharge.html">Set Charge</a>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="Submit" align="middle"
					onclick="readInData()"></input></td>
				<td><button type="submit" class="btn btn-success" onclick="clientLogin()">Log Out</button></td>
			</tr>
		</table>


	</form>

</body>
</html>