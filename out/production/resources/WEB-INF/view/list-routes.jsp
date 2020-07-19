<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
	<title>List Routes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>My Ascents</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Route -->
		
			<input type="button" value="Add Route"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
					<!--  add a search box -->
			<form:form action="search" method="GET">
				Search routes: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<table>
				<tr>
					<th>Route Name</th>
					<th>Grade</th>
					<th>Country</th>
					<th>Climbing Area</th>
					<th>Crag or Sector</th>
					<th>Style</th>
					<th>Date</th>
					<th>Comment</th>
					<th colspan="2">Action</th>
				</tr>
					<!-- loop over and print routes -->
				<c:forEach var="tempRoutes" items="${routes}">
				
								<!-- construct an "update" link withROUTE id -->
					<c:url var="updateLink" value="/routes/showFormForUpdate">
						<c:param name="routeId" value="${tempRoutes.id}" />
					</c:url>
					
					<!-- construct an "delete" link with route id -->
					<c:url var="deleteLink" value="/routes/delete">
						<c:param name="routeId" value="${tempRoutes.id}" />
					</c:url>	
							
					<tr>
						<td> ${tempRoutes.routeName} </td>
						<td> ${tempRoutes.grade} </td>
						<td> ${tempRoutes.country} </td>
						<td> ${tempRoutes.climbingArea} </td>
						<td> ${tempRoutes.cragOrSector} </td>
						<td> ${tempRoutes.style} </td>
						<td> ${tempRoutes.date} </td>
						<td> ${tempRoutes.comment} </td>
						
												<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							</td>
							<td>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this route?'))) return false">Delete</a>
													</td>
					</tr>
				
				</c:forEach>
						
			</table>
	
								<p>
			<a href="${pageContext.request.contextPath}/routes"> &#171 Back to Homepage</a>
		</p>	
	</div>
	</div>						
</body>
</html>