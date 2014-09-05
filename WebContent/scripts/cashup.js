/**
 * 
 */

function cashupViewModel(){
	var self = this;
	
	
	this.cashUpDate = ko.observable();
	this.comments = ko.observable();
	this.status = ko.observable();
	this.amount = ko.observable();
	this.registerAmount = ko.observable();
	this.totalAmount = ko.observable();
	
	this.employee = ko.observable();
	this.sale = ko.observable();
	
	var cashup = {
		
			cashUpDate : self.cashUpDate,
			comments   : self.comments,
			status : self.status,
			amount : self.amount,
			registerAmount : self.registerAmount,
			
			employee : self.employee,
			sale : self.sale
		     
	}
	
	self.cashup = ko.observable();
	self.allCashiers = ko.observableArray([]);
	self.allSales = ko.observableArray([]);
	
	
	
	$.getJSON("http://localhost:8080/PointOfSale/pos/EmployeeController/getAllEmployees",
			null, function(cashierData, status, xhr) {
			
		$.each(cashierData,function(index,value){
			
			self.allCashiers.push(value);
			
		});
		
		

			});
			
	
	$.getJSON("http://localhost:8080/PointOfSale/pos/PurchaseController/getAllSales",
			null, function(salesData, status, xhr) {
			
		$.each(salesData,function(index,value){
			//console.log(value);
			self.allSales.push(value);
			
		});
		
		

			});
			
	self.saveCashup = function(model, event){
	
		$.ajax({
		
			url : "http://localhost:8080/PointOfSale/pos/CashupController/saveCashup",
			data : ko.toJSON(cashup),
			contentType : "application/json; charset=utf-8",
			type : 'POST',
			success : function(cashupData){
				alert(cashupData),
				alert("CashUp was made Successfully");
			},
			error : function(xhr, status, err){
			
				alert(xhr.status + " : " + err + " : " + status);
			}
			
		
		});
	
	
	
	}
}

$(document).ready(function(){
	
	
	ko.applyBindings(new cashupViewModel());
	
});
			
			
					