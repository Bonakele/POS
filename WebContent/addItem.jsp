<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<style type="text/css">
#client-box {
	width: 500px;
	padding: 20px;
	margin: 100px auto;
	/* background: #fff; */
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>


<script src="resources/js/jquery.js"></script>
<script src="resources/js/knockout.js"></script>
<script src="resources/js/gen_validatorv4.js"></script>
<script>

  var ItemModelView =function(){
	  
   var self = this;
   //Declare observable which will be bind with UI 
   self.itemName = ko.observable("");
   self.description = ko.observable("");
   self.quantityInStock = ko.observable("");
   self.quantityRequested = ko.observable("");
   self.discountPerc = ko.observable("");
   self.markDown = ko.observable("");
   self.price = ko.observable(""); 
   self.colour = ko.observable("");
   self.type = ko.observable("");
   self.size = ko.observable("");
   self.priceAfterDiscMark = ko.observable("");
   
   //The Object which stored data entered in the observables
   var ItemObject ={
   
		   itemName:self.itemName,
		   description:self.description,
		   quantityInStock:self.quantityInStock,
		   quantityRequested:self.quantityRequested,
		   discountPerc:self.discountPerc,
		   markDown:self.markDown,
		   price:self.price,
		   colour:self.colour,
		   type:self.type,
		   size:self.size,
		   priceAfterDiscMark:self.priceAfterDiscMarks    
   };
   self.ItemObject=ko.observable();
   self.ItemArray=ko.observableArray([]);
   
   //Function to perform POST (insert Item to database)
    self.save = function(){
    //use ajax to transport json object to controller
    $.ajax({
            type:'POST',
            url:'http://localhost:8080/PointOfSale/pos/ItemController/saveItem',
            data: ko.toJSON(ItemObject),
            
            contentType: 'application/json',
            dataType:"json",
          
            success: function(data){
            	self.ItemArray.push(data);
            	
            alert("Item Added " + data.firstName + " Successfully");
            },
             error: function ()
         {
           alert("Item Added Successfully") 	
         }
    });

    
  };

   }
 
  $(document).ready(function () {

      var viewModel = new ItemModelView();            

      ko.applyBindings(viewModel);

  });

  
  
</script>


</head>
<center><body>
<div id="client-box">
<form class="form-horizontal" role="form" border="1" id="myForm">

    <table>
       <tr>
       <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Item Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="itemName" placeholder="Item Name"  data-bind="value: $root.itemName" >
    </div>
  </div>
    </tr>
    <tr>
 
     <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Quantity In Stock</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantityInStock" placeholder="Quantity In Stock"  data-bind="value: $root.quantityInStock" >
    </div>
  </div>
    <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Quantity Requested</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantityRequested" placeholder="Surname"  data-bind="value: $root.quantityRequested" >
    </div>
  </div>
     
     
    </tr>
    <tr>
       <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" placeholder="price"  data-bind="value: $root.price" >
    </div>
  </div>
    </tr>
    
     <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Type</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="type" placeholder="type"  data-bind="value: $root.type" >
    </div>
  </div>
     
     
    </tr>
    
     <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Size</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="size" placeholder="size"  data-bind="value: $root.size" >
    </div>
  </div>
     
     
    </tr>
    
          
    <tr><td colspan="1"><button type="submit" data-bind="click: $root.save" value="Save Item" class="btn btn-success">Save Item</button></td>
   <td colspan="2"> <input type="reset" value="clear" class="btn btn-warning"></td></tr>
    </table> 

</form>

</div>
</body></center>


</html>