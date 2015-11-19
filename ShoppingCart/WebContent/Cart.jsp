<%@ include file="header.jsp"
%>
<body>
<div class="panel panel-default">
	<h2>You have ${items} items in your shopping cart </h2>
  <div class="panel-body">
		<table class="table table-striped table table-bordered table table-hover" border="3" bordercolor="red">

<thead>

			<tr>
				<th>Quantity</th>
			     <th>Product ID</th>
				<th>Product</th>
				<th>Price</th>
				<th>Subtotal</th>
		
			</tr>
</thead>
<tbody>
		
${tableinfo}

</tbody>
		</table>
		
	<h3>Total: ${total}</h3>	
 
  
   </div>
   </div>

<%@ include file="footer.jsp"
%>