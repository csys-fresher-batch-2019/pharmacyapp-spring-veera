
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@page import="com.chainsys.pharmacyapp.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.pharmacyapp.dao.impl.ProductImplementation"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style = "background-color:skyblue">
<center>
<h3>PRODUCTLIST</h3>
</center>
<%

ProductImplementation dao = new ProductImplementation();
 ArrayList<Product> list = dao.displayProduct();

%>
<center>
<table border="1">
<thead><tr><th>S.no</th> <th> ProductId</th><th>ProductName </th><th>ProductType </th><th>Cost</th><th>Quantity</th><th>ExpiryDate</th></tr>
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
	<td><%=p.getExpiryDate()%></td></tr>
	<%
	}
%>
</tbody>
</table>
</center>
</body>
</html>
