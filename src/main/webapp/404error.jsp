<%-- 
    Document   : index
    Created on : 01 30, 23, 10:36:01 AM
    Author     : Jayvee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>	
	<title>Error 404</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #F9E660;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }
    
    .error-container {
      background-color: #FFF;
      border-radius: 10px;
      box-shadow: 0px 0px 10px #BDBDBD;
      padding: 50px;
      text-align: center;
      max-width: 500px;
    }
    
    h1 {
      font-size: 42px;
      color: #F8BB10;
      margin-bottom: 30px;
    }
    
    p {
      font-size: 18px;
      color: #333;
      margin-bottom: 30px;
    }
    
    button {
      background-color: #F8BB10;
      border: none;
      border-radius: 10px;
      color: #FFF;
      padding: 10px 20px;
      font-size: 18px;
      cursor: pointer;
      box-shadow: 0px 0px 10px #BDBDBD;
    }
  </style>
</head>
<body>
  <div class="error-container">
    <h1>404 Error</h1>
    <p>The page you are looking for does not exist or has been moved.</p>
    <button href="index.jsp">Go Back</button>
  </div>
</body>
</html>