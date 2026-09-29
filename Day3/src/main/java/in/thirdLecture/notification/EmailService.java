package in.thirdLecture.notification;

public class EmailService implements NotificationService{
    public void sendNotification(){
        System.out.println("Email notification sent !!");
    }
}