package in.venkat.SpringBootCore2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    @Value("${paymentgateway.provider:Stripe}")
    private String provider;
    @Value("${paymentgateway.retry-count}")
    private int retryCount;

    //constructor injection --> @Value is used to inject properties values.

//    public PaymentGateway(@Value("${paymentgateway.provider}") String provider,
//                          @Value("${paymentgateway.retry-count}")int retryCount){
//        this.provider = provider;
//        this.retryCount = retryCount;
//    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}

//Ex. @Value("${paymentgateway.provider:Stripe}") --> stripe is default value
//@Value is simple and useful for small cases --> becomes messy when more properties are there.

// so for group properties we can use @ConfigurationProperties. Instead of injecting every property separately, we create one configuration class.
