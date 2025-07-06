<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="base-user.jsp" %>

<section id="hero" class="bg-dark text-white text-center py-5">
   <div class="container">
      <h1 class="display-4 font-weight-bold pt-3">Welcome ${userName}</h1>
      <p class="lead">Explore our wide range of services</p>
   </div>
</section>

<section class="container mt-5">
   <div class="row justify-content-center">
      <div class="col-md-8">
         <div class="card">
            <div class="card-header bg-primary text-white">
               <h2 class="text-center">Book Flight Ticket for Flight Number: ${flightNumber}</h2>
            </div>
            <div class="card-body">
               <c:url var="book_flight_url" value="/flight-service/user/reservation/seat"/>
               <form:form action="${book_flight_url}" method="post" modelAttribute="bookingInfoClientRequest" >
                  <div class="form-group">
                     <label for="flightId">Flight Id:</label>
                     <form:input type="text" class="form-control" path="flightId" value="${flightId}" />
                  </div>
                  <div class="form-group">
                     <label for="passengerName">Passenger Name:</label>
                     <form:input type="text" class="form-control" path="passengerName" />
                  </div>
                  <div class="form-group">
                     <label for="passengerPhone">Your Phone Number:</label>
                     <form:input type="text" class="form-control" path="passengerPhone" />
                  </div>
                  <div class="form-group">
                     <label for="country">Your Country:</label>
                     <form:input type="text" class="form-control" path="country" />
                  </div>
                  <div class="form-group">
                     <label for="age">Your Age:</label>
                     <form:input type="text" class="form-control" path="age" />
                  </div>
                  <div class="form-group">
                     <label for="gender">Gender:</label>
                     <form:select class="form-control" required="true" path="gender">
                        <option value="" disabled selected>Select Your Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Transgender">Transgender</option>
                     </form:select>
                  </div>
                  <div class="text-center">
                     <button type="submit" class="btn btn-primary">Book Ticket</button>
                     <button type="reset" class="btn btn-warning">Reset</button>
                  </div>
               </form:form>
            </div>
         </div>
      </div>
   </div>
</section>
