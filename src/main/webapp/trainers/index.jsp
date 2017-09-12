<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trainers</title>
    <%@include file="/WEB-INF/views/fragments/bootstrap.jspf" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/navbar.jspf" %>

<div class="container">

    <div class="page-header">
        <h1>
            Trainer list
            <small>(CRUD)</small>
            <a href="${pageContext.servletContext.contextPath}/trainer/add/" class="btn btn-success">
                <i class="fa fa-plus" aria-hidden="true"></i>
            </a>
        </h1>
    </div>

    <table class="table table-hover">

        <thead>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th colspan="2" width="1%"></th>
        </thead>

        <tbody>

        <c:forEach items="${trainerList}" var="trainer">

            <tr>
                <td>${trainer.id}</td>
                <td>${trainer.name}</td>
                <td>${trainer.surname}</td>

                <td>
                    <a href="${pageContext.servletContext.contextPath}/trainer/edit/${trainer.id}"
                       class="btn btn-warning">
                        <i class="fa fa-pencil"></i>
                    </a>
                </td>

                <td>
                    <a href="${pageContext.servletContext.contextPath}/trainer/delete/${trainer.id}"
                       class="btn btn-danger"
                       onclick="return confirm('Do you really want to remove \'${trainer.name} ${trainer.surname}\' trainer?');">
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
