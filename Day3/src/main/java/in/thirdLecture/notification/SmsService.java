package in.thirdLecture.notification;

public class SmsService implements NotificationService{
    public void sendNotification(){
        System.out.println("SMS notification sent !");
    }
}