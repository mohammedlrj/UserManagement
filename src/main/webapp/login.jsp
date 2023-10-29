<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</p>
	<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<form action="login" method="post" style="width: 50%; margin-left: 25%;">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email</label>
	    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
	    <input type="password" name="mdp" class="form-control" id="exampleInputPassword1">
	  </div>
	  <button type="submit" class="btn btn-primary mt-3">Submit</button>
	  <a href="inscription.jsp" style="margin-left: 10%;">Don't have an account ? Register</a>
	</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>