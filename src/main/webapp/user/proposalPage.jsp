<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Submit Proposal</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: #f0f6ff;
            font-family: 'Segoe UI', sans-serif;
            margin-left: 250px;
            padding: 30px;
        }

        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            max-width: 800px;
            margin: auto;
        }

        h2 {
            margin-bottom: 20px;
            color: #343a40;
        }

        label {
            font-weight: 600;
            display: block;
            margin: 15px 0 5px;
        }

        select, input[type="checkbox"] {
            padding: 10px;
            width: 100%;
            border: 1px solid #ced4da;
            border-radius: 5px;
        }

        .checkbox-list {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }

        .checkbox-list label {
            font-weight: normal;
            display: flex;
            align-items: center;
        }

        .checkbox-list input {
            margin-right: 8px;
        }

        button {
            background: #6610f2;
            color: white;
            border: none;
            padding: 12px 25px;
            font-size: 16px;
            border-radius: 5px;
            margin-top: 20px;
            cursor: pointer;
            transition: background 0.2s ease-in-out;
        }

        button:hover {
            background: #520dc2;
        }
    </style>
</head>
<body>

<jsp:include page="user_sidebar.jsp" />

<div class="form-container">
    <h2>Submit a New Insurance Proposal</h2>

    <form method="post" action="${pageContext.request.contextPath}/user/submitProposal">

        <label for="vehicle">Select Vehicle:</label>
        <select name="vehicleId" id="vehicle" required>
            <c:forEach var="v" items="${vehicles}">
                <option value="${v.vehicleId}">
                    ${v.make} ${v.model} (${v.type})
                </option>
            </c:forEach>
        </select>

        <label for="policy">Select Policy Type:</label>
        <select name="policyTypeId" id="policy" required>
            <c:forEach var="p" items="${policyTypes}">
                <option value="${p.policyTypeId}">
                    ${p.name} – ₹${p.basePremium}
                </option>
            </c:forEach>
        </select>

        <label>Select Add-ons (optional):</label>
        <div class="checkbox-list">
            <c:forEach var="addon" items="${addons}">
                <label>
                    <input type="checkbox" name="addonIds" value="${addon.addonId}" />
                    ${addon.name} (+₹${addon.extraCost})
                </label>
            </c:forEach>
        </div>

        <button type="submit">Submit Proposal</button>
    </form>
</div>

</body>
</html>
