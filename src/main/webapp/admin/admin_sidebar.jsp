<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

<style>
    .sidebar {
        position: fixed;
        top: 0;
        left: 0;
        width: 250px;
        height: 100%;
        background-color: #0d6efd;
        padding: 20px 0;
        color: white;
        z-index: 1000;
    }

    .sidebar .logo {
        font-size: 1.5rem;
        font-weight: bold;
        text-align: center;
        margin-bottom: 30px;
        color: white;
    }

    .sidebar a {
        display: block;
        color: white;
        padding: 12px 25px;
        text-decoration: none;
        transition: background 0.2s;
    }

    .sidebar a:hover {
        background-color: #084298;
        text-decoration: none;
    }

    .sidebar a.logout {
        color: #ffdddd;
    }

    .sidebar i {
        margin-right: 8px;
    }
</style>
<div class="sidebar">
    <div class="logo">HexaShield Admin</div>
    <a href="${pageContext.request.contextPath}/admin/adminhome"><i class="fas fa-home me-2"></i>Dashboard</a>
    <a href="${pageContext.request.contextPath}/admin/viewUsers"><i class="fas fa-users me-2"></i>View Users</a>
    <a href="${pageContext.request.contextPath}/admin/managePolicies"><i class="fas fa-file-alt me-2"></i>Manage Policies</a>
    <a href="${pageContext.request.contextPath}/admin/manageProposals"><i class="fas fa-file-signature me-2"></i>Manage Proposals</a>
    <a href="${pageContext.request.contextPath}/admin/viewPayments"><i class="fas fa-credit-card me-2"></i>View Payments</a>
    <a href="${pageContext.request.contextPath}/admin/viewDocuments"><i class="fas fa-folder-open me-2"></i>Check Documents</a>
    <a href="${pageContext.request.contextPath}/admin/reports"><i class="fas fa-chart-line me-2"></i>Reports</a>
    <a href="${pageContext.request.contextPath}/logout" class="logout"><i class="fas fa-sign-out-alt me-2"></i>Logout</a>
</div>
