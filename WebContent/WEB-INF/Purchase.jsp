<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.util.Date;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchasing</title>
<script type="text/javascript" src="http://<span class="t64u8" id="t64u8_4">ajax</span>.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">  
    $(document).ready(function(){   
            $('#getData').click(function(){  
                $.ajax({  
                    url:'PurchaseController',  
                    type:'post',  
                    dataType: 'json',
                    dat: JASON,
                    contentType: 'application/json',
                    success: function(data) {  
                        $('#txtPaymentType').val(data.txtPaymentType);  
                        $('#txtTotal').val(data.txtTotal);  
                        $('#txtChange').val(data.txtChange); 
                        $('#txtAmountDue').val(data.txtAmountDue); 
                        $('#date').val(data.date); 
                        $('#item_id').val(data.items);
                    }  
                });  
            });  
    });  
</script> 

</head>
<body> 
		<form method="POST" action="PurchaseController">
				<table>
						<tr><td valign="top">select item:</td><td><input type="text" id="item_id"></td><td><input type="submit" value="search" name="search"></td>
 						<tr><td colspan="2">List of items:<br><textarea rows="10" cols="20"></textarea></td></tr>
						<tr><td>Payment Type:</td><td><input type="text" id="txtPaymentType"></td></tr>
						<tr><td>Date:</td><td><input type="date" id="date"></td></tr>
						<tr><td>Total Amount:</td><td><input type="text" id="txtTotal" readonly="true"></td></tr>
						<tr><td>Vat(14%):</td><td><input type="text" id="txtVat" readonly="true"></td></tr>
						<tr><td>Amount Due:</td><td><input type="text" id="txtAmountDue"></td></tr>
						<tr><td>Change Amount:</td><td><input type="text" id="txtChange" readonly="true"></td></tr>
						<tr><td colspan="2"><input type="button" value="Purchase" id="buy"></td></tr>
				</table>
		
		</form>

		

</body>
</html>