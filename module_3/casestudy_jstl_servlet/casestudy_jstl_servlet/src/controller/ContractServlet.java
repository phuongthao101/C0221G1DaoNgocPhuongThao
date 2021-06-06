package controller;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.service.Service;
import model.service.impl.ContractService;
import model.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet",  urlPatterns = {"/contract"})
public class ContractServlet extends HttpServlet {

    private ContractService contractService = new ContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
//            case "create":
//                showNewForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//                case "delete":
//                    deleteCustomer(request, response);
//                    break;

            default:
                listContract(request, response);
                break;
        }
    }
    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.findAllContract();
        List<Employee> employeeList = contractService.findAllEmployee();
        List<Customer> customerList = contractService.findByAll();
        List<Service> serviceList = contractService.findAllService();

        request.setAttribute("contracts", contractList);
        request.setAttribute("employees", employeeList);
        request.setAttribute("customers", contractList);
        request.setAttribute("services", serviceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list_contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
