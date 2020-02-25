<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<body>
<form action="AddSalesDetails">

<body style = "background-color:LightGray">
</br></br></br><center>
<h3>ProductDetails</h3>
SalesId: <input type="number" name="salesId"placeholder="SalesId" required autofocus/><br/></br>
ProductId: <input type="number" name="productId"placeholder="ProductId" required autofocus/><br/></br>
SalesQuantity: <input type="number" name="salesQuantity"placeholder="SalesQuantity" required autofocus/><br/></br>
Amount: <input type="number" name="Amount"placeholder="Amount" required autofocus/><br/></br>
<!-- <button type="submit">ADD</button><br/>
<button><a href="Adminaccess.jsp">Back</a></button> -->
<button type="submit" class="btn btn-primary">ADD</button>
<a href="Adminaccess.jsp"><button type="submit"
class="btn btn-primary">Back</button></a></br> </br>
</form>
</center>
</body>
</html>

