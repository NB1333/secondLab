<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
      List<String> values = new ArrayList<>();
      Cookie[] cookies = request.getCookies();

      for (int i = 0; i < 4; i++) {
          for (Cookie cookie : cookies) {
              if (parametersNames[i].equals(cookie.getName())) {
                  values.add(cookie.getValue());
              }
          }
      }

      String[] formulaChoice = new String[]{"first", "second", "third"};
      boolean[]choice = new boolean[]{false, false, false};

      for(int i = 0; i < choice.length; i++) {
          for(Cookie cookie : cookies) {
              if(formulaChoice[i].equals(cookie.getValue())) {
                  choice[i] = true;
              }
          }
      }

    %>
    <p>Input four params</p>
    <label>
        <input type="number" step="0.01" name="aParam" placeholder="Enter first param..." required="required"
               value="<%= values.get(0)%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="bParam" placeholder="Enter second param..." required="required"
               value="<%= values.get(1)%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="cParam" placeholder="Enter third param..." required="required"
               value="<%= values.get(2)%>">
    </label><br>
    <label>
        <input type="number" step="0.01" name="dParam" placeholder="Enter fourth param..." required="required"
               value="<%= values.get(3)%>">
    </label><br>

    <p>Choose formula:</p>
    <label class="container">
        <input type="radio" id="expression1" name="formula" value="first" required="required"/>First<br>
        <span class="checkmark"></span>
    </label>
    <label class="container">
        <input type="radio" id="expression2" name="formula" value="second" required="required"/>Second<br>
        <span class="checkmark"></span>
    </label>
    <label class="container">
        <input type="radio" id="expression3" name="formula" value="third" required="required"/>Third<br>
        <span class="checkmark"></span>
    </label>

    <script>
        document.getElementById("expression1").checked = <%=choice[0]%>;
        document.getElementById("expression2").checked = <%=choice[1]%>;
        document.getElementById("expression3").checked = <%=choice[2]%>;
    </script>

    <input type="submit" value="Calculate"/>
</form>
</body>
</html>