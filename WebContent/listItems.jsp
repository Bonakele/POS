<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Items</title>

<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>



<script type="text/javascript">

$(document).ready(function() {
     
    $("#items").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "http://localhost:8080/PointOfSale/pos/ItemController/getAllItem",
        "aoColumns": [
            { "mData": "itemName" },
            { "mData": "description" },
            { "mData": "quantityInStock" },
            { "mData": "price" },
            { "mData": "type" },
            {
                "mData" : "id",
                "fnRender" : function(obj) {
                 if (obj.aData.id)
                  return '<input type="checkbox" name="aCheckBox" class="dt_checked" checked value="'+obj.aData.id+'\"/>';

                 return '<input type="checkbox" name="aCheckBox"  class="dt_checked" value="'+obj.aData.id+'\"/>';
                }
            },
           
        ], 
        "fnServerData" : function(sSource, aoData, fnCallback) {
            $.ajax({
             "dataType" : 'json',
             "type" : "GET",
             "url" : sSource,
             "data" : aoData,
             "success" : fnCallback
            });
        }
        
    } );

} );

</script>
</head>

<body>

<form action="">
<h2><strong>LIST ALL ITEMS IN JTABLE</strong></h2>
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

<table width="70%" style="border: 3px;background: rgb(243, 244, 248);"><tr><td>
    <table id="items" class="display" cellspacing="0" width="100%" id="table-pagination" data-toggle="table" data-url="data2.json" data-height="400" data-pagination="true" data-search="true">
        <thead>
            <tr>
                <th>ITEM NAME</th>
                <th>DESCRIPTION</th>
                <th>QUANTITY</th>
                <th>PRICE</th>
                <th>ITEM TYPE</th>
                <th data-field="id" data-checkbox="true"></th>
            </tr>
        </thead>       
    </table>
    </td></tr></table>
</form>

</body>

</html>