package controller;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.service.impl.ServiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    private ServiceService serviceService = new ServiceService(); // Tạo đối tượng impl để tương tác với model


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
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
                showNewForm(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAllService();
        List<ServiceType> serviceTypeList = serviceService.findAllServiceType();
        List<RentType> rentTypeList = serviceService.findAllRentType();

        request.setAttribute("services", serviceList);
        request.setAttribute("serviceTypes", serviceTypeList);
        request.setAttribute("rentTypes", rentTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ServiceType> serviceTypeList = serviceService.findAllServiceType();
        List<RentType> rentTypeList = serviceService.findAllRentType();

        request.setAttribute("serviceTypes", serviceTypeList);
        request.setAttribute("rentTypes", rentTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create_service.jsp");
        dispatcher.forward(request, response);
    }


    private void createService(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;

        String name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        Double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));

        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));

        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors = request.getParameter("number_of_floors");

        Service service = new Service(name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room,
                description_other_convenience, pool_area, number_of_floors);
        check = serviceService.create(service);

//        if(standard_room == ""){
//        standard_room = null;
//          }

        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create_service.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
