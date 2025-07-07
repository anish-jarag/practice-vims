package com.example.vims_backend.entity;

import java.time.LocalDateTime;

import com.example.vims_backend.entity.enums.NotificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
    private String message;
    
    private LocalDateTime sentAt;
    
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    public Notification() {}

	public Notification(int notificationId, User user, String message, LocalDateTime sentAt, NotificationType type) {
		super();
		this.notificationId = notificationId;
		this.user = user;
		this.message = message;
		this.sentAt = sentAt;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", user=" + user + ", message=" + message
				+ ", sentAt=" + sentAt + ", type=" + type + "]";
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}
    
}
