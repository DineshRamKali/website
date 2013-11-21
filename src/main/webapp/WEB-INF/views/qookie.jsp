<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
		<br/>
		<br/>
		<sf:form class="form" action='${pageContext.request.contextPath}/qookie/create' method = 'POST'
		commandName="quotes">
			<div class="form-group">
				<sf:input name="quote_name" type="text" class="form-control" path="quote_name" placeholder="Title"/>
				<p class="help-block"><sf:errors path="quote_name" class="help-inline"></sf:errors></p>
				<sf:textarea name="quotes" class="form-control" rows="20" path="quotes" placeholder="Twenty Quotes, one per line!"/>
				<p class="help-block"><sf:errors path="quotes" class="help-inline"></sf:errors></p>
			</div>
			<!-- 
			<div class="form-group">
				<label for="InputFile">File input</label> <input type="file"
					id="InputFile">
				<p class="help-block">Only .txt files accepted.</p>
			</div>
			 -->
			<input name="submit" type="submit" value="Submit" class="btn btn-default"/>
				
		</sf:form>
		
		<p>
			<a href="<c:url value = '/j_spring_security_logout'></c:url>">Logout</a>
		</p>
	</div>
</body>
</html>
