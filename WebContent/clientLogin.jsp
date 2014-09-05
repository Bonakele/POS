<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#login-box {
	width: 400px;
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
<div id="login-box">
<form class="form-horizontal" role="form"  action="http://localhost:8080/PointOfSale/pos/ClientController/clientLoginResult" method="post">
  <div class="form-group">
    <label for="saId" class="col-sm-2 control-label">ID Number </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="ID Number" name = "idNum">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password </label>
    <div class="col-sm-10">
      <input type="password" class="form-control" placeholder="Password" name = "password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Sign in</button>
       <a href="customerForm.html" class="btn btn-success">Register</a>
       
    </div>
  </div>
</form>
</div>
</body>
</html>