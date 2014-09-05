<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
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

  var EmployeeModelView =function(){
   var self = this;
   //Declare observable which will be bind with UI 
   self.SA_id = ko.observable("");
   self.firstName = ko.observable("");
   self.surname = ko.observable("");
   self.title = ko.observable("");
   self.occupation = ko.observable("");
   self.telNumberWork = ko.observable("");
   self.telNumberMobile = ko.observable(""); 
   self.password = ko.observable("");
   self.confirm_password = ko.observable("");
   
   //The Object which stored data entered in the observables
   var EmployeeObject ={
   
		   SA_id:self.SA_id,
		   firstName:self.firstName,
		   surname:self.surname,
		   title:self.title,
		   occupation:self.occupation,
		   telNumberWork:self.telNumberWork,
		   telNumberMobile:self.telNumberMobile,
		   password:self.password,
		   confirm_password:self.confirm_password    
   };
   self.EmployeeObject=ko.observable();
   self.EmployeeArray=ko.observableArray([]);
   
   //Function to perform POST (insert Item to database)
    self.save = function(){
    //use ajax to transport json object to controller
    $.ajax({
            type:'POST',
            url:'http://localhost:8080/PointOfSale/pos/EmployeeController/saveEmployee',
            data: ko.toJSON(EmployeeObject),
            
            contentType: 'application/json',
            dataType:"json",
          
            success: function(data){
            	self.EmployeeArray.push(data);
            	
            alert("Employee Added " + data.firstName + " Successfully");
            },
             error: function ()
         {
           alert("message nje") 	
         }
    });

    
  };

   }
 
  $(document).ready(function () {

      var viewModel = new EmployeeModelView();            

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
    <label for="saId" class="col-sm-2 control-label">Id Number</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="idNum" placeholder="id Number"  data-bind="value: $root.SA_id" >
    </div>
  </div>
    </tr>
    <tr>
 
     <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstName" placeholder="First Name"  data-bind="value: $root.firstName" >
    </div>
  </div>
    <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Surname</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="surname" placeholder="Surname"  data-bind="value: $root.surname" >
    </div>
  </div>
     
     
    </tr>
    <tr>
       <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="email" placeholder="Email"  data-bind="value: $root.title" >
    </div>
  </div>
    </tr>
    
     <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Occupation</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="occupation" placeholder="Occupation"  data-bind="value: $root.occupation" >
    </div>
  </div>
     
     
    </tr>
    
     <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" placeholder="password"  data-bind="value: $root.password" >
    </div>
  </div>
     
     
    </tr>
    
    
       <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Contact No. :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="contactNum" placeholder="contact Number"  data-bind="value: $root.telNumberWork" >
    </div>
  </div>
    </tr>
    <tr>
      
     <!--  <td><label class=" control-label">Contact Work :</label></td><td><input  type = "text" class="form-control" id="contactWork" data-bind="value: $root.contactWork"  placeholder="i.e. 047 789 2345"></td> -->
     <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Contact Work :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="contactWork" placeholder="Mobile Number"  data-bind="value: $root.telNumberMobile" >
    </div>
  </div>
    </tr>
        
    <tr><td colspan="1"><button type="submit" data-bind="click: $root.save" value="Save Employee" class="btn btn-success">Save Employee</button></td>
   <td colspan="2"> <input type="reset" value="clear" class="btn btn-warning"></td></tr>
    </table> 

</form>

</div>
</body></center>


</html>