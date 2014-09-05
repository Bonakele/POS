<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="resources/bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	var saveEmployee = function() {

		var SA_id = $("#SA_id").val();
		var firstName = $("firstName").val();    
		var surname = $("surname").val();
		var title = $("surname").val();
		var telNumberWork = $("telNumberWork").val();
		var telNumberMobile = $("telNumberMobile").val();
		var password = $("password").val();
		var confirm_password = $("confirm_password").val();
		

		var jsonObject = {
			"SA_id" : SA_id,
			"firstName" : firstName,
			"surname" : surname,
			"title" : title,
			"telNumberWork" : telNumberWork,
			"telNumberMobile" : telNumberMobile,
			"password" : password,
			"confirm_password":confirm_password,
		};

		

		$
				.ajax({

					url : "http://localhost:8080/PointOfSale/pos/EmployeeController/saveEmployee",
					type : 'post',
					dataType : 'json',
					data : JSON.stringify(jsonObject),
					contentType : "application/json; charset=utf-8",

					success : function(data) {
						alert(data.firstName + " " + data.surname)
					},
					error : function(XHR, status, er) {
						alert(XHR.status + " : " + er + " : " + status+" OH NO, AN ERROR");
						
					}
				});
	}
</script>
<style type="text/css">
#employee-box {
	width: 500px;
	padding: 20px;
	margin: 100px auto;
	/* background: #fff; */
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
<div id="employee-box">
<form class="form-horizontal" role="form">
		<h2 align="center">Employee Details</h2>
		<table border="1" align="center">
			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">SA ID </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="SA_id" placeholder="SA ID">
    </div>
  </div>
				
			</tr>
			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Name </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" placeholder="name">
    </div>
  </div>
			
			</tr>
			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Surname </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="surname" placeholder="surname">
    </div>
  </div>
				
			</tr>
			<tr>
				<!-- <td><label >Title</label></td>
				<td><select id="title">
						<option value="Mr">Mr</option>
						<option value="Mrs">Mrs</option>
						<option value="Miss">Miss</option>
					</select></td> -->
					
					<div class="form-group">
    <label for="title" class="col-sm-2 control-label">Title </label>
    <div class="col-sm-10">
      
     <select id="title" class="form-control" placeholder="Title">
						<option value="Mr">Mr</option>
						<option value="Mrs">Mrs</option>
						<option value="Miss">Miss</option>
					</select>
    </div>
  </div>
			</tr>
			<tr>
				
					<div class="form-group">
    <label for="occupation" class="col-sm-2 control-label">Occupation </label>
    <div class="col-sm-10">
      
     <select id="occupation" class="form-control" placeholder="Home Tel Number">
						<option value="Admin">Admin</option>
						<option value="Cashier">Cashier</option>
						<option value="Driver">Driver</option>
					</select>
    </div>
  </div>
			</tr>
			<tr>
				<!-- <td><label >Home Address</label></td>
				<td><textarea id="homeAddress" rows="3" cols="20"></textarea></td>
				
				 -->
				 
				 <div class="form-group">
    <label for="homeAddress" class="col-sm-2 control-label">Home address </label>
    <div class="col-sm-10">
     
      <textarea id="homeAddress" rows="3" cols="20" class="form-control"></textarea>
    </div>
  </div>
			</tr>
		
			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Tel Number(Home) </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="telNumberHome" placeholder="Home Tel Number">
    </div>
  </div>
			</tr>
			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Cell Number </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="telNumberMobile" placeholder="Cell Number">
    </div>
  </div>
			</tr>

			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Password </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="password" placeholder="password">
    </div>
  </div>
				
			</tr>

			<tr>
				<div class="form-group">
    <label for="saId" class="col-sm-2 control-label">Confirm Password</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="confirm_password" placeholder="Confirm Password">
    </div>
  </div>
			
			</tr>

			<tr>

				<td><input type="submit" value="Submit" onclick="saveEmployee()" class="btn btn-primary"></input></td>
				<td><input type="button" value="Cancel"
					onclick="window.history.back()" class="btn btn-warning"></td>
			</tr>

		</table>
</form>
</div>
</body>
</html>