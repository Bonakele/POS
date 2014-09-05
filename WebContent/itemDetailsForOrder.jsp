<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BONAKELE</title>


<script type="text/javascript" src="resources/bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

					
								$.ajax({
									url : "http://localhost:8080/PointOfSale/pos/ItemController/giveChosenItemList",
									type : 'GET',
									dataType : 'json',

									success : function(data) {

										$.each(data, function(index, value) {
											alert("hello");
										});

									},
									error : function(data, status, er) {
										alert(data + " : " + er + " : "
												+ status);
									}
								});
					});
</script>
</head>
<body>
<h1>hello itemDetailsForOrder.jsp</h1>

</body>
</html>