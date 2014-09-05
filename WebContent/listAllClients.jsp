<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/jquery.dataTables.css">

<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>

<script type="text/javascript">

$(document).ready(function() {
     
    $("#items").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "http://localhost:8080/PointOfSale/pos/DataTableController/getAllClients",
        "aoColumns": [
            { "mData": "idNum" },
            { "mData": "firstName" },
            { "mData": "email" },
            { "mData": "contactNum" },
            { "mData": "contactWork" },             
        ]
    } );

} );

</script>
</head>
<body>
<form action="">
<h2 >Client Details<br><br></h2>

<style> 
#panel,#flip
{
padding:5px;
text-align:center;
background-color:#ee11ff;
border:solid 1px #c3c3c3;
}
#panel
{
padding:50px;
display:none;
}
</style>


<table width="70%" style="border: 3px;background: rgb(243, 244, 248);"><tr><td>
    <table id="items" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>ID Number </th>
                <th>First Name</th>
                <th>Email</th>
                <th>Cell No.</th>
                <th>Tel. Work</th>
            </tr>
        </thead>       
    </table>
    </td></tr></table>
</form>
</body>
</html>