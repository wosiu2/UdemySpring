<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Confirmation</title>
</head>
<body>
	${student.firstName}
	<br>
	${student.lastName }
	<br>
	${student.country }
	<br>
	${student.favoriteLanguage }
	<br>
	<ul>
	<c:forEach var="temp" items="${student.operatingSystem }">
		<li>${temp }</li>
	</c:forEach>
	</ul>
	
</body>
</html>