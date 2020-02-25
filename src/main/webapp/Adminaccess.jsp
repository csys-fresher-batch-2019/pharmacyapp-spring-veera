<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
<%  
HttpSession sese = request.getSession();

  String name=(String)sese.getAttribute("uname");
%> 
    <div class="navbar-header">
      <a class="navbar-brand" href="welcome.jsp">PharmacyApp</a>
    </div>
<!--     <ul class="nav navbar-nav">
 -->         <ul class="nav navbar-nav navbar-right">
    
      <li class="nav-item">
                    <a class="navbar-brand"  href="#" data-target="#myModal">welcome <%=name %></a>                  
                </li>
                </ul> 
                
                
       <!--  <ul class="dropdown-menu">
          <li><a href="#"></a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul> -->
      </li>
    </ul>
  </div>
</nav>
	</form>
	

</head>	
</body>


<body style="background-color: white">

	
	<center>

	</br>	<h2>PharmacyAPP</h2></br></br>

		<a href="CompanyDetails.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Company Details</button></a></br> </br>
				<a href="PurchaseMenu.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Purchase Details</button></a></br> </br> 
	    <a href="ProductDetails.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Product Details</button></a></br> </br> 
		
		<a href="SalesDetails.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Sales Details</button></a></br> </br>
		 <a href="StockMenu.jsp"><button type="submit"
				class="btn btn-primary btn-lg btn-block">Stock Details</button></a></br> </br>
				 <a href="welcome.jsp"><button type="submit"
				class="btn btn-primary">LogOut</button></a></br> </br>



	</center>
</body>
</html>