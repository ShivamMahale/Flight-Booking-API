<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<section class="container my-card mt-4 mb-3 py-5 d-flex justify-content-center align-items-center">
<h1 class="text-center">Please Login to start your journey ahead!! </h1>
</section>
<div class="container-fluid py-2">
 <section style="background-color: #9A616D;">
         <div class="d-flex justify-content-center align-items-center ">
             <div class="col col-xl-8">
                 <div class="card" style="border-radius: 1rem;">
                     <div class="row g-0">
                         <div class="col-md-6 col-lg-5 d-md-block">
                             <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                  alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;"/>
                         </div>
                         <div class="col-md-6 col-lg-7 d-flex align-items-center">
                             <div class="card-body p-4 p-lg-5 text-black">

                                 <form id="login-form" method="post" action="/doLogin">

                                     <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Login Here !!</h5>

                                     <div class="form-outline mb-4">
                                         <p>
                                             <label for="username" class="sr-only">Username</label>
                                             <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
                                         </p>

                                     </div>

                                     <div class="form-outline mb-4">
                                         <p>
                                             <label for="password" class="sr-only">Password</label>
                                             <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
                                         </p>
                                     </div>

                                     <div class="pt-1 mb-4">
                                         <button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
                                     </div>

                                     <a class="small text-muted" href="/flight-service/user/forgot/password">Forgot password?</a>
                                     <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a href="/flight-service/user/register"
                                                                                                               style="color: #393f81;">Register
                                         here</a></p>
                                 </form>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
 </section>
</div>
<% request.setAttribute("content", "user-login.jsp"); %>