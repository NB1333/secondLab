<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulas</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/calculate">
    <p>Input four params</p>
    <label>
        <input type="number" step="0.01" name="aParam" placeholder="Enter first param..." required="required">
    </label><br>
    <label>
        <input type="number" step="0.01" name="bParam" placeholder="Enter second param..." required="required">
    </label><br>
    <label>
        <input type="number" step="0.01" name="cParam" placeholder="Enter third param..." required="required">
    </label><br>
    <label>
        <input type="number" step="0.01" name="dParam" placeholder="Enter fourth param..." required="required">
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

    <input type="submit" value="Calculate"/>
</form>


</body>
</html>