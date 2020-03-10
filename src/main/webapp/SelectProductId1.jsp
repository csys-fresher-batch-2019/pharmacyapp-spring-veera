<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<form action="SelectProductId">
		<body style="background-color: LightGray">
			</br>
			</br>
			</br>
			</br>
			<center>
				Enter ProductId: <input type="text" name="productId"
					placeholder="Enter ProductId" required autofocus /><br />
				<br />
				<!-- <button type="submit">submit</button><br/>
 -->
				<button type="submit" class="btn btn-primary">SEARCH</button>
				<a href="Productdetails.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
			</center>
		</body>
	</form>
</body>
</html>
