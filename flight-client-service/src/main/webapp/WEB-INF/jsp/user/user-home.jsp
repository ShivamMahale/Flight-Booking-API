<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
   <a  href="/flight-service/user/search" class="btn btn-primary">Book Your Flight</a>
 </div>
 </section>
<section class="container text-center py-5" style="width: 100;">
<h3 class="p-3">Search Google Map</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m28!1m12!1m3!1d1901559.5876998934!2d85.77433386995439!3d21.42989079344397!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m13!3e3!4m5!1s0x39f882db4908f667%3A0x43e330e68f6c2cbc!2sKolkata%2C%20West%20Bengal!3m2!1d22.572646!2d88.363895!4m5!1s0x3a1909d2d5170aa5%3A0xfc580e2b68b33fa8!2sBhubaneswar%2C%20Odisha!3m2!1d20.2960587!2d85.8245398!5e0!3m2!1sen!2sin!4v1709062422782!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</section >
<% request.setAttribute("content", "user-home.jsp"); %>