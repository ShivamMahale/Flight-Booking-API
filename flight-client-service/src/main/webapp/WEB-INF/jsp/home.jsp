<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="base.jsp" %>

<section id="hero" class="bg-dark text-white text-center py-5">
   <div class="container">
    <img src="https://static.tnn.in/photo/msid-100330206,width-100,height-200,resizemode-75/100330206.jpg" width="50" height="350" class="card-img-top" alt="...">
     <h1 class="display-4 font-weight-bold pt-3">Welcome to Cloud Touch App</h1>
     <p class="lead">Explore our wide range of services</p>
   </div>
 </section>

<section class="container-fluid mt-5">
    <div class="row">
        <div class="col-md-3">
            <h2 class="text-center mb-4">Airline Catalog</h2>
            <div class="separator"></div>
            <div class="list-group">
                <a href="/flight-service/search" class="list-group-item list-group-item-action">SpiceJet</a>
                <a href="/flight-service/search" class="list-group-item list-group-item-action">IndiGo</a>
                <a href="/flight-service/search" class="list-group-item list-group-item-action">Air India</a>
                <a href="/flight-service/search" class="list-group-item list-group-item-action">Vistara</a>
            </div>
        </div>
        <div class="col-md-9">
            <h2 class="text-center mb-4">Today's Offers</h2>
            <div class="separator"></div>
            <div class="row">
                <div class="col-md-6">
                    <div class="card mb-4 h-100">
                        <img src="https://www.savethestudent.org/uploads/flights.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">SpiceJet</h5>
                            <p><b>Rs 62,990.00</b></p>
                            <a href="/flight-service/search" class="btn btn-primary">Book Now</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card mb-4 h-100">
                        <img src="https://static.tnn.in/photo/msid-100330206,width-100,height-200,resizemode-75/100330206.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">IndiGo</h5>
                            <p><b>Rs 119999</b></p>
                            <a href="/flight-service/search" class="btn btn-primary">Book Now</a>
                        </div>
                    </div>
                </div>
                <!-- Add other airline cards in similar fashion -->
                <div class="col-md-6">
                    <div class="card mb-4 h-100">
                        <img src="https://m.economictimes.com/thumb/msid-105635228,width-1200,height-900,resizemode-4,imgsize-31938/vistara.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Vistara</h5>
                            <p><b>Rs 42,990.00</b></p>
                            <a href="/flight-service/search" class="btn btn-primary">Book Now</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card mb-4 h-100">
                        <img src="https://d12aarmt01l54a.cloudfront.net/cms/images/Media-20230419120946/808-440.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Air India</h5>
                            <p><b>Rs 119999</b></p>
                            <a href="/flight-service/search" class="btn btn-primary">Book Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<% request.setAttribute("content", "home.jsp"); %>
