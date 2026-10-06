package in.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//BeanNameAware --> Aware Interface
// InitializingBean --> one type of using initialization call backs.
@Component
public class CartService implements BeanNameAware
        /*InitializingBean, DisposableBean*/ {

    public CartService() {
        System.out.println("Cart Service constructor called!");
    }

    //BeanNameAware Interface implementation
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is : " + name);
    }
    // Initialization callback using IntializingBean interface implementation
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initialization call back..");
//   }

    @PostConstruct // another way of using initialization call backs , runs after Aware ineteface callback
    public void Notify(){
        System.out.println("Notification Sent");
    }

    @PreDestroy // destruction callback that will be called before bean destruction by spring automatically.
    public void checkout(){
        System.out.println("Bean is getting destroyed");
    }

//    @Override  //DisposableBean Implementation --> one way to use callback before bean desstruction.
//    public void destroy() throws Exception {
//        System.out.println("Bean is getting destroyed");
//    }
}
