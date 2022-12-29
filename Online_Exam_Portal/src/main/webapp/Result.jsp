<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>

<style>
/* Style to page*/
.rsbox {
	background-image: url(rs-background.jpg);
	background-size: cover;
	width: 60vw;
	height: 60vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin: 10vh auto;
}

#mygif img {
	width: 20vw;
	height: 50px;
}

h2 {
	font-size: 2.5em;
}

h3 {
	color: white;
}
</style>
<body>
	<%
	String examstatus = "fail";
	int marks = 0;
	// Getting mark from session  
	session = request.getSession();
	if (!session.isNew()) {
		marks = (Integer) session.getAttribute("totalmark");
		// if mark is 3or above display status pass
		if (marks >= 3) {
			examstatus = "pass";
		}
	}
	%>

	<div class="rsbox">
		<h2>
			Your Result Is
			<%=examstatus%>
		</h2>
		<div id="mygif">
			<img alt="opss"
				src="https://www.funimada.com/assets/images/cards/big/congrats-14.gif">
		</div>
		<h3>
			Score is =
			<%=marks%>/5
		</h3>

		<a href='index.html' class="btn">Home page</a>
	</div>
	<%
	session.setAttribute(examstatus, false);
	%>
</body>
</html>