<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Themes edit</title>
        
        <%@include file="/fragments/bootstrap.jspf" %>
        
        <style>
            .error{
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
                        <h1>Edit theme "${theme.name}"</h1>
                    </div>
                    
                    <form:form role="form" class="form-signin" method="POST" modelAttribute="theme"
                           action="${pageContext.servletContext.contextPath}/theme/edit/${theme.id}">
                        <form:hidden path="id" />
                        
                        <div class="form-group">
                            <label for="name">Theme title:</label>
                            <form:input type="text" class="form-control" id="name" path="name" /> 
                            <form:errors path="name" cssClass="error" />
                        </div>
                        
                        <div class="form-group">
                            <label for="descr">Theme description:</label>
                            <form:textarea class="form-control" id="descr" path="description" rows="10" cols="30" />
                            <form:errors path="description" cssClass="error" />
                        </div>
                        
                        <button name="add_new_theme" class="btn btn-primary"> 
                            <span class="glyphicon glyphicon-ok" style="color: mediumseagreen" aria-hidden="true"></span>
                            Save changes
                        </button>
                        
                        <input type="reset" value="Cancel" class="btn btn-default">
                        <a href="${header["referer"]}" class="btn btn-default">
                                <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                                Back</a>

                        <div class="col-md-8">

                            <c:if test="${!empty trainersAll}">

                                <h3>Trainers</h3>
                                <div class="row">
                                    <c:forEach items="${trainersAll}" var="trainer">
                                        <input class="checkbox-inline" type="checkbox" name="trainersList"
                                               value="${trainer.id}"
                                               <c:if test="${theme.trainerList.contains(trainer)}">checked</c:if>>
                                        ${trainer.name}
                                    </c:forEach>
                                </div>

                            </c:if>

                        </div>

                    </form:form>
                    
                </div>
            </div>
        </div>

    </body>
</html>