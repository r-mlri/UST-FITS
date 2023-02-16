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
  <title>Homepage</title>
  
  <!-- Stylesheet -->
  <link href="../css/a1.css" rel="stylesheet" type="text/css">
  
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
  
  
  
  
  
  
  
  
  
  
  
   <div class="form-container">
      <form>
  <div style="display:flex;">
    <div style="flex:1;">
	  <br>
      <label>Student Number:</label>
      <br>
      <br>
      <input type="text" name="student_number">
      <br>
      <input type="submit" value="Record Exit">
    </div>
    <div style="flex:1;">
      <label>Equipment:</label>
      <br>
      <input type="checkbox" name="equipment_1">Equipment 1
      <br>
      <input type="checkbox" name="equipment_2">Equipment 2
      <br>
      <input type="checkbox" name="equipment_3">Equipment 3
      <br>
      <input type="checkbox" name="equipment_4">Equipment 4
      <br>
      <input type="checkbox" name="equipment_5">Equipment 5
      <br>
      <input type="checkbox" name="equipment_6">Equipment 6
      <br>
      <input type="checkbox" name="equipment_7">Equipment 7
      <br>
      <input type="checkbox" name="equipment_8">Equipment 8
      <br>
      <input type="checkbox" name="equipment_9">Equipment 9
      <br>
      <input type="checkbox" name="equipment_10">Equipment 10
      <br>
    </div>
  </div>
</form>
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
