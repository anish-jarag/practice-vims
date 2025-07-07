<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Users - HexaShield Admin</title>
    <!-- Bootstrap & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <style>
        body {
            background: linear-gradient(to right, #e6f0ff, #f7faff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .content {
            margin-left: 270px;
            padding: 40px;
        }

        .table-container {
            background: white;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
        }

        h2 {
            color: #0d6efd;
            margin-bottom: 25px;
        }

        th {
            background-color: #0d6efd;
            color: white;
        }

        .search-bar {
            margin-bottom: 20px;
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
    <script>
        function filterTable() {
            var input = document.getElementById("searchInput");
            var filter = input.value.toLowerCase();
            var rows = document.querySelectorAll("#userTable tbody tr");
            rows.forEach(row => {
                const visible = Array.from(row.cells).some(td => td.textContent.toLowerCase().includes(filter));
                row.style.display = visible ? "" : "none";
            });
        }
    </script>
</head>
<body>

<!-- Sidebar -->
<jsp:include page="/admin/admin_sidebar.jsp" />

<!-- Main Content -->
<div class="content">
    <div class="container table-container">
        <h2>Registered Users</h2>
        <input type="text" id="searchInput" onkeyup="filterTable()" class="form-control search-bar" placeholder="Search users by name, email or role...">
		
        <table class="table table-bordered table-hover" id="userTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>DOB</th>
                    <th>Aadhaar</th>
                    <th>PAN</th>
                    <th>Role</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.dob}</td>
                        <td>${user.aadhaar}</td>
                        <td>${user.pan}</td>
                        <td>${user.role}</td>
                        <td>${user.createdAt}</td>
                        <td>
						    <a href="${pageContext.request.contextPath}/editUser/${user.userId}" class="btn btn-sm btn-outline-warning">
						        <i class="fas fa-edit"></i> Edit
						    </a>
						    <a href="${pageContext.request.contextPath}/deleteUser/${user.userId}" class="btn btn-sm btn-outline-danger"
						       onclick="return confirm('Are you sure you want to delete this user?');">
						        <i class="fas fa-trash"></i> Delete
						    </a>
						</td>
                    </tr>
                </c:forEach>
                
                
            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
