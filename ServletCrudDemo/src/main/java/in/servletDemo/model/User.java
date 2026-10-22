package in.servletDemo.model;

public class User {
    private Integer id;
    private String name;
    private String emailId;
    private String mobileNo;

    public User(Integer id, String name, String emailId, String mobileNo){
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
