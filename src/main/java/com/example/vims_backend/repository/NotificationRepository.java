package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	List<Notification> findByUser_UserId(int userId);
}
