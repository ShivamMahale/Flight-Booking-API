<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="base-user.jsp" %>

 <!-- Hero Section -->
 <section id="hero" class="bg-dark text-white text-center py-5">
   <div class="container">
     <h1 class="display-4 font-weight-bold pt-3">Welcome ${userName}</h1>
     <p class="lead">Explore our wide range of service</p>
   </div>
 </section>
 <section class="d-flex justify-content-between text-center  py-5">
 <div class="col-md-6 offset-md-3">
   <p class="lead">You Successfully Booked Your Flight and Ticket Number is ${bookingId}</p>
   <p>Happy Journey !! </p>
 </div>
 </section>

<% request.setAttribute("content", "user-book-flight-success.jsp"); %>