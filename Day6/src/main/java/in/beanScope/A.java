package in.beanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private OrderService order;

    @Autowired
    public A(OrderService order){
        this.order = order;
    }
}
