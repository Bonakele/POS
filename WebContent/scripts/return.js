/**
 * 
 */

function formatCurrency(value) {
	return "R" + value.toFixed(2);
};

var idz;
function orders(order) {
	this.id = ko.observable(order.id);
	idz = this.id();
	console.log(idz);
};


function orderItems(item) {
	this.itemName = ko.observable(item.itemName);
	this.price = ko.observable(item.price);
};

//var quantityRequested;

//var price;
//var itemName;


var CartLine = function() {

	var self = this;
	
	self.quantityRequested = ko.observable("");

	this.id = ko.observable();
	this.Reason = ko.observable();
	this.returnDate = ko.observable();
	this.returnAmount = ko.observable();

	// Relationships
	this.employee = ko.observable();
	this.client = ko.observable();
	this.item = ko.observable();
	this.sale = ko.observable();
	this.order = ko.observable();

	var returnItem = {

		id : self.id,
		Reason : self.Reason,
		returnDate : self.returnDate,
		returnAmount : self.returnAmount,
		client : self.client,
		item : self.item,
		sale : self.sale,
		order : self.order
	}

	self.allOrders = ko.observableArray([]);
	self.orderedItems = ko.observableArray([]);
	self.price =
	//console.log(orderedItems);

	$
			.getJSON(
					'http://localhost:8080/PointOfSale/pos/OrderController/getAllOrders',
					function(allData) {

						var mappedData = $.map(allData, function(data) {
							return new orders(data)
							console.log(data);
						});

						self.allOrders(mappedData);

					});
	
			
		

	$
			.getJSON(
					'http://localhost:8080/PointOfSale/pos/OrderController/getOrderedItems/' + 2,
					function(allData) {

						var mappedData = $.map(allData, function(data) {
							/*price : price(data.price);
							itemName : itemName(data.itemName);
						console.log(price());
						console.log(itemName());*/
							
						return new orderItems(data);
						});

						
						self.orderedItems(mappedData);

					});
	

	
	self.subtotal = ko.computed(function() {
		return 12.5 * self.quantityRequested();
	},this);

	// Whenever the Order number changes, reset the Item selection
	self.order.subscribe(function() {
		self.item(undefined);
	});
};

var Cart = function() {
	// Stores an array of lines, and from these, can work out the grandTotal
	var self = this;

	self.lines = ko.observableArray([ new CartLine() ]); // Put one line in
	// by default
	
	 self.grandTotal = ko.computed(function() {
	        var total = 0;
	        $.each(self.lines(), function() {
	        	total += 15.99; 
	        })
	        return total;
	    });

	// Add Items to the Array
	self.addLine = function() {
		self.lines.push(new CartLine())
	};

	// Remove Items to the Array
	self.removeLine = function(line) {
		self.lines.remove(line)
	};

	// Save Return Items
	self.save = function() {
		/*var dataToSave = $.map(self.lines(), function(line) {
		
		});*/
		alert("Congradulation Your refund ws succesfull: ");
	};

};

$(document).ready(function() {
	ko.applyBindings(new Cart());
});
