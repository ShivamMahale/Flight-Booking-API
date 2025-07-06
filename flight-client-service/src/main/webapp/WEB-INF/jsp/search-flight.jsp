<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="base.jsp" %>
<section class="bg-light d-flex justify-content-between p-5">
  <div class="container-fluid">
  <h1 class="text-center py-5">Search Your Flight Here !!</h1>
  <div class="justify-content-between ">
        <c:url var="search_flight_url" value="/flight-service/search"/>
        <form:form class="text-center" action="${search_flight_url}" method="post" modelAttribute="searchFlight">

            <form:label class="p-2" path="from">Origin City: </form:label>
            <form:select type="text" required="true" path="from">
                    <option value="" disabled selected>Select Your City</option>
                     <c:forEach items="${options}" var="option">
                           <option value="${option}">${option}</option>
                     </c:forEach>
             </form:select>

            <form:label class="p-2" path="to">Destination City: </form:label>
            <form:select type="text" required="true" path="to">
                                 <option value="" disabled selected>Select Your City</option>
                                 <c:forEach items="${options}" var="option">
                                       <option value="${option}">${option}</option>
                                 </c:forEach>
             </form:select>

            <form:label class="p-2" path="date">Departure Date: </form:label> <form:input type="date" required="true" path="date"/>

        <div class="container text-center py-5" style="margin-bottom: 20px;">
         <button type="submit" class="btn bg-primary text-white">
            Submit
         </button>
         <button type="reset" class="btn btn-warning">
            Reset
          </button>
           </div>
        </form:form>
     </div>
   </div>
</section>

<section class="text-center py-5">
<h3 class="p-3">Search Google Map</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m28!1m12!1m3!1d1901559.5876998934!2d85.77433386995439!3d21.42989079344397!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m13!3e3!4m5!1s0x39f882db4908f667%3A0x43e330e68f6c2cbc!2sKolkata%2C%20West%20Bengal!3m2!1d22.572646!2d88.363895!4m5!1s0x3a1909d2d5170aa5%3A0xfc580e2b68b33fa8!2sBhubaneswar%2C%20Odisha!3m2!1d20.2960587!2d85.8245398!5e0!3m2!1sen!2sin!4v1709062422782!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</section >

<% request.setAttribute("content", "search-flight.jsp"); %>