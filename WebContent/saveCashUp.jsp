<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script src="resources/js/jquery.js"></script>
<script src="resources/js/knockout.js"></script>

<script type="text/javascript" src="scripts/saveCashUp.js"></script>

<script>
	/*  	function cashUp(label, amount) {
	

	 this.label = ko.observable(label);
	 this.amount = ko.observable(amount);

	 this.quantity = ko.observable(0);
	 this.coinsSubtotal = ko.dependentObservable(function() {
	 return this.amount() * (this.quantity());
	 }.bind(this));

	 this.notesSubtotal = ko.dependentObservable(function() {
	 return this.amount() * this.quantity();
	 }.bind(this));

	 }
	
	 function formatCurrency(value) {
	 return  value.toFixed(2);
	 }

	 function cashUpViewModel() {
	 this.coinsCashUpArray = ko.observableArray([ new cashUp("5c", 0.05),
	 new cashUp("10c", 0.1), new cashUp("20c", 0.2),
	 new cashUp("50c", 0.5), new cashUp("R1", 1),
	 new cashUp("R2", 2), new cashUp("R5", 5) ]);
	 //Notes
	 this.notesCashUpArray = ko.observableArray([ new cashUp("R10", 10),
	 new cashUp("R20", 20), new cashUp("R50", 50),
	 new cashUp("R100", 100), new cashUp("R200", 200) ]);

	 this.coinTotal = ko.dependentObservable(function() {
	 var total = 0;
	 $.each(this.coinsCashUpArray(), function() {
	 total += this.coinsSubtotal()
	 })
	 return total;
	 }.bind(this));

	 this.notesTotal = ko.dependentObservable(function() {
	 var total = 0;
	 $.each(this.notesCashUpArray(), function() {
	 total += this.notesSubtotal()
	 })
	 return total;
	 }.bind(this));
	
	 this.grandTotal = ko.computed(function() { return this.coinTotal() +  this.notesTotal(); }, this);

	 }

	 $(document).ready(function() {
	 //ko.cleanNode($element[0]);
	 ko.applyBindings(new cashUpViewModel());

	 }); */
</script>
<style type="text/css">
</style>
</head>
<h1 align="center">CASH UP</h1>


<body>

	<form>

		<table align="left" width="65%">
			<thead>
				<tr>
	            <th width='10%'><h4>Label</h4></th>
	            <th width='10%'><h4>Quantity</h4></th>
	            <th width='10%'><h4>Subtotal</h4></th>
	           
				</tr>
			</thead>
			<tbody data-bind='foreach: $root.coinsCashUpArray'>
				<tr>
					<td><label data-bind='text: label'></label></td>
					<td><input
						data-bind='value: quantity, valueUpdate: "afterkeydown"' size="2" /></td>

					<td>R <label data-bind='text: formatCurrency(coinsSubtotal())'></label>
					</td>
				</tr>
			</tbody>
		</table>


		<table align="left" width="65%">
			<thead>
				<tr>
	            <th width='10%'></th>
	            <th width='10%'></th>
	            <th width='10%'></th>
	           
				</tr>
			</thead>
			<tbody data-bind='foreach: $root.notesCashUpArray'>
				<tr>
					<td><label data-bind='text: label'></label></td>

					<td><input
						data-bind='value: quantity, valueUpdate: "afterkeydown"' size="2" /></td>

					<td>R <label data-bind='text: formatCurrency(notesSubtotal())'></label>
					</td>
				</tr>
			</tbody>
		</table>

		<p>
			*****Amount in the till*****<span data-bind='text:val'> </span>
		</p>


		<p>
			*****Total Sales Made*****<span
				data-bind='text:formatCurrency(grandTotal())'> </span>
		</p>
	
		<p>
			<span data-bind='if: amount() > 0' style='color: red'> surplus <span data-bind='text: formatCurrency(amount())'></span>
		</p>
		<p>
			<span data-bind='if: 0 > amount()' style='color: red'> shortage <span data-bind='text: formatCurrency(amount())'></span>
		</p>
		<p>
			<span data-bind='if: 0 == amount()' style='color: red'> balance <span data-bind='text: formatCurrency(amount())'></span>
		</p>
		
		
		
		 
	</form>
<!-- <select class="form-control" data-bind="options: $root.employeeList,  optionsText: 'empNum'" multiple="multiple"></select>
 --></body>
</html>