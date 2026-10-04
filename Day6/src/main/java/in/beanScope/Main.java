package in.beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService order = context.getBean(OrderService.class);
//        OrderService order2 = context.getBean(OrderService.class);
//        System.out.println(order == order2);
    }
}

//Bean Scopes : 1.Singleton 2. Prototype
// Singleton --> IOC container is up one bean is created and will be used by all refences created using getBean().
// Spring does not create multiple beans for multiple dependencies in singleton -- order == order2 is true

//Prototype : when IOC container becomes, bean will not be created. Beans are created separately for the references created using getBean()
// Spring creates multiple beans for multiple references -- order == order2 is false.
