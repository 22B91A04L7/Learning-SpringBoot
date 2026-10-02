package in.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired
    private PaymentService payment;

    @Autowired // OrderService depends on PaymentService
    public OrderService(PaymentService payment){
        this.payment = payment;
    }

    public void placeOrder(){
        payment.pay();
        getOrderDetails(); // Now PaymentService does not need OrderService Object
        //So cicular dependecncy is avoided by making class follow SRP or Refractoring Code
        System.out.println("Order placed!");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }

}
