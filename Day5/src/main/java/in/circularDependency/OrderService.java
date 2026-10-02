package in.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService payment;

    @Autowired // OrderService depends on PaymentService
    public OrderService(PaymentService payment){
        this.payment = payment;
    }

    public void placeOrder(){
        payment.pay();
        System.out.println("Order placed!");
    }

}
