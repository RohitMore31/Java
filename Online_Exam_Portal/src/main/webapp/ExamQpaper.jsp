<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.demo.service.*"
	import="java.util.List" import="com.demo.beans.Qpaper"
	import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>
<style>
/* Style for Page */
.body {
	background-image: linear-gradient(to right, #c9c9c9, #008CBA);
	margin: 0;
	padding: 0;
}
/* style to button */
.btnbox{
	margin:2rem;
}
/* style to Questin Box */
.qbox,.endexambox{
	display:flex;
	justify-content:center;
	align-item:center;
	flex-direction:column;
	background-color: #e7e7e7;
	color: #2F2FA2;
	text-align: center;
	height: 60vh;
	width: 60vw;
	margin:0px auto;
	border: 2px solid black;
	
}


</style>
<body>
	<%
	//creating ob of StudentService
	StudentService ss =new StudentServiceImpl();
	HttpSession session1 = request.getSession();
	String topic=(String)session1.getAttribute("Topic");
	
	// calling method of StudentService class to return list of que of that topic
	List<Qpaper> list = ss.allQuestion(topic);
	
	// Getting value from session 
	int qnumber = (Integer) session1.getAttribute("index");
	System.out.println("hiiiii");
	if (qnumber == list.size()) {
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeee");
	%>
	<div class="endexambox">
		<h1>End Of Exam!!!</h1>
		<a href='index.html' class="btn">Home page</a>
	</div>
	<%
	} else {
	%>
	<div class="qbox">
		<h1>Exam Start</h1>
		<h3>
			Question :
			<%=list.get(qnumber).getQue()%></h3>
		<div class="qform">
			<form action="ansSheet" method="get">
				<input type="radio" id="btn1" name="qid" value="a">
				<label for="btn1"><%=list.get(qnumber).getOp1()%></label> 
				<input type='radio' id='btn2' name='qid' value='a'>
				<label for="btn2"><%=list.get(qnumber).getOp2()%></label> 
				<input	type='radio' id='btn3' name='qid' value='a'>
				<label for="btn3"><%=list.get(qnumber).getOp3()%></label> 
				<input	type='radio' id='btn4' name='qid' value='a'>
				<label for="btn4"><%=list.get(qnumber).getOp4()%></label>
		<div class="btnbox"><button type='submit' name='submitop' class="btn">Next</button></div>
		<br>
		</form>
		</div>
		<%
		session1.setAttribute("index", ++qnumber);
		%>
	</div>
	<%} %>
</body>
</html>