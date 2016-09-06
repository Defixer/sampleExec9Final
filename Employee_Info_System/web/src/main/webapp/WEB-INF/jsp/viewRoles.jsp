<%@ page import="com.jpcm.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!--viewRoles.jsp-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Role Information</title>
	</head>
	<body>
		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:set var="ok" value='${param.OK}' />
		<c:if test="${ok == '01'}">
			<c:set var="resultMessage" value="Role Successfully Deleted!" />
		</c:if>
		<c:if test="${ok == '02'}">
			<c:set var="resultMessage" value="Cannot Delete Role. Currently Assigned To Person/s." />
		</c:if>
		<c:if test="${ok == '03'}">
			<c:set var="resultMessage" value="New Role Successfully Added" />
		</c:if>
		<c:if test="${ok == '04'}">
			<c:set var="resultMessage" value="Role Already Exists" />
		</c:if>
				
		<center>
			<br/><br/><h1><u><spring:message code='label.RoleTitle'/></u></h1>
			<p style="color:red;"><c:out value="${resultMessage}"/></p>
			<table border="solid">
				<thead>
					<tr>
						<th><spring:message code='label.RoleName'/> </th>
						<th><spring:message code='label.RoleViewById'/> </th>
						<th><spring:message code='label.RoleAction'/> </th>
					</tr>
				</thead>
				<tbody>
					<c:set var="roleNames" value='${requestScope["roleNames"]}' />
					<c:forEach var="rolename" items="${roleNames}" >
						<c:set var="tempRoleName" value='${rolename.getRoleName()}' />
						<c:set var="roleId" value='${rolename.getRoleId()}' />
						<tr>
							<td><center><c:out value='${tempRoleName}'/></center></td>
							<td><center><a href="roles/role/<c:out value='${roleId}'/>">
							<c:out value='${roleId}'/></a><center></td>
							<td><center><a "submit" href="roles.htm?action=deleteRole&roleId=<c:out value='${roleId}'/>"><input type = "submit" onclick = "return confirm('WARNING!!! : Do you really want to delete &quot;${tempRoleName}&quot; role?')" value = "Delete"></a></center></td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br/><br/>
			
			<form action="roles.htm" method="post">
				<b><spring:message code='label.RoleAddNew'/></b><br/>
				<input type="text" name="newRole" value="" placeholder = "Enter New Role Name" />
				<button type= "submit" name="action" value="addRole"><spring:message code='label.RoleAdd'/></button>
			</form><br/><br/>
			<form action = "person.htm">
				<input type = "submit" value = "Home"/>
			</form>
		</center>
		<style>
			a{
				text-decoration: none;
			}
		</style>
	</body>
</html>
