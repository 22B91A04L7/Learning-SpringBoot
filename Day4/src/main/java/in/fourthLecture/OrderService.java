package in.fourthLecture;

import in.fourthLecture.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    //Field Injection --> Not Recommended
//    @Autowired
    PaymentService payment;

    //Constructor Injection --> Recommended
    @Autowired
    public OrderService(PaymentService payment){
        this.payment = payment;
    }

//    //Setter Injection
//    @Autowired
//    public void setPaymentService(PaymentService payment){
//        this.payment = payment;
//    }

    public void placeOrder(){
        payment.pay();
        System.out.println("Order Placed");
    }
}
