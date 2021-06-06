package controller;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
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

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService(); // Tạo đối tượng impl để tương tác với model

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
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
        } catch (SQLException ex) {
            throw new ServletException(ex);
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
//                case "delete":
//                    deleteCustomer(request, response);
//                    break;

            default:
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAllEmployee();
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegrees = employeeService.findAllEducation();
        List<Division> divisionList = employeeService.findAllDivision();

        request.setAttribute("employees", employeeList);
        request.setAttribute("positions", positionList);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {

        boolean check = false;

        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String id_card = request.getParameter("employee_id_card");
        Double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));

        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");

        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));

        String username = request.getParameter("username");

        Employee employee = new Employee(name, birthday, id_card, employee_salary, employee_phone, employee_email, employee_address,
                position_id, education_degree_id, division_id, username);
        check = employeeService.create(employee);

        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create_employee.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> degreeList = employeeService.findAllEducation();
        List<Division> divisionList = employeeService.findAllDivision();

        request.setAttribute("positions", positionList);
        request.setAttribute("educationDegrees", degreeList);
        request.setAttribute("divisions", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        employeeService.remove(id);

        response.sendRedirect("/employee");
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("employee_name");
        List<Employee> employeeList = employeeService.findByName(name);

        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegrees = employeeService.findAllEducation();
        List<Division> divisionList = employeeService.findAllDivision();

        request.setAttribute("employees", employeeList);
        request.setAttribute("positions", positionList);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
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

        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> degreeList = employeeService.findAllEducation();
        List<Division> divisionList = employeeService.findAllDivision();

        request.setAttribute("positions", positionList);
        request.setAttribute("educationDegrees", degreeList);
        request.setAttribute("divisions", divisionList);

        Employee existingUser = employeeService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit_employee.jsp");
        request.setAttribute("employee", existingUser);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        boolean check = false;
        int id = Integer.parseInt(request.getParameter("employee_id"));

        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String id_card = request.getParameter("employee_id_card");
        Double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));

        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");

        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));

        String username = request.getParameter("username");


        Employee employee = new Employee(name, birthday, id_card, employee_salary, employee_phone, employee_email, employee_address,
                position_id, education_degree_id, division_id, username);

        check= this.employeeService.update(id, employee);
        if (check) {
            request.setAttribute("message", "Employee information was updated");
            request.setAttribute("employee", employee);
        }else {
            request.setAttribute("message", "Fail");
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit_employee.jsp");
        dispatcher.forward(request, response);
    }
}
