package controller;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService(); // Tạo đối tượng impl để tương tác với model

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "search":
                searchUserByName(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
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
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;

            default:
                listCustomer(request, response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findByAll();
        List<TypeCustomer> typeCustomerList = customerService.findAllTypeCustomer();

        request.setAttribute("customers", customerList);
        request.setAttribute("typeCustomers", typeCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;

        int id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");


        Customer newCustomer = new Customer(id, name, birthday,gender, idCard, phone, email, address);
        check = customerService.add(newCustomer);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

        List<TypeCustomer> typeCustomerList = customerService.findAllTypeCustomer();
        request.setAttribute("customerTypes",typeCustomerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
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
        List<TypeCustomer> typeCustomerList = customerService.findAllTypeCustomer();
        request.setAttribute("customerTypes",typeCustomerList);

        Customer existingUser = customerService.findById(id);
        request.setAttribute("customer", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        int id1 = Integer.parseInt(request.getParameter("customer_id"));
        int id = Integer.parseInt(request.getParameter("type_customer_id"));
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        String gender = request.getParameter("customer_gender");
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");

        Customer newCustomer = new Customer(id1,id, name, birthday,gender, idCard, phone, email, address);
        check = customerService.update(id, newCustomer);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        customerService.remove(id);

                 try {
                     response.sendRedirect("/customer");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }

    private void searchUserByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("customer_name");
        List<Customer> customerList = customerService.findByName(name);

        request.setAttribute("customers", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
