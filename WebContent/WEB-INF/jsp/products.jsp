<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>e-commerce-products</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
<script>
	
	function addToCart(id){
		console.log(id);
		let form = document.createElement('form');
		form.action = 'http://localhost:8080/cart';
		form.method = 'POST';
		form.innerHTML = '<input name="itemId" value="'+id+'" type="hidden">';
		document.body.append(form);
		form.submit();
	}
 <c:url value="imagepath" var = "name" /> 

</script>
<style>

</style>

</head>

<body >
	
	<div class="header" >
	
		<h4 style="text-align: left;color: black;padding-top:5px;padding-bottom: 5px;margin-left:1vw">Something Hub 
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="/ECommerceGroupSpring" >Home</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="products" >Products</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >About Us</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >Contact Us</a>
			<a class="flex" style="color: black;" href="admin" >Admin</a>
			<a class="flex" style="color: black;" href="" >Logout</a>
			<a class="flex-no-hover">Welcome: </a>
			
			
		</h4>
		
	</div >
	<h2 style="margin-left:3vw;margin-top:2vw;text-align: left;">All Products</h2>
	<h3 style="margin-left:3vw;text-align: left;font-size: 20px;">Checkout our products available!</h3>
	<div style="border-top:2px solid black;opacity:0.2;margin-left: 3vw;margin-right: 3vw;"></div>
	<br>
	<form style="margin-left: 3vw;" action="/products" method="POST">
		<b>Show <select name="entries" id="number">
			<option value="5">5</option>
			<option value="10">10</option>
		</select> entries</b>
	</form>
	<div class="cards">
		
	
	 <c:forEach var="product" items="${list}">
	 	<div class='card'>
	 	<img class="products" src="${pageContext.request.contextPath}/resources/assets/productpics/${product.name}.png" alt='palceholder' style="width:100%"/>
	 	<h1>${product.name}</h1>
	 	<p class='price'>$${product.price}</p>
	 	<p>${product.description}</p>
	 	<p><button onclick='addToCart("${product.id}")'>Add to Cart</button></p>
	 	</div>
	 	<br>
		 
	 </c:forEach>
	 </div>
	<br>

	
	<div class="footer">
		<div style="border-top:2px solid black;background:blue;opacity:0.2;margin-left: 3vw;margin-right: 3vw;"></div>
		<p style="margin-right: 3vw;padding-top: 10px;">Previous <button>1</button> Next</p>


	</div>
	
	
</body>

</html>