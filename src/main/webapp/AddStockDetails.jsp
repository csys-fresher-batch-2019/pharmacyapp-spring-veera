<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
	<form action="AddStockDetails">

		<body style="background-color: LightGray">
			<br />
			<br />
			<center>
				<h3>StockDetails</h3>
				ProductId: <input type="number" name="productId"
					placeholder="ProductId" required autofocus /><br />
				<br /> OpeningStock: <input type="number" name="openingStock"
					placeholder="OpeningStock" required autofocus /><br />
				<br /> PurchaseQuantity: <input type="number"
					name="purchaseQuantity" placeholder="PurchaseQuantity" required
					autofocus /><br />
				<br /> SalesQuantity: <input type="number" name="salesQuantity"
					placeholder="SalesQuantity" required autofocus /><br />
				<br />
				

				<button type="submit" class="btn btn-primary">ADD</button>
				<a href="Adminaccess.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
	</form>
	</center>
</body>
</html>

