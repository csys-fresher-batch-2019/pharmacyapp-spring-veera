
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@page import="com.chainsys.pharmacyapp.productDetails.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.pharmacyapp.productDetails.ProductImplementation"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style = "background-color:white">
<center>
<h3>ProductList</h3>
</center>
<%

ProductImplementation dao = new ProductImplementation();
 ArrayList<Product> list = dao.displayProduct();

%>
<center>
<table border="1">
<thead><tr><th>S.no</th> <th> ProductId</th><th>ProductName </th><th>ProductType </th><th>Cost</th><th>Total Quantity</th><th>ExpiryDate</th><th>Click</th><th>Quantity</th></tr>
</thead>

<tbody>
</center>
<%
int i= 1;
for(Product p: list)
{%>
	<tr><td><%= i++ %></td>
	<td><%= p.getProductId() %></td>
	<td><%= p.getProductName()%></td>
	<td><%=p.getProductType()%></td>
	<td><%=p.getCost()%></td>
	<td><%=p.getQuantity()%></td>
	<td><%=p.getExpiryDate()%></td>
	<td><input type="checkbox" name="pid" id="pid_<%=p.getProductId()%>"value="<%=p.getProductId()%>"></td>
<%-- 	<td><a href="cart.jsp?productId=<%=p.getProductId()%>"></td></a>
 --%>	
 <%
if ((int) p.getProductId() == 0) {
	%>
	<td><select name="qty_<%=p.getProductId()%>"
		onchange="disable(<%=p.getProductId()%>)" disabled>
			<option value="0"></option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
	</select></td>
	<%
		} else {
	%>
	<td><select name="qty_<%=p.getProductId()%>"
		onchange="disable(<%=p.getProductId()%>)" autofocus>
			<option value="0"></option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
	</select></td>
</tr>

<%
	}
		 %>



 <%
	}
%>
</tbody>
</table>
<br> <br>
 <a href="OrderPlaced.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Buy Now</button></a></br> </br>
<!-- <button type="submit" a href="OrderPlaced.jsp">Buy Now</button>
 -->
</form>
<br>
<button>
<a href="welcome.jsp">Home</a>
</button>
<script>
$(document).ready(function(){
$("form").submit(function(){
if ($('input:checkbox').filter(':checked').length < 1){
alert("Check at least one Game!");
return false;
}
});
});</script>
<script>
		function disable(productId) {
				 
				var i=0;
				var ch = document.getElementById("pid_" + productId);
				if (ch.checked){
					ch.checked=false;
				}
				else{ 
					ch.checked=true;
				}
			}
</script>

<!-- 
Enter ProductId: <input type="number" name="productId"placeholder="Enter productId" required/> -->
<br/>
<br/>
</tbody>
</table>
</body>
</html>