package in.beanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // comment this when manual beans are being used i.e created by @Bean in AppConfig.

@Scope("singleton") // Eager Initialization --> by default bean scope is singleton
//@Scope("prototype") // Lazy Initialization --> beans will be created separately when getBean() is called.
public class OrderService {

    public OrderService(){
        System.out.println("OrderService created !");
    }
}
