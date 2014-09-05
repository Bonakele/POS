<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="resources/jquery.js"></script>
<script src="resources/knockout.js"></script>
<script src="resources/sammy.min.js"></script>

	<script>
(function($){
var app=$.sammy('#add',function()
		{
	
	this.get('#/purchase',function(context){
		this.partial('Purchase.jsp')
	});
	
	this.get('#/return',function(context){
		this.partial('returnItem.jsp')
	});

	this.get('#/allItems',function(context){
		this.partial('tbljsp.jsp')
	});
	
	this.get('#/listItems',function(context){
		this.partial('listItems.jsp')
	});
	
	this.get('#/exchange',function(context){
		this.partial('exchangeItem.jsp')
	});
	
	this.get('#/',function(context){
		this.partial('.jsp')
	});
	
	});
	$(function(){
		app.run('#/')
	});
	
})(jQuery);

</script>

<style> 
#panel,#flip
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#panel
{
padding:50px;
display:none;
}
</style>

</head>
<body>

<a href="#/purchase">Purchases</a><br>
<a href="#/return">Return</a><br>
<a href="#/exchange">Exchange</a><br>
<a href="#/listItems">Report</a>

</body>
</html>