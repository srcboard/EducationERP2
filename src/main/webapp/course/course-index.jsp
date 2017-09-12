<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Courses</title>
        
        <%@include file="/fragments/bootstrap.jspf" %>
    </head>
    <body>
       
        <div class="container-fluid">
            <div class="row">
                <%@include file="/fragments/program-navbar-segment.jspf" %>
                
                <div class="col-md-9">
                    <div class="page-header">
                        <h2>Courses</h2>
                    </div>
                    
                    <table class="table table-striped">
                        <thead>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Themes</th>
                            <th>Groups</th>
                            <th></th>
                            <th></th>
                        </thead>

                        <tbody>
                            <c:forEach items="${AllCourses}" var="currentCourse">
                                <tr>
                                    <td style="width: 15%">${currentCourse.name}</td>
                                    <td style="width: 43%">${currentCourse.description}</td>
                                    <td style="width: 30%">
                                        <%--<c:forEach items="${currentCourse.themeList}" var="currentTheme">--%>
                                            <%--<a href="${pageContext.servletContext.contextPath}/theme/edit/${currentTheme.id}">${currentTheme.name}</a><br>--%>
                                        <%--</c:forEach>--%>
                                    </td>
                                    <td style="width: 10%">
                                        <%--<c:forEach items="${currentCourse.studentGroupList}" var="currentGroup">--%>
                                            <%--<a href="${pageContext.servletContext.contextPath}/groups/edit/${currentGroup.id}">${currentGroup.number}</a><br>--%>
                                        <%--</c:forEach>--%>
                                    </td>
                                    <td style="width: 1%"><a href="${pageContext.servletContext.contextPath}/course/edit/${currentCourse.id}"
                                           class="btn btn-default">
                                            <span class="glyphicon glyphicon-pencil" style="color: darkgreen" aria-hidden="true"></span></a>
                                    </td>
                                    <td style="width: 1%"><a href="${pageContext.servletContext.contextPath}/course/delete/${currentCourse.id}"
                                           class="btn btn-default"
                                           onclick="return confirm('Do you really want to remove course &quot;${currentCourse.name}&quot;?');">
                                           <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                        <a href="${pageContext.servletContext.contextPath}/course/new" class="btn btn-default">Add new course</a>
                </div>
            </div>
        </div>
    </body>
</html>