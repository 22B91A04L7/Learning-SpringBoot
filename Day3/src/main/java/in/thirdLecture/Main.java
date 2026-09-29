//Dependency Injection --> A class receives the objects it depends on from outside, instead of creating
//those objects itself.

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