package in.beanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

//    @Bean
//    public OrderService getOrder(){
//        return new OrderService();
//    }

//    @Bean
//    public OrderService getOrder2(){
//        return new OrderService();
//    }
}

// OrderService scope is singleton but above two beans will be created which are of same OrderService.
// so singleton means one bean definition will have one bean/object but not one class will have only one bean
// Above getOrder() and getOrder2 are two different bean definitions so two different beans of same class would be created even though the scope is singleton.
// If multiple classes depends on OrderService, spring will give error "NoUnigueBeanDefinitionException" because two bean definitions are created manually in AppConfig.

