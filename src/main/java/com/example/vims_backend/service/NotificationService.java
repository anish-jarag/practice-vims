package com.example.vims_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vims_backend.entity.Notification;
import com.example.vims_backend.entity.User;
import com.example.vims_backend.entity.enums.NotificationType;
import com.example.vims_backend.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(User user, String message, NotificationType type) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());
        notification.setType(type);
        notificationRepository.save(notification);
    }


    public List<Notification> getNotificationsForUser(int userId) {
        return notificationRepository.findByUser_UserId(userId);
    }

    public boolean deleteNotification(int id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
