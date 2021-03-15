package Controller;

import Model.User;
import Service.UserService;
import Service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends javax.servlet.http.HttpServlet {
    private UserService service = new UserServiceImpl();


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request,response);
                break;
            case "update":
                //
                break;
            case "delete":
                //
                break;
            default:
                showUserList(response,request);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name,email,country);
        service.save(user);

        showUserList(response,request);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "update":
                //
                break;
            case "delete":
                //
                break;
            default:
                showUserList(response,request);
        }
    }

    private void showUserList(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute("userList",service.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/user/create.jsp");

    }
}
