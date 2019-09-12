<%@ page import="model.Car,java.util.*" %>
<!doctype HTML>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>All available cars</title>
</head>
<body>
<p class="par">
    Click on the car's ID to drive the car.
</p>
<%
    List<Car> cars = (ArrayList<Car>) request.getAttribute("cars");
%>
<table id="showAllCarsTable">
    <tr>
        <th>&emsp;ID&emsp;</th>
        <th>&emsp;&emsp;&ensp;Brand&ensp;&emsp;&emsp;</th>
        <th>&emsp;&emsp;&ensp;Type&ensp;&emsp;&emsp;</th>
        <th>&emsp;&emsp;&ensp;Color&ensp;&emsp;&emsp;</th>
        <th>Current fuel/ Max fuel</th>
    </tr>
    <%
        for (Car car : cars) {
            out.print("<tr><td><a href=\"UseCarServlet?id=" + car.getId() + "\">" + car.getId() + "</a>");
            out.print("</td><td>" + car.getBrand() + "</td><td>" + car.getType()
                    + "</td><td>" + car.getColor() + "</td><td>" + car.getCurrentFuel() + "/" + car.getMaxFuel()
                    + "</td></tr>");
        }
    %>
</table>


<br>
<br>
<form action="index.jsp">
    <input type="submit" value="Go back" class="smallButton"/>
</form>
</body>
</html>