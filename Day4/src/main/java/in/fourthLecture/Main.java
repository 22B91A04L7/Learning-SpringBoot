package in.fourthLecture;

import in.thirdLecture.notification.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //To Up the Spring IOC Container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        User user = context.getBean(User.class);  //Using bean that was manually passsed using @Bean
        System.out.println(user.getName());

        OrderService order = context.getBean(OrderService.class); //Using Bean created by spring automatically by adding @Component
        order.placeOrder();

        NotificationService notification = context.getBean(NotificationService.class);
        // Using bean that was manually created using @Bean because NotificationService is External package that @Component cannot be added.
        notification.sendNotification();
    }
}