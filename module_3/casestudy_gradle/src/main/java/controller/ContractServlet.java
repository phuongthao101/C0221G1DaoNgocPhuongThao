package controller;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.service.impl.ContractService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract"})
public class ContractServlet extends HttpServlet {

    private ContractService contractService = new ContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "edit":
                editContract(request, response);
        }
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
        int id = Integer.parseInt(request.getParameter("contract_id"));
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        int deposit = Integer.parseInt(request.getParameter("deposit"));

        int total_money = Integer.parseInt(request.getParameter("total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));


        Contract contract = new Contract(start_date, end_date, deposit, total_money, employee_id, customer_id, service_id);
        check = contractService.update(id,contract);

        if (check) {
            request.setAttribute("message", "Edit success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/edit_contract.jsp");
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
            case "create":
                break;
            case "edit":
                showEditForm(request, response);
                break;
//                case "delete":
//                    deleteCustomer(request, response);
//                    break;

            default:
                showNewForm(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("contract_id"));
        Contract contract = contractService.findAllContractId(id);
        List<Customer> customerList = contractService.findByAll();
        List<Employee> employeeList = contractService.findAllEmployee();
        List<Service> serviceList = contractService.findAllService();

        request.setAttribute("customers", customerList);
        request.setAttribute("employees", employeeList);
        request.setAttribute("services", serviceList);
        request.setAttribute("contracts", contract);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/edit_contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.findAllContract();
        List<Customer> customerList = contractService.findByAll();
        List<Employee> employeeList = contractService.findAllEmployee();
        List<Service> serviceList = contractService.findAllService();

        request.setAttribute("customers", customerList);
        request.setAttribute("employees", employeeList);
        request.setAttribute("services", serviceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;

        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        int deposit = Integer.parseInt(request.getParameter("deposit"));

        int total_money = Integer.parseInt(request.getParameter("total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));


        Contract contract = new Contract(start_date, end_date, deposit, total_money, employee_id, customer_id, service_id);
        check = contractService.create(contract);

        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contract.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
