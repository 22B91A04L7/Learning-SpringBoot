package in.servletDemo.servlet;

import in.servletDemo.model.User;
import in.servletDemo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService;

    public UserServlet(){
        this.userService = new UserService();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String emailId = req.getParameter("emailId");
        String mobileNo = req.getParameter("mobileNo");

        if(id == null || name == null || emailId == null || mobileNo == null){
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );
            return;

        }

        User user = new User(id, name, emailId, mobileNo);
        User createdUser = userService.createUser(user);
        // return createdUser json res
        res.setStatus(201);
        res.setContentType("application/json");
        res.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User created successfully\"\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String idParam = req.getParameter("id");
        if(idParam == null){
            List<User> userList = userService.getAllUsers();
            res.setStatus(200);
            res.setContentType("application/json");
            res.getWriter().write(usersToJson(userList));
            return;
        }

        Integer id = Integer.parseInt(req.getParameter("id"));
        User userResp = userService.getUserById(id);

        if(userResp == null){
            res.setStatus(404);
            res.setContentType("application/json");
            return;
        }

        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write(userToJson(userResp));


    }


    private String userToJson(User userResp){
       return "{\n" +
                "    \"id\" : " + userResp.getId() + ",\n" +
                "    \"name\" : \"" + userResp.getName() + "\",\n" +
                "    \"email\" : \"" + userResp.getEmailId() + "\",\n" +
                "    \"mobileNo\" : \"" + userResp.getMobileNo() + "\"\n" +
                "}";
    }

    private String usersToJson(List<User> users){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(User user : users){
            stringBuilder.append(userToJson(user));
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
