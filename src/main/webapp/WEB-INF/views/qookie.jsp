<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.js"></script>
<title>Qookie</title>
</head>
<body>
	<div class="container">
		<h1>Qookie!</h1>

		<p>Fortune Cookie for Quotes!</p>

		<form class="form" action='${pageContext.request.contextPath}/qookie/create' method = 'POST'>
			<div class="form-group">
				<input name="name" type="text" class="form-control" placeholder="Name">
				<br/>
				<textarea name="quotes" class="form-control" rows="20" 
				placeholder="Twenty Quotes, one per line!"></textarea>
			</div>
			<!-- 
			<div class="form-group">
				<label for="InputFile">File input</label> <input type="file"
					id="InputFile">
				<p class="help-block">Only .txt files accepted.</p>
			</div>
			 -->
			<input name="submit" type="submit" value="Submit" class="btn btn-default"/>
				
		</form>
		
		<p>
			<a href="<c:url value = '/j_spring_security_logout'></c:url>">Logout</a>
		</p>
	</div>
</body>
</html>
