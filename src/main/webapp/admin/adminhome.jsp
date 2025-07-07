<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HexaShield Admin</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <style>
        body {
            background: linear-gradient(to right, #e6f0ff, #f7faff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
		
		.logout {
            position: absolute;
            bottom: 20px;
            left: 30px;
            color: #ffc107;
        }

        .content {
            margin-left: 270px;
            padding: 40px 30px;
        }

        .card {
            border: none;
            border-radius: 16px;
            padding: 25px;
            background: rgba(255, 255, 255, 0.95);
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-4px);
            box-shadow: 0 10px 30px rgba(0,0,0,0.15);
        }

        .card h4 {
            font-weight: 600;
            color: #0d6efd;
        }

        .card i {
            font-size: 30px;
            margin-bottom: 15px;
            color: #0d6efd;
        }

        .btn {
            font-weight: 500;
        }

        @media screen and (max-width: 768px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }
            .content {
                margin-left: 0;
                padding: 20px;
            }
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
    <jsp:include page="/admin/admin_sidebar.jsp" />

    <!-- Main Content -->
    <div class="content">
        <div class="container">
        <h3>Welcome, <c:out value="${user.name}" default="Admin"/>!</h3>
            <div class="row g-4">
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-users"></i>
                        <h4>Users Overview</h4>
                        <p>Manage users, view profiles and proposal history.</p>
                        <a href="/viewUsers" class="btn btn-outline-primary">Go to Users</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-file-signature"></i>
                        <h4>Proposals</h4>
                        <p>Review, approve or reject insurance proposals.</p>
                        <a href="/manageProposals" class="btn btn-outline-success">Manage Proposals</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-center">
                        <i class="fas fa-credit-card"></i>
                        <h4>Payments</h4>
                        <p>Track and validate premium payments from users.</p>
                        <a href="/viewPayments" class="btn btn-outline-info">View Payments</a>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card text-center">
                        <i class="fas fa-file-invoice"></i>
                        <h4>Reports</h4>
                        <p>Generate monthly policy, claim, and payment reports.</p>
                        <a href="/generateReports" class="btn btn-outline-warning">View Reports</a>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card text-center">
                        <i class="fas fa-folder-open"></i>
                        <h4>Document Requests</h4>
                        <p>Verify user-uploaded documents for proposals.</p>
                        <a href="/viewDocuments" class="btn btn-outline-secondary">Check Documents</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
