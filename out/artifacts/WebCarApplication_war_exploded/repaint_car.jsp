<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype HTML>
<html>
<head>
    <title>Car Repaint Form</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<form action="RepaintCarServlet" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id")%>" >
    <br>
    <br>
    New Color:
    <input type="text" name="color" class="textField">
    <br>
    <br>
    <input type="submit" value="Submit Form" class="smallButton">
</form>

</body>
</html>
