<%@ page import="com.jpcm.model.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!--persons.jsp-->
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> <spring:message code="label.viewTitle"/> </title>
	</head>

	<body>
		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:set var="ok" value='${param.OK}' />
		<c:if test="${ok == '01'}">
			<c:set var="resultMessage" value="Person updated successfully"/>
		</c:if>
		<c:if test="${ok == '02'}">
			<c:set var="resultMessage" value="Person deleted successfully"/>
		</c:if>
		<c:if test="${ok == '03'}">
			<c:set var="resultMessage" value="Contact Information updated successfully"/>
		</c:if>
		<c:if test="${ok == '04'}">
			<c:set var="resultMessage" value="Contact Information deleted succesfully"/>
		</c:if>
		<c:if test="${ok == '05'}">
			<c:set var="resultMessage" value="Role added succesfully"/>
		</c:if>
		<c:if test="${ok == '06'}">
			<c:set var="resultMessage" value="Role deleted succesfully"/>
		</c:if>
		<c:if test="${ok == '07'}">
			<c:set var="resultMessage" value="Contact Information deleted succesfully"/>
		</c:if>


		<h1><u> <spring:message code="label.viewTitle"/></u></h1>
		<h3><p style="color:red;"><c:out value="${resultMessage}"/></p></h3>
		<form action="person.htm" method="post">
			<button type= "submit" name="action" value="home"><spring:message code='label.viewHome'/></button><br/>
			<button type= "submit" name="action" value="addNewPerson"><spring:message code='label.viewAddNew'/></button>
		</form>
		<form action="roles.htm" method="get">
			<button type= "submit" name="action" value="viewRoles"><spring:message code='label.viewRoles'/></button>
		</form><br/><br/>
				
		<form action="person.htm" method="get">
			<spring:message code="label.viewSearchBy"/><br/>
			<select name="search" value="Lastname">
				<option value="Lastname"> <spring:message code="label.viewLastname"/></option>
				<option value="DateHired"> <spring:message code="label.viewDateHired"/></option>
				<option value="Grade"><spring:message code="label.viewGrade"/></option>
			</select>&nbsp;
			<input type = "text" name="searchValue"/>
			<button type= "submit" name="action" value="search"><spring:message code='label.viewSearch'/></button>
		</form>
		<form action="person.htm" method="get">
			<spring:message code="label.viewSortBy"/><br/>
			<select name="sort" value="Lastname">
				<option value="Lastname"> <spring:message code="label.viewLastname"/> </option>
				<option value="Date Hired"> <spring:message code="label.viewDateHired"/> </option>
				<option value="Grade"> <spring:message code="label.viewGrade"/> </option>
			</select>&nbsp;
			<button type= "submit" name="action" value="sort"><spring:message code='label.viewSort'/></button>
		</form>
		
		<center>
			<br/><p>&nbsp;</p>
			<table border="solid" align = "center">
				<thead>
					<tr>
						<th><spring:message code="label.viewId"/></th>
						<th><spring:message code="label.viewName"/></th>
						<th><spring:message code="label.viewAddress"/></th>
						<th><spring:message code="label.viewMobile"/></th>
						<th><spring:message code="label.viewLandline"/></th>
						<th><spring:message code="label.viewEmail"/></th>
						<th><spring:message code="label.viewBirthday"/></th>
						<th><spring:message code="label.viewGrade"/></th>
						<th><spring:message code="label.viewDatehired"/></th>
						<th><spring:message code="label.viewEmployed"/></th>
						<th><spring:message code="label.Roles"/></th>
						<th><spring:message code="label.viewAction"/></th>
					</tr>
				</thead>
				<tbody>
					<c:set var="persons" value='${requestScope["persons"]}' />
					<c:forEach var="person" items="${persons}" >
						<c:set var="personId" value='${person.getId()}' />
						<c:set var="name" value='${person.getTitleName()} ${person.getFirstName()} ${person.getMiddleName()} ${person.getLastName()} ${person.getSuffixName()} ' />
						<c:set var="getAdd" value='${person.getAddressDTO()}' />
						<c:set var="address" value='${getAdd.getAddStreet()} ${getAdd.getAddBarangay()} 
						${getAdd.getAddCityMunicipality()} ${getAdd.getAddZipCode()}' />
						<c:set var="contacts" value='${person.getContactDTOs()}' />
						<c:set var="birthday" value='${person.getBirthday()}' />

						<c:set var="grade" value='${person.getGrade()}' />
						<c:set var="dateHired" value='${person.getDateHired()}' />
						<c:set var="currentlyEmployed" value='${person.getCurrentlyEmployed()}' />
						<c:choose>
							<c:when test="${currentlyEmployed == true}">
								<c:set var="currentlyEmployed" value="Yes" />
							</c:when>
							<c:otherwise>
								<c:set var="currentlyEmployed" value="No" />
							</c:otherwise>
						</c:choose>
						<c:set var="roleNames" value='${person.getRoleDTOs()}' />

						<tr>
							<td><center><c:out value="${personId}"/></center></td>
							<td><center><c:out value="${name}"/></center></td>
							<td><center><c:out value="${address}"/></center></td>
							<td>
								<c:forEach var="contact" items="${contacts}">
									<c:set var="mobileNumber" value='${contact.getMobileNumber()}' />
									<c:if test = "${mobileNumber > 0}">
										<center><c:out value="0${mobileNumber}"/></center>
									</c:if>
								</c:forEach>
							</td>
							<td>
								<c:forEach var="contact" items="${contacts}" >
									<c:set var="landLineNumber" value='${contact.getLandLineNumber()}' />
									<center><c:out value="${landLineNumber}"/></center>
								</c:forEach>
							</td>
							<td>
								<c:forEach var="contact" items="${contacts}" >
									<c:set var="email" value='${contact.getEmailAddress()}' />
									<center><c:out value="${email}"/></center>
								</c:forEach>
							</td>
							<td><center><fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/></center></td>
							<td><center><c:out value="${grade}"/></center></td>
							<td><center><fmt:formatDate value="${dateHired}" pattern="yyyy-MM-dd"/></center></td>
							<td><center><c:out value="${currentlyEmployed}"/></center></td>
							<td>
								<c:forEach var="role" items="${roleNames}" >
									<c:set var="roleName" value='${role.getRoleName()}' />
									<center><c:out value="${roleName}"/></center><br/><br/>
								</c:forEach>
							</td>
							<td>
								<center><br/>
									<c:set var = "shortName" value = "${person.getFirstName()} ${person.getMiddleName()} ${person.getLastName()}"/>
									<a href="person.htm?action=editPerson&personId=<c:out value='${personId}'/>"><input type = "button" value = "Edit Record"></a><br/>
									<a href="person.htm?action=deletePerson&personId=<c:out value='${personId}'/>">
									<input type = "submit" onclick = "return confirm('WARNING!!! : Do you really want to delete record of &quot;${shortName}&quot; ?')" value = "Delete Record"/></a><br/>
									<a href="person.htm?action=editContact&personId=<c:out value='${personId}'/>">
									<input type = "button" value = "Edit Contacts"></a><br/>
									<!--<a href="person.htm?action=addPersonRole&personId=<c:out value='${personId}'/>">
									<input type = "button" value = "Add Role"></a><br/>
									<a href="person.htm?action=deletePersonRole&personId=<c:out value='${personId}'/>">
									<input type = "submit" value = "Delete Role"></a><br/>-->
								</center><br/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br/>			
		</center>
		<c:out value='${requestScope["getServerName"]}'/>
		<style>
			a{
				text-decoration: none;
			}
		</style>
	</body>
	<footer>
		<center>
			<br/><br/><br/>
			<label><font size = "1">&copy September 2016</label><br/>
			<label>Mamen &#8482</font></label>
		</center>
	</footer>
</html>
