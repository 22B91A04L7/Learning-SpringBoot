package in.circularDependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // above line makes IOC Container UP!

        OrderService order = context.getBean(OrderService.class); //Bean of OrderService
        order.placeOrder();

    }
}

//Circular dependency --> when two or more classes depend on other classes directly and indirectly. spring will give error
//beacause spring cannot decide which bean to create first.

//CD can be avoided using Setter Injection or Field Injection but its not a good practice.
// Also spring boot by default wont support circular references so setter and field injecion's fails.

// CD can be avoided by making clear boundaries for the class responsibilities -- follow SRP