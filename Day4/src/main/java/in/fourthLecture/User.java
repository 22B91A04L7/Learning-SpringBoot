package in.fourthLecture;

//Custom object with parameters--> Spring cannot directly create a bean. so we use @Bean and create it in AppConfig
public class User {
    private String name;
    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
