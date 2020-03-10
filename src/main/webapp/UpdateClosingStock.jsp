<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>

<body>
	<form action="UpdateClosingStock">

		<body style="background-color: LightGray">
			<br />
			<br />
			<center>
				<h3>StockDetails</h3>
				<!-- placeholder="StockId" required autofocus -->
				StockId: <input type="number" name="stockId" /><br />
				<br />
				<!-- 
<button type="submit">UPDATE</button><br/><br/>
<button><a href="Adminaccess.jsp">Back</a></button> -->



				<button type="submit" class="btn btn-primary">UPDATE</button>
				<a href="Adminaccess.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
	</form>

	</center>
</body>
</html>

