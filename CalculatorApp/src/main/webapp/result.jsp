<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Resultados
    </h1>
        <%
String[] info= (String[]) request.getAttribute("brands");
String operator = info[0];
String result = info[1];
out.println("<br>la operacion es: <br><br>");
//while(it.hasNext()){
out.println(operator+"<br>");
out.println("el resultado es:<br><br>");
out.println(result);
%>
</body>
</html>