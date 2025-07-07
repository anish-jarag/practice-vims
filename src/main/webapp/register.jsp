<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register - HexaShield</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap & Google Fonts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <link href="images/icon.jpg" rel="icon">

  <style>
    body {
      font-family: 'Poppins', sans-serif;
      margin: 0;
      background: #f1f8ff;
      min-height: 100vh;
      display: flex;
      flex-direction: column;
    }

    .bg-cover {
      background: url('https://images.unsplash.com/photo-1581092789890-ff16b986c293?auto=format&fit=crop&w=1400&q=80') no-repeat center center fixed;
      background-size: cover;
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 30px;
      position: relative;
    }

    .overlay {
      position: absolute;
      top: 0; left: 0;
      width: 100%; height: 100%;
      background-color: rgba(255, 255, 255, 0.8);
      z-index: 0;
    }

    .form-container {
      position: relative;
      z-index: 1;
      background-color: #ffffffcc;
      backdrop-filter: blur(10px);
      padding: 45px 40px;
      border-radius: 20px;
      max-width: 600px;
      width: 100%;
      box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
    }

    h3 {
      font-weight: 600;
      text-align: center;
      color: #0d47a1;
      margin-bottom: 30px;
    }

    .form-control {
      border: none;
      border-bottom: 2px solid #ccc;
      border-radius: 0;
      background: transparent;
      box-shadow: none;
      transition: border-color 0.3s;
    }

    .form-control:focus {
      border-color: #42a5f5;
      box-shadow: none;
    }

    label.form-label {
      font-weight: 500;
      color: #333;
    }

    .btn-gradient {
      background: linear-gradient(45deg, #42a5f5, #478ed1);
      color: white;
      font-weight: 600;
      border: none;
      border-radius: 30px;
      padding: 10px 30px;
      transition: 0.3s ease;
    }

    .btn-gradient:hover {
      background: linear-gradient(45deg, #478ed1, #42a5f5);
      box-shadow: 0 4px 12px rgba(66, 165, 245, 0.4);
    }

    .btn-reset {
      border-radius: 30px;
      font-weight: 600;
      padding: 10px 30px;
    }

    .alert {
      font-size: 0.95rem;
    }

    .navbar-brand {
      font-weight: 600;
    }
  </style>
</head>
<body>

<!-- Background & Overlay Layer -->
<div class="bg-image"></div>
<div class="overlay"></div>

<!-- Navbar -->
<nav class="navbar navbar-expand-sm bg-white shadow-sm position-relative" style="z-index: 2;">
  <div class="container-fluid">
    <a class="navbar-brand text-primary fw-bold" href="index.jsp">HexaShield</a>
    <div class="collapse navbar-collapse justify-content-end">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active fw-semibold" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fw-semibold" href="login.jsp">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Form Section -->
<div class="d-flex align-items-center justify-content-center vh-100 position-relative" style="z-index: 2;">
  <div class="form-container">
    <h3>Create Your HexaShield Account</h3>

    <c:if test="${not empty error}">
      <div class="alert alert-danger text-center">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
      <div class="alert alert-success text-center">${message}</div>
    </c:if>

    <form action="register" method="post" class="needs-validation" novalidate>
      <div class="mb-3">
        <label class="form-label">Full Name</label>
        <input type="text" class="form-control" name="name" placeholder="Your full name" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Email Address</label>
        <input type="email" class="form-control" name="email" placeholder="you@example.com" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Choose a password" required minlength="6">
      </div>

      <div class="mb-3">
        <label class="form-label">Date of Birth</label>
        <input type="date" class="form-control" name="dob" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Aadhaar Number</label>
        <input type="text" class="form-control" name="aadhaar" placeholder="12-digit Aadhaar" required pattern="\d{12}">
      </div>

      <div class="mb-3">
        <label class="form-label">PAN Number</label>
        <input type="text" class="form-control" name="pan" placeholder="Your PAN" maxlength="10" required>
      </div>

      <div class="d-flex justify-content-between mt-4">
        <button type="submit" class="btn btn-gradient">Register</button>
        <button type="reset" class="btn btn-outline-secondary btn-reset">Reset</button>
      </div>
    </form>
  </div>
</div>

<!-- Background Styling -->
<style>
  body, html {
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

  .form-container {
    background-color: rgba(255, 255, 255, 0.95);
    padding: 40px;
    border-radius: 20px;
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
    max-width: 600px;
    width: 90%;
  }

  h3 {
    font-weight: 600;
    text-align: center;
    color: #0d47a1;
    margin-bottom: 25px;
  }

  .btn-gradient {
    background: linear-gradient(45deg, #42a5f5, #478ed1);
    color: white;
    font-weight: 600;
    border: none;
    border-radius: 30px;
    padding: 10px 30px;
    transition: 0.3s ease;
  }

  .btn-gradient:hover {
    background: linear-gradient(45deg, #478ed1, #42a5f5);
    box-shadow: 0 4px 12px rgba(66, 165, 245, 0.4);
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

<!-- Bootstrap JS and Validation -->
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
