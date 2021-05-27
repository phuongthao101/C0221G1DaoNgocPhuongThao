import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", value = "/calculate")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("ProductDescription");

        double listPrice = Double.parseDouble(request.getParameter("ListPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("DiscountPercent"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = discountAmount + listPrice;

        request.setAttribute("description", productDescription);
        request.setAttribute("discountamount", discountAmount);
        request.setAttribute("discountprice", discountPrice);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/show.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
