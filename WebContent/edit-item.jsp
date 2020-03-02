<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="images/css/billyBobsCarLot.css" />
<style>
	fieldset {
		padding-bottom: 15px;
	}
	.fieldGridWrapper {
		display: grid;
		grid-template-columns: 80px auto auto auto;
		grid-gap: 10px;
	}
	.fieldGridWrapper label {
		grid-column: 1;
		width: 80px;
	}
	#makeFld {
		grid-column: span 3;
	}
	#modelFld {
		grid-column: span 3;
	}
	#yearFld {
		grid-column: span 3;
	}
	#serviceMonth, #serviceDay, #serviceYear {
		width: 50px;
	}
	#serviceMonth {
		grid-column: 2;
	}
	#serviceDay {
		grid-column: 3;
	}
	#serviceYear {
		grid-column: 4;
	}
</style>
<title>Billy Bob's Car Lot</title>
</head>
<body>
<h1>Update Details for car in Billy Bob's Car Lot</h1>
<form action="editItemServlet" method="post">
	<fieldset>
		<legend>Update Car Details</legend>
		<div class="fieldGridWrapper">
			<label for="makeFld">Car Make:</label> <input id="makeFld" type="text" name="make" value="${itemToEdit.make}" />
			<label for="modelFld">Car Model:</label> <input id="modelFld" type="text" name="model" value="${itemToEdit.model}" />
			<label for="yearFld">Car Year:</label> <input id="yearFld" type="number" name="year" min="1885" max="2021" value="${itemToEdit.year}" />
			<label for="serviceMonth">Date of Last Oil Change:</label>
			<input id="serviceMonth" type="number" name="serviceMonth" placeholder="mm" maxlength="2" value="${oilChangeDateToEdit.serviceDate.getMonthValue() }" /> 
			<input id="serviceDay" type="number" name="serviceDay" placeholder="dd"  maxlength="2" value="${oilChangeDateToEdit.serviceDate.getDayOfMonth() }" /> 
			<input id="serviceYear" type="number" name="serviceYear" placeholder="yyyy"  maxlength="4" value="${oilChangeDateToEdit.serviceDate.getYear() }" />
		</div>
	</fieldset>
	
	<input type="hidden" name="id" value="${itemToEdit.id}" />
	<input class="btn" type="submit" value="Save" />
</form>
<a class="btn" href="viewAllItemsServlet">View the complete list</a>
</body>
</html>