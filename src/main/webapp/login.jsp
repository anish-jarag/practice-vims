<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login - HexaShield</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap & Fonts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <link href="images/icon.jpg" rel="icon">

  <style>
    html, body {
      height: 100%;
      margin: 0;
      font-family: 'Poppins', sans-serif;
    }

    .bg-image {
      position: fixed;
      top: 0;
      left: 0;
      background: url('images/hero.jpg') no-repeat center center fixed;
      background-size: cover;
      height: 100%;
      width: 100%;
      z-index: 0;
    }

    .overlay {
      position: fixed;
      top: 0;
      left: 0;
      height: 100%;
      width: 100%;
      background-color: rgba(255, 255, 255, 0.7);
      z-index: 1;
    }

    .navbar {
      z-index: 2;
    }

    .main-content {
      position: relative;
      z-index: 2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
    }

    .login-card {
      background-color: rgba(255, 255, 255, 0.95);
      backdrop-filter: blur(10px);
      padding: 40px;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
      width: 90%;
      max-width: 400px;
    }

    .login-card h3 {
      text-align: center;
      font-weight: 600;
      color: #0d47a1;
      margin-bottom: 25px;
    }

    .btn-gradient {
      background: linear-gradient(45deg, #2196f3, #64b5f6);
      border: none;
      color: white;
      font-weight: 600;
      border-radius: 30px;
      padding: 10px 25px;
      transition: 0.3s ease-in-out;
    }

    .btn-gradient:hover {
      background: linear-gradient(45deg, #64b5f6, #2196f3);
      box-shadow: 0 4px 12px rgba(33, 150, 243, 0.3);
    }

    .register-link {
      display: block;
      margin-top: 15px;
      text-align: center;
      font-size: 0.95rem;
    }

    .form-control {
      border: none;
      border-bottom: 2px solid #ccc;
      border-radius: 0;
      background: transparent;
      transition: border-color 0.3s;
    }

    .form-control:focus {
      border-color: #42a5f5;
      box-shadow: none;
    }
  </style>
</head>
<body>

<!-- Background -->
<div class="bg-image"></div>
<div class="overlay"></div>

<!-- Navbar -->
<nav class="navbar navbar-expand-sm bg-white shadow-sm position-relative">
  <div class="container-fluid">
    <a class="navbar-brand text-primary fw-bold" href="index.jsp">HexaShield</a>
    <div class="collapse navbar-collapse justify-content-end">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link fw-semibold" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active fw-semibold" href="login.jsp">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Login Card -->
<div class="main-content">
  <div class="login-card">
    <h3>Welcome Back</h3>

    <c:if test="${not empty error}">
      <div class="alert alert-danger text-center">${error}</div>
    </c:if>

    <form action="login" method="post" class="needs-validation" novalidate>
      <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" placeholder="Enter email" required>
      </div>
      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Enter password" required>
      </div>
      <div class="d-grid">
        <button type="submit" class="btn btn-gradient">Login</button>
      </div>
      <a class="register-link" href="register.jsp">Don't have an account? <strong>Register</strong></a>
    </form>
  </div>
</div>

<!-- Bootstrap JS Validation -->
<script>
(() => {
  'use strict';
  const forms = document.querySelectorAll('.needs-validation');
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.classList.add('was-validated');
    }, false);
  });
})();
</script>

</body>
</html>
