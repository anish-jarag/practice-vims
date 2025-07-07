<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">

<style>
    body {
        background: #f0f6ff;
        font-family: 'Segoe UI', sans-serif;
    }

    .sidebar {
        height: 100vh;
        background: #6610f2;
        padding-top: 40px;
        position: fixed;
        left: 0;
        top: 0;
        width: 250px;
        box-shadow: 2px 0 10px rgba(0,0,0,0.1);
        z-index: 1000;
    }

    .sidebar a {
        color: #fff;
        padding: 15px 30px;
        display: block;
        font-size: 16px;
        text-decoration: none;
        transition: background 0.2s ease-in-out;
    }

    .sidebar a:hover {
        background-color: #520dc2;
    }

    .sidebar .logo {
        font-size: 22px;
        font-weight: bold;
        color: #fff;
        padding: 0 30px 30px;
        border-bottom: 1px solid rgba(255,255,255,0.3);
        margin-bottom: 20px;
    }

    .logout {
        position: absolute;
        bottom: 20px;
        left: 30px;
        color: #ffc107;
    }

    .logout:hover {
        color: #fff;
    }
</style>

<div class="sidebar">
    <div class="logo">HexaShield</div>

    <a href="${pageContext.request.contextPath}/user/userhome"><i class="fas fa-home me-2"></i>Dashboard</a>
    <a href="${pageContext.request.contextPath}/user/myVehicles"><i class="fas fa-car me-2"></i>My Vehicles</a>
    <a href="${pageContext.request.contextPath}/user/viewPolicies"><i class="fas fa-file-alt me-2"></i>View Policies</a>
    <a href="${pageContext.request.contextPath}/user/proposalPage"><i class="fas fa-file-alt me-2"></i>Submit Proposal</a>
    <a href="${pageContext.request.contextPath}/user/viewProposals"><i class="fas fa-list me-2"></i>My Proposals</a>
    <a href="${pageContext.request.contextPath}/user/myPolicies"><i class="fas fa-shield-alt me-2"></i>My Policies</a>
    <a href="${pageContext.request.contextPath}/user/documents"><i class="fas fa-file-upload me-2"></i>My Documents</a>
    <a href="${pageContext.request.contextPath}/user/viewNotifications"><i class="fas fa-bell me-2"></i>Notifications</a>
    <a href="${pageContext.request.contextPath}/logout" class="logout"><i class="fas fa-sign-out-alt me-2"></i>Logout</a>
</div>
