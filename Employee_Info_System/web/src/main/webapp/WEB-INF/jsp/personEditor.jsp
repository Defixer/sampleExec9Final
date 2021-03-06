<%@ page import="com.jpcm.model.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!--personEditor.jsp-->
<html>
	<body>
		<c:set var="person" value='${requestScope["person"]}' />
		<c:set var="personId" value='${person.getId()}' />
		<c:set var="firstName" value='${person.getFirstName()}' />
		<c:set var="middleName" value='${person.getMiddleName()}' />
		<c:set var="lastName" value='${person.getLastName()}' />
		<c:set var="suffixName" value='${person.getSuffixName()}' />
		<c:set var="titleName" value='${person.getTitleName()}' />
		<c:set var="address" value='${person.getAddressDTO()}' />
		<c:set var="addStreet" value='${address.getAddStreet()}' />
		<c:set var="addBarangay" value='${address.getAddBarangay()}' />
		<c:set var="addCityMunicipality" value='${address.getAddCityMunicipality()}' />
		<c:set var="addZipCode" value='${address.getAddZipCode()}' />
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

		<c:set var="resultMessage" value='${requestScope["resultMessage"]}' />
		<c:if test="${resultMessage == null}">
		<c:set var="resultMessage" value="" />
		</c:if>

		<center>
			<br/><br/><h1> <spring:message code='label.addETitle'/> </h1>
			<p style="color:red;"><c:out value="${resultMessage}"/></p>
			<p><font color = "red"><spring:message code='label.addPRequired'/></font></p>
			<form action="person.htm" method="POST" >
				<table align="center" >
					<tr>
						<td align="right"><b><spring:message code='label.addPName'/>&nbsp;&nbsp;&nbsp;</b></td>
						<input style="display:none" type="text" name="personId" size=10 value="<c:out value='${personId}'/>" />
						<td><input type="text" name="titleName" size=10 value="<c:out value='${titleName}'/>" /></td>
						<td><input type="text" name="firstName" value="<c:out value='${firstName}'/>" /></td>
						<td><input type="text" name="middleName" value="<c:out value='${middleName}'/>" /></td>
						<td><input type="text" name="lastName" value="<c:out value='${lastName}'/>" /></td>
						<td><input type="text" name="suffixName" size=10 value="<c:out value='${suffixName}'/>" /></td>
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
						<td align="right"><b><spring:message code='label.addPAddress'/>&nbsp;&nbsp;&nbsp;</b></td>
						
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
						<c:forEach var="contact" items="${contacts}" >
						<c:set var="mobileNumber" value='${contact.getMobileNumber()}' />
						<c:set var="landLineNumber" value='${contact.getLandLineNumber()}' />
						<c:set var="emailAddress" value='${contact.getEmailAddress()}' />
						<tr>
							<td align="right"><b><spring:message code='label.addPContacts'/>&nbsp;&nbsp;&nbsp;</b></td>
							<td><input type="text" name="mobileNumber" value="<c:out value='${mobileNumber}'/>" size=10 /></td>
							<td><input type="text" name="landLineNumber" value="<c:out value='${landLineNumber}'/>" /></td>
							<td><input type="text" name="emailAddress" value="<c:out value='${emailAddress}'/>" /></td>
						</tr>					
					</c:forEach>
					<tr>
						<td></td>
						<td><spring:message code='label.addPMobile'/></td>
						<td><spring:message code='label.addPLandline'/></td>
						<td><spring:message code='label.addPEmail'/></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					
					<tr>
						<td align="right"><b><spring:message code='label.addPBirthday'/>&nbsp;&nbsp;&nbsp;</b></td>
						<td>
						<font color = "red">*</font><input type="text" name="birthday" value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>" size=9/>
						</td>
					</tr>

					<tr>
						<td align="right"><b><spring:message code='label.addPGrade'/>&nbsp;&nbsp;&nbsp;</b></td>
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
						<td align="right"><b><spring:message code='label.addPDateHired'/>&nbsp;&nbsp;&nbsp;</b></td>
						<td>
						<font color = "red">*</font><input type="text" name="dateHired" value="<fmt:formatDate value="${dateHired}" pattern="yyyy-MM-dd"/>" size=9>
						</td>
					</tr>

					<tr>
						<td>
							<b><spring:message code='label.addPEmployed'/></b></td>
						<td>
						<font color = "red">*</font><select name="currentlyEmployed" value="<c:out value='${currentlyEmployed}'/>" >
						<option value="Yes"><spring:message code='label.addPYes'/></option>
						<option value="No"><spring:message code='label.addPNo'/></option>
						</select>
						</td>
					</tr>

					<table>
						<c:set var="roleNames" value='${requestScope["roleNames"]}' />
						<c:set var="roles" value='${person.roleDTOs}' />
						<tr>
							<td>
								<b><spring:message code='label.addPRoles'/></b><br/>
								<c:forEach var="rolename" items="${roleNames}" >
									<c:set var="tempRoleName" value="${rolename.roleName}" />
									<c:set var="counter" value="1" />
									<c:forEach var="role" items="${roles}" >
										<c:set var="tempRole" value="${role.roleName}" />
										<c:if test="${tempRoleName eq tempRole}">
											<c:set var="counter" value="2" />
										</c:if>
									</c:forEach>
									<c:if test="${counter == '2'}">
										<input type="checkbox" name="role" value="<c:out value='${tempRoleName}'/>" checked/> <c:out value='${tempRoleName}'/> <br>
									</c:if>
									<c:if test="${counter == '1'}">
										<input type="checkbox" name="role" value="<c:out value='${tempRoleName}'/>" /> <c:out value='${tempRoleName}'/> <br>
									</c:if>
								</c:forEach>
							</td>
						</tr>
					</table>
				</table><br/><br/>
				<button type= "submit" name="action" value="savePerson"><spring:message code='label.addESave'/></button>
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
