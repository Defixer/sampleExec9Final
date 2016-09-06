<%@ page import="com.jpcm.dto.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!--viewRole.jsp-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of Roles</title>
	</head>
	<body>
		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:set var="ok" value='${param.OK}' />
		<c:if test="${ok == '01'}">
			<c:set var="resultMessage" value="Role successfully deleted!" />
		</c:if>
		<c:if test="${ok == '02'}">
			<c:set var="resultMessage" value="Cannot delete Role. Currently assigned to Person/s." />
		</c:if>
		<c:if test="${ok == '03'}">
			<c:set var="resultMessage" value="New Role successfully added." />
		</c:if>
		<c:if test="${ok == '04'}">
			<c:set var="resultMessage" value="Role already exists." />
		</c:if>
		<center>
			<br/><br/><h1><u><spring:message code = "label.RoleViewById"/></u></h1>
			<c:set var="roleName" value='${requestScope["roleDTO"]}' />
			<c:set var="tempRoleName" value='${roleName.getRoleName()}' />
			<c:set var="roleId" value='${roleName.getRoleId()}' />
			<c:set var="employees" value='${roleName.getPersonDTOs()}' />
			<p><b>ID:</b>
			<c:out value='${roleId}'/>&nbsp;&nbsp;&nbsp;
			<b>NAME: </b>
			<c:out value='${tempRoleName}'/><p/><br/>			
			
			<table >
				<h3><u>Employee List by Role</u></h3>
				<th>ID</th>
				<th>Employee Name</th>
				
				<c:forEach var = "employee" items = "${employees}">
					<c:set var = "empId" value = "${employee.getId()}"/>
					<c:set var = "shortName" value = "${employee.getFirstName()} ${employee.getMiddleName()} ${employee.getLastName()}"/>				
				</c:forEach>				
				<tr>	
					<td><c:out value = "${empId}"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value = "${shortName}"/></td>					
				</tr>				
			</table><br/>
			<button type="button" name="back" onclick="history.back()">Back</button>
		</center>
		<style>
			table{
				border:1px solid black;
			}
		</style>
	</body>
</html>
