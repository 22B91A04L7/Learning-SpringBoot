package in.fourthLecture.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CardPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Paid via Card");
    }
}
