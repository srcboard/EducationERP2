<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Page+</title>
    <%--<sec:csrfMetaTags/>--%>
    <%@include file="/WEB-INF/views/fragments/bootstrap.jspf" %>
</head>
<body>
    
    <%@include file="/WEB-INF/views/fragments/navbar.jspf" %>
    
    <div class="container">
        <%--<a href="../../../../java/com/company/filter/EncodingInterceptor.java"></a>--%>
        <h2>Group list</h2>
        
        <form method="post" action="${pageContext.servletContext.contextPath}/group/edit/<c:if test="${group != null}">${group.id}</c:if><c:if test="${group == null}">${group.id}-1</c:if>">
            <input type="hidden" name="id" value="${group.id}"/>

            <div class="form-group">
                <label for="number">Group number</label>
                <input type="text" class="form-control" id="number" name="number" placeholder="Group number" value="${group.number}"/>
            </div>
            <div class="form-group">
                <label for="schedule">Schedule</label>
                <input type="text" class="form-control" id="schedule" name="schedule" placeholder="Schedule" value="${group.schedule.weakDays}" disabled/>
            </div>
            <div class="form-group">
                <label for="trainer">Trainer</label>
                <input type="text" class="form-control" id="trainer" name="trainer" placeholder="Trainer" value="${group.trainer.surname} ${group.trainer.name}" disabled/>
            </div>
              
            <a href="${pageContext.servletContext.contextPath}/group" class="btn btn-default">Cancel</a>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
            
        </div>
    
</body>
</html>
