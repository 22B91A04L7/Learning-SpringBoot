package in.venkat.SpringBootCore2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user-properties") // prefix must be mentioned to access values and must be in canonicalCase.
public class UserProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// @ConfigurationProperties is used to inject values of grouped properties using one separate class.

