package in.beanScope;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private int age;
}

//User class has two properties --> staefull class
// So prototype scope must be used for this type of statefull classes, singleton cannot be used because different objects have diffrent state values.
