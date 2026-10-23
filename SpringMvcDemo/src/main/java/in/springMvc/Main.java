package in.springMvc;

import in.springMvc.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {

        // Boiler plate
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, baseDoc);

        //Up the IOC container
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.register(AppConfig.class);

        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        tomcat.addServlet(
                contextPath, "dispatcherServlet", dispatcherServlet);

        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat Started on PORT 8080");

        tomcat.getServer().await(); // keeps server running
    }
}

// We are using spring core + spring mvc + embed tomcat + jackson --> so lot of boiler plate code required.
// In spring boot application we can directly start the app using one click.

//Spring MVC --> web framework that helps in building web applications and REST API's
// Embed Tomcat --> Listens incoming requests and uses dispatcher servet to map controllers
// Jackson --> dependency that convers json to Java objects

//Springboot comes with everything auto-configured in it. we simply add springboot-starter-web dependency.
