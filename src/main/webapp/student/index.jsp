<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/WEB-INF/views/fragments/bootstrap.jspf" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/navbar.jspf" %>

<div class="container">

    <div class="page-header">
        <h1>Student list
            <small>(CRUD)</small>
            <a href="${pageContext.servletContext.contextPath}/student/add/" class="btn btn-success">
                <i class="fa fa-plus" aria-hidden="true"></i>
            </a></h1>
    </div>

    <table class="table table-hover">

        <thead>
        <th>#</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Group</th>
        <th colspan="2" width="1%"></th>
        </thead>

        <tbody>

        <c:forEach items="${studentList}" var="student">

            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>

                    <%--<td><c:forEach items="${student.studentGroupList}" var="group">--%>
                    <%--<a href="${pageContext.servletContext.contextPath}/group/index?id=${group.id}">--%>
                    <%--${group.number}--%>
                    <%--</a>--%>
                    <%--<br>--%>
                    <%--</c:forEach>--%>
                <td>--</td>

                </td>

                <td>
                    <a href="${pageContext.servletContext.contextPath}/student/edit/${student.id}"
                       class="btn btn-warning"><i class="fa fa-pencil"></i></a>
                </td>

                <td>
                    <a href="${pageContext.servletContext.contextPath}/student/remove/${student.id}"
                       class="btn btn-danger"
                       onclick="return confirm('Do you really want to remove \'${student.surname} ${student.name}\' student?');">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>
</div>
</body>
</html>
