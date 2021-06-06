package controller;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.service.impl.ContractService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",  urlPatterns = {"/contractDetail"})
public class ContractDetailServlet extends HttpServlet {

    private ContractService contractService = new ContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
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
                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//                case "delete":
//                    deleteCustomer(request, response);
//                    break;

            default:
                showNewForm(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    {
        List<ContractDetail> contractDetailList = contractService.findAllContractDetail();
        List<Contract> contractList = contractService.findAllContract();
        List<AttachService> attachServiceList = contractService.findAllAttachService();


        request.setAttribute("contractDetails", contractDetailList);
        request.setAttribute("contracts", contractList);
        request.setAttribute("attachServices", attachServiceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contractDetail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        String quantity1 = request.getParameter("quantity");

        ContractDetail contractDetail = new ContractDetail(contract_id,attach_service_id,
                quantity1);
        check = contractService.create(contractDetail);

        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create_contractDetail.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
