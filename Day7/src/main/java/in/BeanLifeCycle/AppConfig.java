package in.BeanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

//    @Bean(initMethod = "Notify", destroyMethod = "checkout") // another way of using Initialization callbacks is  - > initMethod
//    public CartService getCartBean(){
//        return new CartService();
//    }
}

//Init method --> called after aware interface
//destroyMethod --> similar like initi method but called before bean destruction.