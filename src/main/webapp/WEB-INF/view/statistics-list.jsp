<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
	<title>My Statistics</title>
	
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/statistics-style.css">

	</head>

<body>
    <%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
     %>

	<div id="wrapper">
		<div id="header">
			<h2>My Ascents</h2>
		</div>
	</div>
	
	<div id="container">
	
	<div id="image">
	<img src="../resources/images/climbing line.jpg">
	</div>
			<form:form action="statistics" method="GET">
			
<p> <b>Total number of routes:</b> 
				<input type="text" value="${numberOfRoutes}" /> </p>
 <p> <b> Number of routes in the last 7 days: </b>
 <input type="text" value="${last7Days}" /> </p>
<p> <b>The first route on: </b>
				 <input type="text" value="${startDate}"/></p>
<p> <b>The last route on: </b>
				<input type="text" value="${endDate}" /></p>
<p> <b>Top 5 of crag/sector: </b> </p>
<ol>
<c:forEach items="${popularCrag}" var="top5">
      
       <li><c:out value = "${top5}"/></li>
      </c:forEach>
</ol>
			</form:form>
				</div>
				
				<div id="footer">
						
			<a href="${pageContext.request.contextPath}/routes"> &#171 Back to Homepage</a>
	
</div>		

</body>
</html>
