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
import java.util.List;

@WebServlet (name = "UserManagementServlet",urlPatterns = "/users")
public class UserManagementServlet extends javax.servlet.http.HttpServlet {
    private UserService userService = new UserServiceImpl();
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
                updateUser(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            default:
                showlistUser(response,request);
                break;
        }
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
                showUpdateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            default:
                showlistUser(response,request);
                break;
        }
    }




    private void showlistUser(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute("userList",userService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.save(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request,response);
        showlistUser(response, request);
    }
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("user/update.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
     int id = Integer.parseInt(request.getParameter("id"));
     String name = request.getParameter("name");
     String email = request.getParameter("email");
     String country = request.getParameter("country");
     User user = this.userService.findByID(id);
     RequestDispatcher requestDispatcher;
     if (user == null) {
         requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
     }else {
         user.setId(id);
         user.setName(name);
         user.setEmail(email);
         user.setCountry(country);
         this.userService.update(id,user);
         request.setAttribute("user",user);
         request.setAttribute("message", "User information update !");
         requestDispatcher = request.getRequestDispatcher("user/update.jsp");
     }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
        }else {
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = this.userService.findByID(id);
            RequestDispatcher requestDispatcher;
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("error-404.jsp");
            }else {
                this.userService.remove(id);
                List<User> userList = this.userService.findAll();
                request.setAttribute("userList",userList);
                requestDispatcher = request.getRequestDispatcher("user/list.jsp");
            }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
        }else {
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("user/view.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
