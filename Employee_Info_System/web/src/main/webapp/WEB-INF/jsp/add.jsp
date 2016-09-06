<%@ page import="com.jpcm.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!--add.jsp-->
<html>
	<body>
		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:if test="${resultMessage == null}">
				<c:set var="resultMessage" value="" />
		</c:if>
		<c:set var="titleName" value="${param.titleName}" />
		<c:set var="firstName" value="${param.firstName}" />
		<c:set var="middleName" value="${param.middleName}" />
		<c:set var="lastName" value="${param.lastName}" />
		<c:set var="suffixName" value="${param.suffixName}" />
		<c:set var="addStreet" value="${param.addStreet}" />
		<c:set var="addBarangay" value="${param.addBarangay}" />
		<c:set var="addCityMunicipality" value="${param.addCityMunicipality}" />
		<c:set var="addProvince" value="${param.addProvince}" />
		<c:set var="addZipCode" value="${param.addZipCode}" />
		<c:set var="mobileNumber" value="${param.mobileNumber}" />
		<c:set var="landLineNumber" value="${param.landLineNumber}" />
		<c:set var="emailAddress" value="${param.emailAddress}" />
		<c:set var="gender" value="${param.gender}" />
		<c:set var="age" value="${param.age}" />
		<c:set var="birthday" value="${param.birthday}" />
		<c:set var="grade" value="${param.grade}" />
		<c:set var="dateHired" value="${param.dateHired}" />
		<c:set var="currentlyEmployed" value="${param.currentlyEmployed}" />

		<h1><u><spring:message code='label.addPTitle'/></u></h1>
		<center>			
			<p style="color:red;"><c:out value="${resultMessage}"/></p>
			<p><font color = "red"> <spring:message code='label.addPRequired'/> </font></p>
			<form action="person.htm" method="POST" >
			<table align="center" >
				<tr>
					<td><b> <spring:message code='label.addPName'/> <b/></td>
					<td><input type="text" name="titleName" size=10 value="<c:out value='${titleName}'/>" /></td>
					<td><input type="text" name="firstName"  value="<c:out value='${firstName}'/>" /></td>
					<td><input type="text" name="middleName" value="<c:out value='${middleName}'/>" /></td>
					<td><input type="text" name="lastName" value="<c:out value='${lastName}'/>" /></td>
					<td><input type="text" name="suffixName" size=10 value="<c:out value='${suffixName}'/>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><spring:message code='label.addPTName'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPFName'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPMName'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPLName'/></td>
					<td><spring:message code='label.addPSName'/></td>
				</tr>
				<tr><td>&nbsp;</td></tr>

				<tr>
					<td><b><spring:message code='label.addPAddress'/><b/></td>
					<td><input type="text" name="addStreet" size=10 value="<c:out value='${addStreet}'/>" /></td>
					<td><input type="text" name="addBarangay" value="<c:out value='${addBarangay}'/>" /></td>
					<td><input type="text" name="addCityMunicipality" value="<c:out value='${addCityMunicipality}'/>" /></td>
					<td><input type="text" name="addZipCode" value="<c:out value='${addZipCode}'/>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><font color = "red">*</font><spring:message code='label.addPStreet'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPBarangay'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPCityMunicipality'/></td>
					<td><font color = "red">*</font><spring:message code='label.addPZipCode'/></td>
				</tr>
				<tr><td>&nbsp;</td></tr>

				<tr>
					<td><b><spring:message code='label.addPContacts'/><b/></td>
					<td><input type="text" name="mobileNumber" size=10 value="<c:out value='${mobileNumber}'/>" /></td>
					<td><input type="text" name="landLineNumber" value="<c:out value='${landLineNumber}'/>" /></td>
					<td><input type="text" name="emailAddress" value="<c:out value='${emailAddress}'/>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><spring:message code='label.addPMobile'/></td>
					<td><spring:message code='label.addPLandline'/></td>
					<td><spring:message code='label.addPEmail'/></td>
				</tr>
				<tr><td>&nbsp;</td></tr>

				<tr>
					<td><b><spring:message code='label.addPBirthday'/><b/></td>
					<td>
						<font color = "red">*</font><input type="text" name="birthday" size=9 value="<c:out value='${birthday}'/>" placeholder = "YYYY-MM-DD" />
					</td>
				</tr>

				<tr>
					<td><b><spring:message code='label.addPGrade'/><b/></td>
					<td>
						<font color = "red">*</font><select name="grade" value="<c:out value='${grade}'/>" >
							<option value="1.00">1.00</option>
							<option value="1.25">1.25</option>
							<option value="1.50">1.50</option>
							<option value="1.75">1.75</option>
							<option value="2.00">2.00</option>
							<option value="2.25">2.25</option>
							<option value="2.50">2.50</option>
							<option value="2.75">2.75</option>
							<option value="3.00">3.00</option>
							<option value="5.00">5.00</option>
						</select>
					</td>
				</tr>

				<tr>
					<td><b><spring:message code='label.addPDateHired'/><b/></td>
					<td>
						<font color = "red">*</font><input type="text" name="dateHired" size=9 value="<c:out value='${dateHired}'/>" placeholder = "YYYY-MM-DD"/>
					</td>
				</tr>

				<tr>
					<td><b><spring:message code='label.addPEmployed'/><b/></td>
					<td>
						<font color = "red">*</font><select name="currentlyEmployed" value="<c:out value='${currentlyEmployed}'/>" >
							<option value="Yes"><spring:message code='label.addPYes'/></option>
							<option value="No"><spring:message code='label.addPNo'/></option>
						</select>
					</td>
				</tr>
				
				<table>
				<c:set var="roleNames" value='${requestScope["roleNames"]}' />
				<tr>
					<td>
						<b><spring:message code='label.addPRoles'/></b><br/>
						<c:forEach var="rolename" items="${roleNames}" >
							<c:set var="tempRoleName" value='${rolename.getRoleName()}' />
							<input type="checkbox" name="role" value="<c:out value='${tempRoleName}'/>" > <c:out value='${tempRoleName}'/> <br>
						</c:forEach>
					</td>
				</tr>
				</table>
			</table><br/><br/>
			<button type= "submit" name="action" value="saveNewPerson"><spring:message code='label.addPSave'/></button>
			<button type= "submit" name="action" value="cancel"><spring:message code='label.addPCancel'/></button>
			</form>
		</center>
	</body>
	<footer>
		<center>
			<br/><br/><br/>
			<label><font size = "1">&copy September 2016</label><br/>
			<label>Mamen &#8482</font></label>
		</center>
	</footer>	
</html>
