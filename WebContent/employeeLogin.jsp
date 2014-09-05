<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm() {
    var x = document.forms["myForm"]["empNum"].value;
    var y=document.forms["myForm"]["password"].value;
   
    if (x == null || x == "") {
        alert("First name must be filled out");
        return false;
    } else if(y==null || y==""){
        	alert("enter password")
    
    }
}
</script>
<script type="text/javascript" src="resources/bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	var employeeLogin = function() {

		var empNum = $("#empNum").val();
		var password = $("#password").val();
		

		var jsonObject = {
			"empNum" : empNum,
			"password" : password,	
		};

		
				$.ajax({

					url : "http://localhost:8080/PointOfSale/pos/EmployeeController/employeeLoginResult",
					type : 'post',
					dataType : 'json',
					data : JSON.stringify(jsonObject),
					contentType : "application/json; charset=utf-8",

					success : function(data) {
						alert("success")
					},
					error : function(XHR, status, er) {
						alert(XHR.status + " : " + er + " : " + status);
					}
				});
	}
</script>

</head>
<body>
	<form id="myForm">
		<h1 align="center">Point Of Sale System Login</h1>

		<table border="1" align="center">

			<tr>
				<td><label >UserName</label></td>
				<td><input id="empNum" /></td>
			</tr>
			<tr>
				<td><label >Password</label></td>
				<td><input type="password" id = password  /></td>
			</tr>

			<tr>
				<td><input type="button" value="Login" align="middle" onclick="employeeLogin()"></input></td>
				<td><a href="employeeForm.html">Register</a></td>
			</tr>
		</table>
	</form>

</body>
</html>