<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"  type="text/css" href="../css/login-page.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title></title>

</head>
<body>

<%--<form action="j_security_check" method="post">--%>
<%--    <!-- Email input -->--%>
<%--    <div class="form-outline mb-4">--%>
<%--        <input name="j_username" type="text" id="form2Example1" class="form-control" />--%>
<%--        <label class="form-label" for="form2Example1">Email address</label>--%>
<%--    </div>--%>

<%--    <!-- Password input -->--%>
<%--    <div class="form-outline mb-4">--%>
<%--        <input  name="j_password" type="password" id="form2Example2" class="form-control" />--%>
<%--        <label class="form-label" for="form2Example2">Password</label>--%>
<%--    </div>--%>

<%--    <!-- Submit button -->--%>
<%--    <input type="submit" class="btn btn-primary btn-block mb-4" value="Авторизироваться">--%>

<%--</form>--%>



<%--<div class="wrapper fadeInDown">--%>
<%--    <div id="formContent">--%>
<%--        <form action="j_security_check" method="post">--%>
<%--            <input name="j_username" type="text" id="login" class="fadeIn second" name="login" placeholder="login">--%>
<%--            <input name="j_password" type="password" id="password" class="fadeIn third" name="login" placeholder="password">--%>
<%--            <input type="submit" class="fadeIn fourth" value="Авторизироваться">--%>
<%--        </form>--%>

<%--    </div>--%>
<%--</div>--%>
<div class="wrapper fadeInDown">
    <div id="formContent">

        <!-- Login Form -->
        <form action="home" method="post">
<%--        <form method="post" action="/home">--%>
            <input name="j_username" type="text" id="login" class="fadeIn second"  placeholder="Логин">
            <input name="j_password" type="password" id="password" class="fadeIn third"  placeholder="Пароль">
            <input type="submit" class="fadeIn fourth" value="Авторизироваться">
        </form>



    </div>
</div>


<!-- jQuery -->
<script src="../js/lib/jquery-3.6.4.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<!-- bootstrap JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!-- JS для всплывающих окон -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>

</body>
</html>
