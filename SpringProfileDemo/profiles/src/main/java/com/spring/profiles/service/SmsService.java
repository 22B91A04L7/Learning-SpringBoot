package com.spring.profiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "prod")
public class SmsService implements NotificationService{
    @Override
    public ResponseEntity<String> notifyUser() {
        return ResponseEntity.ok("PROD : SMS sent!");
    }
}
