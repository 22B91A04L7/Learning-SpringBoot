package in.BeanLifeCycle;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService payment;

    public OrderService(PaymentService payment){
        this.payment = payment;
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        payment.pay();
    }
}
