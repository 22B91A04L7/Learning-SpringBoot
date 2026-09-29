package in.thirdLecture;

import in.thirdLecture.notification.NotificationService;

public class OrderService {
    NotificationService notification;
    //using dependency from another class -- not creating here
    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Order placed !!");
        notification.sendNotification();
    }
}