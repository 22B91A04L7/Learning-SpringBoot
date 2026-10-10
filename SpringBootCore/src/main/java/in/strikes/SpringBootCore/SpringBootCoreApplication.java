package in.strikes.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //makes main file as configuration file
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);
		OrderService order = context.getBean(OrderService.class);
		order.placeOrder();

		UserService user = context.getBean(UserService.class); //UserService is annotated with @Component, here @Bean is used.

	}

	@Bean // In spring boot we can write @Bean annotation to create custom beans in main file.
	// Because @SpringBootConfiguration make main class as AppConfig.
	public UserService getUserServiceBean(){
		return new UserService();
	}
}

//Spring Initializr gives ready-made basic spring boot project structure.
//@SpringBootApplication has @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan that makes main class as configuration class.
// @SpringBootConfiguration --> equals to @Configuration, says spring to consider main as configuration file. package can also be changed.
// @ComponentScan --> scans all components to make beans.
// @EnablaAutoConfiguration --> AutoConfigure files that are pre-configured in spring boot or provided by third party dependencies.
// these autoconfiguration files are configured based on conditions.
// --> @ConditionalOnClass(class_name.class) --> configures only when class is present
// --> @ConditionalOnMissingBean --> creates default bean only when developer has not created it manually.

//Eg : when spring-boot-starter-web dependency is added some pre-configured files are autoconfigured and tomcat server is initialized.
