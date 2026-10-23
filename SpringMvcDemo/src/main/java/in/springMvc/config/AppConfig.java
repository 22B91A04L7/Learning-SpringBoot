package in.springMvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "in.springMvc")
@EnableWebMvc // to enable spring mvc
public class AppConfig {
}
