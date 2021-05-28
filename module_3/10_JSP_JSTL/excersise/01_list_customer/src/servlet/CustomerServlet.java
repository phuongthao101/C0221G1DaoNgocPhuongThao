package servlet;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://upload.wikimedia.org/wikipedia/vi/2/2c/Nobita.png"));
        list.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://upload.wikimedia.org/wikipedia/vi/2/2c/Nobita.png"));
        list.add(new Customer("Nguyễn Thái Hòa ", "1983-08-16", "Nam Định", "https://upload.wikimedia.org/wikipedia/vi/2/2c/Nobita.png"));
        list.add(new Customer("Trần Đăng Khoa", "1983-08-5", "Hà Nội", "https://upload.wikimedia.org/wikipedia/vi/2/2c/Nobita.png"));
        list.add(new Customer("Nguyễn Đình Thi", "1983-08-23", "Hà Tây", "https://upload.wikimedia.org/wikipedia/vi/2/2c/Nobita.png"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//gửi dữ liệu đi JSP
        request.setAttribute("customers", list);
//        hướng đường dẫn file JSP
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list_customer.jsp");
        requestDispatcher.forward(request,response);

    }
}
