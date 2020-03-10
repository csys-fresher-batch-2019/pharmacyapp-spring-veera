<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<form action="CompanyDetails">

		<body style="background-color: LightGray">
			<br />
			<br />
			<br />
			<center>
				<h3>CompanyDetails</h3>
				CompanyId: <input type="number" name="companyId"
					placeholder="CompanyId" required autofocus /><br />
				<br /> CompanyName: <input type="text" name="companyName"
					placeholder="CompanyName" required autofocus /><br />
				<br /> CompanyType: <input type="text" name="companyType"
					placeholder="CompanyType" required autofocus /><br />
				<br /> CompanyAddress: <input type="text" name="companyAddress"
					placeholder="CompanyAddress" required autofocus /><br />
				<br />
				<!-- <button type="submit">ADD</button><br/><br/>
<button><a href="Adminaccess.jsp">Back</a></button> -->
				<!-- <button type="submit" class="btn btn-primary">ADD</button>
<a href="Adminaccess.jsp"><button type="submit"
class="btn btn-primary">Back</button></a></br> </br> -->
				<button type="submit" class="btn btn-primary">ADD</button>
				<a href="Adminaccess.jsp"><button type="submit"
						class="btn btn-primary">Back</button></a></br> </br>
	</form>

	</center>
</body>
</html>

