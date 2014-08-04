<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.8.0.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
  $("#getDetails").click(function(){
  $.ajax({
   type : "GET",
   url : "/EmployeeController",
   success: function(response){
    $("#empType").val(response.empType);
    $("#empName").val(response.empName);
    },
   error : function(){
    }
   
   });
  });
 });

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Employee Name : <input type="text" id="empName"></input><br/>
Employee Position : <input type="text" id="empType"></input><br/>

<input type="button" id="getDetails" value="Display"></input>

</body>
</html>