package Controller;

import Model.RentType;
import Model.Service;
import Model.ServiceType;
import Service.RentType.RentTypeService;
import Service.RentType.RentTypeServiceImpl;
import Service.Service.ServiceService;
import Service.Service.ServiceServiceImpl;
import Service.ServiceType.ServiceTypeService;
import Service.ServiceType.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    RentTypeService rentTypeService = new RentTypeServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "saveInfor":
                SubmitData(request,response);
                break;
            default:
                break;
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "saveInfor":
                //saveInfor(request,respone);
                break;
            default:
                showServiceList(request,response);
                break;
        }
    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceService> listService = this.serviceService.findAllService();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void SubmitData(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("serviceId");

        int area = Integer.parseInt(request.getParameter("serviceArea"));
        double cost = Double.parseDouble(request.getParameter("serviceCost"));
        int maxpeople = Integer.parseInt(request.getParameter("maxPeople"));
        RentType rentType = this.rentTypeService.findById(Integer.parseInt(request.getParameter("rentType")));
        ServiceType serviceType = this.serviceTypeService.findById(Integer.parseInt(request.getParameter("serviceType")));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numFloor = Integer.parseInt(request.getParameter("numOfFloor"));
        String name = serviceType.getService_type_name();
        Service service = new Service(id,name,area,cost,maxpeople,rentType,serviceType,
                standardRoom,description,poolArea,numFloor);
//        Model.Service service = new Model.Service(id,name,area,cost,maxpeople,rentType,serviceType,standardRoom,description,poolArea,numFloor);
//        this.service.save(service);
//        List<Model.Service> serviceList = this.service.findAllService();
        List<ServiceService> serviceList = this.serviceService.findAllService();
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
