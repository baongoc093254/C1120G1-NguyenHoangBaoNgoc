package Controller;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"","/login"})
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        if ("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome " + username + " to website</h1>");
        }else {
            writer.println("<h1>Login Error</h1>");
        }

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("name");
//        String password = request.getParameter("password");
//        System.out.println("Ten cua ban la: " + username);
//        System.out.println("Mat khau :" + password);
//
//        request.setAttribute("ten",username);
//        request.setAttribute("matKhau",password);
//
        RequestDispatcher dispatcher = request.getRequestDispatcher("/FormLogin/index.jsp");
        dispatcher.forward(request,response);
    }
}
