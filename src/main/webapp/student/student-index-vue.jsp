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
    <b-table striped hover
             :items="items"
    >
        <template slot="id" scope="row"></template>
        <template slot="name" scope="row"></template>
        <template slot="surname" scope="row"></template>
        <template slot="edit" scope="row"><b-btn>Edit</b-btn></template>
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
            edit: {label: 'Edit'}
        },
    })

</script>

</body>
</html>