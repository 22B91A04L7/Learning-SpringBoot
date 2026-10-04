package in.beanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") // Eager Initialization --> by default bean scope is singleton
@Scope("prototype") // Lazy Initialization --> beans will be created separately when getBean() is called.
public class OrderService {

    public OrderService(){
        System.out.println("OrderService created !");
    }
}
