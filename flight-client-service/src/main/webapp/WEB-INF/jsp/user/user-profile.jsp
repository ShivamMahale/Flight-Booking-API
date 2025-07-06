<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="base-user.jsp" %>

 <!-- Hero Section -->
 <section id="hero" class="bg-dark text-white text-center py-5">
   <div class="container">
     <h1 class="display-4 font-weight-bold pt-3">Welcome ${userName}</h1>
     <p class="lead">Explore our wide range of service</p>
   </div>
 </section>

<section class="container my-card py-3 d-flex justify-content-center align-items-center">
  <h1 class="text-center">Your Booking History !! </h1>
  </section>
        <div class="container">
               <table class="table table-striped">
                   <thead>

                       <tr>
                           <th>Ticket Number</th>
                           <th>Name </th>
                           <th>Phone</th>
                           <th>Age</th>
                           <th>Gender</th>
                           <th>Country</th>
                           <th>Origin</th>
                           <th>Destination</th>
                           <th>Airline</th>
                           <th>Price</th>
                           <th>Booking Date</th>
                           <th>Flight Number</th>
                           <th>Departure Time</th>

                       </tr>
                   </thead>
                   <tbody>
                       <c:forEach items="${bookings}" var="booking">
                           <tr>
                                <td><c:out value="${booking.bookingId}" /></td>
                                <td><c:out value="${booking.passengerName}" /></td>
                                <td><c:out value="${booking.passengerPhone}" /></td>
                                <td><c:out value="${booking.age}" /></td>
                                <td><c:out value="${booking.gender}" /></td>
                                <td><c:out value="${booking.country}" /></td>
                               <td><c:out value="${booking.originCity}" /></td>
                                <td><c:out value="${booking.destinationCity}" /></td>
                               <td><c:out value="${booking.airline}" /></td>
                               <td><c:out value="${booking.ticketPrice}" /></td>
                               <td><c:out value="${booking.bookingDate}" /></td>
                               <td><c:out value="${booking.flightNumber}" /></td>
                               <td><c:out value="${booking.dateOfDeparture}" /></td>

                       </c:forEach>
                   </tbody>
               </table>
           </div>

           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jrtnyoQ5htLWZ4jNDaxRQ8zHrgrte" crossorigin="anonymous"></script>
<% request.setAttribute("content", "user-profile.jsp"); %>