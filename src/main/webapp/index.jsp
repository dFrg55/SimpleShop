<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>


</head>

<body onload="access()">
</body>
<script>
    $.get('json', function(data) {
        $.each(data, function(i, val) {
            alert(s+t);
        });
    });



    <%--function access(){--%>
    <%--    <% String str="Hello World"; %>--%>
    <%--    var s="<%=str%>";--%>
    <%--    var t=${name};--%>
    <%--    alert(s+t);--%>
    <%--}--%>
</script>


</html>
