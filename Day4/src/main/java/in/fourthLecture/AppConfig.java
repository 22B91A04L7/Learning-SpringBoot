package in.fourthLecture;

import in.thirdLecture.notification.EmailService;
import in.thirdLecture.notification.NotificationService;
import in.thirdLecture.notification.SmsService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@Configurable
@ComponentScan("in.fourthLecture")
public class AppConfig {

    @Bean //we are manually telling spring to use custom object as a bean
    public User createUser(){
        return new User("Venkat", 23);
    }

    @Bean // class from the dependency/external package --> we are making them as beans
    public NotificationService createEmailService(){
        return new EmailService();
    }

    @Bean
    @Primary
    public NotificationService createSmsService(){
        return new SmsService();
    }

}
