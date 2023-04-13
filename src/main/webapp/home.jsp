<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html >
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <title></title>

</head>
<body>
<form action="j_security_check" method="post">
  Input for username:<br>
  <input name="j_username" type="text"><br>
  Input for password:<br>
  <input name="j_password" type="password"><br>
  <input type="submit" value="Авторизироваться">
</form>

<div id="app">

</div>

<!-- js-cookie -->
<script type="module" src="/js/lib/js.cookie.mjs"></script>
<script nomodule defer src="/js/lib/js.cookie.js"></script>
<script type="module">
  import Cookies from '/js/lib/js.cookie.mjs'

  Cookies.set('foo', 'bar')
</script>

<!-- jQuery -->
<script src="js/lib/jquery-3.6.4.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<!-- bootstrap JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!-- JS для всплывающих окон -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>

<!-- основной файл скриптов -->
<script src="js/app.js"></script>

<!-- item scripts -->
<script src="js/item/read-item.js"></script>
<script src="js/item/create-item.js"></script>
<script src="js/item/read-one-item.js"></script>
<script src="js/item/update-item.js"></script>
<script src="js/item/delete-item.js"></script>


<script></script>

</body>
</html>
