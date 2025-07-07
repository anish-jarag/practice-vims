package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Notification;
import com.example.vims_backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestController {

    @Autowired
    private NotificationService notificationService;

//	Get all notifications for a user (for displaying on user dashboard)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable int userId) {
        List<Notification> notifications = notificationService.getNotificationsForUser(userId);
        return ResponseEntity.ok(notifications);
    }

//	Delete a notification (For clearing alerts)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id) {
        if (notificationService.deleteNotification(id)) {
            return ResponseEntity.ok("Notification deleted.");
        } else {
            return ResponseEntity.status(404).body("Notification not found.");
        }
    }
}
