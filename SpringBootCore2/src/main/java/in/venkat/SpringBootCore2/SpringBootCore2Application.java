package in.venkat.SpringBootCore2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCore2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCore2Application.class, args);

		PaymentGateway payment = context.getBean(PaymentGateway.class);
		User user = context.getBean(User.class);

//		payment.setProvider("Paytm"); //setting values manually in java file.
//		payment.setRetryCount(5); // Hard coding using this java file

		System.out.println(payment.getProvider()); //@Value is used.
		System.out.println(payment.getRetryCount());

		System.out.println(user.getName()); // @COnfigurationProperties is used.
		System.out.println(user.getAge());

	}
}
//application.properties, application.yml are configuration files i.e. non-Java files that can be used to inject values
// to dependencies without changing actual java code. This avoids hardcoding of values.
// values can be injected from application.properties file using two annotations :
//@Value --> used when class has few properties.
// @ConfiguartionProperties --> user when class has more properties.

// Spring Boot automatically loads this file when the application starts.

//@Value("${}") --> we use this annotation to inject values in application.properties files into actual java file properties.
//Ex. @Value("${paymentgateway.provider:Stripe}") --> stripe is default value

