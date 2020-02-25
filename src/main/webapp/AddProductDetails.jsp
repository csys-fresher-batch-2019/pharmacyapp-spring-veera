<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<form action="AddProductDetails">

<body style = "background-color:LightGray">
<br/><br/><br/><center>
<h3>ProductDetails</h3>
ProductId: <input type="number" name="productId"placeholder="ProductId" required autofocus/><br/><br/>
ProductName: <input type="text" name="productName"placeholder="ProductName" required autofocus/><br/><br/>
ProductType: <input type="text" name="productType"placeholder="ProductType" required autofocus/><br/><br/>
Cost: <input type="number" name="cost"placeholder="Cost" required autofocus/><br/><br/>
Quantity: <input type="number" name="quantity"placeholder="Quantity" required autofocus/><br/><br/>
ExpiryDate: <input type="date" name="expiryDate"placeholder="ExpiryDate" required autofocus/><br/><br/>
<!-- <button type="submit">ADD</button><br/><br/>
<button><a href="Adminaccess.jsp">Back</a></button> -->
<button type="submit" class="btn btn-primary">ADD</button>
<a href="ProductDetails.jsp"><button type="submit"
class="btn btn-primary">Back</button></a></br> </br>
</form>
</center>
</body>
</html>

