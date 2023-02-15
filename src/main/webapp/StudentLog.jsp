<%-- 
    Document   : index
    Created on : 01 30, 23, 10:36:01 AM
    Author     : Jayvee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>StudentLog</title>
   <style>
  
    /* Add styles for the header */
    header {
      background-color: #333;
      color: #fff;
      display: flex;
      align-items: center;
      height: 50px;
      padding: 0 20px;
      position: fixed;
      top: 0;
      width: 100%;
      z-index: 1;
    }
    /* Add styles for the hamburger menu */
    .menu-toggle {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 50px;
      width: 50px;
      background-color: #333;
      color: #fff;
      cursor: pointer;
    }
    /* Add styles for the icon */
    span {
      font-size: 20px;
      margin-right: 20px;
    }
    /* Hide the menu by default */
    nav {
      display: none;
      background-color: #333;
      color: #fff;
      position: fixed;
      top: 50px;
      left: 0;
      bottom: 0;
      width: 200px;
    }
    /* Show the menu when the hamburger menu is clicked */
    .show-menu {
      display: block;
    }
    /* Add styles for the menu items */
    nav a {
      display: block;
      padding: 20px;
      color: #fff;
      text-decoration: none;
    }
    /*  FOR BACKGROUND PURPOSES
    .picture-container {
      background-image: url("ipeapic.jpg");
      background-size: contain;
      height: calc(100% - 50px - 3px);
      position: fixed;
      top: 53px;
      width: 100%;
      z-index: -1; 
    }*/
    /* Add styles for the footer */
    footer {
      background-color: #333;
      color: #fff;
      display: flex;
      align-items: center;
      height: 50px;
      justify-content: center;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
    /* Add styles for the yellow line under the header */
    .header-line {
      background-color: #ff0;
      height: 3px;
      width: 100%;
      position: fixed;
      top: 50px;
      z-index: 0;
    }
      .form-container {
        background-color: yellow;
        width: 300px;
        height: 230px;
        margin: 100px auto;
        padding: 20px;
        border: 2px solid black;
        text-align: center;
        font-family: Arial, sans-serif;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.25);
      }
      input[type="text"], input[type="password"], select {
        padding: 10px;
        font-size: 14px;
        margin: 10px;
        width: 90%;
        box-sizing: border-box;
        border-radius: 5px;
      }
      input[type="submit"] {
        padding: 10px 20px;
        font-size: 14px;
        background-color: black;
        color: white;
        border: none;
        cursor: pointer;
        margin-top: 20px;
        border-radius: 5px;
      }
  </style>
</head>
<body>
  <header>
    <!-- Add the hamburger menu -->
    <div class="menu-toggle">
      &#9776;
    </div>
    <!-- Add an icon to the header -->
    <span>&#128214;</span>
    <nav>
      <!-- Add the menu options -->
      <a href="Index.jsp">Home</a>
      <a href="#">Equipments</a>
      <a href="#">Trainers</a>
      <a href="StudentLog.jsp">Student Log</a>
      <a href="StudentExit.jsp">Student Exit</a>
      <a href="Login.jsp">Personnel Login</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
  
  
  
  
  
  
  
  
  
  
   <div class="form-container">
      <h1>Student Log</h1>
      <form action="">
        <form action ="<%= request.getContextPath() %>/StudentLog" method="get"action="studentLogServlet">
             <input type="number" name= "SN" class="input-field" placeholder="Student Number" required>
        <input type="submit" value="Log"> 
      </form>
    </div>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!-- Add the footer -->

  <footer>
    University of Santo Tomas ©2023
  </footer>

  <script>
    // Add JavaScript to toggle the menu
    const menuToggle = document.querySelector('.menu-toggle');
    const menu = document.querySelector('nav');
    menuToggle.addEventListener('click', () => {
      menu.classList.toggle('show-menu');
    });
  </script>
</body>
</html>
