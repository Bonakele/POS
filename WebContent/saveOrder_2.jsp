<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/knockout.js"></script>

<script>
	function selectedItems(data) {

		var self = this;
		this.id = ko.observable(data.id);
		this.price = ko.observable(data.price);
		this.itemName = ko.observable(data.itemName);
		this.quantityRequested = ko.observable("");
		this.quantityInStock = ko.observable("");
		this.subtotal = ko.dependentObservable(function() {
			return this.price() * this.quantityRequested();
		}.bind(this));

	}
	
	function formatCurrency(value) {
	    return  value.toFixed(2);
	}

	function itemViewModel() {

		var self = this;

		self.allItems = ko.observableArray([]);
		this.chosenItems = ko.observableArray([]);

		self.grandTotal = ko.dependentObservable(function() {
			var total = 0;
			$.each(self.chosenItems(), function() {
				total += this.subtotal()
			})
			return total;
		}.bind(this));

		this.removeItem = function(item) {
			self.chosenItems.remove(item);
		};

		$("#selectedItems").hide();
		$
				.getJSON(
						'http://localhost:8080/PointOfSale/pos/ItemController/getAllItems',
						function(allData) {

							var mappedData = $.map(allData, function(data) {
								return new selectedItems(data)
							});
							self.allItems(mappedData);
						});

		self.search = function() {

			$("#tablediv").hide();
			$("#selectedItems").show();

		}//end search

		self.status = ko.observable();
		self.comment = ko.observable();
		self.item = ko.observable();
		self.amount = ko.observable();

		var Order = {
			status : self.status,
			comment : self.comment,
			item : self.chosenItems,
			amount:self.grandTotal
		}// end Order

		self.saveOrder = function(model, event) {

			$
					.ajax({

						url : "http://localhost:8080/PointOfSale/pos/OrderController/saveOrder",
						type : 'post',
						dataType : 'json',
						data : ko.toJSON(Order),
						contentType : "application/json; charset=utf-8",

						success : function(orderData) {
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

	
	
		<div id="tablediv">
			<button type="button" class="btn btn-success"
			data-bind="click: search">Order</button>
			<table class="table table-bordered">
				<tr>
					<th class="info">Item Name</th>
					<th class="info">Price</th>
					<th class="info">Select</th>

				</tr>
				<tbody data-bind='foreach:$root.allItems'>
					<tr>

						<td data-bind='text: itemName' /></td>
						<td data-bind='text: formatCurrency(price())' /></td>
						<td><input type="checkbox"
							data-bind="checkedValue: $data, checked: $root.chosenItems" /></td>

					</tr>

				</tbody>

			</table>
		</div>


		<div id="selectedItems">
			<input type="submit" value="Save Order" data-bind="click: saveOrder"
			class="btn btn-success">
			<table class="table table-bordered">
				<tr>
					<th class="info">Item Name</th>
					<th class="info">Quantity</th>
					<th class="info">price</th>
					<th class="info">Subtotal</th>

				</tr>
				<tbody data-bind='foreach:$root.chosenItems'>
					<tr>
						<td data-bind='text:itemName'></td>
						<td><input
							data-bind='value: quantityRequested, valueUpdate: "afterkeydown"' /></td>
						<td data-bind='text: formatCurrency(price())' /></td>
						<td data-bind='text: formatCurrency(subtotal())'></td>
						<td><button data-bind='click:$root.removeItem'
								class="btn btn-danger">Remove</button></td>


					</tr>

				</tbody>

			</table>
			<p>
				Grand Total: R<span data-bind='text:formatCurrency(grandTotal())'> </span>
			</p>
		</div>


	</form>
</body>
</html>