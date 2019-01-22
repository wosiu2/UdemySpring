<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Student form</title>
</head>
<body>
 <form:form action="processForm" modelAttribute="student">
 	First Name: <form:input path="firstName"/>
 	<br><br>
 	Last Name: <form:input path="lastName"/>
 	<form:errors path="lastName" cssClass="error"/>
 	<br><br>
 	
 	<form:select path="country">
 	
 		<form:options items="${student.countryOptions}"/>

 	</form:select>
 	<br><br>
 	Favorite Language:
 	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
 	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
 	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
 	<br><br>
 	Operating systems:
 	Linux <form:checkbox path="operatingSystem" value="Linux"/>
 	Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
 	Windows <form:checkbox path="operatingSystem" value="Windows"/>
 	<br><br>
 	<input type="submit" value="Submit"/>
 	
 </form:form>
 
</body>
</html>