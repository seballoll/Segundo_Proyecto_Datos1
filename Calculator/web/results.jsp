<%--
  Created by IntelliJ IDEA.
  User: seba2
  Date: 27/10/2021
  Time: 10:38 pm
  To change this template use File | Settings | File Templates.
--%>

<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>

    <h1>
        Available Brands
    </h1><%
List result= (List) request.CalculatorServLet("brands");
Iterator it = result.iterator();
out.println("<br>We have <br><br>");
while(it.hasNext()){
out.println(it.next()+"<br>");
}
%>
</body>
</html>