function itemsViewModel() {
	var self = this;

	self.lines = ko.observableArray([newItemRow() ]); // Put one line in
															// by default
//	self.grandTotal = ko.computed(function() {
//		var total = 0;
//		$.each(self.lines(), function() {
//			total += this.subtotal()
//		})
//		return total;
//	}, this);
	

	self.allItems = ko.observableArray([]);

	$.getJSON(
			"http://localhost:8080/PointOfSale/pos/ItemController/getAllItems",
			null, function(allItemData) {

				var obtainedItem = $.map(allItemData, function(data) {
//					return new newItemRow(data)
				});

				self.allItems(obtainedItem);

			});

}

var newItemRow = function() {
	var self = this;

	//self.id = ko.observable(data.id);
	self.itemName = ko.observable();
//	self.quantity = ko.observable(data.quantity);
	self.price = ko.observable();
//	this.subtotal = ko.dependentObservable(function() {
//		return this.price() * this.quantity();
//	}.bind(this));
}

$(document).ready(function() {

	ko.applyBindings(new itemsViewModel());

});
