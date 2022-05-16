<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulas</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form method="GET" action="${pageContext.request.contextPath}/calculate">
    <%
      String[] parametersNames = new String[]{"aParam", "bParam", "cParam", "dParam"};

        for (String parametersName : parametersNames) {
            Cookie param = new Cookie(parametersName, request.getParameter(parametersName));
            param.setValue(request.getParameter(parametersName));
            param.setMaxAge(48 * 60 * 60);
            response.addCookie(param);
        }
    %>
    <p>Input four params</p>
    <label>
        <input type="number" step="0.01" name="aParam" placeholder="Enter first param..." required="required"
               value="<%= request.getParameter("aParam")%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="bParam" placeholder="Enter second param..." required="required"
               value="<%= request.getParameter("bParam")%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="cParam" placeholder="Enter third param..." required="required"
               value="<%= request.getParameter("cParam")%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="dParam" placeholder="Enter fourth param..." required="required"
               value="<%= request.getParameter("dParam")%>">
    </label><br>

    <p>Choose formula:</p>
    <label class="container">
        <input type="radio" name="formula" value="first" required="required"/>First<br>
        <span class="checkmark"></span>
    </label>
    <label class="container">
        <input type="radio" name="formula" value="second" required="required"/>Second<br>
        <span class="checkmark"></span>
    </label>
    <label class="container">
        <input type="radio" name="formula" value="third" required="required"/>Third<br>
        <span class="checkmark"></span>
    </label>

    <%!





    %>

    <input type="submit" value="Calculate"/>
</form>
</body>
</html>