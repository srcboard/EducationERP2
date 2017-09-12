<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <title>About</title>

    <%--<%@include file="/fragments/bootstrap.jspf" %>--%>
    <%@include file="/jspf/bootstrap-vue.jspf" %>

</head>
<body>
<%--<%@include file="/fragments/navbar.jspf" %>--%>

<div id="app">
    <%@include file="/jspf/bootstrap-vue-navbar.jspf" %>
</div>

<script>
    new Vue({
        el: "#app"
    })
</script>

</body>
</html>
