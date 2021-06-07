package controller;

import model.bean.CustomerService.CustomerUsing;
import model.bean.CustomerService.ShowAttachService;
import model.bean.customer.Customer;
import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.service.impl.CustomerService;
import model.service.impl.CustomerUserService;
import model.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerUsingServlet", urlPatterns = {"/customerUsing"})
public class CustomerUsingServlet extends HttpServlet {

    private CustomerUserService customerUserService = new CustomerUserService(); // Tạo đối tượng impl để tương tác với model

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "edit":
                updateCustomerUsing(request, response);
                break;
            case "search":
                searchCustomerUsing(request, response);
                break;
            case "delete":
                deleteCustomerUsing(request, response);
                break;

        }

    }

    private void deleteCustomerUsing(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("contract_id"));
        customerUserService.remove(id);

        try {
            response.sendRedirect("/customerUsing");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchCustomerUsing(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("customer_name");
        List<CustomerUsing> customerList = customerUserService.findByName(name);

        request.setAttribute("customerUsings", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customerUsing.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateCustomerUsing(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        int id = Integer.parseInt(request.getParameter("customer_id"));
        String name = request.getParameter("customer_name");
       String phone1 = request.getParameter("phone");
        String service_name = request.getParameter("service_name");
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String attach_service_name = request.getParameter("attach_service_name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        CustomerUsing customerUsing = new CustomerUsing(id,name,phone1,service_name,contract_id,start_date,end_date,attach_service_name,quantity);
        check = customerUserService.update(id,customerUsing);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customerUsing.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomerUsing(request, response);
                break;

            default:
                listCustomerUsing(request, response);
                break;
        }
    }

    private void listCustomerUsing(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUsing> customerUsingList = customerUserService.findAllCustomerUsing();
        List<ShowAttachService> showAttachServiceList = customerUserService.findAllAttach();
        request.setAttribute("showListAttach",showAttachServiceList);
        request.setAttribute("customerUsings", customerUsingList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customerUsing.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        CustomerUsing existingUser = customerUserService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customerUsing.jsp");
        request.setAttribute("customerUsings", existingUser);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
