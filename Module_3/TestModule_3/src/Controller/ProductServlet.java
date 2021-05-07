package Controller;



import Common.Validate.Validate;
import Model.Product;
import Service.ProductService;
import Service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
//    RentTypeService rentTypeService = new RentTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
//                updateRoom(request, response);
                break;
            case "delete":
//                deleteRoom(request,response);
                break;
//            case "searchByName":
//                searchCustomerByName(request,response);
//                break;
//            case "searchById":
//                searchCustomerById(request,response);
//                break;
            default:
                showListProduct(request,response);
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
//                showUpdateForm(request, response);
                break;
            case "search":
//                searchRoom(request,response);
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

//    private void searchRoom(HttpServletRequest request, HttpServletResponse response) {
//        String search=request.getParameter("search");
//        System.out.println(search);
//        List<Product> customerList = roomService.search(search);
//        request.setAttribute("customerList",customerList);
//        try {
//            request.getRequestDispatcher("customer/list.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList",this.productService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameproduct = request.getParameter("nameproduct");
        String message = Validate.validateName(nameproduct);
        Double price = Double.parseDouble(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Product product = new Product(nameproduct,price,discount,stock);
        productService.save(product);

        showListProduct(request, response);

    }

//    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Room room = this.roomService.findById(id);
//        RequestDispatcher requestDispatcher;
//        if (room == null) {
//            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
//        } else {
//            request.setAttribute("room", room);
//            requestDispatcher = request.getRequestDispatcher("room/update.jsp");
//        }
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    private void updateRoom(HttpServletRequest request, HttpServletResponse response) {
//        int idroom = Integer.parseInt(request.getParameter("idroom"));
//        String room_name = request.getParameter("room_name");
//        String name_customer = request.getParameter("name_customer");
//        int phone_customer = Integer.parseInt(request.getParameter("phone_customer"));
//        String start_date = request.getParameter("start_date");
//        String description = request.getParameter("description");
//        RentType rentType = rentTypeService.findById(Integer.parseInt(request.getParameter("idrent_type")));
//
//        Room room = this.roomService.findById(idroom);
//        RequestDispatcher requestDispatcher;
//        if (room == null) {
//            requestDispatcher = request.getRequestDispatcher("/error-404.jsp");
//
//        } else {
//            room.setIdroom(idroom);
//            room.setNameRoom(room_name);
//            room.setName_customer(name_customer);
//            room.setPhone_customer(phone_customer);
//            room.setStart_date(start_date);
//            room.setDescription(description);
//            room.setRentType(rentType);
//            this.roomService.update(idroom, room);
//            showListRoom(request, response);
//
//
//        }
//    }
//
//    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("idCustomer"));
//        Room room = this.roomService.findById(id);
//        System.out.println(room.getNameRoom());
//        RequestDispatcher requestDispatcher;
//        if (room != null) {
//            this.roomService.remove(id);
//        }
//            List<Room> roomList = this.roomService.findAll();
//            request.setAttribute("roomList",roomList);
//            requestDispatcher = request.getRequestDispatcher("room/list.jsp");
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        showListRoom(request,response);
//    }


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



