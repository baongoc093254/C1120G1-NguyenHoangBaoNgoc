package Controller;

import Model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends javax.servlet.http.HttpServlet {
    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","abc"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","abc"));
        customerList.add(new Customer("Nguyễn Thái Hoà","1983-08-22","Nam Định","abc"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","aaa"));
        customerList.add(new Customer("Nguyễn Đình ","1983-08-19","Hà Nội","bb"));
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
