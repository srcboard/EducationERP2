<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add course</title>
        
        <%@include file="/WEB-INF/views/fragments/bootstrap.jspf" %>
        <style>
        .error{
            color : red;
        }
        </style>
    </head>
    <body>
       
        <div class="container-fluid">
            <div class="row">
                <%@include file="/WEB-INF/views/fragments/program-navbar-segment.jspf" %>
                
                <div class="col-md-9">
                    <div class="page-header">
                        <h1>Adding new course:</h1>
                    </div>
                    
                    <c:url var="currPath" value="${pageContext.servletContext.contextPath}/course/new" />
                   
                    <%@include file="/WEB-INF/views/fragments/course-form-inputs.jspf" %>
                        
                </div>
            </div>
        </div>
    </body>
</html>