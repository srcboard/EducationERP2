<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Themes</title>

    <%@include file="/fragments/bootstrap.jspf" %>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <%@include file="/fragments/program-navbar-segment.jspf" %>

        <div class="col-md-9">
            <div class="page-header">
                <h2>Themes</h2>
            </div>
            <table class="table table-striped">
                <thead>
                <th>#</th>
                <th>Name</th>
                <th>Description</th>
                <th></th>
                <th></th>
                </thead>

                <tbody>
                <c:forEach items="${AllThemes}" var="currentTheme">
                    <tr>
                        <td style="width: 32%">${currentTheme.id}</td>
                        <td style="width: 32%">${currentTheme.name}</td>
                        <td style="width: 66%">${currentTheme.description}</td>
                        <td style="width: 1%"><a
                                href="${pageContext.servletContext.contextPath}/theme/edit/${currentTheme.id}"
                                class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil" style="color: darkgreen" aria-hidden="true"></span></a>
                        </td>
                        <td style="width: 1%"><a
                                href="${pageContext.servletContext.contextPath}/theme/delete/${currentTheme.id}"
                                class="btn btn-default"
                                onclick="return confirm('Do you really want to remove theme &quot;${currentTheme.name}&quot;?');">
                            <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <a href="${pageContext.servletContext.contextPath}/theme/add/" class="btn btn-default">Add new theme</a>

        </div>
    </div>
</div>
</body>
</html>