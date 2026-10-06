package in.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component()
public class UserService implements BeanNameAware, ApplicationContextAware {
    public UserService(){
        System.out.println("UserService created !");
    }

    @Override // call back method from BeanNameAware Interface that is called automatically by spring.
    public void setBeanName(String name) {
        System.out.println("Bean name is : " + name);
    }

    @Override // call back method from ApplicationContextAware Interface that is called automatically by spring.
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Applcation context name : " + applicationContext.getClass());
    }
}
