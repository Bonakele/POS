/**
 * 
 */
function selectedItems(data) {

	this.id = ko.observable(data.id);

}



	
function returnViewModel(){
	
	var self = this;
	
//	this.id = ko.observable();
//	this.Reason = ko.observable();
//	this.returnDate = ko.observable();
//	this.returnAmount = ko.observable();
//	
//
//	// Relationships
//	this.employee = ko.observable();
//	this.client= ko.observable();
//	this.item = ko.observable();
//	this.sale = ko.observable();
//	
//	var returnItem = {
//			
//			id : self.id,
//			Reason : self.Reason,
//			returnDate : self.returnDate, 
//			returnAmount : self.returnAmount,
//			client : self.client, 
//			item :	self.item, 
//			sale : self.sale
//	}
	
	self.returnItem = ko.observable();
	self.allItems = ko.observableArray([]);
	self.allClients = ko.observableArray([]);
	self.allSales = ko.observableArray([]);
	
/*	$.getJSON('http://localhost:8080/PointOfSale/pos/ClientController/getAllClients',
			null, function(data, status, xhr) {
			
		$.each(data,function(index,value){
			self.allClients.push(value);
			console.log(value);
			
		});
		
		

			});*/
	
	$.getJSON('http://localhost:8080/PointOfSale/pos/SalesController/getAllSales',
			function(allData) {

				var mappedData = $.map(allData, function(data) {
					return new selectedItems(data)
				});

				self.allSales(mappedData);

			});
	


/*	
	self.searchOrders = function(model, event){
		
		$.ajax({
			
			url : "http://localhost:8080/PointOfSale/pos/OrderController/getOrdersClient",
			data : ko.toJSON(cashup),
			contentType : "application/json; charset=utf-8",
			type : 'POST',
			success : function(ordersData){
				alert(ordersData),
				alert("Orders by Client ...");
			},
			error : function(xhr, status, err){
			
				alert(xhr.status + " : " + err + " : " + status);
			}
			
		});
		
		
		
	};*/
		
	
}


$(document).ready(function(){
	ko.applyBindings(new returnViewModel());
	
});