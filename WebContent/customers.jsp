<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h2>Coffee Advisor Output</h2>

	<form method="POST" action="controller">
		Imie: <input type="text" name="name" size="20"><br/>
		Nazwisko: <input type="text" name="surname" size="20"><br/>
		Adres: <input type="text" name="address" size="20"><br/>
		Telefon: <input type="text" name="phone" size="20"><br/>
		<input type="Submit" name="Zapisz" />
	</form>
	<br />
	<c:forEach var="type" items="${customers}">
		<c:out value="${type.name}" /> <c:out value="${type.surname}" /> <c:out value="${type.address}" /> <c:out value="${type.phone}" /> 
		<a href="controller?id=${type.id}" >usun</a>
		<br />
	</c:forEach>
</body>
</html>