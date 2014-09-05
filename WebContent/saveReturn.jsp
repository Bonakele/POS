<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="resources/bootstrap/js/jquery.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.css" />

<script src="resources/jquery.js"></script>
<script src="resources/knockout.js"></script>

<script>
	function itemFromSale(data) {
		
		this.itemName = ko.observable(data.itemName);
		this.quantityRequested = ko.observable(data.quantityRequested);
		this.price = ko.observable(data.price);
	}
	
	function SaleMade(data){
		this.saleId = ko.observable(data.id);
		//this.quantityRequested  = ko.observable(data.quantityRequested);
		
	}

	function itemViewModel() {

		var self = this;

		self.saleId = ko.observableArray();
		self.soldItems = ko.observableArray([]);
		this.chosenItems = ko.observableArray([]);

		self.search = function() {

			alert("in search");

			var intSaleId = parseInt(self.saleId);

			$
					.getJSON(
							'http://localhost:8080/PointOfSale/pos/SalesController/getSoldItemsBySalesId/' + 1,
							function(allData) {
								console.log(allData);

								var mappedData = $.map(allData, function(data) {
									return new itemFromSale(data)
								});

								self.soldItems(mappedData);
							});
			
			
			$
			.getJSON(
					'http://localhost:8080/PointOfSale/pos/SalesController/getSalesById/' + 1,
					function(allData) {
						console.log(allData);

						var mappedData = $.map(allData, function(data) {
							return new SaleMade(data)
						});

					});

		}//end search
		
	
		self.item = ko.observable();

		var Return = {
			
			item : self.chosenItems
		}// end Return

		self.saveReturn = function(model, event) {

			$
					.ajax({

						url : "http://localhost:8080/PointOfSale/pos/ReturnItemsController/saveReturn",
						type : 'post',
						dataType : 'json',
						data : ko.toJSON(Return),
						contentType : "application/json; charset=utf-8",

						success : function(orderData) {
							alert("return saved")
						},
						error : function(XHR, status, er) {
							alert(XHR.status + " : " + er + " : " + status
									+ " OH NO, AN ERROR");

						},
					});// end ajax
		}// end saveOrder

	}
	$(document).ready(function() {

		ko.applyBindings(new itemViewModel());

	});
</script>

</head>
<body>
	<form>

		<table class="table table-bordered">
			<tr>
				<th class="info">Item Name</th>
				<th class="info">Quantity</th>
				<th class="info">price</th>
				<th class="info">Select</th>

			</tr>
			<tbody data-bind='foreach:$root.soldItems'>
				<tr>

					<td data-bind='text: itemName' /></td>
					<td data-bind='text: quantityRequested' /></td>
					<td data-bind='text: price' /></td>
					<td><input type="checkbox"
						data-bind="checkedValue: $data, checked: $root.chosenItems" /></td>

				</tr>

			</tbody>

		</table>
		<input type="text" data-bind="text:saleId">
		<button type="button" class="btn btn-success" data-bind="click:search">Search</button>
		<input type="submit" value="Save Return" data-bind="click: saveReturn" class="btn btn-success">
	</form>
</body>
</html>