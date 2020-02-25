<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<form action="UpdatePurchaseAmount">

<body style = "background-color:LightGray">


<br/><br/><br/><center>
<h3>PurchaseDetails</h3>
PurchaseId: <input type="number" name="purchaseId"placeholder="PurchaseId" required autofocus/><br/><br/>
ProductId: <input type="number" name="productId"placeholder="ProductId" required autofocus/><br/><br/>
<!-- 
<button type="submit">UPDATE AMOUNT</button><br/>
<button><a href="PurchaseMenu.jsp">Back</a></button> -->
<button type="submit" class="btn btn-primary">UPDATE AMOUNT</button>
<a href="PurchaseMenu.jsp"><button type="submit"
class="btn btn-primary">Back</button></a></br> </br>
<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>

</form>

</center>
</body>
</html>

