<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Client</title>
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
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrapValidator.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrapValidator.css">
<script>

  var ClientModelView =function(){
   var self = this;
   //Declare observable which will be bind with UI 
   self.idNum = ko.observable("");
   self.firstName = ko.observable("");
   self.surname = ko.observable("");
   self.email = ko.observable("");
   self.contactNum = ko.observable("");
   self.contactWork = ko.observable(""); 
   
   //The Object which stored data entered in the observables
   var ClientObject ={
   
		   idNum:self.idNum,
		   firstName:self.firstName,
		   surname:self.surname,
		   email:self.email,
		   contactNum:self.contactNum,
		   contactWork:self.contactWork,    
   };
   self.ClientObject=ko.observable();
   self.ClientObject=ko.observableArray([]);
   
   //Function to perform POST (insert Item to database)
    self.save = function(){
    //use ajax to transport json object to controller
    $.ajax({
            type:'POST',
            url:'http://localhost:8080/PointOfSale/pos/ClientController/saveClient',
            data: ko.toJSON(ClientObject),
            
            contentType: 'application/json',
            dataType:"json",
          
            success: function(data){
            	self.ClientObject.push(data);
            	
            alert("Record Added Successfully");
             alert("The new Client :" + data.idNum);
            },
             error: function ()
         {
           alert("message nje") 	
         }
    });

    
  };

   }
 
  $(document).ready(function () {

      var viewModel = new ClientModelView();            

      ko.applyBindings(viewModel);

  });

  

</script>

<script>
  $(function () { $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); } );
</script>	

</head>
<center><body>
<div id="client-box">
<form class="form-horizontal" role="form" border="1" id="client">

    <table>
       <tr>
       <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Id Number</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="idNum" placeholder="id Number" maxlength="13"  data-bind="value: $root.idNum" required>
      <p class="help-block"></p>
    </div>
  </div>
    </tr>
    <tr>
 
     <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstName" placeholder="First Name"  data-bind="value: $root.firstName" required>
    </div>
  </div>
    <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Surname</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="surname" placeholder="Surname"  data-bind="value: $root.surname" required>
    </div>
  </div>
     
     
    </tr>
    <tr>
       <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" placeholder="Email"  data-bind="value: $root.email" required>
    </div>
  </div>
    </tr>
       <tr>
      <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Contact No. :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="contactNum" placeholder="contact Number"  data-bind="value: $root.contactNum" required>
    </div>
  </div>
    </tr>
    <tr>
     <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Contact Work :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="contactWork" placeholder="contact Number"  data-bind="value: $root.contactWork" required>
    </div>
  </div>
    </tr>
        
    <tr><td colspan="1"><button type="submit" data-bind="click: $root.save" value="Save CLient" class="btn btn-success">Save Client</button></td>
   <td colspan="2"> <input type="reset" value="clear" class="btn btn-warning"></td></tr>
    </table> 

</form>
	
</div>
</body></center>
<script type="text/javascript">
$(document).ready(function() {
    $('#client').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            }
        }
    });
});
</script>

</html>