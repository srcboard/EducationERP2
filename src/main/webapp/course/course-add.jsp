<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add course</title>

    <%@include file="/fragments/bootstrap.jspf" %>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <%@include file="/fragments/program-navbar-segment.jspf" %>

        <div class="col-md-9">
            <div class="page-header">
                <h1>Adding new course:</h1>
            </div>

            <c:url var="currPath" value="${pageContext.servletContext.contextPath}/course/new"/>

            <%@include file="/fragments/course-form-inputs.jspf" %>

        </div>
    </div>
</div>
</body>
</html>