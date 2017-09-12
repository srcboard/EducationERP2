<%-- 
    Document   : index
    Created on : Feb 29, 2016, 7:42:47 PM
    Author     : human
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>history of lessons</title>

        <%@include file="/WEB-INF/views/fragments/bootstrap.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/views/fragments/navbar.jspf" %>

        <div class="container">
            <div class="page-header">
                <h1>History of lessons</h1>
                <%@include file="/WEB-INF/views/schedules/schedule.warning.jspf" %>
                <div class="dropdown">
                    <form class="navbar-form pull-right" method="POST">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort by:
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a id="sortByDate">Date</a></li>
                            <li><a id="sortByroup">Group</a></li>
                            <li><a id="sortByTrainer">Trainer</a></li>
                        </ul>
                    </form>
                </div>
            </div>
            <table class="table table-hover">
                <thead>
                <th>Training Time</th>
                <th>Group Number</th>
                <th>Trainer</th>
                </thead>
                <tbody>
                    <c:forEach items="${historyList}" var="history">
                        <tr>
                            <td>${history.timestamp}</td>
                            <td>${history.studentGroup.number}</td>
                            <td>${history.studentGroup.trainer.name} ${history.studentGroup.trainer.surname}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
