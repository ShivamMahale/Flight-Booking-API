<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<section class="container my-card mt-4 mb-3 py-5 d-flex justify-content-center align-items-center">
  <div class="container text-center .bg-success.bg-gradient">
    <p>${responseMsg}</p>
  </div>
  <div class="container text-center">
  <a class="btn btn-learn-more" href="/flight-service/user/index">SignIn Here</a>
  </div>
</section>
<% request.setAttribute("content", "success.jsp"); %>