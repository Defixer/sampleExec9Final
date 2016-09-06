<%@ page import="com.jpcm.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!--contactEditor.jsp-->
<html>
	<body>
		<c:set var="person" value='${requestScope["person"]}' />
		<c:set var="personId" value='${person.getId()}' />
		<c:set var="contacts" value='${person.getContactDTOs()}' />
		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:if test="${resultMessage == null}">
		<c:set var="resultMessage" value="" />
		</c:if>

		<center>
			<br/><br/><h1><spring:message code='label.EditTitle'/></h1>
			<p style="color:red;"><c:out value="${resultMessage}"/></p>
			<form action="person.htm" method="POST" >
				<table align="center" >
					<input type="hidden" name="personId" value="<c:out value='${personId}'/>" />
					<c:forEach var="contact" items="${contacts}" >
						<c:set var="contactId" value='${contact.getContactId()}' />
						<c:set var="mobileNumber" value='${contact.getMobileNumber()}' />
						<c:set var="landLineNumber" value='${contact.getLandLineNumber()}' />
						<c:set var="emailAddress" value='${contact.getEmailAddress()}' />
						<tr>
							<td align="right">
								<b><spring:message code='label.EditExist'/>&nbsp;&nbsp;&nbsp;<b/>
							</td>
							<td>
								<input type="text" name="mobileNumber" value="<c:out value='${mobileNumber}'/>" size=10/>
							</td>
							<td>
								<input type="text" name="landLineNumber" value="<c:out value='${landLineNumber}'/>" />
							</td>
							<td>
								<input type="text" name="emailAddress" value="<c:out value='${emailAddress}'/>" />
							</td>
							<td>
								<a href="person.htm?action=deleteContact&personId=<c:out value='${personId}'/>&contactId=<c:out value='${contactId}'/>" onclick = "return confirm('WARNING!!! : Do you really want to delete contact information?')">Delete</a>
							</td>
						</tr>						
					</c:forEach>
					<tr>
						<td></td>
						<td><spring:message code='label.EditMobile'/></td>
						<td><spring:message code='label.EditLandline'/></td>
						<td><spring:message code='label.EditEmail'/></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td align="right"><b><spring:message code='label.EditAddNEw'/>&nbsp;&nbsp;&nbsp;</b></td>
						<td><input type="text" name="newMobileNumber" value="" size=10/></td>
						<td><input type="text" name="newLandLineNumber" value="" /></td>
						<td><input type="text" name="newEmailAddress" value="" /></td>
						</tr><tr>
						<td></td>
						<td><spring:message code='label.EditMobile'/></td>
						<td><spring:message code='label.EditLandline'/></td>
						<td><spring:message code='label.EditEmail'/></td>
					</tr>
				</table><br/><br/>
				<input type="hidden" name="personId" size=10 value="<c:out value='${personId}'/>" />
				<button type= "submit" name="action" value="saveContacts"><spring:message code='label.EditSave'/></button>
				<button type= "submit" name="action" value="cancel"><spring:message code='label.EditCancel'/></button>
			</form>
		</center>
		<style>
			a{
				text-decoration: none;
			}
		</style>
	</body>
</html>
