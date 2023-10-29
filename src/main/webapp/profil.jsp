<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Profil</title>
</head>
<body>
	<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Profil</p>
	<form action="update" method="post" style="width: 50%; margin-left: 25%;">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">ID</label>
	    <input readonly type="text" name="id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= session.getAttribute("id") %>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Nom</label>
	    <input type="text" name="nom" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= session.getAttribute("nom") %>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Prénom</label>
	    <input type="text" name="prenom" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= session.getAttribute("prenom") %>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email</label>
	    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<%= session.getAttribute("email") %>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
	    <input type="text" name="mdp" class="form-control" id="exampleInputPassword1" value="<%= session.getAttribute("mdp") %>">
	  </div>
	  <button type="submit" class="btn btn-primary mt-3">Enregistrer les modifications</button>
	</form>
	<form action="logout" method="post">
	  <button type="submit" class="btn btn-primary mt-3" style="position: absolute; top: 6rem; right: 5rem;">Logout</button>
	</form>
	<form action="delete" method="post">
	  <input type="hidden" name="id" value="<%= session.getAttribute("id") %>"">
	  <button type="submit" class="btn btn-primary mt-3" style="position: absolute; top: 3rem; right: 5rem;">Delete my account</button>
	</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>