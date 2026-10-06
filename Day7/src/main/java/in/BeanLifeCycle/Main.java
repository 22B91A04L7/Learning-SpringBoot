package in.BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//        UserService user = context.getBean(UserService.class);
//        user.setBeanName("Venkat"); //bean name can be printed with a new name but spring does not chnage actual name.

    }
}

// Bean Life Cycle --> a complete of journey of spring managed object i.e bean creation, managing, and destroying.
// 1. Spring IOC containers starts
// 2. spring reads configuration file and scans components
// 3. Reads bean definitions
// 4. Objects are instantiated i.e. created
// 5. Dependencies are injected
// 6. Aware Interfaces --> Basically used by beans to ask IOC container to know what is it name, which bean factory created it, etc..
//  Using Aware interfaces --> call back methods are called automatically by spring.

