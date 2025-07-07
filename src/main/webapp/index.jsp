<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>HexaShield Insurance</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap & Fonts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <link rel="icon" href="images/icon.jpg">

  <style>
    html, body {
      height: 100%;
      margin: 0;
      font-family: 'Poppins', sans-serif;
    }

    body {
      display: flex;
      flex-direction: column;
      background: url('images/hero.jpg') no-repeat center center fixed;
      background-size: cover;
      position: relative;
    }

    .overlay {
      position: fixed;
      top: 0; left: 0;
      width: 100%; height: 100%;
      background-color: rgba(255, 255, 255, 0.25);
      z-index: 0;
    }

    .navbar {
      z-index: 2;
    }

    .main-content {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      z-index: 2;
    }

	.hero-card {
	  background: rgba(255, 255, 255, 0.95);
	  padding: 35px 40px;
	  border-radius: 15px;
	  box-shadow: 0 10px 30px rgba(0,0,0,0.1);
	  max-width: 700px;
	  width: 90%;
	}
	.hero-card h1 {
	  font-size: 2.5rem;
	  font-weight: 700;
	  color: #0d47a1;
	}
	.hero-card p {
	  font-size: 1.1rem;
	  color: #555;
	}

    .hero-btns {
      margin-top: 30px;
    }

    .btn-custom-primary {
	  background: #2196F3;
	  padding: 10px 25px;
	  border-radius: 30px;
	  font-weight: 600;
	  border: none;
	}

    .btn-custom-primary:hover {
      box-shadow: 0 8px 24px rgba(66, 165, 245, 0.4);
      transform: translateY(-2px);
    }

	.btn-custom-outline {
	  border: 2px solid #2196F3;
	  color: #2196F3;
	  padding: 10px 25px;
	  border-radius: 30px;
	  background-color: transparent;
	}

    .btn-custom-outline:hover {
      background-color: #42a5f5;
      color: white;
      transform: translateY(-2px);
    }

    .footer {
      background-color: rgba(255, 255, 255, 0.8);
      text-align: center;
      padding: 15px 0;
      font-size: 14px;
      color: #333;
      z-index: 2;
    }
  </style>
</head>
<body>

<!-- Background Overlay -->
<div class="overlay"></div>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm position-relative">
  <div class="container-fluid px-4">
    <a class="navbar-brand fw-bold text-primary" href="index.jsp">HexaShield</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link fw-semibold" href="registerPage">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fw-semibold" href="loginPage">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Hero Content -->
<div class="main-content">
  <div class="hero-card">
    <h1>Welcome to HexaShield</h1>
    <p>Smart, reliable, and secure insurance for your vehicles. Join the community of drivers who trust us.</p>
    <div class="hero-btns d-flex justify-content-center gap-3 flex-wrap">
      <a href="registerPage" class="btn btn-custom-primary">Get Started</a>
      <a href="loginPage" class="btn btn-custom-outline">Login</a>
    </div>
  </div>
</div>

<!-- Sticky Footer -->
<div class="footer">
  &copy; 2025 HexaShield Insurance. All rights reserved.
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
