package com.spring.profiles.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public interface NotificationService {
    ResponseEntity<String> notifyUser();
}
