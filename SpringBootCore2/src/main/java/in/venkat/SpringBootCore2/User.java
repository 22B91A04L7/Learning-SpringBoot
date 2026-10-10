package in.venkat.SpringBootCore2;

import org.springframework.stereotype.Component;

@Component
public class User {
    UserProperties userProperties; // dependency to add properties.

    public User(UserProperties userProperties){
        this.userProperties = userProperties;
    }

    public String getName() {
        return userProperties.getName();
    }

    public int getAge() {
        return userProperties.getAge();
    }

}
