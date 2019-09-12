<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype HTML>
<html>
<head>
    <title>Car Creation Form</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<form action="FormProcessServlet" method="post">
    Car Form.
    <br>
    <br>
    Brand:
    <input type="text" name="brand" class="textField">
    <br>
    <br>
    Type:
    <select name="type" class="textField">
        <option value="Cabrio">Cabriolet</option>
        <option value="Sport">Sport Car</option>
        <option value="Family">Family Car</option>
    </select>
    <br>
    <br>
    Color:
    <input type="text" name="color" class="textField">
    <br>
    <br>
    Choose type of roof( only for Cabrio):
    <input type="radio" name="openedRoof" value="opened" checked> Opened
    <input type="radio" name="openedRoof" value="notOpened"> Not Opened
    <br>
    <br>
    <input type="submit" value="Submit Form" class="smallButton">
</form>
<form action="index.jsp">
    <input type="submit" value="Go back" class="smallButton"/>
</form>
</body>
</html>
