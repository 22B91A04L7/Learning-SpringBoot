package in.fourthLecture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //To Up the Spring IOC Container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context.getBean(OrderService.class); //Using Bean created by spring
        order.placeOrder();

    }
}