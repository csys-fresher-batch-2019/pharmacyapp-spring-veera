<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<form action="UpdateProductCost">

		<body style="background-color: LightGray">
			</br>
			</br>
			<center>
				<h3>ProductDetails</h3>
				ProductId: <input type="number" name="productId"
					placeholder="ProductId" required autofocus /><br />
				<br /> ProductCost: <input type="number" name="productCost"
					placeholder="ProductCost" required autofocus /><br />
				<br />

				<!-- <button type="submit">UPDATE</button><br/>
<button><a href="Productdetails.jsp">Back</a></button> -->
				<button type="submit" class="btn btn-primary">UPDATE</button>
				<a href="Productdetails.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
	</form>

	</center>
</body>
</html>

