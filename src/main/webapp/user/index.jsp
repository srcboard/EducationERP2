<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/fragments/bootstrap.jspf" %>
</head>
<body>
<%@include file="/fragments/navbar.jspf" %>

<div class="container">
    <div class="page-header">
        <h1>Users list
            <small>(CRUD)</small>
        </h1>
    </div>

    <table class="table table-hover">

        <thead>
        <th>#</th>
        <th>Username</th>
        </thead>

        <tbody>

        <c:forEach items="${userList}" var="user">

            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
            </tr>

        </c:forEach>

        </tbody>

    </table>
</div>
</body>
</html>
