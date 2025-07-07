<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard - VIMS</title>
    <!-- Bootstrap & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: #f0f6ff;
            font-family: 'Segoe UI', sans-serif;
        }

        .content {
            margin-left: 270px;
            padding: 40px;
        }

        .card {
            border: none;
            border-radius: 12px;
            padding: 25px;
            background: #fff;
            box-shadow: 0 4px 18px rgba(0,0,0,0.08);
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: translateY(-4px);
        }

        .card h5 {
            color: #6610f2;
            font-weight: 600;
        }

        .card i {
            font-size: 28px;
            color: #6610f2;
            margin-bottom: 10px;
        }

        h3 {
            color: #333;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
    <jsp:include page="/user/user_sidebar.jsp" />


    <!-- Content -->
    <div class="content">
        <div class="container-fluid">
            <h3>Welcome, <c:out value="${user.name}" default="User" />!</h3>
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-car"></i>
                        <h5>My Vehicles</h5>
                        <p>View and manage your registered vehicles.</p>
                        <a href="/vehiclePage" class="btn btn-outline-primary">Manage Vehicles</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-file-alt"></i>
                        <h5>Submit Proposal</h5>
                        <p>Start a new vehicle insurance proposal.</p>
                        <a href="/proposalPage" class="btn btn-outline-success">Submit Now</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-shield-alt"></i>
                        <h5>My Policies</h5>
                        <p>Track approved policies and validity.</p>
                        <a href="/myPolicies" class="btn btn-outline-info">View Policies</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card text-center">
                        <i class="fas fa-file-upload"></i>
                        <h5>Upload Documents</h5>
                        <p>Submit required documents for processing.</p>
                        <a href="/documents" class="btn btn-outline-secondary">Upload Now</a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card text-center">
                        <i class="fas fa-bell"></i>
                        <h5>Notifications</h5>
                        <p>Stay updated with alerts and updates.</p>
                        <a href="/notifications" class="btn btn-outline-warning">View Alerts</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
