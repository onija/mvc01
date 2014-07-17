<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h2>Coffee Advisor Output</h2>

	<form method="POST" action="CustomerController.do">
		<input type="text" name="name" size="20">
		<input type="text" name="surname" size="20">
		<input type="text" name="address" size="20">
		<input type="text" name="phone" size="20">
		<input type="Submit" name="Zapisz" />
	</form>
	<br />
	<c:forEach var="type" items="${types}">
		<c:out value="${type}" />
		<br />
	</c:forEach>
</body>
</html>