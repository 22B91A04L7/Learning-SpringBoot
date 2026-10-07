package in.strikes.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //makes main file as configuration file
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);
		OrderService order = context.getBean(OrderService.class);
		order.placeOrder();
	}

}

//Spring Initializr gives ready-made basic spring boot project structure.
//@SpringBootApplication has @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan that makes main class as configuration class.
