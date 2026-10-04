package in.beanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    private OrderService order;

    @Autowired
    public B(OrderService order){
        this.order = order;
    }
}
