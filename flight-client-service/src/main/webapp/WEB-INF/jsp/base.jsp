<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-eg1OsShoKf9agwNz6rMPQLb9MYYFzqUhND0gmkA3dOyRJyNvOhA+KqWq47yv3F4dBeoXNP+IUvm1k67vs/hfEg=="
            crossorigin="anonymous">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <title>Cloud Touch App</title>
 </head>
<body>

<nav class="navbar navbar-expand-lg navbar-light b-5" style="background-color: #e3f2fd; box-shadow: 0 4px 2px -2px gray; overflow: hidden; position: fixed; top: 0; width: 100%;">

  <a class="navbar-brand font-weight-bold" href="/flight-service/">
       Cloud Touch App
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active font-weight-bold">

        <a class="item p-3" href="/flight-service/" ><i class="fas fa-home"></i>Home </a>
      </li>
        <li class="nav-item  font-weight-bold">
              <a class="item p-3" href="/flight-service/user/register" ><i class="fas fa-home"></i>Signup</a>
         </li>
          <li class="nav-item  font-weight-bold">
                       <a class="item p-3" href="/flight-service/user/index" ><i class="fas fa-home"></i>Login</a>
                  </li>
      <li class="nav-item  font-weight-bold">
        <a class="item p-3" href="/flight-service/search">Book Flight </a>
      </li>
    </ul>
  </div>
</nav>


<!-- Main content area -->
<div class="container">
<jsp:include page="${content}" />

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script th:src="@{/js/scripts.js}"></script>
</body>
</html>