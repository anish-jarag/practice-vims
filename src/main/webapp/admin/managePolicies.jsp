<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Policies - Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f0f4ff;
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            margin-left: 270px;
            padding: 40px;
        }
        .form-container {
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            margin-bottom: 30px;
        }
        h2 {
            color: #0d6efd;
        }
    </style>
</head>
<body>

<jsp:include page="admin_sidebar.jsp" />

<div class="container">
    <h2>Manage Policy Types</h2>
	
    <!-- Form -->
    <div class="form-container">
        <form method="post" action="${pageContext.request.contextPath}/admin/addPolicyType">
            <div class="mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label>Description</label>
                <textarea name="description" class="form-control" required></textarea>
            </div>
            <div class="mb-3">
                <label>Base Premium (₹)</label>
                <input type="number" name="basePremium" class="form-control" required min="0"/>
            </div>
            <button type="submit" class="btn btn-primary">Add Policy</button>
        </form>
    </div>

    <!-- List -->
    <table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Base Premium</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="policy" items="${policyTypes}">
            <tr>
                <td>${policy.policyTypeId}</td>
                <td>${policy.name}</td>
                <td>${policy.description}</td>
                <td>${policy.basePremium}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/deletePolicyType/${policy.policyTypeId}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Delete this policy?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
