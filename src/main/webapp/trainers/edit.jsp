<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <%@include file="/fragments/bootstrap.jspf" %>
</head>
<body>
<%@include file="/fragments/navbar.jspf" %>

<div id="app">

    <div class="container">

        <form:form method="POST" role="form" modelAttribute="trainer" class="form-signin">

            <div class="row">

                <div class="col-md-4">

                    <h3> Trainer {{ full_name }} </h3>
                    <input type="hidden" name="id" value="${trainer.id}"/>

                    <div class="form-group">
                        <label for="name">Name</label>
                        <form:input type="text" class="form-control" path="name" id="name" title="Name of trainer"/>
                    </div>

                    <div class="form-group">
                        <label for="surname">Surname</label>
                        <input type="text" class="form-control" id="surname" name="surname" placeholder="Second name"
                               value="${trainer.surname}"/>
                    </div>

                    <div class="form-group">
                        <label for="birthday">Birthday</label>
                        <input type="datetime" class="form-control" id="birthday" name="birthday" placeholder="Birthday"
                               value="${trainer.birthday}"/>
                    </div>

                    <a href="/trainer/" class="btn btn-default">Cancel</a>

                    <button type="submit" class="btn btn-primary">Save</button>

                </div>

                <div class="col-md-8">

                    <c:if test="${!empty themesAll}">

                        <h3>Themes</h3>
                        <div class="row">
                            <c:forEach items="${themesAll}" var="theme">
                                <input class="checkbox-inline" type="checkbox" name="themesList" value="${theme.id}"
                                       <c:if test="${trainer.themeList.contains(theme)}">checked</c:if>>
                                ${theme.name}
                            </c:forEach>
                        </div>

                    </c:if>

                </div>

                    <%--<div class="checkbox-inline">--%>
                    <%--<h3>Themes</h3>--%>
                    <%--<div class="row">--%>
                    <%--<form:checkboxes path="themeList" items="${themesAll}" itemLabel="name" itemValue="id"--%>
                    <%--id="themesList" element="span class='col-md-6'"/>--%>
                    <%--</div>--%>
                    <%--</div>--%>

            </div>

        </form:form>

    </div>

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.4.0/vue.js"></script>
<script>
    new Vue({
        el: "#app",
        data: {
            full_name: "${trainer.name} ${trainer.surname}"
        },
        computed: {
            full_name: function () {
                return "${trainer.name} ${trainer.surname}";
            }
        }
    })
</script>

</body>

</html>
