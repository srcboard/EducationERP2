<%-- 
    Document   : courseEdit
    Created on : Mar 23, 2016, 2:58:24 PM
    Author     : Vitalij
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit course</title>
        <style>
            .error {
                color: red; 
            }
        </style> 
        <%@include file="/fragments/bootstrap.jspf" %>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <%@include file="/fragments/program-navbar-segment.jspf" %>

                <div class="col-md-9">
                    <div class="page-header">
                        <h1>Edit course "${course.name}":</h1>
                    </div>
                    <c:url var="currPath" value="${pageContext.servletContext.contextPath}/course/edit/${course.id}" />
                    
                    <%@include file="/fragments/course-form-inputs.jspf" %>
                        
                 </div>
            </div>       
        </div> 
    </body>
</html>