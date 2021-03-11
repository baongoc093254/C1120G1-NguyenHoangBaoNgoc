package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountServlet",urlPatterns = "/discount")
public class ProductDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("description");
        Float listPrice = Float.parseFloat(request.getParameter("price"));
        Double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        double discountAmount = listPrice*discountPercent*0.01;
        double totalPrice = listPrice - discountAmount;

        request.setAttribute("description",productDescription);
        request.setAttribute("price",listPrice);
        request.setAttribute("percent",discountPercent);
        request.setAttribute("amount",discountAmount);
        request.setAttribute("total",totalPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/productdiscount/product.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/productdiscount/home.jsp");

    }
}
