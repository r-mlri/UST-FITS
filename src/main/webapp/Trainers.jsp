Trainers page.txt
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
  <title>Trainer's page</title>
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
    /*				for bg picx
    .picture-container {
      background-image: url("ipeapic.jpg");
      background-size: contain;
      height: calc(100% - 50px - 3px);
      position: fixed;
      top: 53px;
      width: 100%;
      z-index: -1;
    }                                             */
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
 .rectangle {
        position: relative;
        width: 600px;
        height: 300px;
        margin: 50px auto;
        background-color: yellow;
        border: 2px solid #333;
        display: flex;
        align-items: center;
        justify-content: center;
        border-radius: 50px;
      }

      /* Fix the image to the left side */
      .rectangle .image {
        width: 200px;
        height: 200px;
        background-color: #ccc;
        position: absolute;
        left: 25px;
        border-radius: 100px;
        border: 1px solid black;
      }

      /* Style the name, specialty, and sport placeholders */
      .rectangle .placeholder {
        margin: 10px 0;
        font-size: 20px;
        font-weight: bold;
        text-align: left;
        color: #333;
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
      <a href="#">Home</a>
      <a href="#">Equipments</a>
      <a href="#">Trainers</a>
      <a href="#">Student Log</a>
      <a href="#">Student Exit</a>
      <a href="Login.jsp">Personnel Login</a>
    </nav>
  </header>
  
  <!-- Add the yellow line under the header -->
  <div class="header-line"></div>
  
  <div class="picture-container"></div>
  
  
  
  <!-- CONTENTS IN THE MIDDLE OF THE WEBPAGE HERE -->
  
   <div class="rectangle">
      <div class="image"></div>
      <div style="margin-left: 150px;">
        <div class="placeholder" id="name">Name:</div>
        <div class="placeholder" id="specialty">Specialty:</div>
        <div class="placeholder" id="sport">Sport:</div>
      </div>
    </div>
    
    <div class="rectangle">
      <div class="image"></div>
      <div style="margin-left: 150px;">
        <div class="placeholder" id="name">Name:</div>
        <div class="placeholder" id="specialty">Specialty:</div>
        <div class="placeholder" id="sport">Sport:</div>
      </div>
    </div>
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!-- Add the footer -->

  <footer>
      <%@include  file="../headcoda/footer.jsp"%>
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