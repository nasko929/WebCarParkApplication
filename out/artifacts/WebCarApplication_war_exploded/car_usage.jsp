<%@ page import="model.Car" %>
<!doctype HTML>
<html>
<head>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <%
        Car car = (Car) request.getAttribute("car");
    %>
    <title><%= (car == null) ? ("Error: no such car") : ("Using your car: " + car.getBrand()) %>
    </title>
    <%
        if(car == null)
            car = new Car();
    %>
</head>
<body>
<div id="container">
    <div id="buttons">
        <a href=""
        <form action="StartEngineServlet?id=" >
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Start engine" class="smallButton"/>
        </form>
        <form action="StopEngineServlet">
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Stop engine" class="smallButton"/>
        </form>
        <form action="StartDrivingServlet">
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Start Driving" class="smallButton"/>
        </form>
        <form action="StopDrivingServlet">
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Stop Driving" class="smallButton"/>
        </form>
        <form action="RefuelServlet">
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Refuel" class="smallButton"/>
        </form>
        <form action="repaint_car.jsp" method="post">
            <input type="hidden" name="id" value="<%= car.getId()%>">
            <input type="submit" value="Repaint Car" class="smallButton"/>
        </form>
        <form action="ChangeCarServlet">
            <input type="submit" value="Change Car" class="smallButton"/>
        </form>
    </div>
    <div id="errors">
        <p class="par">
            Errors: <br>
        <%
            if(request.getAttribute("error") == null) {
                out.println("<br>None.");
            }
            else {
                out.println("<br>"+request.getAttribute("error"));
            }
        %>
        </p>
    </div>
    <div id="carInfo">
        <p class="par">
            Brand:<br>
            <%= car.getBrand()%><br>
            <br>
            Type: <br>
            <%= car.getType()%>
            <br>
            <%
                if(car.getType().equals("Cabrio")) {
                    out.println("<br>Roof is ");
                    out.println((car.isOpenedRoof()) ? ("opened") : ("closed"));
                    out.println("<br>");
                }
            %>
            <br>
            Color:<br>
            <%= car.getColor()%><br>
            <br>
            Max Speed:<br>
            <%= car.getMaxSpeed()%> <br>
            <br>
            Max Capacity:<br>
            <%= car.getMaxCapacity()%> <br>
            <br>
            Current Fuel/ Max Fuel:<br>
            <%= car.getCurrentFuel() + "/ " + car.getMaxFuel()%> <br>
            <br>
            <%
                if(car.isStartedEngine() && car.isBeingDriven()) {
                    out.print("The car is currently being driven.<br>");
                } else if(car.isStartedEngine() && !car.isBeingDriven()) {
                    out.print("The car's engine is started.<br>");
                } else if(!car.isStartedEngine()) {
                    out.print("The car's engine is not started.<br>");
                }
            %>

        </p>
    </div>
</div>

</body>
</html>