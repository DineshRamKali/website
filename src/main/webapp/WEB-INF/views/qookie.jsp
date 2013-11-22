<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.js"></script>
	
<title>Qookie</title>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-45953111-1', 'abhishukla.com');
  ga('send', 'pageview');

</script>	
</head>
<body>
	<div class="container">
		<h1>Qookie!</h1>
		<p>Fortune Cookie for Quotes!</p>
		<br/>
		<br/>
		<p>Welcome ${username}</p>
		<sf:form class="form" action='${pageContext.request.contextPath}/qookie/create' method = 'POST'
		commandName="quotes">
			
			<p>Your cookies will be availalbe at this link:</p>
			  
			<%-- <a href="http://localhost:8080/website/getQookie?id=${quotes.user.uuid}" target="_blank"> 
					http://localhost:8080/website/getQookie?id=${quotes.user.uuid}</a> --%>
			
			
			
			<a href="http://www.abhishukla.com/getQookie?id=${quotes.user.uuid}" target="_blank"> 
					http://www.abhishukla.com/getQookie?id=${quotes.user.uuid}</a>
			
			<br/>
			<br/>
			<div class="form-group">
				<sf:textarea name="quotes" class="form-control" rows="20" path="quotes" />				
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
