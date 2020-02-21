<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="images/css/billyBobsCarLot.css" />
<title>Billy Bob's Car Lot</title>
</head>
<body>
<h1>Update Details for car in Billy Bob's Car Lot</h1>
<form action="editItemServlet" method="post">
	<fieldset>
		<legend>Add Car</legend>
		<label for="makeFld">Car Make:</label> <input id="makeFld" type="text" name="make" value="${itemToEdit.make}" />
		<label for="modelFld">Car Model:</label> <input id="modelFld" type="text" name="model" value="${itemToEdit.model}" />
		<label for="yearFld">Car Year:</label> <input id="yearFld" type="number" name="year" min="1885" max="2021" value="${itemToEdit.year}" />
	</fieldset>
	<input type="hidden" name="id" value="${itemToEdit.id}" />
	<input class="btn" type="submit" value="Save" />
</form>
<a class="btn" href="viewAllItemsServlet">View the complete list</a>
</body>
</html>