<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hola Mundo!

<%
for (int x=0; x<10; x++){
	//out es el de pantalla, es diferente del system.out.println
	//out escribe en el response (output stream)
	out.println("Lindo mundo "+x+"<br>");
}

%>
</body>
</html>