<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gamazon.com</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}

body, html {
  height: 100%;
  line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("{% static 'gamazon/bg1.jpg'%}");
  min-height: 100%;
}

.w3-bar .w3-button {
  padding: 16px;
}

/*body {font-family: Arial, Helvetica, sans-serif;}*/

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  /*background-color: rgb(0,1,0);*/
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}


.container {
  padding: 16px;
}

span.psw {
  float: right;
  /*padding-top: 16px;*/
}
span.reg{
	float: right;
	padding-top: 20px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 330px;
  top: 0;
  width: 50%; /* Full width */
  height: 100%; /* Full height */
  /*overflow: auto;*/ /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)}
  to {-webkit-transform: scale(1)}
}

@keyframes animatezoom {
  from {transform: scale(0)}
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>

</head>
<body>

<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar">
    <a href="${pageContext.request.contextPath}/ " class="w3-bar-item w3-button w3-wide">HOME</a>
    <a href="${pageContext.request.contextPath}/products" class="w3-bar-item w3-button w3-wide"><i class="fa fa-gamepad" ></i>PRODUCTS</a>

     <security:authorize access="hasRole('CUSTOMER')">
     <a href="${pageContext.request.contextPath}/cart" class="w3-bar-item w3-button w3-wide"><i class="fa fa-shopping-cart" ></i> CART</a>
     </security:authorize>

    <!-- Right-sided navbar links -->

    <div class="w3-right w3-hide-small">
    <security:authorize access="isAuthenticated()">
    <span class="w3-bar-item w3-button">Hello, <security:authentication property="principal.username"/></span>
    <a href="javascript:;" onclick="document.getElementById('form1').submit();" class="w3-bar-item w3-button "><i class="fa fa-sign-out" aria-hidden="true" ></i>LOGOUT</a>
    </security:authorize>


    <security:authorize access="!isAuthenticated()">
      <span class="w3-bar-item w3-button " onclick="location.href = '/customLogin';" style="width:auto;"><i class="fa fa-sign-in" aria-hidden="true" ></i> SIGN IN</span>
     </security:authorize>
     </div>
  </div>
</div>


<form:form id="form1" action="${pageContext.request.contextPath}/logout" method="POST" style="display:none;visibility:hidden;">
</form:form>
<div class="w3-container" style="padding:128px 16px" id="about">
        <h3 class="w3-center">HELLO</h3><br>
        <h3 class="w3-center">Welcome to Gamazon</h3><br>
        <div class="w3-large w3-center">Stop wasting time by doing boring stuff in life .
        <p><a href="${pageContext.request.contextPath}/products" class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Play more </a></p>
        </div>
</div>
</body>
</html>