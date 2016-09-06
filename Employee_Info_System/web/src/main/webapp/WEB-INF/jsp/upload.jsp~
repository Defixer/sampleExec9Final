<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!--upload.jsp-->
<html>
	<head>
		<title>Upload File Request Page</title>
	</head>

	<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
	<c:if test="${resultMessage == null}">
		<c:set var="resultMessage" value="" />
	</c:if>
	<body>
		<center>
			<h1><u><spring:message code='label.UploadTitle'/></u></h1><br/>
			<p style="color:red;"><c:out value="${resultMessage}"/></p>
			<form method="POST" commandName="fileUploadForm" action="person.htm" enctype="multipart/form-data">
				<spring:message code='label.UploadFile'/><br/>
				<input type="file" name="file"><br/><br/>
				<button type= "submit" name="action" value="upload"><spring:message code='label.UploadButton'/></button>
			</form>	
			<form action = "person.htm">
				<input type = "submit" value = "Home"/>
			</form>
		</center>
	</body>
</html>
