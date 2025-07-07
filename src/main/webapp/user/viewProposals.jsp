<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My Proposals</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .status {
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Your Proposals</h2>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Vehicle</th>
            <th>Policy Type</th>
            <th>Status</th>
            <th>Quote Amount</th>
            <th>Submission Date</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${proposals}">
        <tr>
            <td>${p.proposalId}</td>
            <td>${p.vehicle.make} ${p.vehicle.model}</td>
            <td>${p.policyType.name}</td>
            <td class="status">${p.status}</td>
            <td>&#8377; ${p.quoteAmount}</td>
            <td>${p.submissionDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
