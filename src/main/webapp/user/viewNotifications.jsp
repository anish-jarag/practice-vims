<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Notifications - VIMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f5f9ff;
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            margin-left: 270px;
            padding: 40px 20px;
        }
        .card {
            border-radius: 12px;
            padding: 20px;
            margin-bottom: 20px;
            background-color: #ffffff;
            box-shadow: 0 4px 10px rgba(0,0,0,0.05);
        }
        .card-header {
            font-weight: bold;
            color: #0d6efd;
        }
        .badge-info { background-color: #0d6efd; }
        .badge-warning { background-color: #ffc107; color: #000; }
        .badge-danger { background-color: #dc3545; }
    </style>
</head>
<body>

<!-- Optional Sidebar Include -->
<jsp:include page="sidebar.jsp" />

<div class="container">
    <h2 class="mb-4">📢 Notifications</h2>

    <div id="notificationList">
        <!-- Populated via JS -->
    </div>
</div>

<script>
    const userId = 1; // ⚠️ Update dynamically if needed

    fetch(`/api/notifications/user/${userId}`)
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById("notificationList");
            if (!data.length) {
                container.innerHTML = "<p>No notifications found.</p>";
                return;
            }

            data.forEach(n => {
                const badgeColor = getBadge(n.type);
                container.innerHTML += `
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <span>${n.message}</span>
                            <span class="badge ${badgeColor}">${n.type}</span>
                        </div>
                        <div class="card-body text-muted small">
                            Sent at: ${n.sentAt.replace("T", " ").substring(0, 19)}
                        </div>
                    </div>`;
            });
        });

    function getBadge(type) {
        switch (type) {
            case "INFO": return "badge-info";
            case "ALERT": return "badge-warning";
            case "REMINDER": return "badge-danger";
            default: return "badge-secondary";
        }
    }
</script>

</body>
</html>
