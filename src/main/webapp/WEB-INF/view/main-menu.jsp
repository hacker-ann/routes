<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
	<title>My Ascents</title>
	
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/main-style.css" />
	</head>

<body>
		<div id="header">
			<h1>My Ascents</h1>
	</div>
	<div>
					<input type="button" value="My Routes"
				   onclick="window.location.href='${pageContext.request.contextPath}/routes/list'; return false;"
				   class="button"
			/>

</div>
<div>
	
				<input type="button" value="My statistics"
				   onclick="window.location.href='${pageContext.request.contextPath}/routes/statistics'; return false;"
				   class="button"
			/>

	</div>
</body>
</html>