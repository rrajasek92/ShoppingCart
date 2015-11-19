<%@ include file="header.jsp"
%>
<body>

<div class="panel panel-default">
			<div class="panel-body">
			<table class="table table-striped table table-bordered table table-hover">
			<thead>

			<tr>
				<th>Product ID</th>
			     <th>Product</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
		
			</tr>
</thead>
			<tbody>
				<tr><td>${ productList.productid }</td><td>  ${ productList.productname } </td><td> ${ productList.description}</td><td> ${ productList.price } </td><td><form action="http://localhost:8080/ShoppingCart/CartServlet" method="get"><input type="hidden" name="prodID" value="${ productList.productid }"> <input type="text" name="quantity"> &nbsp; &nbsp; &nbsp;<input type="submit" value="Add to Cart"></form></td></tr>
				</tbody>
			</table>
				
			
			</div>
		</div>



<%@ include file="footer.jsp"
%>