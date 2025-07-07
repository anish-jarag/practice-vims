<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.vims_backend.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Vehicles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            padding: 40px;
            background-color: #f0f8ff;
        }
        .container {
            margin-left: 270px;
            padding: 30px;
        }
        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            margin-bottom: 40px;
        }
        .btn {
            font-weight: 500;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<jsp:include page="/user/user_sidebar.jsp" />

<div class="container">
    <h2 class="text-primary mb-4">Manage My Vehicles</h2>

    <!-- Add Vehicle Form -->
    <div class="form-container">
        <form action="addVehicle" method="post">
            <input type="hidden" name="userId" value="<%= user.getUserId() %>">
            <div class="row g-3">
                <div class="col-md-4">
                    <label>Vehicle Type</label>
                    <select name="type" class="form-select" required>
                        <option value="CAR">Car</option>
                        <option value="BIKE">Bike</option>
                        <option value="TRUCK">Truck</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label>Make</label>
                    <input type="text" name="make" class="form-control" required autocomplete="off">
                </div>
                <div class="col-md-4">
                    <label>Model</label>
                    <input type="text" name="model" class="form-control" required autocomplete="off">
                </div>
                <div class="col-md-6">
                    <label>Registration Number</label>
                    <input type="text" name="registrationNumber" class="form-control" required autocomplete="off">
                </div>
                <div class="col-md-6">
                    <label>Manufacture Year</label>
                    <input type="number" name="manufactureYear" class="form-control" min="1990" max="2025" required>
                </div>
            </div>
            <button type="submit" class="btn btn-success mt-4">Add Vehicle</button>
        </form>
    </div>

    <!-- Vehicle List Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>Type</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Reg. No</th>
                    <th>Year</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.vehicleId}</td>
                        <td>${vehicle.type}</td>
                        <td>${vehicle.make}</td>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.registrationNumber}</td>
                        <td>${vehicle.manufactureYear}</td>
                        <td>
                            <button type="button" class="btn btn-warning btn-sm"
                                    onclick="loadVehicle(${vehicle.vehicleId})"
                                    data-bs-toggle="modal" data-bs-target="#editModal">
                                Edit
                            </button>
                            <button class="btn btn-danger btn-sm" onclick="deleteVehicle(${vehicle.vehicleId})">Delete</button>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Edit Vehicle Modal -->
<div class="modal fade" id="editModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content" id="editForm">
            <div class="modal-header">
                <h5 class="modal-title">Edit Vehicle</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="vehicleId" id="vehicleId">
                <div class="mb-2">
                    <label>Type</label>
                    <input name="type" id="type" class="form-control" required autocomplete="off">
                </div>
                <div class="mb-2">
                    <label>Make</label>
                    <input name="make" id="make" class="form-control" required autocomplete="off">
                </div>
                <div class="mb-2">
                    <label>Model</label>
                    <input name="model" id="model" class="form-control" required autocomplete="off">
                </div>
                <div class="mb-2">
                    <label>Registration Number</label>
                    <input name="registrationNumber" id="registrationNumber" class="form-control" required autocomplete="off">
                </div>
                <div class="mb-2">
                    <label>Manufacture Year</label>
                    <input type="number" name="manufactureYear" id="manufactureYear" class="form-control" required>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="submit">Update</button>
            </div>
        </form>
    </div>
</div>

<script>
  function loadVehicle(id) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "/api/vehicles/" + id, false);
    xhr.send();

    if (xhr.status === 200) {
      const v = JSON.parse(xhr.responseText);
      document.getElementById("vehicleId").value = v.vehicleId;
      document.getElementById("type").value = v.type;
      document.getElementById("make").value = v.make;
      document.getElementById("model").value = v.model;
      document.getElementById("registrationNumber").value = v.registrationNumber;
      document.getElementById("manufactureYear").value = v.manufactureYear;
    } else {
      alert("Failed to load vehicle.");
    }
  }

  document.getElementById("editForm").onsubmit = function(e) {
    e.preventDefault();
    const id = document.getElementById("vehicleId").value;

    const data = {
      vehicleId: id,
      type: document.getElementById("type").value,
      make: document.getElementById("make").value,
      model: document.getElementById("model").value,
      registrationNumber: document.getElementById("registrationNumber").value,
      manufactureYear: document.getElementById("manufactureYear").value
    };

    const xhr = new XMLHttpRequest();
    xhr.open("PUT", "/api/vehicles/" + id, false);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(data));

    if (xhr.status === 200) {
      alert("Vehicle updated");
      location.reload();
    } else {
      alert("Update failed");
    }
  };
  
  function deleteVehicle(id) {
	  if (confirm("Are you sure you want to delete this vehicle?")) {
	    const xhr = new XMLHttpRequest();
	    xhr.open("DELETE", "/api/vehicles/" + id, false);
	    xhr.send();

	    if (xhr.status === 200) {
	      alert("Vehicle deleted");
	      location.reload();
	    } else {
	      alert("Delete failed");
	    }
	  }
	}

</script>

</body>
</html>
