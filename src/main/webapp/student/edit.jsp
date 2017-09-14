<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@include file="/fragments/bootstrap.jspf" %>
</head>
<body>
<%@include file="/fragments/navbar.jspf" %>

<div class="container">
    <h2>Student edit</h2>

    <form:form method="POST" role="form" modelAttribute="student" class="form-signin">

        <div class="row">

            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>Information</h4>
                    </div>
                    <div class="panel-body">
                        <input type="hidden" name="id" value="${student.id}"/>

                        <div class="form-group">
                            <label for="name">Name</label>
                            <input placeholder="Enter a name..." type="text" v-model="name" class="form-control"
                                   id="name" name="name" value="${student.name}"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>

                            <%--<div class="form-group">--%>
                            <%--<label for="descr">Description</label>--%>
                            <%--<form:textarea class="form-control" id="descr" path="description" rows="6" cols="60" />--%>
                            <%--<form:errors path="description" cssClass="error" />--%>
                            <%--</div>--%>

                        <div class="form-group">
                            <label for="surname">Surname</label>
                            <input type="text" class="form-control" id="surname" name="surname"
                                   placeholder="Second name" value="${student.surname}"/>
                        </div>

                        <div class="form-group">
                            <label for="birthday">Birthday</label>
                            <input type="date" class="form-control" id="birthday" name="birthday" placeholder="Birthday"
                                   value="${student.birthday}"/>
                        </div>

                        <div class="form-group">
                            <a href="${pageContext.servletContext.contextPath}/student/"
                               class="btn btn-default">Cancel</a>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>

                            <%--<button type="submit" class="btn btn-primary"--%>
                            <%--formaction="${pageContext.servletContext.contextPath}/student/edit/studentgroup/${student.id}">--%>
                            <%--Save with groups--%>
                            <%--</button>--%>

                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>Groups</h4>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th width="1%"><i class="fa fa-check"></i></th>
                                <th>Group name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${groupsAll}" var="group">
                                <tr>
                                    <td>
                                        <input type="checkbox" name="studentGroupsList" value="${group.id}"
                                            ${student.studentGroupList.contains(group) ? 'checked' : ''}>
                                    </td>
                                    <td>${group.number}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

    </form:form>

</div>
</body>
</html>
