<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <%@include file="/fragments/bootstrap.jspf" %>
    </head>
    <body>
        <%@include file="/fragments/navbar.jspf" %>

        <div class="container">
            <div class="page-header">
                <h1>Groups list <small>(CRUD)</small></h1>
            </div>
            <table class="table table-hover">
                <thead>
                <th>#</th>
                <th>Name</th>
                <th>Students</th>
                <th>Timetable</th>
                <th>Trainer</th>
                <th colspan="2" width="1%"></th>
                </thead>
                <tbody>

                    <c:forEach items="${groupList}" var="group">
                        <tr>
                            <td>${group.id}</td>
                            <td>${group.number}</td>
                            <td><c:forEach items="${group.studentList}" var="stud">
                                    <a href="${pageContext.servletContext.contextPath}/student">
                                        ${stud.name} ${stud.surname}
                                    </a>
                                    <br>
                                </c:forEach>
                            </td>
                            <%--td>${group.courseList}</td--%>
                            <td>${group.schedule.weakDays}</td>
                            <td>${group.trainer.surname} ${group.trainer.name}</td>
                            <td><a href="${pageContext.servletContext.contextPath}/group/edit/${group.id}" class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/group/remove/${group.id}" class="btn btn-danger"
                                   onclick="return confirm('Do you really want to remove \'${group.number}\' group?');">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.servletContext.contextPath}/group/edit/-1" class="btn btn-default">
                                    <i class="glyphicon glyphicon-plus"></i> Add Group
                                </a>
        </div>
    </body>
</html>
