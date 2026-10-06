package in.BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
          ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//        UserService user = context.getBean(UserService.class);
//        user.setBeanName("Venkat"); //bean name can be printed with a new name but spring does not chnage actual name.
//        CartService cart = context.getBean(CartService.class);

        context.close();
    }
}

// Bean Life Cycle --> a complete of journey of spring managed object i.e bean creation, managing, and destroying.
// 1. Spring IOC containers starts
// 2. spring reads configuration file and scans components
// 3. Reads bean definitions
// 4. Objects are instantiated i.e. created
// 5. Dependencies are injected
// 6. Aware Interfaces are called --> Basically used by beans to ask IOC container to know what is it name, which bean factory created it, etc..
//  Using Aware interfaces --> call back methods are called automatically by spring.
//  a. BeanNameAware , b.ApplicationContextAware --> Aware interfaces are generally not used. They can be better used in logging.

// 7. Initialization callbacks are called --> similar to Aware interfaces, these interfaces contains methods to initialize and manage data in various data structures.
//    c. @PostContructor annotation --> external package needed "Jakarta" for spring not spring boot.
//    b. InitializingBean
//    c. Init method --> called after aware interface
// After Aware call backs are called spring gives chance for Initialization call backs so that they can be called during starting.

// 8. Bean Ready to use

// 9.Bean Destruction phase --> can be done using 3 ways
//   a. @PreDestroy --> spring calls this method before destroying bean.
//   b. DisposableBean --> methods implemented will be called before bean destruction.
//   c. destroyMethod --> similar like initi method but called before bean destruction.

