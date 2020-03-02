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
	table {
		margin-bottom: 15px;
	}
	table td {
		padding-right: 15px;
	}
	input {
		margin-bottom: 0;
	}
</style>
<title>Billy Bob's Car Lot</title>
</head>
<body>
<h1>Billy Bob's Car Lot</h1>
<form method="post" action="navigationServlet">
<fieldset>
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}" /></td>
<td>${currentitem.make}</td>
<td>${currentitem.model}</td>
<td>${currentitem.year}</td>
</tr>
	<c:set var = "carID" value = "${currentitem.id}" />
	<c:forEach items="${requestScope.allOilChanges}" var="currentdate">
		<c:set var = "dateID" value = "${currentdate.id}" />
		<c:if test = "${carID == dateID}">
		<tr>
			<td>&nbsp;</td>
			<td colspan="3">
				Last Oil Change Date:	
				${currentdate.serviceDate.getMonthValue()}/${currentdate.serviceDate.getDayOfMonth()}/${currentdate.serviceDate.getYear()}
			</td>
		</tr>
		</c:if>
	</c:forEach>
</c:forEach>

</table>
</fieldset>
<input class="btn" type="submit" value="edit" name="doThisToItem" />
<input class="btn" type="submit" value="delete" name="doThisToItem" />
<input class="btn" type="submit" value ="add" name="doThisToItem" />
</form>
</body>
</html>