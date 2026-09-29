package in.thirdLecture;

import in.thirdLecture.notification.NotificationService;
import in.thirdLecture.notification.PopUpService;
import in.thirdLecture.notification.SmsService;

public class Main {
    public static void main(String[] args) {
        //creating object from main class and sending to OrderService
        NotificationService notification = new PopUpService();
        OrderService order = new OrderService(notification);
        order.placeOrder();
    }
}

//Dependency Injection --> A class receives the objects it depends on from outside, instead of creating
//those objects itself.

//IOC -- Inversion of Control : a principle that says class should not create objects, instead it should ask other class to send objcets that are needed by it

// IOC -- Principle
// DI -- Implementation of IOC