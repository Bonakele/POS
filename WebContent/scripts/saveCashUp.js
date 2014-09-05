

function cashUp(label, amount) {
	/*
	 * coinsArray = ko.observableArray([0.05, 0.1, 0.2, 0.5, 1, 2, 5]);
	 * coinsLabel = ko.observableArray(["5c","10c","20c","50c","R1","R2","R5"]);
	 */

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
	return value.toFixed(2);
}

function cashUpViewModel() {

	
	
	this.coinsCashUpArray = ko.observableArray([ new cashUp("5c", 0.05),
			new cashUp("10c", 0.1), new cashUp("20c", 0.2),
			new cashUp("50c", 0.5), new cashUp("R1", 1), new cashUp("R2", 2),
			new cashUp("R5", 5) ]);
	// Notes
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

	this.grandTotal = ko.computed(function() {
		return this.coinTotal() + this.notesTotal();
	}, this);
	

	


}

$(document).ready(function() {
	// ko.cleanNode($element[0]);
	ko.applyBindings(new cashUpViewModel());

});