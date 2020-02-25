<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<form action="AmountcalAftersales">

<body style = "background-color:LightGray">
<br/><br/><br/><center>
<h3>Amount Calculation Aftersales </h3>
ProductId: <input type="number" name="productId"placeholder="ProductId" required autofocus/><br/><br/>
SalesId: <input type="number" name="salesId"placeholder="SalesId" required autofocus/><br/><br/>

<!-- <button type="submit">Calculate</button><br/>
<button><a href="Productdetails.jsp">Back</a></button>
 -->
<button type="submit" class="btn btn-primary">Calculate</button>
<a href="Productdetails.jsp"><button type="submit"
class="btn btn-primary">Back</button></a></br> </br>
</form>

</center>
</body>
</html>

