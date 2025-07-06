<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<div class="container-fluid py-5">
 <section class="bg-light d-flex justify-content-center align-items-center">
   <div class="container">
     <div class="row">
       <div class="col-md-6 offset-md-3">
         <div class="my-card mt-4 mb-3">
           <h1 class="text-center">Register Here !!</h1>
           <span class="text-danger">(*) Asterisk denotes mandatory fields</span>
           <form action="/flight-service/user/register" method="post" modelAttribute="userDto">
             <!--  name field -->
             <div class="form-group">
               <label for="name_field"> Name<span class="text-danger">*</span></label>
               <input
                       name="name"
                       type="text"
                       class="form-control"
                       id="name_field"
                       aria-describedby="emailHelp"
                       placeholder="Enter here"
                       required
                       value="${userDto.name}"
               />


             </div>
             <!-- email field -->
             <div class="form-group">
               <label for="email_field">Your Email<span class="text-danger">*</span></label>
               <input
                       name="email"
                       type="email"
                       class="form-control"
                       id="email_field"
                       aria-describedby="emailHelp"
                       placeholder="Enter here"
                       required
                       value="${userDto.email}"
               />

             </div>
             <!-- phone number field -->
             <div class="form-group">
               <label for="phone_field">Your Phone Number</label>
               <input
                       name="phone"
                       type="tel"
                       class="form-control"
                       id="phone_field"
                       aria-describedby="emailHelp"
                       placeholder="Enter here"
                       value="${userDto.phoneNo}"
               />

             </div>
             <!-- password field -->
             <div class="form-group">
               <label for="password_field">Password <span class="text-danger">*</span></label>
               <input
                       name="password"
                       type="password"
                       class="form-control"
                       id="password_field"
                       aria-describedby="emailHelp"
                       placeholder="Enter here"
                       required
                       value="${userDto.password}"
               />

             </div>

             <div class="container text-center" style="margin-bottom: 20px;">
               <button type="submit" class="btn bg-primary text-white">
                 Submit
               </button>
               <button type="reset" class="btn btn-warning">
                 Reset
               </button>
             </div>
           </form>
         </div>
       </div>
     </div>
   </div>
 </section>
</div>
<% request.setAttribute("content", "user-registration.jsp"); %>