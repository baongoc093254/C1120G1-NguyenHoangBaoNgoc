package Controller;

import Model.Customer;
import Model.CustomerType;
import Service.Customer.CustomerService;
import Service.Customer.CustomerServiceImpl;
import Service.CustomerType.CustomerTypeService;
import Service.CustomerType.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
//            case "searchByName":
//                searchCustomerByName(request,response);
//                break;
//            case "searchById":
//                searchCustomerById(request,response);
//                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String search=request.getParameter("search");
        System.out.println(search);
        List<Customer> customerList = customerService.search(search);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.findAll());
//        request.setAttribute("customerTypeList",customerTypeService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_id = request.getParameter("customer_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customer_idcard = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customer_type_id")));

        Customer customer = new Customer(customer_id, customer_name, customer_birthday, gender,
                customer_idcard, customer_phone, customer_email, customer_address, customerType);
        customerService.save(customer);

        showListCustomer(request, response);

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = this.customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            requestDispatcher = request.getRequestDispatcher("customer/update.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_id = request.getParameter("customer_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        CustomerType customerType = customerTypeService.findById(Integer.parseInt(request.getParameter("customer_type_id")));

        Customer customer = this.customerService.findById(customer_id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");

        } else {
            customer.setCustomer_id(customer_id);
            customer.setCustomer_name(customer_name);
            customer.setCustomer_birthday(customer_birthday);
            customer.setCustomer_gender(gender);
            customer.setCustomer_id_card(customer_id_card);
            customer.setCustomer_phone(customer_phone);
            customer.setCustomer_email(customer_email);
            customer.setCustomer_address(customer_address);
            customer.setCustomerType(customerType);
            this.customerService.update(customer_id, customer);
            showListCustomer(request, response);


        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("da vao deleteCustomer");
        String id = request.getParameter("idCustomer");
        Customer customer = this.customerService.findById(id);
        System.out.println(id);
        System.out.println(customer.getCustomer_name());
        RequestDispatcher requestDispatcher;
        if (customer != null) {
            this.customerService.remove(id);
        }
            List<Customer> customerList = this.customerService.findAll();
            request.setAttribute("customerList",customerList);
            requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showListCustomer(request,response);
    }


}




//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if(customer == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            customer.setName(name);
//            customer.setEmail(email);
//            customer.setAddress(address);
//            this.customerService.update(id, customer);
//            request.setAttribute("customer", customer);
//            request.setAttribute("message", "Customer information was updated");
//            dispatcher = request.getRequestDispatcher("edit.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

// Home page
//private void loadHome(HttpServletRequest request, HttpServletResponse response) {
//    try {
//        request.getRequestDispatcher("home.jsp").forward(request, response);
//    } catch (ServletException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}


// search by customer name
//private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
//    String name = request.getParameter("name");
//    String msg;
//    if (name.equals("")) {
//        msg = "Please Input!!!";
//        request.setAttribute("message", msg);
//    } else {
//        List<Customer> customerList = furamaService.findCustomerByName(name);
//        if (customerList.isEmpty()) {
//            msg = "Not Found";
//            request.setAttribute("message", msg);
//        } else {
//            request.setAttribute("customerListFromServlet", customerList);
//        }
//    }
//    try {
//        request.getRequestDispatcher("search_customer_by_name.jsp").forward(request, response);
//    } catch (ServletException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}



// search by id
//    private void searchCustomerById(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        String msg;
//        if (id.equals("")) {
//            msg = "Please Input!!";
//            request.setAttribute("message", msg);
//        } else {
//            Customer customer = furamaService.findCustomerById(id);
//            if (customer == null || customer.getCustomer_name() == null) {
//                msg = "Not Found";
//                request.setAttribute("message", msg);
//            } else {
//                request.setAttribute("customerInfo", customer);
//            }
//        }
//        try {
//            request.getRequestDispatcher("search_customer_by_id.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




//create service

//    private void createService(HttpServletRequest request, HttpServletResponse response){
//        String service_code = request.getParameter("service_code");
//        String service_name = request.getParameter("service_name");
//        String service_area = request.getParameter("service_area");
//        String service_cost = request.getParameter("service_cost");
//        String service_max_people = request.getParameter("service_max_people");
//        String rent_type_id = request.getParameter("rent_type_id");
//        String service_type_id = request.getParameter("service_type_id");
//        String standard_room = request.getParameter("standard_room");
//        String description_other_convenience = request.getParameter("description_other_convenience");
//        String pool_area = request.getParameter("pool_area");
//        String number_of_floors= request.getParameter("number_of_floors");
//
//        String msg = furamaService.saveService(service_code,service_name,service_area,service_cost,service_max_people,rent_type_id,
//                service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
//        request.setAttribute("message",msg);
//        try {
//            request.getRequestDispatcher("create_service.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}



