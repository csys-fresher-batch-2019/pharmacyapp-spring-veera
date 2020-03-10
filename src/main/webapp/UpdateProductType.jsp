<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<form action="UpdateProductType">

		<body style="background-color: LightGray">
			<br />
			<br />
			<br />
			<center>
				<h3>ProductDetails</h3>
				ProductId: <input type="number" name="productId"
					placeholder="ProductId" required autofocus /><br />
				<br /> ProductType: <input type="text" name="productType"
					placeholder="ProductType" required autofocus /><br />
				<br />
				<!-- <button type="submit">UPDATE</button><br/><br/>
 -->
				<button type="submit" class="btn btn-primary">UPDATE</button>
				<a href="Adminaccess.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
	</form>
	</center>
</body>
</html>

