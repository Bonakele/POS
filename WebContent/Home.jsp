<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>POINT OF SALE SYSTEM</title>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/knockout.js"></script>
<script src="resources/js/sammy.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-social.css">

<script>
	(function($) {
		var app = $.sammy('#add', function() {

			this.get('#/makePurchase', function(context) {
				this.partial('makePurchase.jsp')
			});

			this.get('#/return', function(context) {
				this.partial('return.jsp')
			});

			this.get('#/order', function(context) {
				this.partial('tbljsp.jsp')
			});

			this.get('#/listItems', function(context) {
				this.partial('listAllItems.jsp')
			});

			this.get('#/aboutUs', function(context) {
				this.partial('aboutUs.jsp')
			});

			this.get('#/index', function(context) {
				this.partial('index.jsp')
			});
			this.get('#/home', function(context) {
				this.hide('index.jsp')
				this.partial('Home.jsp')
			});
			
			this.get('#/login', function(context) {
				this.partial('login.jsp')
			});
			this.get('#/listItems', function(context) {
				this.partial('listItems.jsp')
			});

			this.get('#/purchase', function(context) {
				this.partial('saveSale_2.jsp')
			});
			this.get('#/addClient', function(context) {
				this.partial('addClient.jsp')
			});

			this.get('#/listClients', function(context) {
				this.partial('listAllClients.jsp')
			});
			this.get('#/order1', function(context) {
				this.partial('saveOrder_2.jsp')
			});
			this.get('#/employee', function(context) {
				this.partial('employee.jsp')
			});
			
			 this.get('#/cashup', function(context) {
				this.partial('saveCashUp.jsp')
			});
			 this.get('#/exchange', function(context) {
					this.partial('exchange.jsp')
				});
				 

			/* this.get('#/', function(context) {
				this.partial('Home.jsp')
			}); */

		});
		$(function() {
			app.run('#/')
		});

	})(jQuery);
</script>
<link rel="style" href="style.css" type="text/css">
</head>
<h2 align="center">POINT OF SALE</h2>
<body>
	<ul class="nav nav-tabs">
		<li><a href="#"> <span></span><img src="resources/images/home.png" alt="logo">Home
		</a></li>

		<!-- <li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <img src="resources/images/buy.png" alt="logo">Order <span
				class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="#/order1" class="hide">Select Item to Order</a></li>
				<li><a href="#/listItems"> View Items</a></li>
			</ul></li> -->

		 <li class="dropdown"><a class="dropdown-toggle" 
			data-toggle="dropdown" href="#"><img src="resources/images/shopping_cart.png" alt="logo">Sales<span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="#/purchase">Sales</a></li>
				<li><a href="#/return">Return Item</a></li>
				<li><a href="#/cashup">Cash Up</a></li>
			</ul></li> 

		<!-- <li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"><img src="resources/images/people.png" alt="logo"> Customer Manager <span
				class="caret"></span>
		</a>
		
			<ul class="dropdown-menu">

				<li><a href="#/addClient">Create New Customer</a></li>
				<li class="divider"></li>
				<li><a href="#/listClients">list Customers</a></li>
			</ul></li> -->

		<!-- <li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" class="hide"><img src="resources/images/people.png" alt="logo">Employee Manager <span
				class="caret"></span>
		</a>
			<ul class="dropdown-menu">

				<li><a href="#/employee">Create New Employee</a></li>
				<li class="divider"></li>
				<li><a href="#/listClients">list Employee</a></li>
			</ul></li> -->
		<li><a href="#/index"> <span></span><img src="resources/images/login.png" alt="logo"> logout
		</a></li>
		<li><a href="#/aboutUs"><img src="resources/images/info.png" alt="logo"> AboutUs</a></li>
		<!-- <li><a href="#"><img src="resources/images/report.png" alt="logo">Reports</a></li> -->
		
		<li><div>
				<form method="get" action="http://www.google.com/search" role="search" class="navbar-form navbar-left">
					<input type="text" name="q" size="31" maxlength="255" value="" class="form-control" placeholder="Google Search" />
					<input type="submit" value="Search" class="btn btn-info" /> 
				</form>
			</div></li>
	</ul>

	<div id="add">
		<div id="myCarousel" class="carousel slide" align="center">

			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			
			<div class="carousel-inner">
				<div class="item active">
					<img src="resources/images/slide111.jpg" alt="First slide">
					<div class="carousel-caption">Boot</div>
				</div>
				<div class="item">
					<img src="resources/images/slide222.jpg" alt="Second slide">
					<div class="carousel-caption">Clothes</div>
				</div>
				<div class="item">
					<img src="resources/images/slide333.png" alt="Third slide">
					<div class="carousel-caption">This Caption 3</div>
				</div>
				<div class="item">
					<img src="resources/images/slide88.jpg" alt="Forth slide">
					<div class="carousel-caption">This Caption 4</div>
				</div>
				<div class="item">
					<img src="resources/images/slide77.jpg" alt="Forth slide">
					<div class="carousel-caption">This Caption 5</div>
				</div>
			</div>

			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
		
		<div class="col-sm-4 col-lg-4 col-md-4">
			<div class="thumbnail">
				<img src="resources/images/slide1111.jpg" alt="">
				<div class="caption">
					<h4 class="pull-right">R799.99</h4>
					<h4>
						<a href="#">Third Product</a>
					</h4>
					<p>Lowest price for everyone.</p>
				</div>
				<div class="ratings">
					<p class="pull-right">31 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star-empty"></span>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-4 col-lg-4 col-md-4">
			<div class="thumbnail">
				<img src="resources/images/Guess1.jpg" alt="">
				<div class="caption">
					<h4 class="pull-right">R599.99</h4>
					<h4>
						<a href="#">Fourth Product</a>
					</h4>
					<p>Great pefume you  can use.</p>
				</div>
				<div class="ratings">
					<p class="pull-right">6 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star-empty"></span> <span
							class="glyphicon glyphicon-star-empty"></span>
					</p>
				</div>
			</div>
		</div>

		<div class="col-sm-4 col-lg-4 col-md-4">
			<div class="thumbnail">
				<img src="resources/images/suit.jpg" alt="">
				<div class="caption">
					<h4 class="pull-right">R899.99</h4>
					<h4>
						<a href="#">Fifth Product</a>
					</h4>
					<p>This suit is on sale.should you miss this one,you will
						regret</p>
				</div>
				<div class="ratings">
					<p class="pull-right">18 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star-empty"></span>
					</p>
				</div>
			</div>
		</div>
		<div class="container">

			<hr>

			<!-- Footer -->
			<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; My Group 2014</p>
				</div>
			</div>
			</footer>

		</div>
	</div>


</body>
</html>