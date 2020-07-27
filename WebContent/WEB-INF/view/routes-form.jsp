<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Save Route</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-route-style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>My Ascents</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save the Route</h3>

     
		<form:form action="saveRoutes" modelAttribute="routes" method="POST">
		
			<!-- need to associate this data with route id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Route name:</label></td>
						<td><form:input path="routeName" /></td>
					</tr>
				
					<tr>
						<td><label>Grade:</label></td>
						<td><form:input path="grade" /></td>
					</tr>

					<tr>
						<td><label>Country:</label></td>
						<td><form:input path="country" /></td>
					</tr>

					<tr>
						<td><label>Climbing Area:</label></td>
						<td><form:input path="climbingArea" /></td>
					</tr>
					
										<tr>
						<td><label>Crag or Sector:</label></td>
						<td><form:input path="cragOrSector" /></td>
					</tr>
					
										<tr>
						<td><label>Style:</label></td>
						<td>
  <form:radiobutton id="rariobutton" path="style" value="OS" />OS
  <form:radiobutton id="rariobutton" path="style" value="Flash" />Flash
  <form:radiobutton id="rariobutton" path="style" value="RP" />RP
						</td>
					</tr>
					
										<tr>
						<td><label>Date:</label></td>
						<td><form:input path="date" placeholder="yyyy-MM-dd" /></td>
						<td><form:errors id="error" path="date"/></td>
					</tr>
										
												<tr>
						<td><label>Comment:</label></td>
						<td><form:textarea id="textarea" path="comment" /></td>
						
					</tr>
					
							
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
				<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/routes/list"> &#171 Back to List</a>
		</p>
	
	</div>

</body>
</html>