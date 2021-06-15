package controller;

import model.bean.Employee;
import model.service.EmployeeService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends javax.servlet.http.HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "search":
                searchEmployeeByName(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
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
                deleteEmployee(request, response);
                break;

            default:
                listEmployee(request, response);
                break;
        }
  }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findByAll();

        request.setAttribute("employees", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");

        String birthday = request.getParameter("birthday");



        Employee employee = new Employee(name, birthday);

        List<String> validString = employeeService.create(employee);
        int checkFull = 0;
        for (String string : validString) {
            if (string.equals("")) {
                checkFull++;
            }
        }
        if (checkFull == 1) {
            request.setAttribute("message", "success");
        } else {
            request.setAttribute("message", "Fail!!!");
            request.setAttribute("Err", validString);
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

        List<Employee> employeeList = employeeService.findByAll();
        request.setAttribute("employees", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        List<Employee> employeeList = employeeService.findByAll();
        request.setAttribute("employees", employeeList);

        Employee existingUser = employeeService.findById(id);
        request.setAttribute("employee", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;
        int id1 = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");


        Employee employee = new Employee(id1, name,birthday);
        check = employeeService.update(id1, employee);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        employeeService.remove(id);

        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.findByName(name);

        request.setAttribute("employees", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
