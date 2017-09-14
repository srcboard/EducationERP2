<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students</title>
    <%@include file="/jspf/bootstrap-vue-libs.jspf" %>
</head>
<body>
<%@include file="/jspf/bootstrap-vue-navbar.jspf" %>

<div id="app">

    <div class="page-header">

        <h1>Student list
            <small>(CRUD)</small>
            <a href="${pageContext.servletContext.contextPath}/student/add/">
                <i class="fa fa-plus-circle" aria-hidden="true"></i>
            </a>
        </h1>

    </div>

    <b-table striped hover
             :items="items"
    >
        <template slot="id" scope="row"></template>
        <template slot="name" scope="row"></template>
        <template slot="surname" scope="row"></template>
        <template slot="edit" scope="row">
            <b-btn size="sm" @click.stop="edit(row.item,row.index,$event.target)">Edit</b-btn>
        </template>
        <template slot="remove" scope="row">
            <b-btn size="sm" @click.stop="remove(row.item,row.index,$event.target)">Remove</b-btn>
        </template>
    </b-table>
</div>

<script>

    var array = new Array();

    <c:forEach items="${studentList}" var="item">

    var o = new Object();
    o.id = '${item.id}';
    o.name = '${item.name}';
    o.surname = '${item.surname}';
    o.edit = null;
    o.remove = null;
    array.push(o);

    </c:forEach>

    new Vue({
        el: "#app",
        data: {
            items: array
        },
        fields: {
            id: {label: 'Id'},
            name: {label: 'Name'},
            surname: {label: 'Surname'},
            edit: {label: 'Edit'},
            remove: {label: "Remove"}
        },
        methods: {
            edit(item, index, button) {
                location.href = "${pageContext.servletContext.contextPath}/student/edit/".concat(item.id);
            },
            remove(item, index, button) {
                location.href = "${pageContext.servletContext.contextPath}/student/remove/".concat(item.id);
            }
        }
    })

</script>

</body>
</html>