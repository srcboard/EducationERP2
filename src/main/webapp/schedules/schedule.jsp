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

        <%@include file="/fragments/bootstrap.jspf" %>
    </head>
    <body>
        <%@include file="/fragments/navbar.jspf" %>

        <div class="container">
            <div class="page-header">
                <h1>Schedule</h1>
                <%@include file="/schedules/schedule.warning.jspf" %>
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
                    <!--                    <th>Number</th>
                                        <th>Weak days</th>
                                        <th>Lesson time</th>
                                        <th>Trainer</th>-->
                    <tr>
                        <th rowspan="2">ID</th>
                        <th colspan="3">Group</th>
                    </tr><tr>
                        <th>Weak Days</th>
                        <th>Lesson Time</th>
                        <th>Number</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${scheduleList}" var="schedule">
                        <tr>
                            <td>${schedule.id}</td>
                            <td>${schedule.weakDays}</td>
                            <td>${schedule.lessonTime}</td>
                            <td>
                                <c:forEach items="${schedule.studentGroupList}" var="studentGroup">
                                    ${studentGroup.number}
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

                <%--<tbody>
                    <c:forEach items="${scheduleList}" var="schedule">
                        <c:forEach items="${schedule.groupList}" var="group">
                            <tr>
                                <td>${group.number}</td>
                                <td>${schedule.weakDays}</td>
                                <td>${schedule.lessonTime}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </tbody>--%>
            </table>
        </div>
    </body>
</html>
