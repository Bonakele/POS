<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clients CRUD</title>

<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#PersonTableContainer').jtable({
			title : 'Clients ',
		
			paging : true,
			pageSize : 10,
			actions : {
				listAction : 'http://localhost:8080/ClientCRUD/pos/ClientController/getAllClients',
				createAction : 'CRUDController?action=create',
				updateAction : 'CRUDController?action=update',
				deleteAction : 'CRUDController?action=delete' 
			},
			fields : {
				idNum : {
					create:true,
					edit : true,
					list : true,
					title : 'ID No.',
					width : '20%'
				},
				firstName : {
					title : 'Customer Name',
					width : '30%'
				},
				email : {
					title : 'Email',
					width : '30%'
				},
				contactNum : {
					title : 'Phone',
					width : '20%',
				},
				contactWork : {
					title : 'Work Contact',
					width : '20%',

				}

			}
		});
		$('#PersonTableContainer').jtable('load');
	});
</script>
</head>

<body>
	
	<div style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">

		<h1>POS Clients</h1>

		<div id="PersonTableContainer"></div>

	</div>

</body>
</html>
