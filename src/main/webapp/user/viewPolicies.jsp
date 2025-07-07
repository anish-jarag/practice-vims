<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Policies - HexaShield</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f4f9ff;
            padding: 30px;
        }
        
        .container {
		    margin-left: 270px; /* same width as sidebar */
		    padding: 30px;
		}

        .policy-card {
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            margin-bottom: 20px;
        }

        .policy-card h5 {
            color: #0d6efd;
            margin-bottom: 10px;
        }

        .policy-card p {
            margin-bottom: 6px;
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
    <jsp:include page="/user/user_sidebar.jsp" />
<div class="container">
    <h2 class="mb-4 text-primary">Available Insurance Policies</h2>

    <c:forEach var="p" items="${policies}">
        <div class="policy-card">
            <h5>${p.name}</h5>
            <p><strong>Base Premium:</strong> ₹${p.basePremium}</p>
            <p><strong>Description:</strong> ${p.description}</p>
        </div>
    </c:forEach>

    <c:if test="${empty policies}">
        <p class="text-muted">No policies available at the moment.</p>
    </c:if>
</div>

</body>
</html>
