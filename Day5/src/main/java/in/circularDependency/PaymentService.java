package in.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

//    private OrderService order;
//
//    @Autowired // PaymentService depends on OrderService
//    public PaymentService(OrderService order){
//        this.order = order;
//    }

    public void pay(){
        System.out.println("Payment done !");
//      order.getOrderDetails(); // not this class responsibility
    }
}

//Commented PaymentService Dependency to make it user SRP and that removes Circular Dependency
